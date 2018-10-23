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
    public int hashCode() {
        int hash = 0;
        hash += (idvideo != null ? idvideo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Videos)) {
            return false;
        }
        Videos other = (Videos) object;
        return !((this.idvideo == null && other.idvideo != null) || (this.idvideo != null && !this.idvideo.equals(other.idvideo)));
    }

    @Override
	public String toString() {
		return "Videos [idvideo=" + idvideo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", url=" + url
				+ ", Tema=" + idtema + "]";
	}
    
}

