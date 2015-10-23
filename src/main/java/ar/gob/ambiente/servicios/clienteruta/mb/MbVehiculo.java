
package ar.gob.ambiente.servicios.clienteruta.mb;

import ar.gob.ambiente.servicios.clienteruta.model.Vehiculo;
import ar.gob.ambiente.servicios.clienteruta.srv.SrvFacade;
import java.io.Serializable;
import java.util.Enumeration;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 * Bean de respaldo para las vistas de consulta de Vehículos
 * @author rincostante
 */
public class MbVehiculo implements Serializable{

    private Vehiculo current;
    private String dominio;
    private boolean responseOk;
    private boolean rtoOk;
    
    @EJB
    private SrvFacade srvFacade;
    
    public MbVehiculo() {
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

    public Vehiculo getCurrent() {
        return current;
    }

    public void setCurrent(Vehiculo current) {
        this.current = current;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public boolean isResponseOk() {
        return responseOk;
    }

    public void setResponseOk(boolean responseOk) {
        this.responseOk = responseOk;
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
                if(!s.equals("mbVehiculo")){
                    session.removeAttribute(s);
                }
            }
        }
    }    
    
    /**
     * Método que invoca al servicio para obtener la Flota de una Empresa mediante el CUIT
     */
    public void mostrarVehiculo(){
        current = getFacade().obtenerVehiculo(dominio);
        if(current != null){
            responseOk = true;
        }
        if(!current.getRTO().getNroPlanilla().equals("")){
            rtoOk = true;
        }
    }          
    
    /**
     * Método para limpiar el modelo
     */
    public void limpiarVehiculo(){
        current = null;
        responseOk = false;
        rtoOk = false;
        dominio = null;
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
