package com.codehard.miscursos.modelos;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "config", catalog = "esccursos", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Config.findAll", query = "SELECT c FROM Config c")
    , @NamedQuery(name = "Config.findByIdconfig", query = "SELECT c FROM Config c WHERE c.idconfig = :idconfig")
    , @NamedQuery(name = "Config.findByColor", query = "SELECT c FROM Config c WHERE c.color = :color")
    , @NamedQuery(name = "Config.findByTipoletra", query = "SELECT c FROM Config c WHERE c.tipoletra = :tipoletra")
    , @NamedQuery(name = "Config.findByOtro", query = "SELECT c FROM Config c WHERE c.otro = :otro")})
public class Config implements Serializable {

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idconfig")
    private Integer idconfig;
    @Column(name = "color")
    private String color;
    @Column(name = "tipoletra")
    private String tipoletra;
    @Column(name = "otro")
    private String otro;
    @JoinColumn(name = "idadmin", referencedColumnName = "idadmin")
    @ManyToOne(optional = false)
    private Administrador idadmin;
    @JoinColumn(name = "idplantel", referencedColumnName = "idplantel")
    @ManyToOne(optional = false)
    private Plantel idplantel;

    public Config() {
    }

    public Config(Integer idconfig) {
        this.idconfig = idconfig;
    }

    public Config(Integer idconfig, String color, String tipoletra, String otro) {
        this.idconfig = idconfig;
        this.color = color;
        this.tipoletra = tipoletra;
        this.otro = otro;
    }

    public Integer getIdconfig() {
        return idconfig;
    }

    public void setIdconfig(Integer idconfig) {
        this.idconfig = idconfig;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipoletra() {
        return tipoletra;
    }

    public void setTipoletra(String tipoletra) {
        this.tipoletra = tipoletra;
    }

    public String getOtro() {
        return otro;
    }

    public void setOtro(String otro) {
        this.otro = otro;
    }

    public Administrador getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(Administrador idadmin) {
        this.idadmin = idadmin;
    }

    public Plantel getIdplantel() {
        return idplantel;
    }

    public void setIdplantel(Plantel idplantel) {
        this.idplantel = idplantel;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((idadmin == null) ? 0 : idadmin.hashCode());
		result = prime * result + ((idconfig == null) ? 0 : idconfig.hashCode());
		result = prime * result + ((idplantel == null) ? 0 : idplantel.hashCode());
		result = prime * result + ((otro == null) ? 0 : otro.hashCode());
		result = prime * result + ((tipoletra == null) ? 0 : tipoletra.hashCode());
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
		Config other = (Config) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (idadmin == null) {
			if (other.idadmin != null)
				return false;
		} else if (!idadmin.equals(other.idadmin))
			return false;
		if (idconfig == null) {
			if (other.idconfig != null)
				return false;
		} else if (!idconfig.equals(other.idconfig))
			return false;
		if (idplantel == null) {
			if (other.idplantel != null)
				return false;
		} else if (!idplantel.equals(other.idplantel))
			return false;
		if (otro == null) {
			if (other.otro != null)
				return false;
		} else if (!otro.equals(other.otro))
			return false;
		if (tipoletra == null) {
			if (other.tipoletra != null)
				return false;
		} else if (!tipoletra.equals(other.tipoletra))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Config [idconfig=" + idconfig + ", color=" + color + ", tipoletra=" + tipoletra + ", otro=" + otro
				+ ", idadmin=" + idadmin + ", idplantel=" + idplantel + "]";
	}

    
}
