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
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((idcurso == null) ? 0 : idcurso.hashCode());
		result = prime * result + ((idtema == null) ? 0 : idtema.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((recursosList == null) ? 0 : recursosList.hashCode());
		result = prime * result + ((videosList == null) ? 0 : videosList.hashCode());
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
		Temas other = (Temas) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (idcurso == null) {
			if (other.idcurso != null)
				return false;
		} else if (!idcurso.equals(other.idcurso))
			return false;
		if (idtema == null) {
			if (other.idtema != null)
				return false;
		} else if (!idtema.equals(other.idtema))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (recursosList == null) {
			if (other.recursosList != null)
				return false;
		} else if (!recursosList.equals(other.recursosList))
			return false;
		if (videosList == null) {
			if (other.videosList != null)
				return false;
		} else if (!videosList.equals(other.videosList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Temas [idtema=" + idtema + ", nombre=" + nombre + ", descripcion=" + descripcion + ", videosList="
				+ videosList + ", idcurso=" + idcurso + ", recursosList=" + recursosList + "]";
	}

    
    
}
