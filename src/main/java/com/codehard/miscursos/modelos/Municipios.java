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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "municipios", catalog = "esccursos", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Municipios.findAll", query = "SELECT m FROM Municipios m")
    , @NamedQuery(name = "Municipios.findByIdmunicipio", query = "SELECT m FROM Municipios m WHERE m.idmunicipio = :idmunicipio")
    , @NamedQuery(name = "Municipios.findByNombre", query = "SELECT m FROM Municipios m WHERE m.nombre = :nombre")})
public class Municipios implements Serializable {

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmunicipio")
    private Integer idmunicipio;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmunicipio")
    private List<Plantel> plantelList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmunicipio")
    private List<Alumno> alumnoList;

    public Municipios() {
    }

    public Municipios(Integer idmunicipio) {
        this.idmunicipio = idmunicipio;
    }

    public Municipios(Integer idmunicipio, String nombre) {
        this.idmunicipio = idmunicipio;
        this.nombre = nombre;
    }

    public Integer getIdmunicipio() {
        return idmunicipio;
    }

    public void setIdmunicipio(Integer idmunicipio) {
        this.idmunicipio = idmunicipio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Plantel> getPlantelList() {
        return plantelList;
    }

    public void setPlantelList(List<Plantel> plantelList) {
        this.plantelList = plantelList;
    }

    @XmlTransient
    public List<Alumno> getAlumnoList() {
        return alumnoList;
    }

    public void setAlumnoList(List<Alumno> alumnoList) {
        this.alumnoList = alumnoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmunicipio != null ? idmunicipio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Municipios)) {
            return false;
        }
        Municipios other = (Municipios) object;
        return !((this.idmunicipio == null && other.idmunicipio != null) || (this.idmunicipio != null && !this.idmunicipio.equals(other.idmunicipio)));
    }

    @Override
	public String toString() {
		return "Municipios [idmunicipio=" + idmunicipio + ", nombre=" + nombre + ", alumnoList=" + alumnoList
				+ ", plantelList=" + plantelList + "]";
	}
    
}

