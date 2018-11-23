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
@Table(name = "faltasclase", catalog = "esccursos", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Faltasclase.findAll", query = "SELECT f FROM Faltasclase f")
    , @NamedQuery(name = "Faltasclase.findByIdasistencia", query = "SELECT f FROM Faltasclase f WHERE f.idasistencia = :idasistencia")
    , @NamedQuery(name = "Faltasclase.findByTipofalta", query = "SELECT f FROM Faltasclase f WHERE f.tipofalta = :tipofalta")
    , @NamedQuery(name = "Faltasclase.findByFecha", query = "SELECT f FROM Faltasclase f WHERE f.fecha = :fecha")})
public class Faltasclase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idasistencia")
    private Integer idasistencia;
    @Basic(optional = false)
    @Column(name = "tipofalta")
    private short tipofalta;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "idalumno", referencedColumnName = "idalumno")
    @ManyToOne(optional = false)
    private Alumno idalumno;
    @JoinColumn(name = "idclase", referencedColumnName = "idclase")
    @ManyToOne(optional = false)
    private Clases idclase;

    public Faltasclase() {
    }

    public Faltasclase(Integer idasistencia) {
        this.idasistencia = idasistencia;
    }

    public Faltasclase(Integer idasistencia, short tipofalta, Date fecha) {
        this.idasistencia = idasistencia;
        this.tipofalta = tipofalta;
        this.fecha = fecha;
    }

    public Integer getIdasistencia() {
        return idasistencia;
    }

    public void setIdasistencia(Integer idasistencia) {
        this.idasistencia = idasistencia;
    }

    public short getTipofalta() {
        return tipofalta;
    }

    public void setTipofalta(short tipofalta) {
        this.tipofalta = tipofalta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Alumno getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(Alumno idalumno) {
        this.idalumno = idalumno;
    }

    public Clases getIdclase() {
        return idclase;
    }

    public void setIdclase(Clases idclase) {
        this.idclase = idclase;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idasistencia != null ? idasistencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Faltasclase)) {
            return false;
        }
        Faltasclase other = (Faltasclase) object;
        if ((this.idasistencia == null && other.idasistencia != null) || (this.idasistencia != null && !this.idasistencia.equals(other.idasistencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hardasarock.miscursos.modelos.Faltasclase[ idasistencia=" + idasistencia + " ]";
    }
    
}
