package com.example.Quiz.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "difficulty")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Difficulty.findAll", query = "SELECT d FROM Difficulty d"),
    @NamedQuery(name = "Difficulty.findByDifid", query = "SELECT d FROM Difficulty d WHERE d.difid = :difid"),
    @NamedQuery(name = "Difficulty.findByDiflevel", query = "SELECT d FROM Difficulty d WHERE d.diflevel = :diflevel"),
    @NamedQuery(name = "Difficulty.findByDifpoints", query = "SELECT d FROM Difficulty d WHERE d.difpoints = :difpoints")})
public class Difficulty implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "difid")
    private Integer difid;
    @Column(name = "diflevel")
    private Integer diflevel;
    @Column(name = "difpoints")
    private Integer difpoints;
    @OneToMany(mappedBy = "difid")
    @JsonManagedReference
    private Set<Question> questionSet;

    public Difficulty() {
    }

    public Difficulty(Integer difid) {
        this.difid = difid;
    }

    public Integer getDifid() {
        return difid;
    }

    public void setDifid(Integer difid) {
        this.difid = difid;
    }

    public Integer getDiflevel() {
        return diflevel;
    }

    public void setDiflevel(Integer diflevel) {
        this.diflevel = diflevel;
    }

    public Integer getDifpoints() {
        return difpoints;
    }

    public void setDifpoints(Integer difpoints) {
        this.difpoints = difpoints;
    }

    @XmlTransient
    public Set<Question> getQuestionSet() {
        return questionSet;
    }

    public void setQuestionSet(Set<Question> questionSet) {
        this.questionSet = questionSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (difid != null ? difid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Difficulty)) {
            return false;
        }
        Difficulty other = (Difficulty) object;
        if ((this.difid == null && other.difid != null) || (this.difid != null && !this.difid.equals(other.difid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "difficulty id=" + difid + " level=" + diflevel + " points=" + difpoints;
    }

}
