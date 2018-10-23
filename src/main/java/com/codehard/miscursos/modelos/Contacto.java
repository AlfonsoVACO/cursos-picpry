package com.codehard.miscursos.modelos;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "contacto", catalog = "esccursos", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contacto.findAll", query = "SELECT c FROM Contacto c")
    , @NamedQuery(name = "Contacto.findByIdcontacto", query = "SELECT c FROM Contacto c WHERE c.idcontacto = :idcontacto")
    , @NamedQuery(name = "Contacto.findByNombre", query = "SELECT c FROM Contacto c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Contacto.findByCorreo", query = "SELECT c FROM Contacto c WHERE c.correo = :correo")
    , @NamedQuery(name = "Contacto.findByMotivo", query = "SELECT c FROM Contacto c WHERE c.motivo = :motivo")
    , @NamedQuery(name = "Contacto.findByFecha", query = "SELECT c FROM Contacto c WHERE c.fecha = :fecha")
    , @NamedQuery(name = "Contacto.findByEstado", query = "SELECT c FROM Contacto c WHERE c.estado = :estado")})
public class Contacto implements Serializable {

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcontacto")
    private Integer idcontacto;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @Column(name = "motivo")
    private String motivo;
    @Basic(optional = false)
    @Lob
    @Column(name = "mensaje")
    private String mensaje;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "estado")
    private int estado;
    @JoinColumn(name = "idplantel", referencedColumnName = "idplantel")
    @ManyToOne(optional = false)
    private Plantel idplantel;

    public Contacto() {
    }

    public Contacto(Integer idcontacto) {
        this.idcontacto = idcontacto;
    }

    public Contacto(Integer idcontacto, String nombre, String correo, String motivo, String mensaje, Date fecha, int estado) {
        this.idcontacto = idcontacto;
        this.nombre = nombre;
        this.correo = correo;
        this.motivo = motivo;
        this.mensaje = mensaje;
        this.fecha = fecha;
        this.estado = estado;
    }

    public Integer getIdcontacto() {
        return idcontacto;
    }

    public void setIdcontacto(Integer idcontacto) {
        this.idcontacto = idcontacto;
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

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Plantel getIdplantel() {
        return idplantel;
    }

    public void setIdplantel(Plantel idplantel) {
        this.idplantel = idplantel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcontacto != null ? idcontacto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Contacto)) {
            return false;
        }
        Contacto other = (Contacto) object;
        return !((this.idcontacto == null && other.idcontacto != null) || (this.idcontacto != null && !this.idcontacto.equals(other.idcontacto)));
    }

	@Override
	public String toString() {
		return "Contacto [idcontacto=" + idcontacto + ", nombre=" + nombre + ", correo=" + correo + ", motivo=" + motivo
				+ ", mensaje=" + mensaje + ", fecha=" + fecha + ", idplantel=" + idplantel + "]";
	}
    
}
