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

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "estados", catalog = "esccursos", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estados.findAll", query = "SELECT e FROM Estados e")
    , @NamedQuery(name = "Estados.findByIdestado", query = "SELECT e FROM Estados e WHERE e.idestado = :idestado")
    , @NamedQuery(name = "Estados.findByNombre", query = "SELECT e FROM Estados e WHERE e.nombre = :nombre")})
public class Estados implements Serializable {

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idestado")
    private Integer idestado;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idestado")
    @JsonManagedReference
    private List<Plantel> plantelList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idestado")
    @JsonManagedReference
    private List<Alumno> alumnoList;

    public Estados() {
    }

    public Estados(Integer idestado) {
        this.idestado = idestado;
    }

    public Estados(Integer idestado, String nombre) {
        this.idestado = idestado;
        this.nombre = nombre;
    }

    public Integer getIdestado() {
        return idestado;
    }

    public void setIdestado(Integer idestado) {
        this.idestado = idestado;
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
		result = prime * result + ((idestado == null) ? 0 : idestado.hashCode());
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
		Estados other = (Estados) obj;
		if (alumnoList == null) {
			if (other.alumnoList != null)
				return false;
		} else if (!alumnoList.equals(other.alumnoList))
			return false;
		if (idestado == null) {
			if (other.idestado != null)
				return false;
		} else if (!idestado.equals(other.idestado))
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
		return "Estados [idestado=" + idestado + ", nombre=" + nombre + "]";
	}

    
}

