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
@Table(name = "notasfinales", catalog = "esccursos", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notasfinales.findAll", query = "SELECT n FROM Notasfinales n")
    , @NamedQuery(name = "Notasfinales.findByIdnotafinal", query = "SELECT n FROM Notasfinales n WHERE n.idnotafinal = :idnotafinal")
    , @NamedQuery(name = "Notasfinales.findByParcial", query = "SELECT n FROM Notasfinales n WHERE n.parcial = :parcial")
    , @NamedQuery(name = "Notasfinales.findByCalificacionfinal", query = "SELECT n FROM Notasfinales n WHERE n.calificacionfinal = :calificacionfinal")})
public class Notasfinales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idnotafinal")
    private Integer idnotafinal;
    @Basic(optional = false)
    @Column(name = "parcial")
    private int parcial;
    @Basic(optional = false)
    @Column(name = "calificacionfinal")
    private double calificacionfinal;
    @JoinColumn(name = "idalumno", referencedColumnName = "idalumno")
    @ManyToOne(optional = false)
    private Alumno idalumno;
    @JoinColumn(name = "idclase", referencedColumnName = "idclase")
    @ManyToOne(optional = false)
    private Clases idclase;

    public Notasfinales() {
    }

    public Notasfinales(Integer idnotafinal) {
        this.idnotafinal = idnotafinal;
    }

    public Notasfinales(Integer idnotafinal, int parcial, double calificacionfinal) {
        this.idnotafinal = idnotafinal;
        this.parcial = parcial;
        this.calificacionfinal = calificacionfinal;
    }

    public Integer getIdnotafinal() {
        return idnotafinal;
    }

    public void setIdnotafinal(Integer idnotafinal) {
        this.idnotafinal = idnotafinal;
    }

    public int getParcial() {
        return parcial;
    }

    public void setParcial(int parcial) {
        this.parcial = parcial;
    }

    public double getCalificacionfinal() {
        return calificacionfinal;
    }

    public void setCalificacionfinal(double calificacionfinal) {
        this.calificacionfinal = calificacionfinal;
    }

    public Alumno getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(Alumno idalumno) {
        this.idalumno = idalumno;
    }

    public Clases getIdclase() {
        return idclase;
    }

    public void setIdclase(Clases idclase) {
        this.idclase = idclase;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idnotafinal != null ? idnotafinal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Notasfinales)) {
            return false;
        }
        Notasfinales other = (Notasfinales) object;
        if ((this.idnotafinal == null && other.idnotafinal != null) || (this.idnotafinal != null && !this.idnotafinal.equals(other.idnotafinal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hardasarock.miscursos.modelos.Notasfinales[ idnotafinal=" + idnotafinal + " ]";
    }
    
}
