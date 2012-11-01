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
@Table(name = "ATTRACTIONVISITED")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Attractionvisited.findAll", query = "SELECT a FROM Attractionvisited a"),
    @NamedQuery(name = "Attractionvisited.findById", query = "SELECT a FROM Attractionvisited a WHERE a.id = :id"),
    @NamedQuery(name = "Attractionvisited.findByCreatedby", query = "SELECT a FROM Attractionvisited a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "Attractionvisited.findByCreatedon", query = "SELECT a FROM Attractionvisited a WHERE a.createdon = :createdon"),
    @NamedQuery(name = "Attractionvisited.findByModifiedby", query = "SELECT a FROM Attractionvisited a WHERE a.modifiedby = :modifiedby"),
    @NamedQuery(name = "Attractionvisited.findByModifiedon", query = "SELECT a FROM Attractionvisited a WHERE a.modifiedon = :modifiedon")})
public class Attractionvisited implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
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
    @ManyToOne
    private Userbase userid;
    @JoinColumn(name = "TRANSACTIONID", referencedColumnName = "ID")
    @ManyToOne
    private Transactioninfo transactionid;
    @JoinColumn(name = "ATTRACTIONID", referencedColumnName = "ID")
    @ManyToOne
    private Attraction attractionid;

    public Attractionvisited() {
    }

    public Attractionvisited(BigDecimal id) {
        this.id = id;
    }

    public Attractionvisited(BigDecimal id, BigInteger createdby, Date createdon, BigInteger modifiedby, Date modifiedon) {
        this.id = id;
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
        if (!(object instanceof Attractionvisited)) {
            return false;
        }
        Attractionvisited other = (Attractionvisited) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.chooseadventure.entity.Attractionvisited[ id=" + id + " ]";
    }
    
}
