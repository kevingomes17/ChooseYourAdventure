/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.chooseadventure.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kevingomes17
 */
@Entity
@Table(name = "EMPLOYEEBOSS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employeeboss.findAll", query = "SELECT e FROM Employeeboss e"),
    @NamedQuery(name = "Employeeboss.findByEmployeeid", query = "SELECT e FROM Employeeboss e WHERE e.employeebossPK.employeeid = :employeeid"),
    @NamedQuery(name = "Employeeboss.findByBossemployeeid", query = "SELECT e FROM Employeeboss e WHERE e.employeebossPK.bossemployeeid = :bossemployeeid"),
    @NamedQuery(name = "Employeeboss.findByCreatedby", query = "SELECT e FROM Employeeboss e WHERE e.createdby = :createdby"),
    @NamedQuery(name = "Employeeboss.findByCreatedon", query = "SELECT e FROM Employeeboss e WHERE e.createdon = :createdon"),
    @NamedQuery(name = "Employeeboss.findByModifiedby", query = "SELECT e FROM Employeeboss e WHERE e.modifiedby = :modifiedby"),
    @NamedQuery(name = "Employeeboss.findByModifiedon", query = "SELECT e FROM Employeeboss e WHERE e.modifiedon = :modifiedon")})
public class Employeeboss implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmployeebossPK employeebossPK;
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
    @JoinColumn(name = "BOSSEMPLOYEEID", referencedColumnName = "USERID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Useremployee useremployee;
    @JoinColumn(name = "EMPLOYEEID", referencedColumnName = "USERID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Useremployee useremployee1;

    public Employeeboss() {
    }

    public Employeeboss(EmployeebossPK employeebossPK) {
        this.employeebossPK = employeebossPK;
    }

    public Employeeboss(EmployeebossPK employeebossPK, BigInteger createdby, Date createdon, BigInteger modifiedby, Date modifiedon) {
        this.employeebossPK = employeebossPK;
        this.createdby = createdby;
        this.createdon = createdon;
        this.modifiedby = modifiedby;
        this.modifiedon = modifiedon;
    }

    public Employeeboss(BigInteger employeeid, BigInteger bossemployeeid) {
        this.employeebossPK = new EmployeebossPK(employeeid, bossemployeeid);
    }

    public EmployeebossPK getEmployeebossPK() {
        return employeebossPK;
    }

    public void setEmployeebossPK(EmployeebossPK employeebossPK) {
        this.employeebossPK = employeebossPK;
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

    public Useremployee getUseremployee() {
        return useremployee;
    }

    public void setUseremployee(Useremployee useremployee) {
        this.useremployee = useremployee;
    }

    public Useremployee getUseremployee1() {
        return useremployee1;
    }

    public void setUseremployee1(Useremployee useremployee1) {
        this.useremployee1 = useremployee1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeebossPK != null ? employeebossPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employeeboss)) {
            return false;
        }
        Employeeboss other = (Employeeboss) object;
        if ((this.employeebossPK == null && other.employeebossPK != null) || (this.employeebossPK != null && !this.employeebossPK.equals(other.employeebossPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.chooseadventure.entity.Employeeboss[ employeebossPK=" + employeebossPK + " ]";
    }
    
}
