package com.codehard.miscursos.modelos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "cursos", catalog = "esccursos", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cursos.findAll", query = "SELECT c FROM Cursos c")
    , @NamedQuery(name = "Cursos.findByIdcurso", query = "SELECT c FROM Cursos c WHERE c.idcurso = :idcurso")
    , @NamedQuery(name = "Cursos.findByClave", query = "SELECT c FROM Cursos c WHERE c.clave = :clave")
    , @NamedQuery(name = "Cursos.findByNombre", query = "SELECT c FROM Cursos c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Cursos.findByCupo", query = "SELECT c FROM Cursos c WHERE c.cupo = :cupo")
    , @NamedQuery(name = "Cursos.findByCupotemp", query = "SELECT c FROM Cursos c WHERE c.cupotemp = :cupotemp")
    , @NamedQuery(name = "Cursos.findByDescripcioncorta", query = "SELECT c FROM Cursos c WHERE c.descripcioncorta = :descripcioncorta")
    , @NamedQuery(name = "Cursos.findByCosto", query = "SELECT c FROM Cursos c WHERE c.costo = :costo")
    , @NamedQuery(name = "Cursos.findByImg", query = "SELECT c FROM Cursos c WHERE c.img = :img")})
public class Cursos implements Serializable {

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcurso")
    private Integer idcurso;
    @Basic(optional = false)
    @Column(name = "clave")
    private String clave;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "cupo")
    private int cupo;
    @Basic(optional = false)
    @Column(name = "cupotemp")
    private int cupotemp;
    @Basic(optional = false)
    @Column(name = "descripcioncorta")
    private String descripcioncorta;
    @Basic(optional = false)
    @Lob
    @Column(name = "descripcionlarga")
    private String descripcionlarga;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "costo")
    private BigDecimal costo;
    @Basic(optional = false)
    @Column(name = "img")
    private String img;
    @Basic(optional = false)
    @Lob
    @Column(name = "estado")
    private byte[] estado;
    @JoinColumn(name = "idadmin", referencedColumnName = "idadmin")
    @ManyToOne(optional = false)
    private Administrador idadmin;
    @JoinColumn(name = "idcategoria", referencedColumnName = "idcategoria")
    @ManyToOne(optional = false)
    private Categoria idcategoria;
    @JoinColumn(name = "idhorario", referencedColumnName = "idhorario")
    @ManyToOne(optional = false)
    private Horario idhorario;
    @JoinColumn(name = "idplantel", referencedColumnName = "idplantel")
    @ManyToOne(optional = false)
    private Plantel idplantel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcurso")
    private List<Calificacion> calificacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcurso")
    private List<CursoProfesor> cursoProfesorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcurso")
    private List<Asistencia> asistenciaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcurso")
    private List<Temas> temasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcurso")
    private List<Comentarios> comentariosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcurso")
    private List<Pagos> pagosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcurso")
    private List<Libros> librosList;

    public Cursos() {
    }

    public Cursos(Integer idcurso) {
        this.idcurso = idcurso;
    }

    public Cursos(Integer idcurso, String clave, String nombre, int cupo, int cupotemp, String descripcioncorta, String descripcionlarga, BigDecimal costo, String img, byte[] estado) {
        this.idcurso = idcurso;
        this.clave = clave;
        this.nombre = nombre;
        this.cupo = cupo;
        this.cupotemp = cupotemp;
        this.descripcioncorta = descripcioncorta;
        this.descripcionlarga = descripcionlarga;
        this.costo = costo;
        this.img = img;
        this.estado = estado;
    }

    public Integer getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(Integer idcurso) {
        this.idcurso = idcurso;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    public int getCupotemp() {
        return cupotemp;
    }

    public void setCupotemp(int cupotemp) {
        this.cupotemp = cupotemp;
    }

    public String getDescripcioncorta() {
        return descripcioncorta;
    }

    public void setDescripcioncorta(String descripcioncorta) {
        this.descripcioncorta = descripcioncorta;
    }

    public String getDescripcionlarga() {
        return descripcionlarga;
    }

    public void setDescripcionlarga(String descripcionlarga) {
        this.descripcionlarga = descripcionlarga;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public byte[] getEstado() {
        return estado;
    }

    public void setEstado(byte[] estado) {
        this.estado = estado;
    }

    public Administrador getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(Administrador idadmin) {
        this.idadmin = idadmin;
    }

    public Categoria getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(Categoria idcategoria) {
        this.idcategoria = idcategoria;
    }

    public Horario getIdhorario() {
        return idhorario;
    }

    public void setIdhorario(Horario idhorario) {
        this.idhorario = idhorario;
    }

    public Plantel getIdplantel() {
        return idplantel;
    }

    public void setIdplantel(Plantel idplantel) {
        this.idplantel = idplantel;
    }

    @XmlTransient
    public List<Calificacion> getCalificacionList() {
        return calificacionList;
    }

    public void setCalificacionList(List<Calificacion> calificacionList) {
        this.calificacionList = calificacionList;
    }

    @XmlTransient
    public List<CursoProfesor> getCursoProfesorList() {
        return cursoProfesorList;
    }

    public void setCursoProfesorList(List<CursoProfesor> cursoProfesorList) {
        this.cursoProfesorList = cursoProfesorList;
    }

    @XmlTransient
    public List<Asistencia> getAsistenciaList() {
        return asistenciaList;
    }

    public void setAsistenciaList(List<Asistencia> asistenciaList) {
        this.asistenciaList = asistenciaList;
    }

    @XmlTransient
    public List<Temas> getTemasList() {
        return temasList;
    }

    public void setTemasList(List<Temas> temasList) {
        this.temasList = temasList;
    }

    @XmlTransient
    public List<Comentarios> getComentariosList() {
        return comentariosList;
    }

    public void setComentariosList(List<Comentarios> comentariosList) {
        this.comentariosList = comentariosList;
    }

    @XmlTransient
    public List<Pagos> getPagosList() {
        return pagosList;
    }

    public void setPagosList(List<Pagos> pagosList) {
        this.pagosList = pagosList;
    }

    @XmlTransient
    public List<Libros> getLibrosList() {
        return librosList;
    }

    public void setLibrosList(List<Libros> librosList) {
        this.librosList = librosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcurso != null ? idcurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Cursos)) {
            return false;
        }
        Cursos other = (Cursos) object;
        return !((this.idcurso == null && other.idcurso != null) || (this.idcurso != null && !this.idcurso.equals(other.idcurso)));
    }

	@Override
	public String toString() {
		return "Cursos [idcurso=" + idcurso + ", clave=" + clave + ", nombre=" + nombre + ", cupo=" + cupo
				+ ", cupotemp=" + cupotemp + ", descripcioncorta=" + descripcioncorta + ", descripcionlarga="
				+ descripcionlarga + ", costo=" + costo + ", img=" + img + ", estado=" + Arrays.toString(estado)
				+ ", idadmin=" + idadmin + ", idcategoria=" + idcategoria + ", idhorario=" + idhorario + ", idplantel="
				+ idplantel + ", calificacionList=" + calificacionList + ", cursoProfesorList=" + cursoProfesorList
				+ ", asistenciaList=" + asistenciaList + ", temasList=" + temasList + ", comentariosList="
				+ comentariosList + ", pagosList=" + pagosList + ", librosList=" + librosList + "]";
	}
    
}

