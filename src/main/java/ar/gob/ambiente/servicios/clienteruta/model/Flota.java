
package ar.gob.ambiente.servicios.clienteruta.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase que encapsula la información correpondiente una flota de vehículos:
 * El listado con todos los vehículos correspondientes y el total de los mismos
 * @author rincostante
 */
public class Flota implements Serializable{
    /**
     * Vesrión del WS
     */
    private String versionWS;
    
    /**
     * Objeto que encapsula los datos del error si este se produjera
     */
    private Error error;
    
    /**
     * Listado de los vehículos que constituyen la Flota
     */
    private ArrayList<Vehiculo> listaVehiculos;
    
    /**
     * Total de vehículos que constituyen la Flota
     */
    private int total;
    
    /**
     * Cadena que indica el resultado de la búsqueda
     */
    private String result;
    
    
    /*******************
     * Geters y seters *
     *******************/

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getVersionWS() {
        return versionWS;
    }

    public void setVersionWS(String versionWS) {
        this.versionWS = versionWS;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public ArrayList<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(ArrayList<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

}
