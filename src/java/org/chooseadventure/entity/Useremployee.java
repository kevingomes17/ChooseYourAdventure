/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.chooseadventure.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kevingomes17
 */
@Entity
@Table(name = "USEREMPLOYEE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Useremployee.findAll", query = "SELECT u FROM Useremployee u"),
    @NamedQuery(name = "Useremployee.findByUserid", query = "SELECT u FROM Useremployee u WHERE u.userid = :userid"),
    @NamedQuery(name = "Useremployee.findBySsn", query = "SELECT u FROM Useremployee u WHERE u.ssn = :ssn"),
    @NamedQuery(name = "Useremployee.findByCompanyid", query = "SELECT u FROM Useremployee u WHERE u.companyid = :companyid"),
    @NamedQuery(name = "Useremployee.findByCreatedby", query = "SELECT u FROM Useremployee u WHERE u.createdby = :createdby"),
    @NamedQuery(name = "Useremployee.findByCreatedon", query = "SELECT u FROM Useremployee u WHERE u.createdon = :createdon"),
    @NamedQuery(name = "Useremployee.findByModifiedby", query = "SELECT u FROM Useremployee u WHERE u.modifiedby = :modifiedby"),
    @NamedQuery(name = "Useremployee.findByModifiedon", query = "SELECT u FROM Useremployee u WHERE u.modifiedon = :modifiedon")})
public class Useremployee implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "USERID")
    private BigDecimal userid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SSN")
    private int ssn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COMPANYID")
    private BigInteger companyid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATEDBY")
    private BigInteger createdby;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATEDON")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdon;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MODIFIEDBY")
    private BigInteger modifiedby;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MODIFIEDON")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedon;
    @JoinColumn(name = "USERID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Userbase userbase;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "useremployee")
    private Collection<Attractionemployee> attractionemployeeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bossEmployeeId")
    private Collection<Team> teamCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "useremployee")
    private Collection<EmployeeTeam> employeeTeamCollection;
    @OneToMany(mappedBy = "directorid")
    private Collection<Attraction> attractionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "useremployee")
    private Collection<Employeerole> employeeroleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "useremployee")
    private Collection<Employeedateworking> employeedateworkingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "useremployee")
    private Collection<Employeeboss> employeebossCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "useremployee1")
    private Collection<Employeeboss> employeebossCollection1;

    public Useremployee() {
    }

    public Useremployee(BigDecimal userid) {
        this.userid = userid;
    }

    public Useremployee(BigDecimal userid, int ssn, BigInteger companyid, BigInteger createdby, Date createdon, BigInteger modifiedby, Date modifiedon) {
        this.userid = userid;
        this.ssn = ssn;
        this.companyid = companyid;
        this.createdby = createdby;
        this.createdon = createdon;
        this.modifiedby = modifiedby;
        this.modifiedon = modifiedon;
    }

    public BigDecimal getUserid() {
        return userid;
    }

    public void setUserid(BigDecimal userid) {
        this.userid = userid;
    }

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public BigInteger getCompanyid() {
        return companyid;
    }

    public void setCompanyid(BigInteger companyid) {
        this.companyid = companyid;
    }

    public BigInteger getCreatedby() {
        return createdby;
    }

    public void setCreatedby(BigInteger createdby) {
        this.createdby = createdby;
    }

    public Date getCreatedon() {
        return createdon;
    }

    public void setCreatedon(Date createdon) {
        this.createdon = createdon;
    }

    public BigInteger getModifiedby() {
        return modifiedby;
    }

    public void setModifiedby(BigInteger modifiedby) {
        this.modifiedby = modifiedby;
    }

    public Date getModifiedon() {
        return modifiedon;
    }

    public void setModifiedon(Date modifiedon) {
        this.modifiedon = modifiedon;
    }

    public Userbase getUserbase() {
        return userbase;
    }

    public void setUserbase(Userbase userbase) {
        this.userbase = userbase;
    }

    @XmlTransient
    public Collection<Attractionemployee> getAttractionemployeeCollection() {
        return attractionemployeeCollection;
    }

    public void setAttractionemployeeCollection(Collection<Attractionemployee> attractionemployeeCollection) {
        this.attractionemployeeCollection = attractionemployeeCollection;
    }

    @XmlTransient
    public Collection<Team> getTeamCollection() {
        return teamCollection;
    }

    public void setTeamCollection(Collection<Team> teamCollection) {
        this.teamCollection = teamCollection;
    }

    @XmlTransient
    public Collection<EmployeeTeam> getEmployeeTeamCollection() {
        return employeeTeamCollection;
    }

    public void setEmployeeTeamCollection(Collection<EmployeeTeam> employeeTeamCollection) {
        this.employeeTeamCollection = employeeTeamCollection;
    }

    @XmlTransient
    public Collection<Attraction> getAttractionCollection() {
        return attractionCollection;
    }

    public void setAttractionCollection(Collection<Attraction> attractionCollection) {
        this.attractionCollection = attractionCollection;
    }

    @XmlTransient
    public Collection<Employeerole> getEmployeeroleCollection() {
        return employeeroleCollection;
    }

    public void setEmployeeroleCollection(Collection<Employeerole> employeeroleCollection) {
        this.employeeroleCollection = employeeroleCollection;
    }

    @XmlTransient
    public Collection<Employeedateworking> getEmployeedateworkingCollection() {
        return employeedateworkingCollection;
    }

    public void setEmployeedateworkingCollection(Collection<Employeedateworking> employeedateworkingCollection) {
        this.employeedateworkingCollection = employeedateworkingCollection;
    }

    @XmlTransient
    public Collection<Employeeboss> getEmployeebossCollection() {
        return employeebossCollection;
    }

    public void setEmployeebossCollection(Collection<Employeeboss> employeebossCollection) {
        this.employeebossCollection = employeebossCollection;
    }

    @XmlTransient
    public Collection<Employeeboss> getEmployeebossCollection1() {
        return employeebossCollection1;
    }

    public void setEmployeebossCollection1(Collection<Employeeboss> employeebossCollection1) {
        this.employeebossCollection1 = employeebossCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Useremployee)) {
            return false;
        }
        Useremployee other = (Useremployee) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.chooseadventure.entity.Useremployee[ userid=" + userid + " ]";
    }
    
}
