
package ar.gob.ambiente.servicios.clienteruta.model;

import java.io.Serializable;

/**
 * Clase que encapsula los códigos de error
 * @author rincostante
 */
public class Error implements Serializable{
    private String codigo;
    private String descripcion;
    private String detalle;
    private String versionWS;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getVersionWS() {
        return versionWS;
    }

    public void setVersionWS(String versionWS) {
        this.versionWS = versionWS;
    }
    
    /**
     * Constructor de la clase para deserializar la estructura JSON
     * @param codigo: Código del error
     * @param descripcion: Descripción del error que se produjo
     * @param detalle: Especificación de lo que ocasionó el error
     * @param versionWS: Versión del WS
     */
    public Error(String codigo,
            String descripcion,
            String detalle,
            String versionWS){
        this.descripcion = descripcion;
        this.codigo = codigo;
        this.detalle = detalle;
        this.versionWS = versionWS;
    }
}
