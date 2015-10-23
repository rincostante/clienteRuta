/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.gob.ambiente.servicios.clienteruta.srv;

import ar.gob.ambiente.servicios.clienteruta.model.Empresa;
import ar.gob.ambiente.servicios.clienteruta.model.Flota;
import ar.gob.ambiente.servicios.clienteruta.model.RespEmpresa;
import ar.gob.ambiente.servicios.clienteruta.util.EncriptaMd5;
import com.google.gson.Gson;
import java.util.Calendar;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import org.primefaces.context.RequestContext;
import ar.gob.ambiente.servicios.clienteruta.model.Error;
import ar.gob.ambiente.servicios.clienteruta.model.Rto;
import ar.gob.ambiente.servicios.clienteruta.model.Vehiculo;

/**
 * Clase que provée los métodos para obtener, mediante el uso del ws,
 * la información solicitada por el usuarios, y remitirla a las vistas.
 * Se utiliza la librería Gson para deserializar el sring json en un POJO
 * Los datos para la conexión y acceso al servicio CENT (salt y srvHost)
 * se obtienen del archivo de configuración.
 * El String veJson será guardado del último vehículo consultado para no tener 
 * que hacer una nueva búsqueda utilizando el servicio al consultar el RTO correspondiente.
 * @author rincostante
 */
@Stateless
public class SrvFacade {
    
    private static final String salt = ResourceBundle.getBundle("/Bundle").getString("Salt");
    private static final String srvHost = ResourceBundle.getBundle("/Bundle").getString("srvHost");
    private String cadenaAEncriptar;
    private Error error;
    private String strFecha;
    private String token;
    private String target;
    private Client cliente;
    private Gson gson;
    private String strJson;
    private String veJson;
    
    @PostConstruct
    /**
     * Método que ejecuta inmediátamente después de haberse instanciado el objeto y setea los campos principales usuados por todos los métodos
     */
    public void init(){
        int dia;
        String sDia;
        Calendar fecha = Calendar.getInstance();
        dia = fecha.get(Calendar.DAY_OF_MONTH);
        if(dia > 9){
            sDia = Integer.toString(dia);
        }else{
            sDia = "0" + Integer.toString(dia);
        }
        strFecha = Integer.toString(fecha.get(Calendar.YEAR)) + "-" + Integer.toString(fecha.get(Calendar.MONTH) + 1) + "-" + sDia; 
        cliente = ClientBuilder.newClient();
        gson = new Gson();
    }    

    /**
     * Método que utiliza el método homónimo del servicio CENT
     * @param cuit
     * @return 
     */
    public Empresa obtenerEmpresa(String cuit){
        Empresa empResult;
        RespEmpresa respEmp;
        
        // contruyo la cadena a encriptar
        cadenaAEncriptar = strFecha + cuit + salt;
        
        // encripto la caden para poblar el token
        try{
            token = EncriptaMd5.encriptar(cadenaAEncriptar);
            target = srvHost + "/" + "obtenerEmpresa?cuit=" + cuit + "&token=" + token;
        
            strJson = cliente.target(target).request(MediaType.APPLICATION_JSON_TYPE).get(String.class);
            
            if(strJson.indexOf("\"empresa\":[]") != -1){
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Búsqueda de Empresas", ResourceBundle.getBundle("/Bundle").getString("EmpresaNoEncontrada"));
                RequestContext.getCurrentInstance().showMessageInDialog(message);
                empResult = null;
            }else{
                if(strJson.indexOf("\"error\":") != -1){
                    respEmp = gson.fromJson(strJson, RespEmpresa.class);
                    error = respEmp.getError();
                    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Búsqueda de Empresas", ResourceBundle.getBundle("/Bundle").getString("ErrorWS") + ""
                            + " Código: " + error.getCodigo() + "; Descripción: " + error.getDescripcion() + "; Detalle: " + error.getDetalle() + "; VersionWS: " + error.getVersionWS());
                    RequestContext.getCurrentInstance().showMessageInDialog(message);
                    empResult = null;
                }else{
                    respEmp = gson.fromJson(strJson, RespEmpresa.class);
                    empResult = respEmp.getEmpresa();
                }
            }

            return empResult;
        }catch(Exception e){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Búsqueda de Empresas", ResourceBundle.getBundle("/Bundle").getString("ErrorDePila") + e.getMessage());
            RequestContext.getCurrentInstance().showMessageInDialog(message);
            return null;
        }
    }
    
    /**
     * Método que utiliza el método homónimo del servicio CENT
     * @param cuit
     * @return 
     */
    public Flota obtenerFlota(String cuit){
        Flota flota;
        
        // contruyo la cadena a encriptar
        cadenaAEncriptar = strFecha + cuit + salt;
        
        // encripto la caden para poblar el token
        try{
            token = EncriptaMd5.encriptar(cadenaAEncriptar);
            target = srvHost + "/" + "obtenerFlota?cuit=" + cuit + "&token=" + token;
            strJson = cliente.target(target).request(MediaType.APPLICATION_JSON_TYPE).get(String.class);
            
            // valido que tenga flota
            if(strJson.indexOf("\"empresa\":") != -1){
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Búsqueda de Flotas", ResourceBundle.getBundle("/Bundle").getString("FlotaNoEncontrada"));
                RequestContext.getCurrentInstance().showMessageInDialog(message);
                return null;
            }else if(strJson.indexOf("\"error\":") != -1){
                flota = gson.fromJson(strJson, Flota.class);
                String stError = "Hubo un error ejecutando el método obtenerFlota. Código: " + flota.getError().getCodigo() + "; descripción: "
                        + "" + flota.getError().getDescripcion() + "; detalle: " + flota.getError().getDetalle() + "; versión WS: " + flota.getError().getVersionWS();
                

                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Búsqueda de Flotas", stError);
                RequestContext.getCurrentInstance().showMessageInDialog(message);
                return null;
            }else{
                // verifico si algún vehículo contiene una RTO vacía
                if(strJson.indexOf("\"RTO\":[]") != -1){
                    // en ese caso reemplazo las cadenas
                    String rtoVacio = "\"RTO\":\\[\\]";
                    String rtoReemplazo = "\"RTO\":{\"nroPlanilla\":\"\",\"codTaller\":\"\",\"codAuditoria\":\"\",\"dominio\":\"\","
                            + "\"fechaRevision\":\"\",\"fechaVencimiento\":\"\",\"codTipoUso\":\"\",\"serieCertificado\":\"\","
                            + "\"nroCertificado\":\"\",\"codTipoVehiculo\":\"\",\"categoriaVehiculo\":\"\",\"configuracionEjes\":\"\","
                            + "\"numeroEjes\":\"\",\"marcaTacografo\":\"\",\"nroTacografo\":\"\",\"codTipoCaja\":\"\",\"tipCaja\":\"\","
                            + "\"cargasPeligrosas\":false,\"nroChasis\":\"\",\"nroMotor\":\"\",\"anioModelo\":\"\",\"versionRTO\":\"\","
                            + "\"versionWS\":\"\"}";
                    strJson = strJson.replaceAll(rtoVacio, rtoReemplazo);
                }
                flota = gson.fromJson(strJson, Flota.class);
                return flota;
            }
            
        }catch(Exception e){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Búsqueda de Flotas", ResourceBundle.getBundle("/Bundle").getString("ErrorDePila") + e.getMessage());
            RequestContext.getCurrentInstance().showMessageInDialog(message);
            return null;
        }        
    }
    
    /**
     * Por razones de prolijidad y seguridad quité la clase RTO del Vehículo porque en algunos casos vieve vacía.
     * Para obtener el RTO de un vehículo, obtengo a este último con el servicio y vaerifico que tenga RTO, si es así
     * la leo y la deserializo en la clase correspondiente
     * @param matricula
     * @return 
     */
    public Rto obtenerRto(String matricula){
        Rto rto;
        String rtoJson;
        
        // contruyo la cadena a encriptar
        cadenaAEncriptar = strFecha + matricula + salt;
        
        // encripto la caden para poblar el token
        try{
            token = EncriptaMd5.encriptar(cadenaAEncriptar);
            target = srvHost + "/" + "obtenerVehiculo?dominio=" + matricula + "&token=" + token;
            
            // obtngo el vehículo correspondiente a la matrícula recibida
            strJson = cliente.target(target).request(MediaType.APPLICATION_JSON_TYPE).get(String.class);
            
            // obtento el substring del RTO
            rtoJson = strJson.substring(strJson.indexOf("RTO"));
            int iLlaveFin = rtoJson.indexOf("}");
            rtoJson = rtoJson.substring(5, iLlaveFin + 1);
            
            // obtengo el objeto RTO si el string viene lleno, de lo contrario devuelvo nulo
            if(!rtoJson.substring(0, 2).equals("[]")){
                rto = gson.fromJson(rtoJson, Rto.class);
            }else{
                // mando mensaje al usuario
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Búsqueda de Flotas", "El Vehículo no tine datos sobre la RTO.");
                RequestContext.getCurrentInstance().showMessageInDialog(message);
                rto = null;
            }
            
            return rto;
        }catch(Exception e){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Búsqueda de RTO", ResourceBundle.getBundle("/Bundle").getString("ErrorDePila") + e.getMessage());
            RequestContext.getCurrentInstance().showMessageInDialog(message);
            return null;
        }
    }       
    
    /**
     * Método que utiliza el método homónimo del servicio CENT.
     * Dado que la estructura del json devuelto tiene un formato redundante,
     * se procesa el contenido antes de deserializarlo en el objeto Vehículo
     * @param matricula
     * @return 
     */
    public Vehiculo obtenerVehiculo(String matricula){
        int iLlaveFin;
        Vehiculo ve;
        
        // contruyo la cadena a encriptar
        cadenaAEncriptar = strFecha + matricula + salt;
        
        // encripto la caden para poblar el token
        try{
            token = EncriptaMd5.encriptar(cadenaAEncriptar);
            target = srvHost + "/" + "obtenerVehiculo?dominio=" + matricula + "&token=" + token;
            
            // obtengo el vehículo correspondiente a la matrícula recibida
            strJson = cliente.target(target).request(MediaType.APPLICATION_JSON_TYPE).get(String.class);

            // valido que no haya error
            if(strJson.indexOf("\"error\":") != -1){
                // como este string viene medio raro lo leo y corto la parte del error
                String errJson = strJson.substring(strJson.indexOf("\"error\":") + 8, strJson.indexOf("}") + 1);
                error = gson.fromJson(errJson, Error.class);
                String stError = "Hubo un error ejecutando el método obtenerVehiculo. Código: " + error.getCodigo() + "; descripción: "
                        + "" + error.getDescripcion() + "; detalle: " + error.getDetalle() + "; versión WS: " + error.getVersionWS();
                //String stError = "pepe";
                
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Búsqueda de Vehículo", stError);
                RequestContext.getCurrentInstance().showMessageInDialog(message);
                
                return null;
            }else{
                // si no hay error proceso el string para obtener el formato correcto
                veJson = strJson.substring(strJson.indexOf("\"vehiculo\":{\"vehiculo\""));

                iLlaveFin = veJson.length();
                veJson = veJson.substring(23, iLlaveFin - 2);
                
                // verifico si el vehículo contiene una RTO
                if(veJson.indexOf("\"RTO\":[]") != -1){
                    // si viene vacío reemplazo
                    String rtoVacio = "\"RTO\":\\[\\]";
                    String rtoReemplazo = "\"RTO\":{\"nroPlanilla\":\"\",\"codTaller\":\"\",\"codAuditoria\":\"\",\"dominio\":\"\","
                            + "\"fechaRevision\":\"\",\"fechaVencimiento\":\"\",\"codTipoUso\":\"\",\"serieCertificado\":\"\","
                            + "\"nroCertificado\":\"\",\"codTipoVehiculo\":\"\",\"categoriaVehiculo\":\"\",\"configuracionEjes\":\"\","
                            + "\"numeroEjes\":\"\",\"marcaTacografo\":\"\",\"nroTacografo\":\"\",\"codTipoCaja\":\"\",\"tipCaja\":\"\","
                            + "\"cargasPeligrosas\":false,\"nroChasis\":\"\",\"nroMotor\":\"\",\"anioModelo\":\"\",\"versionRTO\":\"\","
                            + "\"versionWS\":\"\"}";
                    veJson = veJson.replaceAll(rtoVacio, rtoReemplazo);
                }

                ve = gson.fromJson(veJson, Vehiculo.class);

                return ve;
            }
            

        }catch(Exception e){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Búsqueda de Vehículos", ResourceBundle.getBundle("/Bundle").getString("ErrorDePila") + e.getMessage());
            RequestContext.getCurrentInstance().showMessageInDialog(message);
            return null;
        }
    }
}
