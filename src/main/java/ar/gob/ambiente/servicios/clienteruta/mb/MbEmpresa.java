/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.gob.ambiente.servicios.clienteruta.mb;

import ar.gob.ambiente.servicios.clienteruta.model.Empresa;
import ar.gob.ambiente.servicios.clienteruta.srv.SrvFacade;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 * Bean de respaldo para la vista de consulta de Empresas
 * Para parsear JSON: http://chuwiki.chuidiang.org/index.php?title=Ejemplos_JSON_y_Java_con_Gson
 * Ejemplo: http://www.adictosaltrabajo.com/tutoriales/gson-java-json/
 * @author rincostante
 */
public class MbEmpresa implements Serializable{

    private Empresa current;
    private String strCuit;
    
    @EJB
    private SrvFacade srvFacade;
    
    public MbEmpresa() {
    }
    
    
    /*******************
     * geters y seters *
     *******************/
    
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
    
    public void mostrarEmpresa(){
        current = getFacade().obtenerEmpresa(strCuit);
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
