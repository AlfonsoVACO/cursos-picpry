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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "clases", catalog = "esccursos", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clases.findAll", query = "SELECT c FROM Clases c")
    , @NamedQuery(name = "Clases.findByIdclase", query = "SELECT c FROM Clases c WHERE c.idclase = :idclase")
    , @NamedQuery(name = "Clases.findByNombre", query = "SELECT c FROM Clases c WHERE c.nombre = :nombre")})
public class Clases implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idclase")
    private Integer idclase;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idclase")
    private List<Notasfinales> notasfinalesList;
    @JoinColumn(name = "idgrupo", referencedColumnName = "idgrupo")
    @ManyToOne(optional = false)
    private Grupo idgrupo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idclase")
    private List<Faltasclase> faltasclaseList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idclase")
    private List<Tareas> tareasList;

    public Clases() {
    }

    public Clases(Integer idclase) {
        this.idclase = idclase;
    }

    public Clases(Integer idclase, String nombre) {
        this.idclase = idclase;
        this.nombre = nombre;
    }

    public Integer getIdclase() {
        return idclase;
    }

    public void setIdclase(Integer idclase) {
        this.idclase = idclase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Notasfinales> getNotasfinalesList() {
        return notasfinalesList;
    }

    public void setNotasfinalesList(List<Notasfinales> notasfinalesList) {
        this.notasfinalesList = notasfinalesList;
    }

    public Grupo getIdgrupo() {
        return idgrupo;
    }

    public void setIdgrupo(Grupo idgrupo) {
        this.idgrupo = idgrupo;
    }

    @XmlTransient
    public List<Faltasclase> getFaltasclaseList() {
        return faltasclaseList;
    }

    public void setFaltasclaseList(List<Faltasclase> faltasclaseList) {
        this.faltasclaseList = faltasclaseList;
    }

    @XmlTransient
    public List<Tareas> getTareasList() {
        return tareasList;
    }

    public void setTareasList(List<Tareas> tareasList) {
        this.tareasList = tareasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idclase != null ? idclase.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Clases)) {
            return false;
        }
        Clases other = (Clases) object;
        if ((this.idclase == null && other.idclase != null) || (this.idclase != null && !this.idclase.equals(other.idclase))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hardasarock.miscursos.modelos.Clases[ idclase=" + idclase + " ]";
    }
    
}
