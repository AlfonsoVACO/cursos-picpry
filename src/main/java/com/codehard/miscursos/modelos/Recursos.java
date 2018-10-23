package com.codehard.miscursos.modelos;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "recursos", catalog = "esccursos", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recursos.findAll", query = "SELECT r FROM Recursos r")
    , @NamedQuery(name = "Recursos.findByIdrecurso", query = "SELECT r FROM Recursos r WHERE r.idrecurso = :idrecurso")
    , @NamedQuery(name = "Recursos.findByNombre", query = "SELECT r FROM Recursos r WHERE r.nombre = :nombre")
    , @NamedQuery(name = "Recursos.findByFecha", query = "SELECT r FROM Recursos r WHERE r.fecha = :fecha")})
public class Recursos implements Serializable {

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
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idrecurso")
    private List<Archivos> archivosList;
    @JoinColumn(name = "idtema", referencedColumnName = "idtema")
    @ManyToOne(optional = false)
    private Temas idtema;

    public Recursos() {
    }

    public Recursos(Integer idrecurso) {
        this.idrecurso = idrecurso;
    }

    public Recursos(Integer idrecurso, String nombre, String descripcion, Date fecha) {
        this.idrecurso = idrecurso;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @XmlTransient
    public List<Archivos> getArchivosList() {
        return archivosList;
    }

    public void setArchivosList(List<Archivos> archivosList) {
        this.archivosList = archivosList;
    }

    public Temas getIdtema() {
        return idtema;
    }

    public void setIdtema(Temas idtema) {
        this.idtema = idtema;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrecurso != null ? idrecurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Recursos)) {
            return false;
        }
        Recursos other = (Recursos) object;
        return !((this.idrecurso == null && other.idrecurso != null) || (this.idrecurso != null && !this.idrecurso.equals(other.idrecurso)));
    }

    @Override
	public String toString() {
		return "Recursos [idrecurso=" + idrecurso + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fecha="
				+ fecha + ", archivosList=" + archivosList + ", idTema=" + idtema + "]";
	}
    
}

