/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.chooseadventure.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kevingomes17
 */
@Entity
@Table(name = "INSTRUCTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Instructor.findAll", query = "SELECT i FROM Instructor i"),
    @NamedQuery(name = "Instructor.findById", query = "SELECT i FROM Instructor i WHERE i.id = :id"),
    @NamedQuery(name = "Instructor.findByFName", query = "SELECT i FROM Instructor i WHERE i.fName = :fName"),
    @NamedQuery(name = "Instructor.findByLName", query = "SELECT i FROM Instructor i WHERE i.lName = :lName")})
public class Instructor implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "F_NAME")
    private String fName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "L_NAME")
    private String lName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instructor")
    private Collection<Classes> classesCollection;
    @JoinColumn(name = "MEMBER_ID", referencedColumnName = "ID")
    @ManyToOne
    private Reccentermember memberId;
    @JoinColumn(name = "BANG", referencedColumnName = "ID")
    @ManyToOne
    private Classes bang;
    @JoinColumn(name = "LAST_CLASS_TAUGHT", referencedColumnName = "ID")
    @ManyToOne
    private Classes lastClassTaught;

    public Instructor() {
    }

    public Instructor(BigDecimal id) {
        this.id = id;
    }

    public Instructor(BigDecimal id, String fName, String lName) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    @XmlTransient
    public Collection<Classes> getClassesCollection() {
        return classesCollection;
    }

    public void setClassesCollection(Collection<Classes> classesCollection) {
        this.classesCollection = classesCollection;
    }

    public Reccentermember getMemberId() {
        return memberId;
    }

    public void setMemberId(Reccentermember memberId) {
        this.memberId = memberId;
    }

    public Classes getBang() {
        return bang;
    }

    public void setBang(Classes bang) {
        this.bang = bang;
    }

    public Classes getLastClassTaught() {
        return lastClassTaught;
    }

    public void setLastClassTaught(Classes lastClassTaught) {
        this.lastClassTaught = lastClassTaught;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instructor)) {
            return false;
        }
        Instructor other = (Instructor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.chooseadventure.entity.Instructor[ id=" + id + " ]";
    }
    
}
