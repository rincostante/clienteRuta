

package ar.gob.ambiente.servicios.clienteruta.mb;

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
 * Bean de respaldo para las vistas de consulta de Flotas
 * @author rincostante
 */
public class MbFlota implements Serializable{

    private Flota current;
    private Vehiculo vehiculo;
    private String strCuit;
    private boolean responseOk;
    private boolean rtoOk;
    private List<Vehiculo> listVehiculos;
    
    @EJB
    private SrvFacade srvFacade;
    
    public MbFlota() {
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

    public Flota getCurrent() {
        return current;
    }

    public void setCurrent(Flota current) {
        this.current = current;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getStrCuit() {
        return strCuit;
    }

    public void setStrCuit(String strCuit) {
        this.strCuit = strCuit;
    }

    public boolean isResponseOk() {
        return responseOk;
    }

    public void setResponseOk(boolean responseOk) {
        this.responseOk = responseOk;
    }

    public List<Vehiculo> getListVehiculos() {
        return listVehiculos;
    }

    public void setListVehiculos(List<Vehiculo> listVehiculos) {
        this.listVehiculos = listVehiculos;
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
                if(!s.equals("mbFlota")){
                    session.removeAttribute(s);
                }
            }
        }
    }         
    
    /**
     * Método que invoca al servicio para obtener la Flota de una Empresa mediante el CUIT
     */
    public void mostrarFlota(){
        current = getFacade().obtenerFlota(strCuit);
        if(current != null){
            responseOk = true;
            listVehiculos = current.getListaVehiculos();
        }
    }
    
    /**
     * Método para limpiar el modelo
     */
    public void limpiarFlota(){
        current = null;
        responseOk = false;
        strCuit = null;
    }  
    
    /**
     * Meétodo que muestra en una ventana emergente los datos de un Vehículo
     */
    public void verVehiculo(){
        if(!vehiculo.getRTO().getNroPlanilla().equals("")){
            rtoOk = true;
        }else{
            rtoOk = false;
        }
        Map<String,Object> options = new HashMap<>();
        options.put("contentWidth", 500);
        RequestContext.getCurrentInstance().openDialog("dlgVer", options, null);    
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
        String logo = servletContext.getRealPath("") + File.separator + "resources" + File.separator + "img" + File.separator + "logoCoord80x270.jpg";
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
