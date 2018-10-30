package com.codehard.miscursos.modelos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "otrospagos", catalog = "esccursos", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Otrospagos.findAll", query = "SELECT o FROM Otrospagos o")
    , @NamedQuery(name = "Otrospagos.findByIdpago", query = "SELECT o FROM Otrospagos o WHERE o.idpago = :idpago")
    , @NamedQuery(name = "Otrospagos.findByConcepto", query = "SELECT o FROM Otrospagos o WHERE o.concepto = :concepto")
    , @NamedQuery(name = "Otrospagos.findByMonto", query = "SELECT o FROM Otrospagos o WHERE o.monto = :monto")
    , @NamedQuery(name = "Otrospagos.findByEstatus", query = "SELECT o FROM Otrospagos o WHERE o.estatus = :estatus")
    , @NamedQuery(name = "Otrospagos.findByReferencia", query = "SELECT o FROM Otrospagos o WHERE o.referencia = :referencia")
    , @NamedQuery(name = "Otrospagos.findByFechapago", query = "SELECT o FROM Otrospagos o WHERE o.fechapago = :fechapago")})
public class Otrospagos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpago")
    private Integer idpago;
    @Basic(optional = false)
    @Column(name = "concepto")
    private String concepto;
    @Basic(optional = false)
    @Column(name = "monto")
    private double monto;
    @Basic(optional = false)
    @Column(name = "estatus")
    private short estatus;
    @Column(name = "referencia")
    private String referencia;
    @Basic(optional = false)
    @Column(name = "fechapago")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechapago;
    @JoinColumn(name = "idalumno", referencedColumnName = "idalumno")
    @ManyToOne(optional = false)
    private Alumno idalumno;

    public Otrospagos() {
    }

    public Otrospagos(Integer idpago) {
        this.idpago = idpago;
    }

    public Otrospagos(Integer idpago, String concepto, double monto, short estatus, Date fechapago) {
        this.idpago = idpago;
        this.concepto = concepto;
        this.monto = monto;
        this.estatus = estatus;
        this.fechapago = fechapago;
    }

    public Integer getIdpago() {
        return idpago;
    }

    public void setIdpago(Integer idpago) {
        this.idpago = idpago;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public short getEstatus() {
        return estatus;
    }

    public void setEstatus(short estatus) {
        this.estatus = estatus;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Date getFechapago() {
        return fechapago;
    }

    public void setFechapago(Date fechapago) {
        this.fechapago = fechapago;
    }

    public Alumno getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(Alumno idalumno) {
        this.idalumno = idalumno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpago != null ? idpago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Otrospagos)) {
            return false;
        }
        Otrospagos other = (Otrospagos) object;
        if ((this.idpago == null && other.idpago != null) || (this.idpago != null && !this.idpago.equals(other.idpago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hardasarock.miscursos.modelos.Otrospagos[ idpago=" + idpago + " ]";
    }
    
}
