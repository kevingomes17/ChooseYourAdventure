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
@Table(name = "ATTRACTIONMANAGEMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Attractionmanagement.findAll", query = "SELECT a FROM Attractionmanagement a"),
    @NamedQuery(name = "Attractionmanagement.findByAttractionid", query = "SELECT a FROM Attractionmanagement a WHERE a.attractionid = :attractionid"),
    @NamedQuery(name = "Attractionmanagement.findByMaintenancecount", query = "SELECT a FROM Attractionmanagement a WHERE a.maintenancecount = :maintenancecount"),
    @NamedQuery(name = "Attractionmanagement.findBySecuritycount", query = "SELECT a FROM Attractionmanagement a WHERE a.securitycount = :securitycount"),
    @NamedQuery(name = "Attractionmanagement.findByTicketingcount", query = "SELECT a FROM Attractionmanagement a WHERE a.ticketingcount = :ticketingcount"),
    @NamedQuery(name = "Attractionmanagement.findByCuratorcount", query = "SELECT a FROM Attractionmanagement a WHERE a.curatorcount = :curatorcount"),
    @NamedQuery(name = "Attractionmanagement.findByTourguidecount", query = "SELECT a FROM Attractionmanagement a WHERE a.tourguidecount = :tourguidecount"),
    @NamedQuery(name = "Attractionmanagement.findByModifiedby", query = "SELECT a FROM Attractionmanagement a WHERE a.modifiedby = :modifiedby"),
    @NamedQuery(name = "Attractionmanagement.findByModifiedon", query = "SELECT a FROM Attractionmanagement a WHERE a.modifiedon = :modifiedon"),
    @NamedQuery(name = "Attractionmanagement.findByCreatedby", query = "SELECT a FROM Attractionmanagement a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "Attractionmanagement.findByCreatedon", query = "SELECT a FROM Attractionmanagement a WHERE a.createdon = :createdon")})
public class Attractionmanagement implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ATTRACTIONID")
    private BigDecimal attractionid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MAINTENANCECOUNT")
    private BigInteger maintenancecount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SECURITYCOUNT")
    private BigInteger securitycount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TICKETINGCOUNT")
    private BigInteger ticketingcount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CURATORCOUNT")
    private BigInteger curatorcount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOURGUIDECOUNT")
    private BigInteger tourguidecount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MODIFIEDBY")
    private BigInteger modifiedby;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MODIFIEDON")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedon;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATEDBY")
    private BigInteger createdby;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATEDON")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdon;
    @JoinColumn(name = "ATTRACTIONID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Attraction attraction;

    public Attractionmanagement() {
    }

    public Attractionmanagement(BigDecimal attractionid) {
        this.attractionid = attractionid;
    }

    public Attractionmanagement(BigDecimal attractionid, BigInteger maintenancecount, BigInteger securitycount, BigInteger ticketingcount, BigInteger curatorcount, BigInteger tourguidecount, BigInteger modifiedby, Date modifiedon, BigInteger createdby, Date createdon) {
        this.attractionid = attractionid;
        this.maintenancecount = maintenancecount;
        this.securitycount = securitycount;
        this.ticketingcount = ticketingcount;
        this.curatorcount = curatorcount;
        this.tourguidecount = tourguidecount;
        this.modifiedby = modifiedby;
        this.modifiedon = modifiedon;
        this.createdby = createdby;
        this.createdon = createdon;
    }

    public BigDecimal getAttractionid() {
        return attractionid;
    }

    public void setAttractionid(BigDecimal attractionid) {
        this.attractionid = attractionid;
    }

    public BigInteger getMaintenancecount() {
        return maintenancecount;
    }

    public void setMaintenancecount(BigInteger maintenancecount) {
        this.maintenancecount = maintenancecount;
    }

    public BigInteger getSecuritycount() {
        return securitycount;
    }

    public void setSecuritycount(BigInteger securitycount) {
        this.securitycount = securitycount;
    }

    public BigInteger getTicketingcount() {
        return ticketingcount;
    }

    public void setTicketingcount(BigInteger ticketingcount) {
        this.ticketingcount = ticketingcount;
    }

    public BigInteger getCuratorcount() {
        return curatorcount;
    }

    public void setCuratorcount(BigInteger curatorcount) {
        this.curatorcount = curatorcount;
    }

    public BigInteger getTourguidecount() {
        return tourguidecount;
    }

    public void setTourguidecount(BigInteger tourguidecount) {
        this.tourguidecount = tourguidecount;
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

    public Attraction getAttraction() {
        return attraction;
    }

    public void setAttraction(Attraction attraction) {
        this.attraction = attraction;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (attractionid != null ? attractionid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Attractionmanagement)) {
            return false;
        }
        Attractionmanagement other = (Attractionmanagement) object;
        if ((this.attractionid == null && other.attractionid != null) || (this.attractionid != null && !this.attractionid.equals(other.attractionid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.chooseadventure.entity.Attractionmanagement[ attractionid=" + attractionid + " ]";
    }
    
}
