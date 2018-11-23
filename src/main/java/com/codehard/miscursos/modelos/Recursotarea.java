package com.codehard.miscursos.modelos;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "recursotarea", catalog = "esccursos", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recursotarea.findAll", query = "SELECT r FROM Recursotarea r")
    , @NamedQuery(name = "Recursotarea.findByIdrecurso", query = "SELECT r FROM Recursotarea r WHERE r.idrecurso = :idrecurso")
    , @NamedQuery(name = "Recursotarea.findByNombre", query = "SELECT r FROM Recursotarea r WHERE r.nombre = :nombre")
    , @NamedQuery(name = "Recursotarea.findByArchivo", query = "SELECT r FROM Recursotarea r WHERE r.archivo = :archivo")
    , @NamedQuery(name = "Recursotarea.findByTipoarchivo", query = "SELECT r FROM Recursotarea r WHERE r.tipoarchivo = :tipoarchivo")
    , @NamedQuery(name = "Recursotarea.findByExtension", query = "SELECT r FROM Recursotarea r WHERE r.extension = :extension")})
public class Recursotarea implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrecurso")
    private Integer idrecurso;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Lob
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "archivo")
    private String archivo;
    @Column(name = "tipoarchivo")
    private String tipoarchivo;
    @Column(name = "extension")
    private String extension;
    @JoinColumn(name = "idalumno", referencedColumnName = "idalumno")
    @ManyToOne(optional = false)
    private Alumno idalumno;
    @JoinColumn(name = "idtarea", referencedColumnName = "idtarea")
    @ManyToOne(optional = false)
    private Tareas idtarea;

    public Recursotarea() {
    }

    public Recursotarea(Integer idrecurso) {
        this.idrecurso = idrecurso;
    }

    public Recursotarea(Integer idrecurso, String nombre, String descripcion) {
        this.idrecurso = idrecurso;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getIdrecurso() {
        return idrecurso;
    }

    public void setIdrecurso(Integer idrecurso) {
        this.idrecurso = idrecurso;
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

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public String getTipoarchivo() {
        return tipoarchivo;
    }

    public void setTipoarchivo(String tipoarchivo) {
        this.tipoarchivo = tipoarchivo;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Alumno getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(Alumno idalumno) {
        this.idalumno = idalumno;
    }

    public Tareas getIdtarea() {
        return idtarea;
    }

    public void setIdtarea(Tareas idtarea) {
        this.idtarea = idtarea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrecurso != null ? idrecurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Recursotarea)) {
            return false;
        }
        Recursotarea other = (Recursotarea) object;
        if ((this.idrecurso == null && other.idrecurso != null) || (this.idrecurso != null && !this.idrecurso.equals(other.idrecurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hardasarock.miscursos.modelos.Recursotarea[ idrecurso=" + idrecurso + " ]";
    }
    
}
