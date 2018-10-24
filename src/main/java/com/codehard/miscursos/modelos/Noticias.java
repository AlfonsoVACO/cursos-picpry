package com.codehard.miscursos.modelos;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "noticias", catalog = "esccursos", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Noticias.findAll", query = "SELECT n FROM Noticias n")
    , @NamedQuery(name = "Noticias.findByIdnoticia", query = "SELECT n FROM Noticias n WHERE n.idnoticia = :idnoticia")
    , @NamedQuery(name = "Noticias.findByNombre", query = "SELECT n FROM Noticias n WHERE n.nombre = :nombre")
    , @NamedQuery(name = "Noticias.findByFecha", query = "SELECT n FROM Noticias n WHERE n.fecha = :fecha")})
public class Noticias implements Serializable {

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idnoticia")
    private Integer idnoticia;
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
    @JoinColumn(name = "idadmin", referencedColumnName = "idadmin")
    @ManyToOne(optional = false)
    @JsonBackReference
    private Administrador idadmin;
    @JoinColumn(name = "idplantel", referencedColumnName = "idplantel")
    @ManyToOne(optional = false)
    @JsonBackReference
    private Plantel idplantel;

    public Noticias() {
    }

    public Noticias(Integer idnoticia) {
        this.idnoticia = idnoticia;
    }

    public Noticias(Integer idnoticia, String nombre, String descripcion, Date fecha) {
        this.idnoticia = idnoticia;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public Integer getIdnoticia() {
        return idnoticia;
    }

    public void setIdnoticia(Integer idnoticia) {
        this.idnoticia = idnoticia;
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

    public Administrador getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(Administrador idadmin) {
        this.idadmin = idadmin;
    }

    public Plantel getIdplantel() {
        return idplantel;
    }

    public void setIdplantel(Plantel idplantel) {
        this.idplantel = idplantel;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((idadmin == null) ? 0 : idadmin.hashCode());
		result = prime * result + ((idnoticia == null) ? 0 : idnoticia.hashCode());
		result = prime * result + ((idplantel == null) ? 0 : idplantel.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Noticias other = (Noticias) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (idadmin == null) {
			if (other.idadmin != null)
				return false;
		} else if (!idadmin.equals(other.idadmin))
			return false;
		if (idnoticia == null) {
			if (other.idnoticia != null)
				return false;
		} else if (!idnoticia.equals(other.idnoticia))
			return false;
		if (idplantel == null) {
			if (other.idplantel != null)
				return false;
		} else if (!idplantel.equals(other.idplantel))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Noticias [idnoticia=" + idnoticia + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fecha="
				+ fecha + "]";
	}

    
}
