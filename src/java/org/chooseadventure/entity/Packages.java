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
@Table(name = "PACKAGES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Packages.findAll", query = "SELECT p FROM Packages p"),
    @NamedQuery(name = "Packages.findById", query = "SELECT p FROM Packages p WHERE p.id = :id"),
    @NamedQuery(name = "Packages.findByCityId", query = "SELECT p FROM Packages p WHERE p.cityId = :cityId"),
    @NamedQuery(name = "Packages.findByName", query = "SELECT p FROM Packages p WHERE p.name = :name"),
    @NamedQuery(name = "Packages.findByDescription", query = "SELECT p FROM Packages p WHERE p.description = :description"),
    @NamedQuery(name = "Packages.findByCostperticket", query = "SELECT p FROM Packages p WHERE p.costperticket = :costperticket"),
    @NamedQuery(name = "Packages.findByCreatedby", query = "SELECT p FROM Packages p WHERE p.createdby = :createdby"),
    @NamedQuery(name = "Packages.findByCreatedon", query = "SELECT p FROM Packages p WHERE p.createdon = :createdon"),
    @NamedQuery(name = "Packages.findByModifiedby", query = "SELECT p FROM Packages p WHERE p.modifiedby = :modifiedby"),
    @NamedQuery(name = "Packages.findByModifiedon", query = "SELECT p FROM Packages p WHERE p.modifiedon = :modifiedon")})
public class Packages implements Serializable {
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
    @Size(max = 2000)
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COSTPERTICKET")
    private BigDecimal costperticket;
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
    @Column(name = "city_id")
    private BigDecimal cityId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "packages")
    private Collection<Packageattraction> packageattractionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "packageid")
    private Collection<Transactionpackage> transactionpackageCollection;

    public Packages() {
    }

    public Packages(BigDecimal id) {
        this.id = id;
    }

    public Packages(BigDecimal id, String name, BigDecimal costperticket, BigInteger createdby, Date createdon, BigInteger modifiedby, Date modifiedon) {
        this.id = id;
        this.name = name;
        this.costperticket = costperticket;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getCostperticket() {
        return costperticket;
    }

    public void setCostperticket(BigDecimal costperticket) {
        this.costperticket = costperticket;
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

    public BigDecimal getCityId() {
        return cityId;
    }

    public void setCityId(BigDecimal cityId) {
        this.cityId = cityId;
    }
    
    @XmlTransient
    public Collection<Packageattraction> getPackageattractionCollection() {
        return packageattractionCollection;
    }

    public void setPackageattractionCollection(Collection<Packageattraction> packageattractionCollection) {
        this.packageattractionCollection = packageattractionCollection;
    }

    @XmlTransient
    public Collection<Transactionpackage> getTransactionpackageCollection() {
        return transactionpackageCollection;
    }

    public void setTransactionpackageCollection(Collection<Transactionpackage> transactionpackageCollection) {
        this.transactionpackageCollection = transactionpackageCollection;
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
        if (!(object instanceof Packages)) {
            return false;
        }
        Packages other = (Packages) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.chooseadventure.entity.Packages[ id=" + id + " ]";
    }
    
}
