

package ar.gob.ambiente.servicios.clienteruta.mb;

import java.io.Serializable;
import java.util.Enumeration;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 * Bean de respaldo para el inicio y salida de la aplicación
 * @author rincostante
 */
public class MbIndex implements Serializable{

    private boolean iniciado;
    
    public MbIndex() {
    }

    public boolean isIniciado() {
        return iniciado;
    }

    public void setIniciado(boolean iniciado) {
        this.iniciado = iniciado;
    }
   
    /**
     * Método que el index inicialice el bean y esté disponible para cerrar todo desde cualquier menú de la aplicación
     */
    public void iniciar(){
    }     
    
    /**
     * Método para vaciar la memoria al salir
     */
    public void logout(){
        String s;
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
        .getExternalContext().getSession(true);
        Enumeration enume = session.getAttributeNames();
        while(enume.hasMoreElements()){
            s = (String)enume.nextElement();
            if(s.substring(0, 2).equals("mb")){
                session.removeAttribute(s);
            }
        }
    }
}
