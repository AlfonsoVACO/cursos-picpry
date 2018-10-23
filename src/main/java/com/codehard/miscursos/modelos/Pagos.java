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
    private Alumno idalumno;
    @JoinColumn(name = "idcurso", referencedColumnName = "idcurso")
    @ManyToOne(optional = false)
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
        int hash = 0;
        hash += (idpago != null ? idpago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Pagos)) {
            return false;
        }
        Pagos other = (Pagos) object;
        return !((this.idpago == null && other.idpago != null) || (this.idpago != null && !this.idpago.equals(other.idpago)));
    }

    @Override
	public String toString() {
		return "Pagos [idpago=" + idpago + ", cantidad=" + cantidad + ", estatus=" + estatus + ", tipo=" + tipo
				+ ", fecharegistro=" + fecharegistro + ", fechapago=" + fechapago + ", tiket=" + tiket + ", idalumno="
				+ idalumno + ", idcurso=" + idcurso + "]";
	}
    
}
