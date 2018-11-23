package com.codehard.miscursos.modelos;


import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "quiz", catalog = "esccursos", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Quiz.findAll", query = "SELECT q FROM Quiz q")
    , @NamedQuery(name = "Quiz.findByIdquiz", query = "SELECT q FROM Quiz q WHERE q.idquiz = :idquiz")
    , @NamedQuery(name = "Quiz.findByAleatorio", query = "SELECT q FROM Quiz q WHERE q.aleatorio = :aleatorio")
    , @NamedQuery(name = "Quiz.findByTimer", query = "SELECT q FROM Quiz q WHERE q.timer = :timer")
    , @NamedQuery(name = "Quiz.findByOntimer", query = "SELECT q FROM Quiz q WHERE q.ontimer = :ontimer")
    , @NamedQuery(name = "Quiz.findByMaxquest", query = "SELECT q FROM Quiz q WHERE q.maxquest = :maxquest")
    , @NamedQuery(name = "Quiz.findByMaxint", query = "SELECT q FROM Quiz q WHERE q.maxint = :maxint")
    , @NamedQuery(name = "Quiz.findByOnmaxint", query = "SELECT q FROM Quiz q WHERE q.onmaxint = :onmaxint")})
public class Quiz implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idquiz")
    private Integer idquiz;
    @Basic(optional = false)
    @Column(name = "aleatorio")
    private int aleatorio;
    @Basic(optional = false)
    @Column(name = "timer")
    private int timer;
    @Column(name = "ontimer")
    @Temporal(TemporalType.TIME)
    private Date ontimer;
    @Basic(optional = false)
    @Column(name = "maxquest")
    private int maxquest;
    @Basic(optional = false)
    @Column(name = "maxint")
    private int maxint;
    @Column(name = "onmaxint")
    private Integer onmaxint;
    @Basic(optional = false)
    @Lob
    @Column(name = "active")
    private byte[] active;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idquiz")
    private List<Questions> questionsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idquiz")
    private List<Registroquiz> registroquizList;
    @JoinColumn(name = "idgrupo", referencedColumnName = "idgrupo")
    @ManyToOne(optional = false)
    private Grupo idgrupo;

    public Quiz() {
    }

    public Quiz(Integer idquiz) {
        this.idquiz = idquiz;
    }

    public Quiz(Integer idquiz, int aleatorio, int timer, int maxquest, int maxint, byte[] active) {
        this.idquiz = idquiz;
        this.aleatorio = aleatorio;
        this.timer = timer;
        this.maxquest = maxquest;
        this.maxint = maxint;
        this.active = active;
    }

    public Integer getIdquiz() {
        return idquiz;
    }

    public void setIdquiz(Integer idquiz) {
        this.idquiz = idquiz;
    }

    public int getAleatorio() {
        return aleatorio;
    }

    public void setAleatorio(int aleatorio) {
        this.aleatorio = aleatorio;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public Date getOntimer() {
        return ontimer;
    }

    public void setOntimer(Date ontimer) {
        this.ontimer = ontimer;
    }

    public int getMaxquest() {
        return maxquest;
    }

    public void setMaxquest(int maxquest) {
        this.maxquest = maxquest;
    }

    public int getMaxint() {
        return maxint;
    }

    public void setMaxint(int maxint) {
        this.maxint = maxint;
    }

    public Integer getOnmaxint() {
        return onmaxint;
    }

    public void setOnmaxint(Integer onmaxint) {
        this.onmaxint = onmaxint;
    }

    public byte[] getActive() {
        return active;
    }

    public void setActive(byte[] active) {
        this.active = active;
    }

    @XmlTransient
    public List<Questions> getQuestionsList() {
        return questionsList;
    }

    public void setQuestionsList(List<Questions> questionsList) {
        this.questionsList = questionsList;
    }

    public Grupo getIdgrupo() {
        return idgrupo;
    }

    public void setIdgrupo(Grupo idgrupo) {
        this.idgrupo = idgrupo;
    }

    @XmlTransient
    public List<Registroquiz> getRegistroquizList() {
		return registroquizList;
	}

	public void setRegistroquizList(List<Registroquiz> registroquizList) {
		this.registroquizList = registroquizList;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idquiz != null ? idquiz.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Quiz)) {
            return false;
        }
        Quiz other = (Quiz) object;
        if ((this.idquiz == null && other.idquiz != null) || (this.idquiz != null && !this.idquiz.equals(other.idquiz))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hardasarock.miscursos.modelos.Quiz[ idquiz=" + idquiz + " ]";
    }
    
}
