/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.chooseadventure.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kevingomes17
 */
@Entity
@Table(name = "EMPLOYEEDATEWORKING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employeedateworking.findAll", query = "SELECT e FROM Employeedateworking e"),
    @NamedQuery(name = "Employeedateworking.findByDayoff", query = "SELECT e FROM Employeedateworking e WHERE e.employeedateworkingPK.dayoff = :dayoff"),
    @NamedQuery(name = "Employeedateworking.findByLeaveReason", query = "SELECT e FROM Employeedateworking e WHERE e.leaveReason = :leaveReason"),
    @NamedQuery(name = "Employeedateworking.findByUserid", query = "SELECT e FROM Employeedateworking e WHERE e.employeedateworkingPK.userid = :userid"),
    @NamedQuery(name = "Employeedateworking.findByCreatedby", query = "SELECT e FROM Employeedateworking e WHERE e.createdby = :createdby"),
    @NamedQuery(name = "Employeedateworking.findByCreateon", query = "SELECT e FROM Employeedateworking e WHERE e.createon = :createon"),
    @NamedQuery(name = "Employeedateworking.findByModifiedby", query = "SELECT e FROM Employeedateworking e WHERE e.modifiedby = :modifiedby"),
    @NamedQuery(name = "Employeedateworking.findByModifiedon", query = "SELECT e FROM Employeedateworking e WHERE e.modifiedon = :modifiedon")})
public class Employeedateworking implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmployeedateworkingPK employeedateworkingPK;
    @Size(max = 50)
    @Column(name = "LEAVE_REASON")
    private String leaveReason;
    @Column(name = "CREATEDBY")
    private BigInteger createdby;
    @Column(name = "CREATEON")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createon;
    @Column(name = "MODIFIEDBY")
    private BigInteger modifiedby;
    @Column(name = "MODIFIEDON")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedon;
    @JoinColumn(name = "USERID", referencedColumnName = "USERID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Useremployee useremployee;

    public Employeedateworking() {
    }

    public Employeedateworking(EmployeedateworkingPK employeedateworkingPK) {
        this.employeedateworkingPK = employeedateworkingPK;
    }

    public Employeedateworking(Date dayoff, BigInteger userid) {
        this.employeedateworkingPK = new EmployeedateworkingPK(dayoff, userid);
    }

    public EmployeedateworkingPK getEmployeedateworkingPK() {
        return employeedateworkingPK;
    }

    public void setEmployeedateworkingPK(EmployeedateworkingPK employeedateworkingPK) {
        this.employeedateworkingPK = employeedateworkingPK;
    }

    public String getLeaveReason() {
        return leaveReason;
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason;
    }

    public BigInteger getCreatedby() {
        return createdby;
    }

    public void setCreatedby(BigInteger createdby) {
        this.createdby = createdby;
    }

    public Date getCreateon() {
        return createon;
    }

    public void setCreateon(Date createon) {
        this.createon = createon;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeedateworkingPK != null ? employeedateworkingPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employeedateworking)) {
            return false;
        }
        Employeedateworking other = (Employeedateworking) object;
        if ((this.employeedateworkingPK == null && other.employeedateworkingPK != null) || (this.employeedateworkingPK != null && !this.employeedateworkingPK.equals(other.employeedateworkingPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.chooseadventure.entity.Employeedateworking[ employeedateworkingPK=" + employeedateworkingPK + " ]";
    }
    
}
