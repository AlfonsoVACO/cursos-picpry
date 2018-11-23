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
@Table(name = "servicios", catalog = "esccursos", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servicios.findAll", query = "SELECT s FROM Servicios s")
    , @NamedQuery(name = "Servicios.findByIdservicio", query = "SELECT s FROM Servicios s WHERE s.idservicio = :idservicio")
    , @NamedQuery(name = "Servicios.findByNombre", query = "SELECT s FROM Servicios s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "Servicios.findByEstatus", query = "SELECT s FROM Servicios s WHERE s.estatus = :estatus")
    , @NamedQuery(name = "Servicios.findByFecha", query = "SELECT s FROM Servicios s WHERE s.fecha = :fecha")})
public class Servicios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idservicio")
    private Integer idservicio;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "estatus")
    private short estatus;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "idalumno", referencedColumnName = "idalumno")
    @ManyToOne(optional = false)
    private Alumno idalumno;

    public Servicios() {
    }

    public Servicios(Integer idservicio) {
        this.idservicio = idservicio;
    }

    public Servicios(Integer idservicio, String nombre, short estatus, Date fecha) {
        this.idservicio = idservicio;
        this.nombre = nombre;
        this.estatus = estatus;
        this.fecha = fecha;
    }

    public Integer getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(Integer idservicio) {
        this.idservicio = idservicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public short getEstatus() {
        return estatus;
    }

    public void setEstatus(short estatus) {
        this.estatus = estatus;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idservicio != null ? idservicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Servicios)) {
            return false;
        }
        Servicios other = (Servicios) object;
        if ((this.idservicio == null && other.idservicio != null) || (this.idservicio != null && !this.idservicio.equals(other.idservicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hardasarock.miscursos.modelos.Servicios[ idservicio=" + idservicio + " ]";
    }
    
}
