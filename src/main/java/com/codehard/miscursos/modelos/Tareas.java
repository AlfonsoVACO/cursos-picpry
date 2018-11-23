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
@Table(name = "tareas", catalog = "esccursos", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tareas.findAll", query = "SELECT t FROM Tareas t")
    , @NamedQuery(name = "Tareas.findByIdtarea", query = "SELECT t FROM Tareas t WHERE t.idtarea = :idtarea")
    , @NamedQuery(name = "Tareas.findByNombre", query = "SELECT t FROM Tareas t WHERE t.nombre = :nombre")})
public class Tareas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtarea")
    private Integer idtarea;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Lob
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtarea")
    private List<Recursotarea> recursotareaList;
    @JoinColumn(name = "idclase", referencedColumnName = "idclase")
    @ManyToOne(optional = false)
    private Clases idclase;

    public Tareas() {
    }

    public Tareas(Integer idtarea) {
        this.idtarea = idtarea;
    }

    public Tareas(Integer idtarea, String nombre, String descripcion) {
        this.idtarea = idtarea;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getIdtarea() {
        return idtarea;
    }

    public void setIdtarea(Integer idtarea) {
        this.idtarea = idtarea;
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
    public List<Recursotarea> getRecursotareaList() {
        return recursotareaList;
    }

    public void setRecursotareaList(List<Recursotarea> recursotareaList) {
        this.recursotareaList = recursotareaList;
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
        hash += (idtarea != null ? idtarea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Tareas)) {
            return false;
        }
        Tareas other = (Tareas) object;
        if ((this.idtarea == null && other.idtarea != null) || (this.idtarea != null && !this.idtarea.equals(other.idtarea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hardasarock.miscursos.modelos.Tareas[ idtarea=" + idtarea + " ]";
    }
    
}
