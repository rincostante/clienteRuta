/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.gob.ambiente.servicios.clienteruta.srv;

import ar.gob.ambiente.servicios.clienteruta.model.Empresa;
import ar.gob.ambiente.servicios.clienteruta.model.Flota;
import ar.gob.ambiente.servicios.clienteruta.model.Vehiculo;
import ar.gob.ambiente.servicios.clienteruta.util.EncriptaMd5;
import java.util.Calendar;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

/**
 * Clase que provée los métodos para obtener, mediante el uso del ws,
 * la información solicitada por el usuarios, y remitirla a las vistas.
 * @author rincostante
 */
@Stateless
public class SrvFacade {

    private static final String salt = ResourceBundle.getBundle("/Bundle").getString("Salt");
    private static final String srvHost = ResourceBundle.getBundle("/Bundle").getString("srvHost");
    private String cadenaAEncriptar;
    private String error;
    private String strFecha;
    private String token;
    
    @PostConstruct
    public void init(){
        Calendar fecha = Calendar.getInstance();
        strFecha = Integer.toString(fecha.get(Calendar.YEAR)) + "-"
                + Integer.toString(fecha.get(Calendar.MONTH) + 1) + "-0"
                + Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)); 
    }    
    
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    
    public Empresa obtenerEmpresa(String cuit){
        String target;
        Client cliente = ClientBuilder.newClient();
        // contruyo la cadena a encriptar
        cadenaAEncriptar = strFecha + cuit + salt;
        
        // encripto la caden para poblar el token
        try{
            token = EncriptaMd5.encriptar(cadenaAEncriptar);
            target = srvHost + "/" + "obtenerEmpresa?cuit=" + cuit + "&token=" + token;
            Empresa emp = cliente.target(target).request(MediaType.APPLICATION_JSON_TYPE).get(Empresa.class);
            return emp;
        }catch(Exception e){
            return null;
        }
    }
    
    public Flota obtenerFlota(Long cuit){
        return null;
        
    }
    
    public Vehiculo obtenerVehiculo(String matricula){
        return null;
        
    }       
}
