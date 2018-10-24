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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
    @JsonManagedReference
    private List<CursoProfesor> cursoProfesorList;
    @JoinColumn(name = "idadmin", referencedColumnName = "idadmin")
    @ManyToOne(optional = false)
    @JsonBackReference
    private Administrador idadmin;
    @JoinColumn(name = "idrol", referencedColumnName = "idrol")
    @ManyToOne(optional = false)
    @JsonBackReference
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
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(actualiza);
		result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
		result = prime * result + ((clave == null) ? 0 : clave.hashCode());
		result = prime * result + ((correo == null) ? 0 : correo.hashCode());
		result = prime * result + ((cursoProfesorList == null) ? 0 : cursoProfesorList.hashCode());
		result = prime * result + Arrays.hashCode(eliminar);
		result = prime * result + ((fecharegistro == null) ? 0 : fecharegistro.hashCode());
		result = prime * result + ((idadmin == null) ? 0 : idadmin.hashCode());
		result = prime * result + ((idprofesor == null) ? 0 : idprofesor.hashCode());
		result = prime * result + ((idrol == null) ? 0 : idrol.hashCode());
		result = prime * result + Arrays.hashCode(img);
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		Profesor other = (Profesor) obj;
		if (!Arrays.equals(actualiza, other.actualiza))
			return false;
		if (apellidos == null) {
			if (other.apellidos != null)
				return false;
		} else if (!apellidos.equals(other.apellidos))
			return false;
		if (clave == null) {
			if (other.clave != null)
				return false;
		} else if (!clave.equals(other.clave))
			return false;
		if (correo == null) {
			if (other.correo != null)
				return false;
		} else if (!correo.equals(other.correo))
			return false;
		if (cursoProfesorList == null) {
			if (other.cursoProfesorList != null)
				return false;
		} else if (!cursoProfesorList.equals(other.cursoProfesorList))
			return false;
		if (!Arrays.equals(eliminar, other.eliminar))
			return false;
		if (fecharegistro == null) {
			if (other.fecharegistro != null)
				return false;
		} else if (!fecharegistro.equals(other.fecharegistro))
			return false;
		if (idadmin == null) {
			if (other.idadmin != null)
				return false;
		} else if (!idadmin.equals(other.idadmin))
			return false;
		if (idprofesor == null) {
			if (other.idprofesor != null)
				return false;
		} else if (!idprofesor.equals(other.idprofesor))
			return false;
		if (idrol == null) {
			if (other.idrol != null)
				return false;
		} else if (!idrol.equals(other.idrol))
			return false;
		if (!Arrays.equals(img, other.img))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Profesor [idprofesor=" + idprofesor + ", clave=" + clave + ", nombre=" + nombre + ", apellidos="
				+ apellidos + ", correo=" + correo + ", password=" + password + ", actualiza="
				+ Arrays.toString(actualiza) + ", eliminar=" + Arrays.toString(eliminar) +
				", fecharegistro=" + fecharegistro +  "]";
	}


    
}

