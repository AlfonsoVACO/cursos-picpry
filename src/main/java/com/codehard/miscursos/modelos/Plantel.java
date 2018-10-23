package com.codehard.miscursos.modelos;

import java.io.Serializable;
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
@Table(name = "plantel", catalog = "esccursos", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plantel.findAll", query = "SELECT p FROM Plantel p")
    , @NamedQuery(name = "Plantel.findByIdplantel", query = "SELECT p FROM Plantel p WHERE p.idplantel = :idplantel")
    , @NamedQuery(name = "Plantel.findByNombre", query = "SELECT p FROM Plantel p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Plantel.findByDireccion", query = "SELECT p FROM Plantel p WHERE p.direccion = :direccion")
    , @NamedQuery(name = "Plantel.findByCd", query = "SELECT p FROM Plantel p WHERE p.cd = :cd")})
public class Plantel implements Serializable {

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idplantel")
    private Integer idplantel;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "cd")
    private String cd;
    @Lob
    @Column(name = "img")
    private byte[] img;
    @Basic(optional = false)
    @Lob
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idplantel")
    private List<Cursos> cursosList;
    @JoinColumn(name = "idadmin", referencedColumnName = "idadmin")
    @ManyToOne(optional = false)
    private Administrador idadmin;
    @JoinColumn(name = "idestado", referencedColumnName = "idestado")
    @ManyToOne(optional = false)
    private Estados idestado;
    @JoinColumn(name = "idmunicipio", referencedColumnName = "idmunicipio")
    @ManyToOne(optional = false)
    private Municipios idmunicipio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idplantel")
    private List<Contacto> contactoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idplantel")
    private List<Alumno> alumnoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idplantel")
    private List<Noticias> noticiasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idplantel")
    private List<Config> configList;

    public Plantel() {
    }

    public Plantel(Integer idplantel) {
        this.idplantel = idplantel;
    }

    public Plantel(Integer idplantel, String nombre, String direccion, String cd, String descripcion) {
        this.idplantel = idplantel;
        this.nombre = nombre;
        this.direccion = direccion;
        this.cd = cd;
        this.descripcion = descripcion;
    }

    public Integer getIdplantel() {
        return idplantel;
    }

    public void setIdplantel(Integer idplantel) {
        this.idplantel = idplantel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCd() {
        return cd;
    }

    public void setCd(String cd) {
        this.cd = cd;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Cursos> getCursosList() {
        return cursosList;
    }

    public void setCursosList(List<Cursos> cursosList) {
        this.cursosList = cursosList;
    }

    public Administrador getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(Administrador idadmin) {
        this.idadmin = idadmin;
    }

    public Estados getIdestado() {
        return idestado;
    }

    public void setIdestado(Estados idestado) {
        this.idestado = idestado;
    }

    public Municipios getIdmunicipio() {
        return idmunicipio;
    }

    public void setIdmunicipio(Municipios idmunicipio) {
        this.idmunicipio = idmunicipio;
    }

    @XmlTransient
    public List<Contacto> getContactoList() {
        return contactoList;
    }

    public void setContactoList(List<Contacto> contactoList) {
        this.contactoList = contactoList;
    }

    @XmlTransient
    public List<Alumno> getAlumnoList() {
        return alumnoList;
    }

    public void setAlumnoList(List<Alumno> alumnoList) {
        this.alumnoList = alumnoList;
    }

    @XmlTransient
    public List<Noticias> getNoticiasList() {
        return noticiasList;
    }

    public void setNoticiasList(List<Noticias> noticiasList) {
        this.noticiasList = noticiasList;
    }

    @XmlTransient
    public List<Config> getConfigList() {
        return configList;
    }

    public void setConfigList(List<Config> configList) {
        this.configList = configList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idplantel != null ? idplantel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Plantel)) {
            return false;
        }
        Plantel other = (Plantel) object;
        return !((this.idplantel == null && other.idplantel != null) || (this.idplantel != null && !this.idplantel.equals(other.idplantel)));
    }

    @Override
	public String toString() {
		return "Plantel [idplantel=" + idplantel + ", nombre=" + nombre + ", direccion=" + direccion + ", cd=" + cd
				+ ", img=" + Arrays.toString(img) + ", descripcion=" + descripcion + ", cursosList=" + cursosList
				+ ", contactoList=" + contactoList + ", alumnoList=" + alumnoList + ", noticiasList=" + noticiasList
				+ ", configList=" + configList + ", idestado=" + idestado + ", idmunicipio=" + idmunicipio + "]";
	}
    
}