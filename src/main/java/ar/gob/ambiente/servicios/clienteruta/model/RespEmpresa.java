
package ar.gob.ambiente.servicios.clienteruta.model;

import java.io.Serializable;

/**
 * Clase que encapsula el mensaje devuelto por el método de búsqueda de Empresa
 * @author rincostante
 */
public class RespEmpresa implements Serializable{
    private String versionWS;
    private Empresa empresa;
    private Error error;

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public String getVersionWS() {
        return versionWS;
    }

    public void setVersionWS(String versionWS) {
        this.versionWS = versionWS;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    
    /**
     * Constructor de la clase para deserializar la estructura JSON
     * @param versionWS: Versión del WS
     * @param empresa: Objeto devuelto por el método del WS
     * @param error: Error que pudiera retornas del método del WS
     */
    public RespEmpresa(String versionWS, Empresa empresa, Error error){
        this.empresa = empresa;
        this.versionWS = versionWS;
        this.error = error;
    }
}
