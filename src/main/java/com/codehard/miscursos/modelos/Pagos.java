package com.codehard.miscursos.modelos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "pagos", catalog = "esccursos", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pagos.findAll", query = "SELECT p FROM Pagos p")
    , @NamedQuery(name = "Pagos.findByIdpago", query = "SELECT p FROM Pagos p WHERE p.idpago = :idpago")
    , @NamedQuery(name = "Pagos.findByCantidad", query = "SELECT p FROM Pagos p WHERE p.cantidad = :cantidad")
    , @NamedQuery(name = "Pagos.findByEstatus", query = "SELECT p FROM Pagos p WHERE p.estatus = :estatus")
    , @NamedQuery(name = "Pagos.findByTipo", query = "SELECT p FROM Pagos p WHERE p.tipo = :tipo")
    , @NamedQuery(name = "Pagos.findByFecharegistro", query = "SELECT p FROM Pagos p WHERE p.fecharegistro = :fecharegistro")
    , @NamedQuery(name = "Pagos.findByFechavencimiento", query = "SELECT p FROM Pagos p WHERE p.fechavencimiento = :fechavencimiento")
    , @NamedQuery(name = "Pagos.findByFechapago", query = "SELECT p FROM Pagos p WHERE p.fechapago = :fechapago")
    , @NamedQuery(name = "Pagos.findByTiket", query = "SELECT p FROM Pagos p WHERE p.tiket = :tiket")})
public class Pagos implements Serializable {

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpago")
    private Integer idpago;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "cantidad")
    private BigDecimal cantidad;
    @Basic(optional = false)
    @Column(name = "estatus")
    private int estatus;
    @Column(name = "folioefectivo")
    private int folioefectivo;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @Column(name = "fecharegistro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecharegistro;
    @Basic(optional = false)
    @Column(name = "fechavencimiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechavencimiento;
    @Basic(optional = false)
    @Column(name = "fechapago")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechapago;
    @Column(name = "tiket")
    private String tiket;
    @JoinColumn(name = "idalumno", referencedColumnName = "idalumno")
    @ManyToOne(optional = false)
    @JsonBackReference
    private Alumno idalumno;
    @JoinColumn(name = "idcurso", referencedColumnName = "idcurso")
    @ManyToOne(optional = false)
    @JsonBackReference
    private Cursos idcurso;

    public Pagos() {
    }

    public Pagos(Integer idpago) {
        this.idpago = idpago;
    }

    public Pagos(Integer idpago, BigDecimal cantidad, int estatus, String tipo, Date fecharegistro, Date fechavencimiento, Date fechapago, String tiket) {
        this.idpago = idpago;
        this.cantidad = cantidad;
        this.estatus = estatus;
        this.tipo = tipo;
        this.fecharegistro = fecharegistro;
        this.fechavencimiento = fechavencimiento;
        this.fechapago = fechapago;
        this.tiket = tiket;
    }

    public Integer getIdpago() {
        return idpago;
    }

    public void setIdpago(Integer idpago) {
        this.idpago = idpago;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public int getFolioefectivo() {
		return folioefectivo;
	}

	public void setFolioefectivo(int folioefectivo) {
		this.folioefectivo = folioefectivo;
	}

	public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public Date getFechavencimiento() {
        return fechavencimiento;
    }

    public void setFechavencimiento(Date fechavencimiento) {
        this.fechavencimiento = fechavencimiento;
    }

    public Date getFechapago() {
        return fechapago;
    }

    public void setFechapago(Date fechapago) {
        this.fechapago = fechapago;
    }

    public String getTiket() {
        return tiket;
    }

    public void setTiket(String tiket) {
        this.tiket = tiket;
    }

    public Alumno getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(Alumno idalumno) {
        this.idalumno = idalumno;
    }

    public Cursos getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(Cursos idcurso) {
        this.idcurso = idcurso;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cantidad == null) ? 0 : cantidad.hashCode());
		result = prime * result + estatus;
		result = prime * result + ((fechapago == null) ? 0 : fechapago.hashCode());
		result = prime * result + ((fecharegistro == null) ? 0 : fecharegistro.hashCode());
		result = prime * result + ((fechavencimiento == null) ? 0 : fechavencimiento.hashCode());
		result = prime * result + folioefectivo;
		result = prime * result + ((idalumno == null) ? 0 : idalumno.hashCode());
		result = prime * result + ((idcurso == null) ? 0 : idcurso.hashCode());
		result = prime * result + ((idpago == null) ? 0 : idpago.hashCode());
		result = prime * result + ((tiket == null) ? 0 : tiket.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		Pagos other = (Pagos) obj;
		if (cantidad == null) {
			if (other.cantidad != null)
				return false;
		} else if (!cantidad.equals(other.cantidad))
			return false;
		if (estatus != other.estatus)
			return false;
		if (fechapago == null) {
			if (other.fechapago != null)
				return false;
		} else if (!fechapago.equals(other.fechapago))
			return false;
		if (fecharegistro == null) {
			if (other.fecharegistro != null)
				return false;
		} else if (!fecharegistro.equals(other.fecharegistro))
			return false;
		if (fechavencimiento == null) {
			if (other.fechavencimiento != null)
				return false;
		} else if (!fechavencimiento.equals(other.fechavencimiento))
			return false;
		if (folioefectivo != other.folioefectivo)
			return false;
		if (idalumno == null) {
			if (other.idalumno != null)
				return false;
		} else if (!idalumno.equals(other.idalumno))
			return false;
		if (idcurso == null) {
			if (other.idcurso != null)
				return false;
		} else if (!idcurso.equals(other.idcurso))
			return false;
		if (idpago == null) {
			if (other.idpago != null)
				return false;
		} else if (!idpago.equals(other.idpago))
			return false;
		if (tiket == null) {
			if (other.tiket != null)
				return false;
		} else if (!tiket.equals(other.tiket))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pagos [idpago=" + idpago + ", cantidad=" + cantidad + ", estatus=" + estatus + ", folioefectivo="
				+ folioefectivo + ", tipo=" + tipo + ", fecharegistro=" + fecharegistro + ", fechavencimiento="
				+ fechavencimiento + ", fechapago=" + fechapago + ", tiket=" + tiket +  "]";
	}
    
}
