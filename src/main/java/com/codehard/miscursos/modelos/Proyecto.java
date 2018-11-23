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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "proyecto", catalog = "esccursos", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyecto.findAll", query = "SELECT p FROM Proyecto p")
    , @NamedQuery(name = "Proyecto.findByIdproyecto", query = "SELECT p FROM Proyecto p WHERE p.idproyecto = :idproyecto")
    , @NamedQuery(name = "Proyecto.findByNombre", query = "SELECT p FROM Proyecto p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Proyecto.findByEstado", query = "SELECT p FROM Proyecto p WHERE p.estado = :estado")
    , @NamedQuery(name = "Proyecto.findByOtraempresa", query = "SELECT p FROM Proyecto p WHERE p.otraempresa = :otraempresa")
    , @NamedQuery(name = "Proyecto.findByOtradireccion", query = "SELECT p FROM Proyecto p WHERE p.otradireccion = :otradireccion")
    , @NamedQuery(name = "Proyecto.findByOtratelefono", query = "SELECT p FROM Proyecto p WHERE p.otratelefono = :otratelefono")
    , @NamedQuery(name = "Proyecto.findByFecharegistro", query = "SELECT p FROM Proyecto p WHERE p.fecharegistro = :fecharegistro")
    , @NamedQuery(name = "Proyecto.findByFechaentrega", query = "SELECT p FROM Proyecto p WHERE p.fechaentrega = :fechaentrega")
    , @NamedQuery(name = "Proyecto.findByOtracontacto", query = "SELECT p FROM Proyecto p WHERE p.otracontacto = :otracontacto")
    , @NamedQuery(name = "Proyecto.findByOtratelefonocontacto", query = "SELECT p FROM Proyecto p WHERE p.otratelefonocontacto = :otratelefonocontacto")})
public class Proyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idproyecto")
    private Integer idproyecto;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Lob
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "estado")
    private short estado;
    @Column(name = "otraempresa")
    private String otraempresa;
    @Column(name = "otradireccion")
    private String otradireccion;
    @Column(name = "otratelefono")
    private String otratelefono;
    @Basic(optional = false)
    @Column(name = "fecharegistro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecharegistro;
    @Basic(optional = false)
    @Column(name = "fechaentrega")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaentrega;
    @Basic(optional = false)
    @Column(name = "otracontacto")
    private String otracontacto;
    @Basic(optional = false)
    @Column(name = "otratelefonocontacto")
    private String otratelefonocontacto;
    @JoinColumn(name = "idalumno", referencedColumnName = "idalumno")
    @ManyToOne(optional = false)
    private Alumno idalumno;
    @JoinColumn(name = "idempresa", referencedColumnName = "idempresa")
    @ManyToOne
    private Empresa idempresa;
    @JoinColumn(name = "idprofesor", referencedColumnName = "idprofesor")
    @ManyToOne(optional = false)
    private Profesor idprofesor;

    public Proyecto() {
    }

    public Proyecto(Integer idproyecto) {
        this.idproyecto = idproyecto;
    }

    public Proyecto(Integer idproyecto, String nombre, String descripcion, short estado, Date fecharegistro, Date fechaentrega, String otracontacto, String otratelefonocontacto) {
        this.idproyecto = idproyecto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fecharegistro = fecharegistro;
        this.fechaentrega = fechaentrega;
        this.otracontacto = otracontacto;
        this.otratelefonocontacto = otratelefonocontacto;
    }

    public Integer getIdproyecto() {
        return idproyecto;
    }

    public void setIdproyecto(Integer idproyecto) {
        this.idproyecto = idproyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public short getEstado() {
        return estado;
    }

    public void setEstado(short estado) {
        this.estado = estado;
    }

    public String getOtraempresa() {
        return otraempresa;
    }

    public void setOtraempresa(String otraempresa) {
        this.otraempresa = otraempresa;
    }

    public String getOtradireccion() {
        return otradireccion;
    }

    public void setOtradireccion(String otradireccion) {
        this.otradireccion = otradireccion;
    }

    public String getOtratelefono() {
        return otratelefono;
    }

    public void setOtratelefono(String otratelefono) {
        this.otratelefono = otratelefono;
    }

    public Date getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public Date getFechaentrega() {
        return fechaentrega;
    }

    public void setFechaentrega(Date fechaentrega) {
        this.fechaentrega = fechaentrega;
    }

    public String getOtracontacto() {
        return otracontacto;
    }

    public void setOtracontacto(String otracontacto) {
        this.otracontacto = otracontacto;
    }

    public String getOtratelefonocontacto() {
        return otratelefonocontacto;
    }

    public void setOtratelefonocontacto(String otratelefonocontacto) {
        this.otratelefonocontacto = otratelefonocontacto;
    }

    public Alumno getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(Alumno idalumno) {
        this.idalumno = idalumno;
    }

    public Empresa getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(Empresa idempresa) {
        this.idempresa = idempresa;
    }

    public Profesor getIdprofesor() {
        return idprofesor;
    }

    public void setIdprofesor(Profesor idprofesor) {
        this.idprofesor = idprofesor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproyecto != null ? idproyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Proyecto)) {
            return false;
        }
        Proyecto other = (Proyecto) object;
        if ((this.idproyecto == null && other.idproyecto != null) || (this.idproyecto != null && !this.idproyecto.equals(other.idproyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hardasarock.miscursos.modelos.Proyecto[ idproyecto=" + idproyecto + " ]";
    }
    
}

