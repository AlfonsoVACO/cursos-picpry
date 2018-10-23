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
        int hash = 0;
        hash += (idalumno != null ? idalumno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Alumno)) {
            return false;
        }
        Alumno other = (Alumno) object;
        return !((this.idalumno == null && other.idalumno != null) || (this.idalumno != null && !this.idalumno.equals(other.idalumno)));
    }

	@Override
	public String toString() {
		return "Alumno [idalumno=" + idalumno + ", matricula=" + matricula + ", nombre=" + nombre + ", apellidos="
				+ apellidos + ", telefono=" + telefono + ", direccion=" + direccion + ", cp=" + cp + ", img=" + img
				+ ", correo=" + correo + ", password=" + password + ", estado=" + Arrays.toString(estado) + ", keydes="
				+ keydes + ", idestado=" + idestado + ", idmunicipio=" + idmunicipio + ", idplantel=" + idplantel
				+ ", pagosList=" + pagosList + ", asistenciaList=" + asistenciaList + ", comentariosList="
				+ comentariosList + "]";
	}
    
}

