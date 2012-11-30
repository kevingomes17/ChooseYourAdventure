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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kevingomes17
 */
@Entity
@Table(name = "MEMBERSHIP_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MembershipType.findAll", query = "SELECT m FROM MembershipType m"),
    @NamedQuery(name = "MembershipType.findById", query = "SELECT m FROM MembershipType m WHERE m.id = :id"),
    @NamedQuery(name = "MembershipType.findByName", query = "SELECT m FROM MembershipType m WHERE m.name = :name"),
    @NamedQuery(name = "MembershipType.findByCreditPointsNeeded", query = "SELECT m FROM MembershipType m WHERE m.creditPointsNeeded = :creditPointsNeeded"),
    @NamedQuery(name = "MembershipType.findByCreatedby", query = "SELECT m FROM MembershipType m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MembershipType.findByCreatedon", query = "SELECT m FROM MembershipType m WHERE m.createdon = :createdon"),
    @NamedQuery(name = "MembershipType.findByModifiedby", query = "SELECT m FROM MembershipType m WHERE m.modifiedby = :modifiedby"),
    @NamedQuery(name = "MembershipType.findByModifiedon", query = "SELECT m FROM MembershipType m WHERE m.modifiedon = :modifiedon")})
public class MembershipType implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREDIT_POINTS_NEEDED")
    private BigInteger creditPointsNeeded;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "membershiptypeid")
    private Collection<Discount> discountCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "membershiptype")
    private Collection<Userwebsite> userwebsiteCollection;

    public MembershipType() {
    }

    public MembershipType(BigDecimal id) {
        this.id = id;
    }

    public MembershipType(BigDecimal id, String name, BigInteger creditPointsNeeded, BigInteger createdby, Date createdon, BigInteger modifiedby, Date modifiedon) {
        this.id = id;
        this.name = name;
        this.creditPointsNeeded = creditPointsNeeded;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getCreditPointsNeeded() {
        return creditPointsNeeded;
    }

    public void setCreditPointsNeeded(BigInteger creditPointsNeeded) {
        this.creditPointsNeeded = creditPointsNeeded;
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

    @XmlTransient
    public Collection<Discount> getDiscountCollection() {
        return discountCollection;
    }

    public void setDiscountCollection(Collection<Discount> discountCollection) {
        this.discountCollection = discountCollection;
    }

    @XmlTransient
    public Collection<Userwebsite> getUserwebsiteCollection() {
        return userwebsiteCollection;
    }

    public void setUserwebsiteCollection(Collection<Userwebsite> userwebsiteCollection) {
        this.userwebsiteCollection = userwebsiteCollection;
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
        if (!(object instanceof MembershipType)) {
            return false;
        }
        MembershipType other = (MembershipType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.chooseadventure.entity.MembershipType[ id=" + id + " ]";
    }
    
}
