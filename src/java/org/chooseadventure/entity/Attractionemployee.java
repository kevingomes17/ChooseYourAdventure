/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.chooseadventure.entity;

import java.io.Serializable;
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
@Table(name = "ATTRACTIONEMPLOYEE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Attractionemployee.findAll", query = "SELECT a FROM Attractionemployee a"),
    @NamedQuery(name = "Attractionemployee.findByEmployeeid", query = "SELECT a FROM Attractionemployee a WHERE a.attractionemployeePK.employeeid = :employeeid"),
    @NamedQuery(name = "Attractionemployee.findByAttractionid", query = "SELECT a FROM Attractionemployee a WHERE a.attractionemployeePK.attractionid = :attractionid"),
    @NamedQuery(name = "Attractionemployee.findByCreatedby", query = "SELECT a FROM Attractionemployee a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "Attractionemployee.findByCreatedon", query = "SELECT a FROM Attractionemployee a WHERE a.createdon = :createdon"),
    @NamedQuery(name = "Attractionemployee.findByModifiedby", query = "SELECT a FROM Attractionemployee a WHERE a.modifiedby = :modifiedby"),
    @NamedQuery(name = "Attractionemployee.findByModifiedon", query = "SELECT a FROM Attractionemployee a WHERE a.modifiedon = :modifiedon")})
public class Attractionemployee implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AttractionemployeePK attractionemployeePK;
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
    @JoinColumn(name = "EMPLOYEEID", referencedColumnName = "USERID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Useremployee useremployee;
    @JoinColumn(name = "ATTRACTIONID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Attraction attraction;

    public Attractionemployee() {
    }

    public Attractionemployee(AttractionemployeePK attractionemployeePK) {
        this.attractionemployeePK = attractionemployeePK;
    }

    public Attractionemployee(AttractionemployeePK attractionemployeePK, BigInteger createdby, Date createdon, BigInteger modifiedby, Date modifiedon) {
        this.attractionemployeePK = attractionemployeePK;
        this.createdby = createdby;
        this.createdon = createdon;
        this.modifiedby = modifiedby;
        this.modifiedon = modifiedon;
    }

    public Attractionemployee(BigInteger employeeid, BigInteger attractionid) {
        this.attractionemployeePK = new AttractionemployeePK(employeeid, attractionid);
    }

    public AttractionemployeePK getAttractionemployeePK() {
        return attractionemployeePK;
    }

    public void setAttractionemployeePK(AttractionemployeePK attractionemployeePK) {
        this.attractionemployeePK = attractionemployeePK;
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

    public Useremployee getUseremployee() {
        return useremployee;
    }

    public void setUseremployee(Useremployee useremployee) {
        this.useremployee = useremployee;
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
        hash += (attractionemployeePK != null ? attractionemployeePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Attractionemployee)) {
            return false;
        }
        Attractionemployee other = (Attractionemployee) object;
        if ((this.attractionemployeePK == null && other.attractionemployeePK != null) || (this.attractionemployeePK != null && !this.attractionemployeePK.equals(other.attractionemployeePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.chooseadventure.entity.Attractionemployee[ attractionemployeePK=" + attractionemployeePK + " ]";
    }
    
}
