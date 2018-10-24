package com.codehard.miscursos.modelos;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "comentarios", catalog = "esccursos", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comentarios.findAll", query = "SELECT c FROM Comentarios c")
    , @NamedQuery(name = "Comentarios.findByIdcomentario", query = "SELECT c FROM Comentarios c WHERE c.idcomentario = :idcomentario")})
public class Comentarios implements Serializable {

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcomentario")
    private Integer idcomentario;
    @Basic(optional = false)
    @Lob
    @Column(name = "comentario")
    private String comentario;
    @JoinColumn(name = "idalumno", referencedColumnName = "idalumno")
    @ManyToOne(optional = false)
    @JsonBackReference
    private Alumno idalumno;
    @JoinColumn(name = "idcurso", referencedColumnName = "idcurso")
    @ManyToOne(optional = false)
    @JsonBackReference
    private Cursos idcurso;

    public Comentarios() {
    }

    public Comentarios(Integer idcomentario) {
        this.idcomentario = idcomentario;
    }

    public Comentarios(Integer idcomentario, String comentario) {
        this.idcomentario = idcomentario;
        this.comentario = comentario;
    }

    public Integer getIdcomentario() {
        return idcomentario;
    }

    public void setIdcomentario(Integer idcomentario) {
        this.idcomentario = idcomentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
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
		result = prime * result + ((comentario == null) ? 0 : comentario.hashCode());
		result = prime * result + ((idalumno == null) ? 0 : idalumno.hashCode());
		result = prime * result + ((idcomentario == null) ? 0 : idcomentario.hashCode());
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
		Comentarios other = (Comentarios) obj;
		if (comentario == null) {
			if (other.comentario != null)
				return false;
		} else if (!comentario.equals(other.comentario))
			return false;
		if (idalumno == null) {
			if (other.idalumno != null)
				return false;
		} else if (!idalumno.equals(other.idalumno))
			return false;
		if (idcomentario == null) {
			if (other.idcomentario != null)
				return false;
		} else if (!idcomentario.equals(other.idcomentario))
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
		return "Comentarios [idcomentario=" + idcomentario + ", comentario=" + comentario + "]";
	}

        
}
