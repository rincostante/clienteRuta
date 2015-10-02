
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
     * Listado de los vehículos que constituyen la Flota
     */
    private ArrayList<Vehiculo> listaVehiculos;
    
    /**
     * Total de vehículos que constituyen la Flota
     */
    private int total;
    
    
    /*******************
     * Geters y seters *
     *******************/

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
