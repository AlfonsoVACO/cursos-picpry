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
    private Administrador idadmin;
    @JoinColumn(name = "idplantel", referencedColumnName = "idplantel")
    @ManyToOne(optional = false)
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
        int hash = 0;
        hash += (idnoticia != null ? idnoticia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Noticias)) {
            return false;
        }
        Noticias other = (Noticias) object;
        return !((this.idnoticia == null && other.idnoticia != null) || (this.idnoticia != null && !this.idnoticia.equals(other.idnoticia)));
    }

    @Override
	public String toString() {
		return "Noticias [idnoticia=" + idnoticia + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fecha="
				+ fecha + ", idplantel=" + idplantel + "]";
	}
    
}
