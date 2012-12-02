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
@Table(name = "TRANSACTIONDISCOUNT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transactiondiscount.findAll", query = "SELECT t FROM Transactiondiscount t"),
    @NamedQuery(name = "Transactiondiscount.findByTransactionid", query = "SELECT t FROM Transactiondiscount t WHERE t.transactiondiscountPK.transactionid = :transactionid"),
    @NamedQuery(name = "Transactiondiscount.findByDiscountid", query = "SELECT t FROM Transactiondiscount t WHERE t.transactiondiscountPK.discountid = :discountid"),
    @NamedQuery(name = "Transactiondiscount.findByDiscountamount", query = "SELECT t FROM Transactiondiscount t WHERE t.discountamount = :discountamount"),
    @NamedQuery(name = "Transactiondiscount.findByCreatedby", query = "SELECT t FROM Transactiondiscount t WHERE t.createdby = :createdby"),
    @NamedQuery(name = "Transactiondiscount.findByCreatedon", query = "SELECT t FROM Transactiondiscount t WHERE t.createdon = :createdon"),
    @NamedQuery(name = "Transactiondiscount.findByModifiedby", query = "SELECT t FROM Transactiondiscount t WHERE t.modifiedby = :modifiedby"),
    @NamedQuery(name = "Transactiondiscount.findByModifiedon", query = "SELECT t FROM Transactiondiscount t WHERE t.modifiedon = :modifiedon")})
public class Transactiondiscount implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TransactiondiscountPK transactiondiscountPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "DISCOUNTAMOUNT")
    private BigDecimal discountamount;
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
    @JoinColumn(name = "TRANSACTIONID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Transactioninfo transactioninfo;
    @JoinColumn(name = "DISCOUNTID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Discount discount;

    public Transactiondiscount() {
    }

    public Transactiondiscount(TransactiondiscountPK transactiondiscountPK) {
        this.transactiondiscountPK = transactiondiscountPK;
    }

    public Transactiondiscount(TransactiondiscountPK transactiondiscountPK, BigDecimal discountamount, BigInteger createdby, Date createdon, BigInteger modifiedby, Date modifiedon) {
        this.transactiondiscountPK = transactiondiscountPK;
        this.discountamount = discountamount;
        this.createdby = createdby;
        this.createdon = createdon;
        this.modifiedby = modifiedby;
        this.modifiedon = modifiedon;
    }

    public Transactiondiscount(BigInteger transactionid, BigInteger discountid) {
        this.transactiondiscountPK = new TransactiondiscountPK(transactionid, discountid);
    }

    public TransactiondiscountPK getTransactiondiscountPK() {
        return transactiondiscountPK;
    }

    public void setTransactiondiscountPK(TransactiondiscountPK transactiondiscountPK) {
        this.transactiondiscountPK = transactiondiscountPK;
    }

    public BigDecimal getDiscountamount() {
        return discountamount;
    }

    public void setDiscountamount(BigDecimal discountamount) {
        this.discountamount = discountamount;
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

    public Transactioninfo getTransactioninfo() {
        return transactioninfo;
    }

    public void setTransactioninfo(Transactioninfo transactioninfo) {
        this.transactioninfo = transactioninfo;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transactiondiscountPK != null ? transactiondiscountPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transactiondiscount)) {
            return false;
        }
        Transactiondiscount other = (Transactiondiscount) object;
        if ((this.transactiondiscountPK == null && other.transactiondiscountPK != null) || (this.transactiondiscountPK != null && !this.transactiondiscountPK.equals(other.transactiondiscountPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.chooseadventure.entity.Transactiondiscount[ transactiondiscountPK=" + transactiondiscountPK + " ]";
    }
    
}
