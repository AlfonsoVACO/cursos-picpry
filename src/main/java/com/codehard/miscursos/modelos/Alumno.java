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
@Table(name = "alumno", catalog = "esccursos", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alumno.findAll", query = "SELECT a FROM Alumno a")
    , @NamedQuery(name = "Alumno.findByIdalumno", query = "SELECT a FROM Alumno a WHERE a.idalumno = :idalumno")
    , @NamedQuery(name = "Alumno.findByMatricula", query = "SELECT a FROM Alumno a WHERE a.matricula = :matricula")
    , @NamedQuery(name = "Alumno.findByNombre", query = "SELECT a FROM Alumno a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Alumno.findByApellidos", query = "SELECT a FROM Alumno a WHERE a.apellidos = :apellidos")
    , @NamedQuery(name = "Alumno.findByTelefono", query = "SELECT a FROM Alumno a WHERE a.telefono = :telefono")
    , @NamedQuery(name = "Alumno.findByDireccion", query = "SELECT a FROM Alumno a WHERE a.direccion = :direccion")
    , @NamedQuery(name = "Alumno.findByCp", query = "SELECT a FROM Alumno a WHERE a.cp = :cp")
    , @NamedQuery(name = "Alumno.findByImg", query = "SELECT a FROM Alumno a WHERE a.img = :img")
    , @NamedQuery(name = "Alumno.findByCorreo", query = "SELECT a FROM Alumno a WHERE a.correo = :correo")
    , @NamedQuery(name = "Alumno.findByPassword", query = "SELECT a FROM Alumno a WHERE a.password = :password")
    , @NamedQuery(name = "Alumno.findByKeydes", query = "SELECT a FROM Alumno a WHERE a.keydes = :keydes")})
public class Alumno implements Serializable {

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idalumno")
    private Integer idalumno;
    @Column(name = "matricula")
    private String matricula;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "telefono")
    private Integer telefono;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "cp")
    private String cp;
    @Column(name = "img")
    private String img;
    @Basic(optional = false)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Lob
    @Column(name = "estado")
    private byte[] estado;
    @Column(name = "keydes")
    private String keydes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idalumno")
    private List<Calificacion> calificacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idalumno")
    private List<Asistencia> asistenciaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idalumno")
    private List<Comentarios> comentariosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idalumno")
    private List<Resetopass> resetopassList;
    @JoinColumn(name = "idestado", referencedColumnName = "idestado")
    @ManyToOne(optional = false)
    private Estados idestado;
    @JoinColumn(name = "idmunicipio", referencedColumnName = "idmunicipio")
    @ManyToOne(optional = false)
    private Municipios idmunicipio;
    @JoinColumn(name = "idplantel", referencedColumnName = "idplantel")
    @ManyToOne(optional = false)
    private Plantel idplantel;
    @JoinColumn(name = "idrol", referencedColumnName = "idrol")
    @ManyToOne(optional = false)
    private Roles idrol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idalumno")
    private List<Pagos> pagosList;

    public Alumno() {
    }

    public Alumno(Integer idalumno) {
        this.idalumno = idalumno;
    }

    public Alumno(Integer idalumno, String matricula, String nombre, String apellidos, String direccion, String cp, String correo, String password, byte[] estado) {
        this.idalumno = idalumno;
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.cp = cp;
        this.correo = correo;
        this.password = password;
        this.estado = estado;
    }

    public Integer getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(Integer idalumno) {
        this.idalumno = idalumno;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
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

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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

    public byte[] getEstado() {
        return estado;
    }

    public void setEstado(byte[] estado) {
        this.estado = estado;
    }

    public String getKeydes() {
        return keydes;
    }

    public void setKeydes(String keydes) {
        this.keydes = keydes;
    }

    @XmlTransient
    public List<Calificacion> getCalificacionList() {
        return calificacionList;
    }

    public void setCalificacionList(List<Calificacion> calificacionList) {
        this.calificacionList = calificacionList;
    }

    @XmlTransient
    public List<Asistencia> getAsistenciaList() {
        return asistenciaList;
    }

    public void setAsistenciaList(List<Asistencia> asistenciaList) {
        this.asistenciaList = asistenciaList;
    }

    @XmlTransient
    public List<Comentarios> getComentariosList() {
        return comentariosList;
    }

    public void setComentariosList(List<Comentarios> comentariosList) {
        this.comentariosList = comentariosList;
    }

    @XmlTransient
    public List<Resetopass> getResetopassList() {
        return resetopassList;
    }

    public void setResetopassList(List<Resetopass> resetopassList) {
        this.resetopassList = resetopassList;
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

    public Plantel getIdplantel() {
        return idplantel;
    }

    public void setIdplantel(Plantel idplantel) {
        this.idplantel = idplantel;
    }

    public Roles getIdrol() {
        return idrol;
    }

    public void setIdrol(Roles idrol) {
        this.idrol = idrol;
    }

    @XmlTransient
    public List<Pagos> getPagosList() {
        return pagosList;
    }

    public void setPagosList(List<Pagos> pagosList) {
        this.pagosList = pagosList;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
		result = prime * result + ((asistenciaList == null) ? 0 : asistenciaList.hashCode());
		result = prime * result + ((calificacionList == null) ? 0 : calificacionList.hashCode());
		result = prime * result + ((comentariosList == null) ? 0 : comentariosList.hashCode());
		result = prime * result + ((correo == null) ? 0 : correo.hashCode());
		result = prime * result + ((cp == null) ? 0 : cp.hashCode());
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + Arrays.hashCode(estado);
		result = prime * result + ((idalumno == null) ? 0 : idalumno.hashCode());
		result = prime * result + ((idestado == null) ? 0 : idestado.hashCode());
		result = prime * result + ((idmunicipio == null) ? 0 : idmunicipio.hashCode());
		result = prime * result + ((idplantel == null) ? 0 : idplantel.hashCode());
		result = prime * result + ((idrol == null) ? 0 : idrol.hashCode());
		result = prime * result + ((img == null) ? 0 : img.hashCode());
		result = prime * result + ((keydes == null) ? 0 : keydes.hashCode());
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((pagosList == null) ? 0 : pagosList.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((resetopassList == null) ? 0 : resetopassList.hashCode());
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
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
		Alumno other = (Alumno) obj;
		if (apellidos == null) {
			if (other.apellidos != null)
				return false;
		} else if (!apellidos.equals(other.apellidos))
			return false;
		if (asistenciaList == null) {
			if (other.asistenciaList != null)
				return false;
		} else if (!asistenciaList.equals(other.asistenciaList))
			return false;
		if (calificacionList == null) {
			if (other.calificacionList != null)
				return false;
		} else if (!calificacionList.equals(other.calificacionList))
			return false;
		if (comentariosList == null) {
			if (other.comentariosList != null)
				return false;
		} else if (!comentariosList.equals(other.comentariosList))
			return false;
		if (correo == null) {
			if (other.correo != null)
				return false;
		} else if (!correo.equals(other.correo))
			return false;
		if (cp == null) {
			if (other.cp != null)
				return false;
		} else if (!cp.equals(other.cp))
			return false;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (!Arrays.equals(estado, other.estado))
			return false;
		if (idalumno == null) {
			if (other.idalumno != null)
				return false;
		} else if (!idalumno.equals(other.idalumno))
			return false;
		if (idestado == null) {
			if (other.idestado != null)
				return false;
		} else if (!idestado.equals(other.idestado))
			return false;
		if (idmunicipio == null) {
			if (other.idmunicipio != null)
				return false;
		} else if (!idmunicipio.equals(other.idmunicipio))
			return false;
		if (idplantel == null) {
			if (other.idplantel != null)
				return false;
		} else if (!idplantel.equals(other.idplantel))
			return false;
		if (idrol == null) {
			if (other.idrol != null)
				return false;
		} else if (!idrol.equals(other.idrol))
			return false;
		if (img == null) {
			if (other.img != null)
				return false;
		} else if (!img.equals(other.img))
			return false;
		if (keydes == null) {
			if (other.keydes != null)
				return false;
		} else if (!keydes.equals(other.keydes))
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (pagosList == null) {
			if (other.pagosList != null)
				return false;
		} else if (!pagosList.equals(other.pagosList))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (resetopassList == null) {
			if (other.resetopassList != null)
				return false;
		} else if (!resetopassList.equals(other.resetopassList))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Alumno [idalumno=" + idalumno + ", matricula=" + matricula + ", nombre=" + nombre + ", apellidos="
				+ apellidos + ", telefono=" + telefono + ", direccion=" + direccion + ", cp=" + cp + ", img=" + img
				+ ", correo=" + correo + ", password=" + password + ", estado=" + Arrays.toString(estado) + ", keydes="
				+ keydes + ", calificacionList=" + calificacionList + ", asistenciaList=" + asistenciaList
				+ ", comentariosList=" + comentariosList + ", resetopassList=" + resetopassList + ", idestado="
				+ idestado + ", idmunicipio=" + idmunicipio + ", idplantel=" + idplantel + ", idrol=" + idrol
				+ ", pagosList=" + pagosList + "]";
	}


}

