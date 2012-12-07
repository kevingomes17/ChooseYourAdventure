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
@Table(name = "TICKETSAVAILABLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ticketsavailable.findAll", query = "SELECT t FROM Ticketsavailable t"),
    @NamedQuery(name = "Ticketsavailable.findById", query = "SELECT t FROM Ticketsavailable t WHERE t.id = :id"),
    @NamedQuery(name = "Ticketsavailable.findByRemainingtickets", query = "SELECT t FROM Ticketsavailable t WHERE t.remainingtickets = :remainingtickets"),
    @NamedQuery(name = "Ticketsavailable.findByDateavailable", query = "SELECT t FROM Ticketsavailable t WHERE t.dateavailable = :dateavailable"),
    @NamedQuery(name = "Ticketsavailable.findByAttractionIdDateTickets", query = "SELECT t FROM Ticketsavailable t WHERE t.dateavailable = :dateavailable AND t.remainingtickets >= :remainingtickets AND t.attractionid = :attractionid"),
    @NamedQuery(name = "Ticketsavailable.findByCreatedby", query = "SELECT t FROM Ticketsavailable t WHERE t.createdby = :createdby"),
    @NamedQuery(name = "Ticketsavailable.findByCreatedon", query = "SELECT t FROM Ticketsavailable t WHERE t.createdon = :createdon"),
    @NamedQuery(name = "Ticketsavailable.findByModifiedby", query = "SELECT t FROM Ticketsavailable t WHERE t.modifiedby = :modifiedby"),
    @NamedQuery(name = "Ticketsavailable.findByModifiedon", query = "SELECT t FROM Ticketsavailable t WHERE t.modifiedon = :modifiedon")})
public class Ticketsavailable implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REMAININGTICKETS")
    private BigInteger remainingtickets;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATEAVAILABLE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateavailable;
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
    @JoinColumn(name = "ATTRACTIONID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Attraction attractionid;

    public Ticketsavailable() {
    }

    public Ticketsavailable(BigDecimal id) {
        this.id = id;
    }

    public Ticketsavailable(BigDecimal id, BigInteger remainingtickets, Date dateavailable, BigInteger createdby, Date createdon, BigInteger modifiedby, Date modifiedon) {
        this.id = id;
        this.remainingtickets = remainingtickets;
        this.dateavailable = dateavailable;
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

    public BigInteger getRemainingtickets() {
        return remainingtickets;
    }

    public void setRemainingtickets(BigInteger remainingtickets) {
        this.remainingtickets = remainingtickets;
    }

    public Date getDateavailable() {
        return dateavailable;
    }

    public void setDateavailable(Date dateavailable) {
        this.dateavailable = dateavailable;
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
        if (!(object instanceof Ticketsavailable)) {
            return false;
        }
        Ticketsavailable other = (Ticketsavailable) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.chooseadventure.entity.Ticketsavailable[ id=" + id + " ]";
    }
    
}
