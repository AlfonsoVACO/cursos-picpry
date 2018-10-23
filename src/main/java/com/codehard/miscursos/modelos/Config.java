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
        int hash = 0;
        hash += (idconfig != null ? idconfig.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Config)) {
            return false;
        }
        Config other = (Config) object;
        return !((this.idconfig == null && other.idconfig != null) || (this.idconfig != null && !this.idconfig.equals(other.idconfig)));
    }

	@Override
	public String toString() {
		return "Config [idconfig=" + idconfig + ", color=" + color + ", tipoletra=" + tipoletra + ", otro=" + otro
				+ ", idplantel=" + idplantel + "]";
	}
    
}
