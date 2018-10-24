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
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alumnoList == null) ? 0 : alumnoList.hashCode());
		result = prime * result + ((cd == null) ? 0 : cd.hashCode());
		result = prime * result + ((configList == null) ? 0 : configList.hashCode());
		result = prime * result + ((contactoList == null) ? 0 : contactoList.hashCode());
		result = prime * result + ((cursosList == null) ? 0 : cursosList.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + ((idadmin == null) ? 0 : idadmin.hashCode());
		result = prime * result + ((idestado == null) ? 0 : idestado.hashCode());
		result = prime * result + ((idmunicipio == null) ? 0 : idmunicipio.hashCode());
		result = prime * result + ((idplantel == null) ? 0 : idplantel.hashCode());
		result = prime * result + Arrays.hashCode(img);
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((noticiasList == null) ? 0 : noticiasList.hashCode());
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
		Plantel other = (Plantel) obj;
		if (alumnoList == null) {
			if (other.alumnoList != null)
				return false;
		} else if (!alumnoList.equals(other.alumnoList))
			return false;
		if (cd == null) {
			if (other.cd != null)
				return false;
		} else if (!cd.equals(other.cd))
			return false;
		if (configList == null) {
			if (other.configList != null)
				return false;
		} else if (!configList.equals(other.configList))
			return false;
		if (contactoList == null) {
			if (other.contactoList != null)
				return false;
		} else if (!contactoList.equals(other.contactoList))
			return false;
		if (cursosList == null) {
			if (other.cursosList != null)
				return false;
		} else if (!cursosList.equals(other.cursosList))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (idadmin == null) {
			if (other.idadmin != null)
				return false;
		} else if (!idadmin.equals(other.idadmin))
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
		return true;
	}

	@Override
	public String toString() {
		return "Plantel [idplantel=" + idplantel + ", nombre=" + nombre + ", direccion=" + direccion + ", cd=" + cd
				+ ", img=" + Arrays.toString(img) + ", descripcion=" + descripcion + ", cursosList=" + cursosList
				+ ", idadmin=" + idadmin + ", idestado=" + idestado + ", idmunicipio=" + idmunicipio + ", contactoList="
				+ contactoList + ", alumnoList=" + alumnoList + ", noticiasList=" + noticiasList + ", configList="
				+ configList + "]";
	}


    
}