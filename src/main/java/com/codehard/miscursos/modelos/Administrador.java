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
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(actualizar);
		result = prime * result + ((clave == null) ? 0 : clave.hashCode());
		result = prime * result + ((configList == null) ? 0 : configList.hashCode());
		result = prime * result + ((correo == null) ? 0 : correo.hashCode());
		result = prime * result + ((cursosList == null) ? 0 : cursosList.hashCode());
		result = prime * result + Arrays.hashCode(eliminar);
		result = prime * result + ((idadmin == null) ? 0 : idadmin.hashCode());
		result = prime * result + ((idrol == null) ? 0 : idrol.hashCode());
		result = prime * result + Arrays.hashCode(img);
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((noticiasList == null) ? 0 : noticiasList.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((plantelList == null) ? 0 : plantelList.hashCode());
		result = prime * result + ((profesorList == null) ? 0 : profesorList.hashCode());
		result = prime * result + Arrays.hashCode(registrar);
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
		Administrador other = (Administrador) obj;
		if (!Arrays.equals(actualizar, other.actualizar))
			return false;
		if (clave == null) {
			if (other.clave != null)
				return false;
		} else if (!clave.equals(other.clave))
			return false;
		if (configList == null) {
			if (other.configList != null)
				return false;
		} else if (!configList.equals(other.configList))
			return false;
		if (correo == null) {
			if (other.correo != null)
				return false;
		} else if (!correo.equals(other.correo))
			return false;
		if (cursosList == null) {
			if (other.cursosList != null)
				return false;
		} else if (!cursosList.equals(other.cursosList))
			return false;
		if (!Arrays.equals(eliminar, other.eliminar))
			return false;
		if (idadmin == null) {
			if (other.idadmin != null)
				return false;
		} else if (!idadmin.equals(other.idadmin))
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
		if (noticiasList == null) {
			if (other.noticiasList != null)
				return false;
		} else if (!noticiasList.equals(other.noticiasList))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (plantelList == null) {
			if (other.plantelList != null)
				return false;
		} else if (!plantelList.equals(other.plantelList))
			return false;
		if (profesorList == null) {
			if (other.profesorList != null)
				return false;
		} else if (!profesorList.equals(other.profesorList))
			return false;
		if (!Arrays.equals(registrar, other.registrar))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Administrador [idadmin=" + idadmin + ", clave=" + clave + "]";
	}


    
}
