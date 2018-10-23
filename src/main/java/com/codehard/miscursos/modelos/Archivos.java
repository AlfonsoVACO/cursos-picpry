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
@Table(name = "archivos", catalog = "esccursos", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Archivos.findAll", query = "SELECT a FROM Archivos a")
    , @NamedQuery(name = "Archivos.findByIdarchivo", query = "SELECT a FROM Archivos a WHERE a.idarchivo = :idarchivo")
    , @NamedQuery(name = "Archivos.findByUrl", query = "SELECT a FROM Archivos a WHERE a.url = :url")
    , @NamedQuery(name = "Archivos.findByExtension", query = "SELECT a FROM Archivos a WHERE a.extension = :extension")})
public class Archivos implements Serializable {

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idarchivo")
    private Integer idarchivo;
    @Basic(optional = false)
    @Column(name = "url")
    private String url;
    @Basic(optional = false)
    @Column(name = "extension")
    private String extension;
    @JoinColumn(name = "idrecurso", referencedColumnName = "idrecurso")
    @ManyToOne(optional = false)
    private Recursos idrecurso;

    public Archivos() {
    }

    public Archivos(Integer idarchivo) {
        this.idarchivo = idarchivo;
    }

    public Archivos(Integer idarchivo, String url, String extension) {
        this.idarchivo = idarchivo;
        this.url = url;
        this.extension = extension;
    }

    public Integer getIdarchivo() {
        return idarchivo;
    }

    public void setIdarchivo(Integer idarchivo) {
        this.idarchivo = idarchivo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Recursos getIdrecurso() {
        return idrecurso;
    }

    public void setIdrecurso(Recursos idrecurso) {
        this.idrecurso = idrecurso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idarchivo != null ? idarchivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Archivos)) {
            return false;
        }
        Archivos other = (Archivos) object;
        return !((this.idarchivo == null && other.idarchivo != null) || (this.idarchivo != null && !this.idarchivo.equals(other.idarchivo)));
    }

	@Override
	public String toString() {
		return "Archivos [idarchivo=" + idarchivo + ", url=" + url + ", extension=" + extension + ", idrecurso="
				+ idrecurso + "]";
	}
    
}
