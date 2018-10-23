package com.codehard.miscursos.modelos;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "profesor", catalog = "esccursos", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profesor.findAll", query = "SELECT p FROM Profesor p")
    , @NamedQuery(name = "Profesor.findByIdprofesor", query = "SELECT p FROM Profesor p WHERE p.idprofesor = :idprofesor")
    , @NamedQuery(name = "Profesor.findByClave", query = "SELECT p FROM Profesor p WHERE p.clave = :clave")
    , @NamedQuery(name = "Profesor.findByNombre", query = "SELECT p FROM Profesor p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Profesor.findByApellidos", query = "SELECT p FROM Profesor p WHERE p.apellidos = :apellidos")
    , @NamedQuery(name = "Profesor.findByCorreo", query = "SELECT p FROM Profesor p WHERE p.correo = :correo")
    , @NamedQuery(name = "Profesor.findByPassword", query = "SELECT p FROM Profesor p WHERE p.password = :password")
    , @NamedQuery(name = "Profesor.findByFecharegistro", query = "SELECT p FROM Profesor p WHERE p.fecharegistro = :fecharegistro")})
public class Profesor implements Serializable {

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idprofesor")
    private Integer idprofesor;
    @Basic(optional = false)
    @Column(name = "clave")
    private String clave;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Lob
    @Column(name = "actualiza")
    private byte[] actualiza;
    @Basic(optional = false)
    @Lob
    @Column(name = "eliminar")
    private byte[] eliminar;
    @Lob
    @Column(name = "img")
    private byte[] img;
    @Basic(optional = false)
    @Column(name = "fecharegistro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecharegistro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idprofesor")
    private List<CursoProfesor> cursoProfesorList;
    @JoinColumn(name = "idadmin", referencedColumnName = "idadmin")
    @ManyToOne(optional = false)
    private Administrador idadmin;
    @JoinColumn(name = "idrol", referencedColumnName = "idrol")
    @ManyToOne(optional = false)
    private Roles idrol;

    public Profesor() {
    }

    public Profesor(Integer idprofesor) {
        this.idprofesor = idprofesor;
    }

    public Profesor(Integer idprofesor, String clave, String nombre, String apellidos, String correo, String password, byte[] actualiza, byte[] eliminar, Date fecharegistro) {
        this.idprofesor = idprofesor;
        this.clave = clave;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.password = password;
        this.actualiza = actualiza;
        this.eliminar = eliminar;
        this.fecharegistro = fecharegistro;
    }

    public Integer getIdprofesor() {
        return idprofesor;
    }

    public void setIdprofesor(Integer idprofesor) {
        this.idprofesor = idprofesor;
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
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

    public byte[] getActualiza() {
        return actualiza;
    }

    public void setActualiza(byte[] actualiza) {
        this.actualiza = actualiza;
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

    public Date getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    @XmlTransient
    public List<CursoProfesor> getCursoProfesorList() {
        return cursoProfesorList;
    }

    public void setCursoProfesorList(List<CursoProfesor> cursoProfesorList) {
        this.cursoProfesorList = cursoProfesorList;
    }

    public Administrador getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(Administrador idadmin) {
        this.idadmin = idadmin;
    }

    public Roles getIdrol() {
        return idrol;
    }

    public void setIdrol(Roles idrol) {
        this.idrol = idrol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprofesor != null ? idprofesor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Profesor)) {
            return false;
        }
        Profesor other = (Profesor) object;
        return !((this.idprofesor == null && other.idprofesor != null) || (this.idprofesor != null && !this.idprofesor.equals(other.idprofesor)));
    }

    @Override
	public String toString() {
		return "Profesor [idprofesor=" + idprofesor + ", clave=" + clave + ", nombre=" + nombre + ", apellidos="
				+ apellidos + ", correo=" + correo + ", password=" + password + ", actualiza="
				+ Arrays.toString(actualiza) + ", eliminar=" + Arrays.toString(eliminar) + ", img="
				+ Arrays.toString(img) + ", idadmin=" + idadmin + ", cursoProfesorList=" + cursoProfesorList + "]";
	}
    
}

