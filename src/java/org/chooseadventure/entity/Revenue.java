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
@Table(name = "REVENUE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Revenue.findAll", query = "SELECT r FROM Revenue r"),
    @NamedQuery(name = "Revenue.findByTransactionid", query = "SELECT r FROM Revenue r WHERE r.transactionid = :transactionid"),
    @NamedQuery(name = "Revenue.findByRevenueamount", query = "SELECT r FROM Revenue r WHERE r.revenueamount = :revenueamount"),
    @NamedQuery(name = "Revenue.findByRevenuetype", query = "SELECT r FROM Revenue r WHERE r.revenuetype = :revenuetype"),
    @NamedQuery(name = "Revenue.findByCreatedby", query = "SELECT r FROM Revenue r WHERE r.createdby = :createdby"),
    @NamedQuery(name = "Revenue.findByCreateon", query = "SELECT r FROM Revenue r WHERE r.createon = :createon"),
    @NamedQuery(name = "Revenue.findByModifiedby", query = "SELECT r FROM Revenue r WHERE r.modifiedby = :modifiedby"),
    @NamedQuery(name = "Revenue.findByModifiedon", query = "SELECT r FROM Revenue r WHERE r.modifiedon = :modifiedon")})
public class Revenue implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRANSACTIONID")
    private BigDecimal transactionid;
    @Column(name = "REVENUEAMOUNT")
    private BigInteger revenueamount;
    @Column(name = "REVENUETYPE")
    private BigInteger revenuetype;
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
    @JoinColumn(name = "TRANSACTIONID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Transactioninfo transactioninfo;

    public Revenue() {
    }

    public Revenue(BigDecimal transactionid) {
        this.transactionid = transactionid;
    }

    public BigDecimal getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(BigDecimal transactionid) {
        this.transactionid = transactionid;
    }

    public BigInteger getRevenueamount() {
        return revenueamount;
    }

    public void setRevenueamount(BigInteger revenueamount) {
        this.revenueamount = revenueamount;
    }

    public BigInteger getRevenuetype() {
        return revenuetype;
    }

    public void setRevenuetype(BigInteger revenuetype) {
        this.revenuetype = revenuetype;
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

    public Transactioninfo getTransactioninfo() {
        return transactioninfo;
    }

    public void setTransactioninfo(Transactioninfo transactioninfo) {
        this.transactioninfo = transactioninfo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transactionid != null ? transactionid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Revenue)) {
            return false;
        }
        Revenue other = (Revenue) object;
        if ((this.transactionid == null && other.transactionid != null) || (this.transactionid != null && !this.transactionid.equals(other.transactionid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.chooseadventure.entity.Revenue[ transactionid=" + transactionid + " ]";
    }
    
}
