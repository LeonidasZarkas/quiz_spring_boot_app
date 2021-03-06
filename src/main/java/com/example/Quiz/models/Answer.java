package com.example.Quiz.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "answers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Answer.findAll", query = "SELECT a FROM Answer a"),
    @NamedQuery(name = "Answer.findByAnswerid", query = "SELECT a FROM Answer a WHERE a.answerid = :answerid"),
    @NamedQuery(name = "Answer.findByAnswer", query = "SELECT a FROM Answer a WHERE a.answer = :answer"),
    @NamedQuery(name = "Answer.findByIsright", query = "SELECT a FROM Answer a WHERE a.isright = :isright")})
public class Answer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "answerid")
    private Integer answerid;
    @Column(name = "answer")
    private String answer;
    @Column(name = "isright")
    private Boolean isright;
    @ManyToOne (fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "qid", referencedColumnName = "qid")
    private Question qid;

    public Answer() {
    }

    public Answer(Integer answerid) {
        this.answerid = answerid;
    }

    public Integer getAnswerid() {
        return answerid;
    }

    public void setAnswerid(Integer answerid) {
        this.answerid = answerid;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Boolean getIsright() {
        return isright;
    }

    public void setRight(Boolean isright) {
        this.isright = isright;
    }

    public Question getQid() {
        return qid;
    }

    public void setQid(Question qid) {
        this.qid = qid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (answerid != null ? answerid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Answer)) {
            return false;
        }
        Answer other = (Answer) object;
        if ((this.answerid == null && other.answerid != null) || (this.answerid != null && !this.answerid.equals(other.answerid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return answerid + " " + answer + " question id: " + qid.getQid();
    }


}
