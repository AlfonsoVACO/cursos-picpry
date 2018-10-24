package com.codehard.miscursos.modelos;

import java.io.Serializable;
import java.util.Arrays;
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
@Table(name = "asistencia", catalog = "esccursos", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asistencia.findAll", query = "SELECT a FROM Asistencia a")
    , @NamedQuery(name = "Asistencia.findByIdasistencia", query = "SELECT a FROM Asistencia a WHERE a.idasistencia = :idasistencia")
    , @NamedQuery(name = "Asistencia.findByFecha", query = "SELECT a FROM Asistencia a WHERE a.fecha = :fecha")})
public class Asistencia implements Serializable {

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idasistencia")
    private Integer idasistencia;
    @Basic(optional = false)
    @Lob
    @Column(name = "asistio")
    private byte[] asistio;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "idalumno", referencedColumnName = "idalumno")
    @ManyToOne(optional = false)
    @JsonBackReference
    private Alumno idalumno;
    @JoinColumn(name = "idcurso", referencedColumnName = "idcurso")
    @ManyToOne(optional = false)
    @JsonBackReference
    private Cursos idcurso;

    public Asistencia() {
    }

    public Asistencia(Integer idasistencia) {
        this.idasistencia = idasistencia;
    }

    public Asistencia(Integer idasistencia, byte[] asistio, Date fecha) {
        this.idasistencia = idasistencia;
        this.asistio = asistio;
        this.fecha = fecha;
    }

    public Integer getIdasistencia() {
        return idasistencia;
    }

    public void setIdasistencia(Integer idasistencia) {
        this.idasistencia = idasistencia;
    }

    public byte[] getAsistio() {
        return asistio;
    }

    public void setAsistio(byte[] asistio) {
        this.asistio = asistio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Alumno getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(Alumno idalumno) {
        this.idalumno = idalumno;
    }

    public Cursos getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(Cursos idcurso) {
        this.idcurso = idcurso;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(asistio);
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((idalumno == null) ? 0 : idalumno.hashCode());
		result = prime * result + ((idasistencia == null) ? 0 : idasistencia.hashCode());
		result = prime * result + ((idcurso == null) ? 0 : idcurso.hashCode());
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
		Asistencia other = (Asistencia) obj;
		if (!Arrays.equals(asistio, other.asistio))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (idalumno == null) {
			if (other.idalumno != null)
				return false;
		} else if (!idalumno.equals(other.idalumno))
			return false;
		if (idasistencia == null) {
			if (other.idasistencia != null)
				return false;
		} else if (!idasistencia.equals(other.idasistencia))
			return false;
		if (idcurso == null) {
			if (other.idcurso != null)
				return false;
		} else if (!idcurso.equals(other.idcurso))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Asistencia [idasistencia=" + idasistencia + ", asistio=" + Arrays.toString(asistio) + ", fecha=" + fecha
				+ "]";
	}


}
