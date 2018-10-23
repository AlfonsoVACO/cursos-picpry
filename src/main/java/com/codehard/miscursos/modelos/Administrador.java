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
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "administrador", catalog = "esccursos", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administrador.findAll", query = "SELECT a FROM Administrador a")
    , @NamedQuery(name = "Administrador.findByIdadmin", query = "SELECT a FROM Administrador a WHERE a.idadmin = :idadmin")
    , @NamedQuery(name = "Administrador.findByClave", query = "SELECT a FROM Administrador a WHERE a.clave = :clave")
    , @NamedQuery(name = "Administrador.findByNombre", query = "SELECT a FROM Administrador a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Administrador.findByCorreo", query = "SELECT a FROM Administrador a WHERE a.correo = :correo")
    , @NamedQuery(name = "Administrador.findByPassword", query = "SELECT a FROM Administrador a WHERE a.password = :password")})
public class Administrador implements Serializable {

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idadmin")
    private Integer idadmin;
    @Basic(optional = false)
    @Column(name = "clave")
    private String clave;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Lob
    @Column(name = "actualizar")
    private byte[] actualizar;
    @Basic(optional = false)
    @Lob
    @Column(name = "registrar")
    private byte[] registrar;
    @Basic(optional = false)
    @Lob
    @Column(name = "eliminar")
    private byte[] eliminar;
    @Lob
    @Column(name = "img")
    private byte[] img;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idadmin")
    private List<Cursos> cursosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idadmin")
    private List<Plantel> plantelList;
    @JoinColumn(name = "idrol", referencedColumnName = "idrol")
    @ManyToOne(optional = false)
    private Roles idrol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idadmin")
    private List<Profesor> profesorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idadmin")
    private List<Noticias> noticiasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idadmin")
    private List<Config> configList;

    public Administrador() {
    }

    public Administrador(Integer idadmin) {
        this.idadmin = idadmin;
    }

    public Administrador(Integer idadmin, String clave, String nombre, String correo, String password, byte[] actualizar, byte[] registrar, byte[] eliminar) {
        this.idadmin = idadmin;
        this.clave = clave;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.actualizar = actualizar;
        this.registrar = registrar;
        this.eliminar = eliminar;
    }

    public Integer getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(Integer idadmin) {
        this.idadmin = idadmin;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getActualizar() {
        return actualizar;
    }

    public void setActualizar(byte[] actualizar) {
        this.actualizar = actualizar;
    }

    public byte[] getRegistrar() {
        return registrar;
    }

    public void setRegistrar(byte[] registrar) {
        this.registrar = registrar;
    }

    public byte[] getEliminar() {
        return eliminar;
    }

    public void setEliminar(byte[] eliminar) {
        this.eliminar = eliminar;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    @XmlTransient
    public List<Cursos> getCursosList() {
        return cursosList;
    }

    public void setCursosList(List<Cursos> cursosList) {
        this.cursosList = cursosList;
    }

    @XmlTransient
    public List<Plantel> getPlantelList() {
        return plantelList;
    }

    public void setPlantelList(List<Plantel> plantelList) {
        this.plantelList = plantelList;
    }

    public Roles getIdrol() {
        return idrol;
    }

    public void setIdrol(Roles idrol) {
        this.idrol = idrol;
    }

    @XmlTransient
    public List<Profesor> getProfesorList() {
        return profesorList;
    }

    public void setProfesorList(List<Profesor> profesorList) {
        this.profesorList = profesorList;
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
        hash += (idadmin != null ? idadmin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Administrador)) {
            return false;
        }
        Administrador other = (Administrador) object;
        return !((this.idadmin == null && other.idadmin != null) || (this.idadmin != null && !this.idadmin.equals(other.idadmin)));
    }

	@Override
	public String toString() {
		return "Administrador [idadmin=" + idadmin + ", clave=" + clave + ", nombre=" + nombre + ", correo=" + correo
				+ ", password=" + password + ", actualizar=" + Arrays.toString(actualizar) + ", registrar="
				+ Arrays.toString(registrar) + ", eliminar=" + Arrays.toString(eliminar) + ", img="
				+ Arrays.toString(img) + ", cursosList=" + cursosList + ", profesorList=" + profesorList
				+ ", noticiasList=" + noticiasList + ", configList=" + configList + ", plantelList=" + plantelList
				+ "]";
	}
    
}
