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
    
    public Municipios(String nombre) {
        this.nombre = nombre;
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
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alumnoList == null) ? 0 : alumnoList.hashCode());
		result = prime * result + ((idmunicipio == null) ? 0 : idmunicipio.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((plantelList == null) ? 0 : plantelList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Municipios other = (Municipios) obj;
		if (alumnoList == null) {
			if (other.alumnoList != null)
				return false;
		} else if (!alumnoList.equals(other.alumnoList))
			return false;
		if (idmunicipio == null) {
			if (other.idmunicipio != null)
				return false;
		} else if (!idmunicipio.equals(other.idmunicipio))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (plantelList == null) {
			if (other.plantelList != null)
				return false;
		} else if (!plantelList.equals(other.plantelList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Municipios [idmunicipio=" + idmunicipio + ", nombre=" + nombre +  "]";
	}

    
}

