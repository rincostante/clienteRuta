
package ar.gob.ambiente.servicios.clienteruta.model;

import java.io.Serializable;
import java.util.Objects;

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
    private Long cuit;
    
    private int anioModelo;
    
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
    
    private int cantEjes;
    
    /**
     * True si esta declarado realiza cargas peligrosas
     */
    private boolean cargasPeligrosas;
    
    /**
     * Objeto que encapsula los datos de la Revisión técnica del vehículo
     */
    private Rto rto;
    
    /**
     * [2003,2012]
     */
    private int versionRUTA;
    
    /**
     * Versión del servicio web
     */
    private String versionWS;
    
  
    /*******************
     * Geters y Seters *
     *******************/

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

    public Long getCuit() {
        return cuit;
    }

    public void setCuit(Long cuit) {
        this.cuit = cuit;
    }

    public int getAnioModelo() {
        return anioModelo;
    }

    public void setAnioModelo(int anioModelo) {
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

    public int getCantEjes() {
        return cantEjes;
    }

    public void setCantEjes(int cantEjes) {
        this.cantEjes = cantEjes;
    }

    public boolean isCargasPeligrosas() {
        return cargasPeligrosas;
    }

    public void setCargasPeligrosas(boolean cargasPeligrosas) {
        this.cargasPeligrosas = cargasPeligrosas;
    }

    public Rto getRto() {
        return rto;
    }

    public void setRto(Rto rto) {
        this.rto = rto;
    }

    public int getVersionRUTA() {
        return versionRUTA;
    }

    public void setVersionRUTA(int versionRUTA) {
        this.versionRUTA = versionRUTA;
    }

    public String getVersionWS() {
        return versionWS;
    }

    public void setVersionWS(String versionWS) {
        this.versionWS = versionWS;
    }
    
    
    /*************************
     * Métodos sobreescritos *
     *************************/    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dominio != null ? dominio.hashCode() : 0);
        return hash;
    }        

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehiculo other = (Vehiculo) obj;
        if (!Objects.equals(this.dominio, other.dominio)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "ar.gob.ambiente.servicios.clienteruta.model.Vehiculo[ dominio=" + dominio + " ]";
    }     
}
