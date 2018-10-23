package com.codehard.miscursos.modelos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "temas", catalog = "esccursos", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Temas.findAll", query = "SELECT t FROM Temas t")
    , @NamedQuery(name = "Temas.findByIdtema", query = "SELECT t FROM Temas t WHERE t.idtema = :idtema")
    , @NamedQuery(name = "Temas.findByNombre", query = "SELECT t FROM Temas t WHERE t.nombre = :nombre")})
public class Temas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtema")
    private Integer idtema;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Lob
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtema")
    private List<Videos> videosList;
    @JoinColumn(name = "idcurso", referencedColumnName = "idcurso")
    @ManyToOne(optional = false)
    private Cursos idcurso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtema")
    private List<Recursos> recursosList;

    public Temas() {
    }

    public Temas(Integer idtema) {
        this.idtema = idtema;
    }

    public Temas(Integer idtema, String nombre, String descripcion) {
        this.idtema = idtema;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getIdtema() {
        return idtema;
    }

    public void setIdtema(Integer idtema) {
        this.idtema = idtema;
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

    @XmlTransient
    public List<Videos> getVideosList() {
        return videosList;
    }

    public void setVideosList(List<Videos> videosList) {
        this.videosList = videosList;
    }

    public Cursos getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(Cursos idcurso) {
        this.idcurso = idcurso;
    }

    @XmlTransient
    public List<Recursos> getRecursosList() {
        return recursosList;
    }

    public void setRecursosList(List<Recursos> recursosList) {
        this.recursosList = recursosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtema != null ? idtema.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Temas)) {
            return false;
        }
        Temas other = (Temas) object;
        return !((this.idtema == null && other.idtema != null) || (this.idtema != null && !this.idtema.equals(other.idtema)));
    }

    @Override
    public String toString() {
        return "com.hardasarock.miscursos.modelos.Temas[ idtema=" + idtema + " ]";
    }
    
}
