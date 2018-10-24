package com.codehard.miscursos.modelos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "videos", catalog = "esccursos", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Videos.findAll", query = "SELECT v FROM Videos v")
    , @NamedQuery(name = "Videos.findByIdvideo", query = "SELECT v FROM Videos v WHERE v.idvideo = :idvideo")
    , @NamedQuery(name = "Videos.findByNombre", query = "SELECT v FROM Videos v WHERE v.nombre = :nombre")
    , @NamedQuery(name = "Videos.findByDescripcion", query = "SELECT v FROM Videos v WHERE v.descripcion = :descripcion")
    , @NamedQuery(name = "Videos.findByUrl", query = "SELECT v FROM Videos v WHERE v.url = :url")})
public class Videos implements Serializable {

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idvideo")
    private Integer idvideo;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "url")
    private String url;
    @JoinColumn(name = "idtema", referencedColumnName = "idtema")
    @ManyToOne(optional = false)
    private Temas idtema;

    public Videos() {
    }

    public Videos(Integer idvideo) {
        this.idvideo = idvideo;
    }

    public Videos(Integer idvideo, String nombre, String descripcion, String url) {
        this.idvideo = idvideo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.url = url;
    }

    public Integer getIdvideo() {
        return idvideo;
    }

    public void setIdvideo(Integer idvideo) {
        this.idvideo = idvideo;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Temas getIdtema() {
        return idtema;
    }

    public void setIdtema(Temas idtema) {
        this.idtema = idtema;
    }

	@Override
	public String toString() {
		return "Videos [idvideo=" + idvideo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", url=" + url
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((idtema == null) ? 0 : idtema.hashCode());
		result = prime * result + ((idvideo == null) ? 0 : idvideo.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
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
		Videos other = (Videos) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (idtema == null) {
			if (other.idtema != null)
				return false;
		} else if (!idtema.equals(other.idtema))
			return false;
		if (idvideo == null) {
			if (other.idvideo != null)
				return false;
		} else if (!idvideo.equals(other.idvideo))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

    
    
}

