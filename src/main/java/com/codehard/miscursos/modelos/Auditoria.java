package com.codehard.miscursos.modelos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "auditoria", catalog = "esccursos", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Auditoria.findAll", query = "SELECT a FROM Auditoria a")
    , @NamedQuery(name = "Auditoria.findByIdaudita", query = "SELECT a FROM Auditoria a WHERE a.idaudita = :idaudita")
    , @NamedQuery(name = "Auditoria.findByIp", query = "SELECT a FROM Auditoria a WHERE a.ip = :ip")
    , @NamedQuery(name = "Auditoria.findByAccion", query = "SELECT a FROM Auditoria a WHERE a.accion = :accion")
    , @NamedQuery(name = "Auditoria.findByTabla", query = "SELECT a FROM Auditoria a WHERE a.tabla = :tabla")
    , @NamedQuery(name = "Auditoria.findByFecharegistro", query = "SELECT a FROM Auditoria a WHERE a.fecharegistro = :fecharegistro")})
public class Auditoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idaudita")
    private Integer idaudita;
    @Basic(optional = false)
    @Column(name = "ip")
    private String ip;
    @Basic(optional = false)
    @Column(name = "accion")
    private String accion;
    @Basic(optional = false)
    @Column(name = "tabla")
    private String tabla;
    @Basic(optional = false)
    @Column(name = "fecharegistro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecharegistro;

    public Auditoria() {
    }

    public Auditoria(Integer idaudita) {
        this.idaudita = idaudita;
    }

    public Auditoria(Integer idaudita, String ip, String accion, String tabla, Date fecharegistro) {
        this.idaudita = idaudita;
        this.ip = ip;
        this.accion = accion;
        this.tabla = tabla;
        this.fecharegistro = fecharegistro;
    }

    public Integer getIdaudita() {
        return idaudita;
    }

    public void setIdaudita(Integer idaudita) {
        this.idaudita = idaudita;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public Date getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accion == null) ? 0 : accion.hashCode());
		result = prime * result + ((fecharegistro == null) ? 0 : fecharegistro.hashCode());
		result = prime * result + ((idaudita == null) ? 0 : idaudita.hashCode());
		result = prime * result + ((ip == null) ? 0 : ip.hashCode());
		result = prime * result + ((tabla == null) ? 0 : tabla.hashCode());
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
		Auditoria other = (Auditoria) obj;
		if (accion == null) {
			if (other.accion != null)
				return false;
		} else if (!accion.equals(other.accion))
			return false;
		if (fecharegistro == null) {
			if (other.fecharegistro != null)
				return false;
		} else if (!fecharegistro.equals(other.fecharegistro))
			return false;
		if (idaudita == null) {
			if (other.idaudita != null)
				return false;
		} else if (!idaudita.equals(other.idaudita))
			return false;
		if (ip == null) {
			if (other.ip != null)
				return false;
		} else if (!ip.equals(other.ip))
			return false;
		if (tabla == null) {
			if (other.tabla != null)
				return false;
		} else if (!tabla.equals(other.tabla))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Auditoria [idaudita=" + idaudita + ", ip=" + ip + ", accion=" + accion + ", tabla=" + tabla
				+ ", fecharegistro=" + fecharegistro + "]";
	}

    
}
