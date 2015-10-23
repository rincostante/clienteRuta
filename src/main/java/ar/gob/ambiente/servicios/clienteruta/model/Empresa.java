
package ar.gob.ambiente.servicios.clienteruta.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Clase que encapsula la información perteneciente a las Empresas de transporte de Residuos Peligrosos
 * @author rincostante
 */
public class Empresa implements Serializable{
    
    private static final long serialVersionUID = 1L;
    /**
     * Cuit de la Empresa no debe repetirse
     */
    private String cuit;
    
    /**
     * Razón social por la cual es conocida la Empresa
     */
    private String razonSocial;
    
    /**
     * Cadena que especifica tipo de transporte realizado por la empresa
     */
    private String tipoTransportista;
    
    /**
     * Categoría del transporte realizado por la Empresa
     */
    private String categoria;
    
    /**
     * Listado de códigos de tipo String, ej: "CMG" 
     */
    private ArrayList<String> codigosCategorias;
    
    /**
     * Domicilio Postal de la Empresa. Calle y número.
     */
    private String direccion;
    
    /**
     * Nombre de la localidad Postal de donde está afincada la Empresa.
     */
    private String localidad;
    
    /**
     * Nombre de la Provincia donde está afincada la Empresa
     */
    private String provincia;
    
    /**
     * Código del país al que la Empresa pertenece
     */
    private String paisCodigo;
    
    /**
     * Número telefónico de contacto
     */
    private String telefono;
    
    /**
     * correo electrónico del contacto
     */
    private String email;
    
    /**
     * True si esta declarado que realiza cargas peligrosas
     */
    private boolean cargasPeligrosas;
    
    /**
     * Versión del servicio web
     */
    private String versionWS;
    
    public Empresa(String cuit,
            String razonSocial,
            String tipoTransportista,
            String categoria,
            ArrayList<String> codigosCategorias,
            String direccion,
            String localidad,
            String provincia,
            String paisCodigo,
            String telefono,
            String email,
            boolean cargasPeligrosas,
            String versionWS){
        this.categoria = categoria;
        this.cuit = cuit;
        this.direccion = direccion;
        this.email = email;
        this.localidad = localidad;
        this.paisCodigo = paisCodigo;
        this.provincia = provincia;
        this.razonSocial = razonSocial;
        this.telefono = telefono;
        this.tipoTransportista = tipoTransportista;
        this.versionWS = versionWS;
    }
    
    /*******************
     * Geters y Seters *
     *******************/
    
    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getTipoTransportista() {
        return tipoTransportista;
    }

    public void setTipoTransportista(String tipoTransportista) {
        this.tipoTransportista = tipoTransportista;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public ArrayList<String> getCodigosCategorias() {
        return codigosCategorias;
    }

    public void setCodigosCategorias(ArrayList<String> codigosCategorias) {
        this.codigosCategorias = codigosCategorias;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPaisCodigo() {
        return paisCodigo;
    }

    public void setPaisCodigo(String paisCodigo) {
        this.paisCodigo = paisCodigo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isCargasPeligrosas() {
        return cargasPeligrosas;
    }

    public void setCargasPeligrosas(boolean cargasPeligrosas) {
        this.cargasPeligrosas = cargasPeligrosas;
    }

    public String getVersionWS() {
        return versionWS;
    }

    public void setVersionWS(String versionWS) {
        this.versionWS = versionWS;
    }
}
