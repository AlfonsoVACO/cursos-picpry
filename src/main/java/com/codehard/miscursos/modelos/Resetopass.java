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
        int hash = 0;
        hash += (idresetopass != null ? idresetopass.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Resetopass)) {
            return false;
        }
        Resetopass other = (Resetopass) object;
        return !((this.idresetopass == null && other.idresetopass != null) || (this.idresetopass != null && !this.idresetopass.equals(other.idresetopass)));
    }

    @Override
	public String toString() {
		return "Resetopass [idresetopass=" + idresetopass + ", token=" + token + ", creado=" + creado + ", idalumno="
				+ idalumno + "]";
	}
    
}
