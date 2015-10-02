/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.gob.ambiente.servicios.clienteruta.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Clase que encapsula los datos de la Revisión técnica del vehículo
 * @author rincostante
 */
public class Rto implements Serializable{
    /**
     * Identificación de la Revisión
     */
    private Long nroPlanilla;
    
    private int codAuditoria;
    
    /**
     * Código del taller que realizó la Revisón
     */
    private int codTaller;
    
    private String dominio;
    
    /**
     * Fecha en Que Realizo Ultima Revisión
     */
    private String fechaRevision;
    
    /**
     * Fecha de vencimiento de la Revisión
     */
    private String fechaVencimiento;
    
    /**
     * Código Del Tipo de Uso Que Realiza
     */
    private String codTipoUso;
    
    /**
     * Serie del Certificado RTO
     */
    private String serieCertificado;
    
    /**
     * Numero del Certificado RTO
     */
    private int nroCertificado;
    
    private String codigoTipoVehiculo;
    
    private String categoriaVehiculo;
    
    /**
     * Configuración de Ejes del Vehículo
     */
    private String configuracionEjes;
    
    private int numeroEjes;
    
    private String marcaTacografo;
    
    private int nroTacografo;
    
    private String codTipoCaja;
    
    private String tipoCaja;
    
    private boolean cargasPeligrosas;
    
    private String nroChasis;
    
    private String nroMotor;
    
    private int anioModelo;
    
    /**
     * [2003,2014]
     */
    private String versionRTO;
    
    /**
     * Versión del Servicio web
     */
    private String versionWS;
    
    
    /*******************
     * Geters y Seters *
     *******************/    

    public Long getNroPlanilla() {
        return nroPlanilla;
    }

    public void setNroPlanilla(Long nroPlanilla) {
        this.nroPlanilla = nroPlanilla;
    }

    public int getCodAuditoria() {
        return codAuditoria;
    }

    public void setCodAuditoria(int codAuditoria) {
        this.codAuditoria = codAuditoria;
    }

    public int getCodTaller() {
        return codTaller;
    }

    public void setCodTaller(int codTaller) {
        this.codTaller = codTaller;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public String getFechaRevision() {
        return fechaRevision;
    }

    public void setFechaRevision(String fechaRevision) {
        this.fechaRevision = fechaRevision;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getCodTipoUso() {
        return codTipoUso;
    }

    public void setCodTipoUso(String codTipoUso) {
        this.codTipoUso = codTipoUso;
    }

    public String getSerieCertificado() {
        return serieCertificado;
    }

    public void setSerieCertificado(String serieCertificado) {
        this.serieCertificado = serieCertificado;
    }

    public int getNroCertificado() {
        return nroCertificado;
    }

    public void setNroCertificado(int nroCertificado) {
        this.nroCertificado = nroCertificado;
    }

    public String getCodigoTipoVehiculo() {
        return codigoTipoVehiculo;
    }

    public void setCodigoTipoVehiculo(String codigoTipoVehiculo) {
        this.codigoTipoVehiculo = codigoTipoVehiculo;
    }

    public String getCategoriaVehiculo() {
        return categoriaVehiculo;
    }

    public void setCategoriaVehiculo(String categoriaVehiculo) {
        this.categoriaVehiculo = categoriaVehiculo;
    }

    public String getConfiguracionEjes() {
        return configuracionEjes;
    }

    public void setConfiguracionEjes(String configuracionEjes) {
        this.configuracionEjes = configuracionEjes;
    }

    public int getNumeroEjes() {
        return numeroEjes;
    }

    public void setNumeroEjes(int numeroEjes) {
        this.numeroEjes = numeroEjes;
    }

    public String getMarcaTacografo() {
        return marcaTacografo;
    }

    public void setMarcaTacografo(String marcaTacografo) {
        this.marcaTacografo = marcaTacografo;
    }

    public int getNroTacografo() {
        return nroTacografo;
    }

    public void setNroTacografo(int nroTacografo) {
        this.nroTacografo = nroTacografo;
    }

    public String getCodTipoCaja() {
        return codTipoCaja;
    }

    public void setCodTipoCaja(String codTipoCaja) {
        this.codTipoCaja = codTipoCaja;
    }

    public String getTipoCaja() {
        return tipoCaja;
    }

    public void setTipoCaja(String tipoCaja) {
        this.tipoCaja = tipoCaja;
    }

    public boolean isCargasPeligrosas() {
        return cargasPeligrosas;
    }

    public void setCargasPeligrosas(boolean cargasPeligrosas) {
        this.cargasPeligrosas = cargasPeligrosas;
    }

    public String getNroChasis() {
        return nroChasis;
    }

    public void setNroChasis(String nroChasis) {
        this.nroChasis = nroChasis;
    }

    public String getNroMotor() {
        return nroMotor;
    }

    public void setNroMotor(String nroMotor) {
        this.nroMotor = nroMotor;
    }

    public int getAnioModelo() {
        return anioModelo;
    }

    public void setAnioModelo(int anioModelo) {
        this.anioModelo = anioModelo;
    }

    public String getVersionRTO() {
        return versionRTO;
    }

    public void setVersionRTO(String versionRTO) {
        this.versionRTO = versionRTO;
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
        hash += (nroPlanilla != null ? nroPlanilla.hashCode() : 0);
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
        final Rto other = (Rto) obj;
        if (!Objects.equals(this.nroPlanilla, other.nroPlanilla)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "ar.gob.ambiente.servicios.clienteruta.model.Rto[ nroPlanilla=" + nroPlanilla + " ]";
    }         
}
