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
@Table(name = "ATTRACTIONTYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Attractiontype.findAll", query = "SELECT a FROM Attractiontype a"),
    @NamedQuery(name = "Attractiontype.findById", query = "SELECT a FROM Attractiontype a WHERE a.id = :id"),
    @NamedQuery(name = "Attractiontype.findByName", query = "SELECT a FROM Attractiontype a WHERE a.name = :name"),
    @NamedQuery(name = "Attractiontype.findByCreatedby", query = "SELECT a FROM Attractiontype a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "Attractiontype.findByCreatedon", query = "SELECT a FROM Attractiontype a WHERE a.createdon = :createdon"),
    @NamedQuery(name = "Attractiontype.findByModifiedby", query = "SELECT a FROM Attractiontype a WHERE a.modifiedby = :modifiedby"),
    @NamedQuery(name = "Attractiontype.findByModifiedon", query = "SELECT a FROM Attractiontype a WHERE a.modifiedon = :modifiedon")})
public class Attractiontype implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NAME")
    private String name;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "attractiontypeid")
    private Collection<Attraction> attractionCollection;

    public Attractiontype() {
    }

    public Attractiontype(BigDecimal id) {
        this.id = id;
    }

    public Attractiontype(BigDecimal id, String name, BigInteger createdby, Date createdon, BigInteger modifiedby, Date modifiedon) {
        this.id = id;
        this.name = name;
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
    public Collection<Attraction> getAttractionCollection() {
        return attractionCollection;
    }

    public void setAttractionCollection(Collection<Attraction> attractionCollection) {
        this.attractionCollection = attractionCollection;
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
        if (!(object instanceof Attractiontype)) {
            return false;
        }
        Attractiontype other = (Attractiontype) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.chooseadventure.entity.Attractiontype[ id=" + id + " ]";
    }
    
}
