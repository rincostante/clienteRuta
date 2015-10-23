
package ar.gob.ambiente.servicios.clienteruta.model;

import java.io.Serializable;

/**
 * Clase que encapsula la información perteneciente a los Vehículos de transporte de Residuos Peligrosos
 * @author rincostante
 */
public class Vehiculo implements Serializable{
    
    /**
     * Matrícula del vehículo que será tomado como la id
     */
    private String dominio;
    
    /**
     * Razón social de la Empresa a la que pertenence el Vehículo
     */
    private String razonSocial;
    
    /**
     * Cuit de la Empresa a la que pertenece el Vehículo
     */
    private String cuit;
    
    private String anioModelo;
    
    private String nroChasis;
    
    private String tipoVehiculo;
    
    /**
     * Código abreviado del tipo de vehículo
     */
    private String codigoTipoVehiculo;
    
    private String categoria;
    
    private String marcaChasis;
    
    private String modeloChasis;
    
    private String marcaMotor;
    
    private String marcaCarroceria;
    
    private String tipoCaja;
    
    private String tipoCarga;
    
    /**
     * Configuración de los ejes del Vehículo
     */
    private String configuracionEjes;
    
    private String cantEjes;
    
    /**
     * True si esta declarado realiza cargas peligrosas
     */
    private boolean cargasPeligrosas;

    
    /**
     * [2003,2012]
     */
    private String versionRUTA;
    
    /**
     * Versión del servicio web
     */
    private String versionWS;
    
    /**
     * En este campo se encapsularán los datos de la rto del vehículo
     * cuando el objeto se obtiene desde obtenerVehiculo
     */
    //private Rto rto;
    
    /**
     * Cadena para guardar el contenido de la rto cuando el vehículo se obtiene desde obtenerFlota
     */
    private Rto RTO;
    
  
    /*******************
     * Geters y Seters *
     *******************/

    public Rto getRTO() {
        return RTO;
    }

    public void setRTO(Rto RTO) {
        this.RTO = RTO;
    }
/*
    public Rto getRto() {
        return rto;
    }

    public void setRto(Rto rto) {
        this.rto = rto;
    }
*/
    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getAnioModelo() {
        return anioModelo;
    }

    public void setAnioModelo(String anioModelo) {
        this.anioModelo = anioModelo;
    }

    public String getNroChasis() {
        return nroChasis;
    }

    public void setNroChasis(String nroChasis) {
        this.nroChasis = nroChasis;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getCodigoTipoVehiculo() {
        return codigoTipoVehiculo;
    }

    public void setCodigoTipoVehiculo(String codigoTipoVehiculo) {
        this.codigoTipoVehiculo = codigoTipoVehiculo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMarcaChasis() {
        return marcaChasis;
    }

    public void setMarcaChasis(String marcaChasis) {
        this.marcaChasis = marcaChasis;
    }

    public String getModeloChasis() {
        return modeloChasis;
    }

    public void setModeloChasis(String modeloChasis) {
        this.modeloChasis = modeloChasis;
    }

    public String getMarcaMotor() {
        return marcaMotor;
    }

    public void setMarcaMotor(String marcaMotor) {
        this.marcaMotor = marcaMotor;
    }

    public String getMarcaCarroceria() {
        return marcaCarroceria;
    }

    public void setMarcaCarroceria(String marcaCarroceria) {
        this.marcaCarroceria = marcaCarroceria;
    }

    public String getTipoCaja() {
        return tipoCaja;
    }

    public void setTipoCaja(String tipoCaja) {
        this.tipoCaja = tipoCaja;
    }

    public String getTipoCarga() {
        return tipoCarga;
    }

    public void setTipoCarga(String tipoCarga) {
        this.tipoCarga = tipoCarga;
    }

    public String getConfiguracionEjes() {
        return configuracionEjes;
    }

    public void setConfiguracionEjes(String configuracionEjes) {
        this.configuracionEjes = configuracionEjes;
    }

    public String getCantEjes() {
        return cantEjes;
    }

    public void setCantEjes(String cantEjes) {
        this.cantEjes = cantEjes;
    }

    public boolean isCargasPeligrosas() {
        return cargasPeligrosas;
    }

    public void setCargasPeligrosas(boolean cargasPeligrosas) {
        this.cargasPeligrosas = cargasPeligrosas;
    }

    public String getVersionRUTA() {
        return versionRUTA;
    }

    public void setVersionRUTA(String versionRUTA) {
        this.versionRUTA = versionRUTA;
    }

    public String getVersionWS() {
        return versionWS;
    }

    public void setVersionWS(String versionWS) {
        this.versionWS = versionWS;
    }
    
    
    public Vehiculo(String dominio,
        String razonSocial,
        String cuit,
        String anioModelo,
        String nroChasis,
        String tipoVehiculo,
        String codigoTipoVehiculo,
        String categoria,
        String marcaChasis,
        String modeloChasis,
        String marcaMotor,
        String marcaCarroceria,
        String tipoCaja,
        String tipoCarga,
        String configuracionEjes,
        String cantEjes,
        boolean cargasPeligrosas,
        String versionRUTA,
        String versionWS){
        
        this.anioModelo = anioModelo;
        this.cantEjes = cantEjes;
        this.cargasPeligrosas = cargasPeligrosas;
        this.categoria = categoria;
        this.codigoTipoVehiculo = codigoTipoVehiculo;
        this.configuracionEjes = configuracionEjes;
        this.cuit = cuit;
        this.dominio = dominio;
        this.marcaCarroceria = marcaCarroceria;
        this.marcaChasis = marcaChasis;
        this.marcaMotor = marcaMotor;
        this.modeloChasis = modeloChasis;
        this.nroChasis = nroChasis;
        this.razonSocial = razonSocial;
        this.tipoCaja = tipoCaja;
        this.tipoCarga = tipoCarga;
        this.tipoVehiculo = tipoVehiculo;
        this.versionRUTA = versionRUTA;
        this.versionWS = versionWS;
    }
}
