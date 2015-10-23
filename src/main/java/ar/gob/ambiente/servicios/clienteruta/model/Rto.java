/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.gob.ambiente.servicios.clienteruta.model;

import java.io.Serializable;

/**
 * Clase que encapsula los datos de la Revisión técnica del vehículo
 * @author rincostante
 */
public class Rto implements Serializable{

    
    /**
     * Versión del Servicio web
     */
    private String versionWS;
    private String versionRTO;
    private String anioModelo;
    private boolean cargasPeligrosas;
    private String nroChasis;
    private String nroMotor;   
    private String codTipoCaja;
    private String tipoCaja;    
    private String configuracionEjes;
    private String numeroEjes;
    private String marcaTacografo;
    private String nroTacografo;
    private String serieCertificado;
    private String nroCertificado;
    private String codTipoVehiculo;
    private String categoriaVehiculo;
    private String nroPlanilla;
    private String codTaller;
    private String codAuditoria;
    private String dominio;
    private String fechaRevision;
    private String fechaVencimiento;
    private String codTipoUso;

    
    /*******************
     * Geters y Seters *
     *******************/    
    public String getConfiguracionEjes() {
        return configuracionEjes;
    }

    public void setConfiguracionEjes(String configuracionEjes) {
        this.configuracionEjes = configuracionEjes;
    }

    public String getNumeroEjes() {
        return numeroEjes;
    }

    public void setNumeroEjes(String numeroEjes) {
        this.numeroEjes = numeroEjes;
    }

    public String getMarcaTacografo() {
        return marcaTacografo;
    }

    public void setMarcaTacografo(String marcaTacografo) {
        this.marcaTacografo = marcaTacografo;
    }

    public String getNroTacografo() {
        return nroTacografo;
    }

    public void setNroTacografo(String nroTacografo) {
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
    
    public String getVersionRTO() {
        return versionRTO;
    }

    public void setVersionRTO(String versionRTO) {
        this.versionRTO = versionRTO;
    }

    public String getAnioModelo() {
        return anioModelo;
    }

    public void setAnioModelo(String anioModelo) {
        this.anioModelo = anioModelo;
    }

    public String getVersionWS() {
        return versionWS;
    }

    public void setVersionWS(String versionWS) {
        this.versionWS = versionWS;
    }
    public String getSerieCertificado() {
        return serieCertificado;
    }

    public void setSerieCertificado(String serieCertificado) {
        this.serieCertificado = serieCertificado;
    }

    public String getNroCertificado() {
        return nroCertificado;
    }

    public void setNroCertificado(String nroCertificado) {
        this.nroCertificado = nroCertificado;
    }

    public String getCodTipoVehiculo() {
        return codTipoVehiculo;
    }

    public void setCodTipoVehiculo(String codTipoVehiculo) {
        this.codTipoVehiculo = codTipoVehiculo;
    }

    public String getCategoriaVehiculo() {
        return categoriaVehiculo;
    }

    public void setCategoriaVehiculo(String categoriaVehiculo) {
        this.categoriaVehiculo = categoriaVehiculo;
    }

    public String getNroPlanilla() {
        return nroPlanilla;
    }

    public void setNroPlanilla(String nroPlanilla) {
        this.nroPlanilla = nroPlanilla;
    }

    public String getCodTaller() {
        return codTaller;
    }

    public void setCodTaller(String codTaller) {
        this.codTaller = codTaller;
    }

    public String getCodAuditoria() {
        return codAuditoria;
    }

    public void setCodAuditoria(String codAuditoria) {
        this.codAuditoria = codAuditoria;
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
    
    public Rto(String versionWS, 
            String versionRTO, 
            String anioModelo, 
            boolean cargasPeligrosas, 
            String nroChasis, 
            String nroMotor,
            String codTipoCaja,
            String tipoCaja,
            String numeroEjes,
            String configuracionEjes,
            String marcaTacografo,
            String nroTacografo,
            String serieCertificado,
            String nroCertificado,
            String codTipoVehiculo,
            String categoriaVehiculo,
            
            String nroPlanilla,
            String codTaller,
            String codAuditoria,
            String dominio,
            String fechaRevision,
            String fechaVencimiento,
            String codTipoUso){
        this.cargasPeligrosas = cargasPeligrosas;
        this.nroChasis = nroChasis;
        this.nroMotor = nroMotor;        
        this.anioModelo = anioModelo;
        this.versionRTO = versionRTO;
        this.versionWS = versionWS;
        this.codTipoCaja = codTipoCaja;
        this.tipoCaja = tipoCaja;
        this.numeroEjes = numeroEjes;
        this.configuracionEjes = configuracionEjes;
        this.marcaTacografo = marcaTacografo;
        this.nroTacografo = nroTacografo;
        this.serieCertificado = serieCertificado;
        this.nroCertificado = nroCertificado;
        this.codTipoVehiculo = codTipoVehiculo;
        this.categoriaVehiculo = categoriaVehiculo;
        this.nroPlanilla = nroPlanilla;
        this.codTaller = codTaller;
        this.codAuditoria = codAuditoria;
        this.dominio = dominio;
        this.fechaRevision = fechaRevision;
        this.fechaVencimiento = fechaVencimiento;
        this.codTipoUso = codTipoUso;
    }
}
