/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.chooseadventure.entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author kevingomes17
 */
@Embeddable
public class TransactiondiscountPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRANSACTIONID")
    private BigInteger transactionid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DISCOUNTID")
    private BigInteger discountid;

    public TransactiondiscountPK() {
    }

    public TransactiondiscountPK(BigInteger transactionid, BigInteger discountid) {
        this.transactionid = transactionid;
        this.discountid = discountid;
    }

    public BigInteger getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(BigInteger transactionid) {
        this.transactionid = transactionid;
    }

    public BigInteger getDiscountid() {
        return discountid;
    }

    public void setDiscountid(BigInteger discountid) {
        this.discountid = discountid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transactionid != null ? transactionid.hashCode() : 0);
        hash += (discountid != null ? discountid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransactiondiscountPK)) {
            return false;
        }
        TransactiondiscountPK other = (TransactiondiscountPK) object;
        if ((this.transactionid == null && other.transactionid != null) || (this.transactionid != null && !this.transactionid.equals(other.transactionid))) {
            return false;
        }
        if ((this.discountid == null && other.discountid != null) || (this.discountid != null && !this.discountid.equals(other.discountid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.chooseadventure.entity.TransactiondiscountPK[ transactionid=" + transactionid + ", discountid=" + discountid + " ]";
    }
    
}
