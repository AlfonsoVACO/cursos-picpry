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
@Table(name = "registroquiz", catalog = "esccursos", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Registroquiz.findAll", query = "SELECT r FROM Registroquiz r")
    , @NamedQuery(name = "Registroquiz.findByIdregistro", query = "SELECT r FROM Registroquiz r WHERE r.idregistro = :idregistro")
    , @NamedQuery(name = "Registroquiz.findByCountquest", query = "SELECT r FROM Registroquiz r WHERE r.countquest = :countquest")
    , @NamedQuery(name = "Registroquiz.findByCalificacion", query = "SELECT r FROM Registroquiz r WHERE r.calificacion = :calificacion")
    , @NamedQuery(name = "Registroquiz.findByTimer", query = "SELECT r FROM Registroquiz r WHERE r.timer = :timer")
    , @NamedQuery(name = "Registroquiz.findByFechaini", query = "SELECT r FROM Registroquiz r WHERE r.fechaini = :fechaini")
    , @NamedQuery(name = "Registroquiz.findByFechafin", query = "SELECT r FROM Registroquiz r WHERE r.fechafin = :fechafin")
    , @NamedQuery(name = "Registroquiz.findByPorcent", query = "SELECT r FROM Registroquiz r WHERE r.porcent = :porcent")})
public class Registroquiz implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idregistro")
    private Integer idregistro;
    @Column(name = "countquest")
    private int countquest;
    @Column(name = "calificacion")
    private double calificacion;
    @Lob
    @Column(name = "respuestas")
    private String respuestas;
    @Column(name = "timer")
    @Temporal(TemporalType.TIME)
    private Date timer;
    @Basic(optional = false)
    @Column(name = "fechaini")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaini;
    @Basic(optional = false)
    @Column(name = "fechafin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechafin;
    @Column(name = "porcent")
    private double porcent;
    @JoinColumn(name = "idalumno", referencedColumnName = "idalumno")
    @ManyToOne(optional = false)
    private Alumno idalumno;
    @JoinColumn(name = "idquiz", referencedColumnName = "idquiz")
    @ManyToOne(optional = false)
    private Quiz idquiz;

    public Registroquiz() {
    }

    public Registroquiz(Integer idregistro) {
        this.idregistro = idregistro;
    }

    public Registroquiz(Integer idregistro, int countquest, double calificacion, String respuestas, Date timer, Date fechaini, Date fechafin, double porcent) {
        this.idregistro = idregistro;
        this.countquest = countquest;
        this.calificacion = calificacion;
        this.respuestas = respuestas;
        this.timer = timer;
        this.fechaini = fechaini;
        this.fechafin = fechafin;
        this.porcent = porcent;
    }

    public Integer getIdregistro() {
        return idregistro;
    }

    public void setIdregistro(Integer idregistro) {
        this.idregistro = idregistro;
    }

    public int getCountquest() {
        return countquest;
    }

    public void setCountquest(int countquest) {
        this.countquest = countquest;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public String getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(String respuestas) {
        this.respuestas = respuestas;
    }

    public Date getTimer() {
        return timer;
    }

    public void setTimer(Date timer) {
        this.timer = timer;
    }

    public Date getFechaini() {
        return fechaini;
    }

    public void setFechaini(Date fechaini) {
        this.fechaini = fechaini;
    }
    
    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public double getPorcent() {
		return porcent;
	}

	public void setPorcent(double porcent) {
		this.porcent = porcent;
	}

	public Alumno getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(Alumno idalumno) {
        this.idalumno = idalumno;
    }    

    public Quiz getIdquiz() {
		return idquiz;
	}

	public void setIdquiz(Quiz idquiz) {
		this.idquiz = idquiz;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idregistro != null ? idregistro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Registroquiz)) {
            return false;
        }
        Registroquiz other = (Registroquiz) object;
        if ((this.idregistro == null && other.idregistro != null) || (this.idregistro != null && !this.idregistro.equals(other.idregistro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hardasarock.miscursos.modelos.Registroquiz[ idregistro=" + idregistro + " ]";
    }
    
}
