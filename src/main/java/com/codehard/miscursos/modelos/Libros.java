package com.codehard.miscursos.modelos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;

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

@Entity
@Table(name = "libros", catalog = "esccursos", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Libros.findAll", query = "SELECT l FROM Libros l")
    , @NamedQuery(name = "Libros.findByIdlibro", query = "SELECT l FROM Libros l WHERE l.idlibro = :idlibro")
    , @NamedQuery(name = "Libros.findByNombre", query = "SELECT l FROM Libros l WHERE l.nombre = :nombre")
    , @NamedQuery(name = "Libros.findByDescripcion", query = "SELECT l FROM Libros l WHERE l.descripcion = :descripcion")
    , @NamedQuery(name = "Libros.findByAutor", query = "SELECT l FROM Libros l WHERE l.autor = :autor")
    , @NamedQuery(name = "Libros.findByPrecio", query = "SELECT l FROM Libros l WHERE l.precio = :precio")})
public class Libros implements Serializable {

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlibro")
    private Integer idlibro;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "autor")
    private String autor;
    @Basic(optional = false)
    @Lob
    @Column(name = "estatus")
    private byte[] estatus;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "precio")
    private BigDecimal precio;
    @JoinColumn(name = "idcurso", referencedColumnName = "idcurso")
    @ManyToOne(optional = false)
    private Cursos idcurso;

    public Libros() {
    }

    public Libros(Integer idlibro) {
        this.idlibro = idlibro;
    }

    public Libros(Integer idlibro, String nombre, String descripcion, String autor, byte[] estatus, BigDecimal precio) {
        this.idlibro = idlibro;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.autor = autor;
        this.estatus = estatus;
        this.precio = precio;
    }

    public Integer getIdlibro() {
        return idlibro;
    }

    public void setIdlibro(Integer idlibro) {
        this.idlibro = idlibro;
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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public byte[] getEstatus() {
        return estatus;
    }

    public void setEstatus(byte[] estatus) {
        this.estatus = estatus;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
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
        hash += (idlibro != null ? idlibro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Libros)) {
            return false;
        }
        Libros other = (Libros) object;
        return !((this.idlibro == null && other.idlibro != null) || (this.idlibro != null && !this.idlibro.equals(other.idlibro)));
    }

    @Override
	public String toString() {
		return "Libros [idlibro=" + idlibro + ", nombre=" + nombre + ", descripcion=" + descripcion + ", autor=" + autor
				+ ", estatus=" + Arrays.toString(estatus) + ", precio=" + precio + ", idcurso=" + idcurso + "]";
	}
    
}
