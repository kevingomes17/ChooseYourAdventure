/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.chooseadventure.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kevingomes17
 */
@Entity
@Table(name = "RECCENTERMEMBER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reccentermember.findAll", query = "SELECT r FROM Reccentermember r"),
    @NamedQuery(name = "Reccentermember.findById", query = "SELECT r FROM Reccentermember r WHERE r.id = :id"),
    @NamedQuery(name = "Reccentermember.findByFName", query = "SELECT r FROM Reccentermember r WHERE r.fName = :fName"),
    @NamedQuery(name = "Reccentermember.findByLName", query = "SELECT r FROM Reccentermember r WHERE r.lName = :lName"),
    @NamedQuery(name = "Reccentermember.findByDob", query = "SELECT r FROM Reccentermember r WHERE r.dob = :dob")})
public class Reccentermember implements Serializable {
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "DOB")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dob;
    @OneToMany(mappedBy = "memberId")
    private Collection<Instructor> instructorCollection;
    @JoinColumn(name = "FAMILY_ID", referencedColumnName = "ID")
    @ManyToOne
    private Familypackage familyId;

    public Reccentermember() {
    }

    public Reccentermember(BigDecimal id) {
        this.id = id;
    }

    public Reccentermember(BigDecimal id, String fName, String lName, Date dob) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.dob = dob;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @XmlTransient
    public Collection<Instructor> getInstructorCollection() {
        return instructorCollection;
    }

    public void setInstructorCollection(Collection<Instructor> instructorCollection) {
        this.instructorCollection = instructorCollection;
    }

    public Familypackage getFamilyId() {
        return familyId;
    }

    public void setFamilyId(Familypackage familyId) {
        this.familyId = familyId;
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
        if (!(object instanceof Reccentermember)) {
            return false;
        }
        Reccentermember other = (Reccentermember) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.chooseadventure.entity.Reccentermember[ id=" + id + " ]";
    }
    
}
