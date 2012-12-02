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
import javax.persistence.ManyToOne;
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
@Table(name = "TRANSACTIONINFO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transactioninfo.findAll", query = "SELECT t FROM Transactioninfo t"),
    @NamedQuery(name = "Transactioninfo.findById", query = "SELECT t FROM Transactioninfo t WHERE t.id = :id"),
    @NamedQuery(name = "Transactioninfo.findByAmount", query = "SELECT t FROM Transactioninfo t WHERE t.amount = :amount"),
    @NamedQuery(name = "Transactioninfo.findByRewardpointsused", query = "SELECT t FROM Transactioninfo t WHERE t.rewardpointsused = :rewardpointsused"),
    @NamedQuery(name = "Transactioninfo.findByCreditcardamount", query = "SELECT t FROM Transactioninfo t WHERE t.creditcardamount = :creditcardamount"),
    @NamedQuery(name = "Transactioninfo.findByCreatedby", query = "SELECT t FROM Transactioninfo t WHERE t.createdby = :createdby"),
    @NamedQuery(name = "Transactioninfo.findByCreatedon", query = "SELECT t FROM Transactioninfo t WHERE t.createdon = :createdon"),
    @NamedQuery(name = "Transactioninfo.findByModifiedby", query = "SELECT t FROM Transactioninfo t WHERE t.modifiedby = :modifiedby"),
    @NamedQuery(name = "Transactioninfo.findByModifiedon", query = "SELECT t FROM Transactioninfo t WHERE t.modifiedon = :modifiedon")})
public class Transactioninfo implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AMOUNT")
    private BigInteger amount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REWARDPOINTSUSED")
    private int rewardpointsused;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREDITCARDAMOUNT")
    private BigDecimal creditcardamount;
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
    @JoinColumn(name = "USERID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Userbase userid;
    @OneToMany(mappedBy = "transactionid")
    private Collection<Attractionvisited> attractionvisitedCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transactioninfo")
    private Collection<Transactiondiscount> transactiondiscountCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transactionid")
    private Collection<Transactionreward> transactionrewardCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "transactioninfo")
    private Revenue revenue;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transactionid")
    private Collection<Transactionpackage> transactionpackageCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transactionid")
    private Collection<Transactionattraction> transactionattractionCollection;

    public Transactioninfo() {
    }

    public Transactioninfo(BigDecimal id) {
        this.id = id;
    }

    public Transactioninfo(BigDecimal id, BigInteger amount, int rewardpointsused, BigDecimal creditcardamount, BigInteger createdby, Date createdon, BigInteger modifiedby, Date modifiedon) {
        this.id = id;
        this.amount = amount;
        this.rewardpointsused = rewardpointsused;
        this.creditcardamount = creditcardamount;
        this.createdby = createdby;
        this.createdon = createdon;
        this.modifiedby = modifiedby;
        this.modifiedon = modifiedon;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getAmount() {
        return amount;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
    }

    public int getRewardpointsused() {
        return rewardpointsused;
    }

    public void setRewardpointsused(int rewardpointsused) {
        this.rewardpointsused = rewardpointsused;
    }

    public BigDecimal getCreditcardamount() {
        return creditcardamount;
    }

    public void setCreditcardamount(BigDecimal creditcardamount) {
        this.creditcardamount = creditcardamount;
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

    public Userbase getUserid() {
        return userid;
    }

    public void setUserid(Userbase userid) {
        this.userid = userid;
    }

    @XmlTransient
    public Collection<Attractionvisited> getAttractionvisitedCollection() {
        return attractionvisitedCollection;
    }

    public void setAttractionvisitedCollection(Collection<Attractionvisited> attractionvisitedCollection) {
        this.attractionvisitedCollection = attractionvisitedCollection;
    }

    @XmlTransient
    public Collection<Transactiondiscount> getTransactiondiscountCollection() {
        return transactiondiscountCollection;
    }

    public void setTransactiondiscountCollection(Collection<Transactiondiscount> transactiondiscountCollection) {
        this.transactiondiscountCollection = transactiondiscountCollection;
    }

    @XmlTransient
    public Collection<Transactionreward> getTransactionrewardCollection() {
        return transactionrewardCollection;
    }

    public void setTransactionrewardCollection(Collection<Transactionreward> transactionrewardCollection) {
        this.transactionrewardCollection = transactionrewardCollection;
    }

    public Revenue getRevenue() {
        return revenue;
    }

    public void setRevenue(Revenue revenue) {
        this.revenue = revenue;
    }

    @XmlTransient
    public Collection<Transactionpackage> getTransactionpackageCollection() {
        return transactionpackageCollection;
    }

    public void setTransactionpackageCollection(Collection<Transactionpackage> transactionpackageCollection) {
        this.transactionpackageCollection = transactionpackageCollection;
    }

    @XmlTransient
    public Collection<Transactionattraction> getTransactionattractionCollection() {
        return transactionattractionCollection;
    }

    public void setTransactionattractionCollection(Collection<Transactionattraction> transactionattractionCollection) {
        this.transactionattractionCollection = transactionattractionCollection;
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
        if (!(object instanceof Transactioninfo)) {
            return false;
        }
        Transactioninfo other = (Transactioninfo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.chooseadventure.entity.Transactioninfo[ id=" + id + " ]";
    }
    
}
