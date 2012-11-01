/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.chooseadventure.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
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
@Table(name = "USERWEBSITE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userwebsite.findAll", query = "SELECT u FROM Userwebsite u"),
    @NamedQuery(name = "Userwebsite.findByUserid", query = "SELECT u FROM Userwebsite u WHERE u.userid = :userid"),
    @NamedQuery(name = "Userwebsite.findByRewardpoints", query = "SELECT u FROM Userwebsite u WHERE u.rewardpoints = :rewardpoints"),
    @NamedQuery(name = "Userwebsite.findByCreditpoints", query = "SELECT u FROM Userwebsite u WHERE u.creditpoints = :creditpoints"),
    @NamedQuery(name = "Userwebsite.findByCreatedby", query = "SELECT u FROM Userwebsite u WHERE u.createdby = :createdby"),
    @NamedQuery(name = "Userwebsite.findByCreatedon", query = "SELECT u FROM Userwebsite u WHERE u.createdon = :createdon"),
    @NamedQuery(name = "Userwebsite.findByModifiedby", query = "SELECT u FROM Userwebsite u WHERE u.modifiedby = :modifiedby"),
    @NamedQuery(name = "Userwebsite.findByModifiedon", query = "SELECT u FROM Userwebsite u WHERE u.modifiedon = :modifiedon")})
public class Userwebsite implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "USERID")
    private BigDecimal userid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REWARDPOINTS")
    private BigInteger rewardpoints;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREDITPOINTS")
    private BigInteger creditpoints;
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
    @JoinColumn(name = "MEMBERSHIPTYPE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private MembershipType membershiptype;

    public Userwebsite() {
    }

    public Userwebsite(BigDecimal userid) {
        this.userid = userid;
    }

    public Userwebsite(BigDecimal userid, BigInteger rewardpoints, BigInteger creditpoints, BigInteger createdby, Date createdon, BigInteger modifiedby, Date modifiedon) {
        this.userid = userid;
        this.rewardpoints = rewardpoints;
        this.creditpoints = creditpoints;
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

    public BigInteger getRewardpoints() {
        return rewardpoints;
    }

    public void setRewardpoints(BigInteger rewardpoints) {
        this.rewardpoints = rewardpoints;
    }

    public BigInteger getCreditpoints() {
        return creditpoints;
    }

    public void setCreditpoints(BigInteger creditpoints) {
        this.creditpoints = creditpoints;
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

    public MembershipType getMembershiptype() {
        return membershiptype;
    }

    public void setMembershiptype(MembershipType membershiptype) {
        this.membershiptype = membershiptype;
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
        if (!(object instanceof Userwebsite)) {
            return false;
        }
        Userwebsite other = (Userwebsite) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.chooseadventure.entity.Userwebsite[ userid=" + userid + " ]";
    }
    
}
