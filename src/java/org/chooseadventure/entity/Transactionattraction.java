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
@Table(name = "TRANSACTIONATTRACTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transactionattraction.findAll", query = "SELECT t FROM Transactionattraction t"),
    @NamedQuery(name = "Transactionattraction.findById", query = "SELECT t FROM Transactionattraction t WHERE t.id = :id"),
    @NamedQuery(name = "Transactionattraction.findByTicketcount", query = "SELECT t FROM Transactionattraction t WHERE t.ticketcount = :ticketcount"),
    @NamedQuery(name = "Transactionattraction.findByTicketexpirationdate", query = "SELECT t FROM Transactionattraction t WHERE t.ticketexpirationdate = :ticketexpirationdate"),
    @NamedQuery(name = "Transactionattraction.findByCreatedby", query = "SELECT t FROM Transactionattraction t WHERE t.createdby = :createdby"),
    @NamedQuery(name = "Transactionattraction.findByCreatedon", query = "SELECT t FROM Transactionattraction t WHERE t.createdon = :createdon"),
    @NamedQuery(name = "Transactionattraction.findByModifiedby", query = "SELECT t FROM Transactionattraction t WHERE t.modifiedby = :modifiedby"),
    @NamedQuery(name = "Transactionattraction.findByModifiedon", query = "SELECT t FROM Transactionattraction t WHERE t.modifiedon = :modifiedon")})
public class Transactionattraction implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TICKETCOUNT")
    private BigInteger ticketcount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TICKETEXPIRATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ticketexpirationdate;
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
    @JoinColumn(name = "TRANSACTIONID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Transactioninfo transactionid;
    @JoinColumn(name = "ATTRACTIONID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Attraction attractionid;

    public Transactionattraction() {
    }

    public Transactionattraction(BigDecimal id) {
        this.id = id;
    }

    public Transactionattraction(BigDecimal id, BigInteger ticketcount, Date ticketexpirationdate, BigInteger createdby, Date createdon, BigInteger modifiedby, Date modifiedon) {
        this.id = id;
        this.ticketcount = ticketcount;
        this.ticketexpirationdate = ticketexpirationdate;
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

    public BigInteger getTicketcount() {
        return ticketcount;
    }

    public void setTicketcount(BigInteger ticketcount) {
        this.ticketcount = ticketcount;
    }

    public Date getTicketexpirationdate() {
        return ticketexpirationdate;
    }

    public void setTicketexpirationdate(Date ticketexpirationdate) {
        this.ticketexpirationdate = ticketexpirationdate;
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

    public Transactioninfo getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(Transactioninfo transactionid) {
        this.transactionid = transactionid;
    }

    public Attraction getAttractionid() {
        return attractionid;
    }

    public void setAttractionid(Attraction attractionid) {
        this.attractionid = attractionid;
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
        if (!(object instanceof Transactionattraction)) {
            return false;
        }
        Transactionattraction other = (Transactionattraction) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.chooseadventure.entity.Transactionattraction[ id=" + id + " ]";
    }
    
}
