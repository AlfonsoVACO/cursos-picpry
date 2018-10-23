package com.codehard.miscursos.modelos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "horario", catalog = "esccursos", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Horario.findAll", query = "SELECT h FROM Horario h")
    , @NamedQuery(name = "Horario.findByIdhorario", query = "SELECT h FROM Horario h WHERE h.idhorario = :idhorario")
    , @NamedQuery(name = "Horario.findByDescripcion", query = "SELECT h FROM Horario h WHERE h.descripcion = :descripcion")
    , @NamedQuery(name = "Horario.findByFechade", query = "SELECT h FROM Horario h WHERE h.fechade = :fechade")
    , @NamedQuery(name = "Horario.findByFechaa", query = "SELECT h FROM Horario h WHERE h.fechaa = :fechaa")})
public class Horario implements Serializable {

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idhorario")
    private Integer idhorario;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "fechade")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechade;
    @Basic(optional = false)
    @Column(name = "fechaa")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idhorario")
    private List<Cursos> cursosList;

    public Horario() {
    }

    public Horario(Integer idhorario) {
        this.idhorario = idhorario;
    }

    public Horario(Integer idhorario, String descripcion, Date fechade, Date fechaa) {
        this.idhorario = idhorario;
        this.descripcion = descripcion;
        this.fechade = fechade;
        this.fechaa = fechaa;
    }

    public Integer getIdhorario() {
        return idhorario;
    }

    public void setIdhorario(Integer idhorario) {
        this.idhorario = idhorario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechade() {
        return fechade;
    }

    public void setFechade(Date fechade) {
        this.fechade = fechade;
    }

    public Date getFechaa() {
        return fechaa;
    }

    public void setFechaa(Date fechaa) {
        this.fechaa = fechaa;
    }

    @XmlTransient
    public List<Cursos> getCursosList() {
        return cursosList;
    }

    public void setCursosList(List<Cursos> cursosList) {
        this.cursosList = cursosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idhorario != null ? idhorario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Horario)) {
            return false;
        }
        Horario other = (Horario) object;
        return !((this.idhorario == null && other.idhorario != null) || (this.idhorario != null && !this.idhorario.equals(other.idhorario)));
    }

    @Override
	public String toString() {
		return "Horario [idhorario=" + idhorario + ", descripcion=" + descripcion + ", fechade=" + fechade + ", fechaa="
				+ fechaa + ", cursosList=" + cursosList + "]";
	}
    
}

