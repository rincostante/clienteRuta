

package ar.gob.ambiente.servicios.clienteruta.mb;

import ar.gob.ambiente.servicios.clienteruta.model.Empresa;
import ar.gob.ambiente.servicios.clienteruta.model.Flota;
import ar.gob.ambiente.servicios.clienteruta.model.Vehiculo;
import ar.gob.ambiente.servicios.clienteruta.srv.SrvFacade;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

/**
 * Bean de respaldo para las vistas de consulta de Empresas
 * @author rincostante
 */
public class MbEmpresa implements Serializable{

    private Empresa current;
    private Vehiculo vehiculo;
    private String strCuit;
    private boolean responseOk;
    private Flota flota;
    private List<Vehiculo> listVehiculos;
    private boolean rtoOk;
    
    @EJB
    private SrvFacade srvFacade;
    
    public MbEmpresa() {
        responseOk = false;
        rtoOk = false;
    }
    
    
    /*******************
     * geters y seters *
     *******************/
    
    public boolean isRtoOk() {
        return rtoOk;
    }

    public void setRtoOk(boolean rtoOk) {
        this.rtoOk = rtoOk;
    }
    
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    
    public List<Vehiculo> getListVehiculos() {
        return listVehiculos;
    }

    public void setListVehiculos(List<Vehiculo> listVehiculos) {
        this.listVehiculos = listVehiculos;
    }
    
    public boolean isResponseOk() {
        return responseOk;
    }

    public void setResponseOk(boolean responseOk) {
        this.responseOk = responseOk;
    }

    public Empresa getCurrent() {
        return current;
    }

    public void setCurrent(Empresa current) {
        this.current = current;
    }

    public String getStrCuit() {
        return strCuit;
    }

    public void setStrCuit(String strCuit) {
        this.strCuit = strCuit;
    }
    
    
    /**********************
     * Métodos operativos *
     **********************/
    
    /**
     * Método que borra de la memoria los MB innecesarios al cargar el listado 
     */
    public void iniciar(){

        String s;
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
        .getExternalContext().getSession(true);
        Enumeration enume = session.getAttributeNames();
        while(enume.hasMoreElements()){
            s = (String)enume.nextElement();
            if(s.substring(0, 2).equals("mb")){
                if(!s.equals("mbEmpresa")){
                    session.removeAttribute(s);
                }
            }
        }
    }     
    
    /**
     * Método que invoca al servicio para obtener los datos de la Empresa
     */
    public void mostrarEmpresa(){
        current = getFacade().obtenerEmpresa(strCuit);
        if(current != null){
            responseOk = true;
        }
    }
    
    /**
     * Método que invoca al servicio para obtener los datos de la Flota de Vehículos de una Empresa
     * y los muestra en una ventana emergente
     */
    public void mostrarFlota(){
        flota = getFacade().obtenerFlota(strCuit);
        
        // analizo la respuesta acá, antes de llamar al diálogo
        if(flota != null){
            // solo pueblo el listado y abro el diálogo si no hay ningún error
            listVehiculos = flota.getListaVehiculos();
            Map<String,Object> options = new HashMap<>();
            options.put("contentWidth", 900);
            options.put("contentHeight", 750);
            RequestContext.getCurrentInstance().openDialog("dlgVerFlota", options, null);       
        }
    }
    
    /**
     * Meétodo que muestra en una ventana emergente los datos de un Vehículo
     */
    public void verVehiculo(){
        rtoOk = !vehiculo.getRTO().getNroPlanilla().equals("");
        Map<String,Object> options = new HashMap<>();
        options.put("contentWidth", 500);
        RequestContext.getCurrentInstance().openDialog("dlgVerVehiculo", options, null);    
    }
    
    /**
     * Método para limpiar el modelo
     */
    public void limpiarEmpresa(){
        current = null;
        responseOk = false;
        strCuit = null;
    }    
    
    /**
     * Método para la confección del pdf
     * @param document
     * @throws DocumentException
     * @throws IOException 
     */
    public void preProcessPDF(Object document) throws DocumentException, IOException {
        Document pdf = (Document) document;    
        pdf.open();

        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String logo = servletContext.getRealPath("") + File.separator + "resources" + File.separator + "img" + File.separator + "EncabezadoDRP.jpg";
        pdf.add(Image.getInstance(logo));
    }      
    
    
    /*********************
    ** Métodos privados **
    **********************/
    /**
     * @return el Facade que implementa los métodos que consumen el WS
     */
    private SrvFacade getFacade() {
        return srvFacade;
    }  
}
