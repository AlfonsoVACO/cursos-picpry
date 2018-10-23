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
@Table(name = "calificacion", catalog = "esccursos", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calificacion.findAll", query = "SELECT c FROM Calificacion c")
    , @NamedQuery(name = "Calificacion.findByIdcalificacion", query = "SELECT c FROM Calificacion c WHERE c.idcalificacion = :idcalificacion")
    , @NamedQuery(name = "Calificacion.findByEstrellas", query = "SELECT c FROM Calificacion c WHERE c.estrellas = :estrellas")
    , @NamedQuery(name = "Calificacion.findByComentario", query = "SELECT c FROM Calificacion c WHERE c.comentario = :comentario")})
public class Calificacion implements Serializable {

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcalificacion")
    private Integer idcalificacion;
    @Basic(optional = false)
    @Column(name = "estrellas")
    private int estrellas;
    @Basic(optional = false)
    @Column(name = "comentario")
    private String comentario;
    @JoinColumn(name = "idalumno", referencedColumnName = "idalumno")
    @ManyToOne(optional = false)
    private Alumno idalumno;
    @JoinColumn(name = "idcurso", referencedColumnName = "idcurso")
    @ManyToOne(optional = false)
    private Cursos idcurso;

    public Calificacion() {
    }

    public Calificacion(Integer idcalificacion) {
        this.idcalificacion = idcalificacion;
    }

    public Calificacion(Integer idcalificacion, int estrellas, String comentario) {
        this.idcalificacion = idcalificacion;
        this.estrellas = estrellas;
        this.comentario = comentario;
    }

    public Integer getIdcalificacion() {
        return idcalificacion;
    }

    public void setIdcalificacion(Integer idcalificacion) {
        this.idcalificacion = idcalificacion;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
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
        int hash = 0;
        hash += (idcalificacion != null ? idcalificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Calificacion)) {
            return false;
        }
        Calificacion other = (Calificacion) object;
        return !((this.idcalificacion == null && other.idcalificacion != null) || (this.idcalificacion != null && !this.idcalificacion.equals(other.idcalificacion)));
    }

    @Override
	public String toString() {
		return "Calificacion [idcalificacion=" + idcalificacion + ", estrellas=" + estrellas + ", comentario="
				+ comentario + ", idalumno=" + idalumno + ", idcurso=" + idcurso + "]";
	}
    
}
