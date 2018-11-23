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
@Table(name = "roles", catalog = "esccursos", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roles.findAll", query = "SELECT r FROM Roles r")
    , @NamedQuery(name = "Roles.findByIdrol", query = "SELECT r FROM Roles r WHERE r.idrol = :idrol")
    , @NamedQuery(name = "Roles.findByDescripcion", query = "SELECT r FROM Roles r WHERE r.descripcion = :descripcion")})
public class Roles implements Serializable {

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrol")
    private Integer idrol;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idrol")
    private List<Administrador> administradorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idrol")
    private List<Alumno> alumnoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idrol")
    private List<Profesor> profesorList;

    public Roles() {
    }

    public Roles(Integer idrol) {
        this.idrol = idrol;
    }

    public Roles(Integer idrol, String descripcion) {
        this.idrol = idrol;
        this.descripcion = descripcion;
    }

    public Integer getIdrol() {
        return idrol;
    }

    public void setIdrol(Integer idrol) {
        this.idrol = idrol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Administrador> getAdministradorList() {
        return administradorList;
    }

    public void setAdministradorList(List<Administrador> administradorList) {
        this.administradorList = administradorList;
    }

    @XmlTransient
    public List<Alumno> getAlumnoList() {
        return alumnoList;
    }

    public void setAlumnoList(List<Alumno> alumnoList) {
        this.alumnoList = alumnoList;
    }

    @XmlTransient
    public List<Profesor> getProfesorList() {
        return profesorList;
    }

    public void setProfesorList(List<Profesor> profesorList) {
        this.profesorList = profesorList;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((administradorList == null) ? 0 : administradorList.hashCode());
		result = prime * result + ((alumnoList == null) ? 0 : alumnoList.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((idrol == null) ? 0 : idrol.hashCode());
		result = prime * result + ((profesorList == null) ? 0 : profesorList.hashCode());
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
		Roles other = (Roles) obj;
		if (administradorList == null) {
			if (other.administradorList != null)
				return false;
		} else if (!administradorList.equals(other.administradorList))
			return false;
		if (alumnoList == null) {
			if (other.alumnoList != null)
				return false;
		} else if (!alumnoList.equals(other.alumnoList))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (idrol == null) {
			if (other.idrol != null)
				return false;
		} else if (!idrol.equals(other.idrol))
			return false;
		if (profesorList == null) {
			if (other.profesorList != null)
				return false;
		} else if (!profesorList.equals(other.profesorList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Roles [idrol=" + idrol + ", descripcion=" + descripcion +  "]";
	}


    
}

