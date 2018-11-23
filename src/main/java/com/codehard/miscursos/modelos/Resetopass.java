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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "resetopass", catalog = "esccursos", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resetopass.findAll", query = "SELECT r FROM Resetopass r")
    , @NamedQuery(name = "Resetopass.findByIdresetopass", query = "SELECT r FROM Resetopass r WHERE r.idresetopass = :idresetopass")
    , @NamedQuery(name = "Resetopass.findByToken", query = "SELECT r FROM Resetopass r WHERE r.token = :token")
    , @NamedQuery(name = "Resetopass.findByCreado", query = "SELECT r FROM Resetopass r WHERE r.creado = :creado")})
public class Resetopass implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idresetopass")
    private Integer idresetopass;
    @Basic(optional = false)
    @Column(name = "token")
    private String token;
    @Basic(optional = false)
    @Column(name = "creado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creado;
    @JoinColumn(name = "idalumno", referencedColumnName = "idalumno")
    @ManyToOne(optional = false)
    private Alumno idalumno;

    public Resetopass() {
    }

    public Resetopass(Integer idresetopass) {
        this.idresetopass = idresetopass;
    }

    public Resetopass(Integer idresetopass, String token, Date creado) {
        this.idresetopass = idresetopass;
        this.token = token;
        this.creado = creado;
    }

    public Integer getIdresetopass() {
        return idresetopass;
    }

    public void setIdresetopass(Integer idresetopass) {
        this.idresetopass = idresetopass;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getCreado() {
        return creado;
    }

    public void setCreado(Date creado) {
        this.creado = creado;
    }

    public Alumno getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(Alumno idalumno) {
        this.idalumno = idalumno;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creado == null) ? 0 : creado.hashCode());
		result = prime * result + ((idalumno == null) ? 0 : idalumno.hashCode());
		result = prime * result + ((idresetopass == null) ? 0 : idresetopass.hashCode());
		result = prime * result + ((token == null) ? 0 : token.hashCode());
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
		Resetopass other = (Resetopass) obj;
		if (creado == null) {
			if (other.creado != null)
				return false;
		} else if (!creado.equals(other.creado))
			return false;
		if (idalumno == null) {
			if (other.idalumno != null)
				return false;
		} else if (!idalumno.equals(other.idalumno))
			return false;
		if (idresetopass == null) {
			if (other.idresetopass != null)
				return false;
		} else if (!idresetopass.equals(other.idresetopass))
			return false;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Resetopass [idresetopass=" + idresetopass + ", token=" + token + ", creado=" + creado +  "]";
	}


    
}
