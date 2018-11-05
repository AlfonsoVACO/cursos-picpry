package com.codehard.miscursos.modelos;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "questions", catalog = "esccursos", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Questions.findAll", query = "SELECT q FROM Questions q")
    , @NamedQuery(name = "Questions.findByIdquestion", query = "SELECT q FROM Questions q WHERE q.idquestion = :idquestion")
    , @NamedQuery(name = "Questions.findByQuestion", query = "SELECT q FROM Questions q WHERE q.question = :question")
    , @NamedQuery(name = "Questions.findByType", query = "SELECT q FROM Questions q WHERE q.type = :type")
    , @NamedQuery(name = "Questions.findByMessage", query = "SELECT q FROM Questions q WHERE q.message = :message")})
public class Questions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idquestion")
    private Integer idquestion;
    @Basic(optional = false)
    @Column(name = "question")
    private String question;
    @Basic(optional = false)
    @Lob
    @Column(name = "options")
    private String options;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @Column(name = "message")
    private String message;
    @Basic(optional = false)
    @Lob
    @Column(name = "answers")
    private String answers;
    @JoinColumn(name = "idquiz", referencedColumnName = "idquiz")
    @ManyToOne(optional = false)
    private Quiz idquiz;

    public Questions() {
    }

    public Questions(Integer idquestion) {
        this.idquestion = idquestion;
    }

    public Questions(Integer idquestion, String question, String options, String type, String answers) {
        this.idquestion = idquestion;
        this.question = question;
        this.options = options;
        this.type = type;
        this.answers = answers;
    }

    public Integer getIdquestion() {
        return idquestion;
    }

    public void setIdquestion(Integer idquestion) {
        this.idquestion = idquestion;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }

    public Quiz getIdquiz() {
        return idquiz;
    }

    public void setIdquiz(Quiz idquiz) {
        this.idquiz = idquiz;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idquestion != null ? idquestion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Questions)) {
            return false;
        }
        Questions other = (Questions) object;
        if ((this.idquestion == null && other.idquestion != null) || (this.idquestion != null && !this.idquestion.equals(other.idquestion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hardasarock.miscursos.modelos.Questions[ idquestion=" + idquestion + " ]";
    }
    
}
