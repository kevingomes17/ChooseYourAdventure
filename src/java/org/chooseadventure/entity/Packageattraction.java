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
@Table(name = "PACKAGEATTRACTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Packageattraction.findAll", query = "SELECT p FROM Packageattraction p"),
    @NamedQuery(name = "Packageattraction.findByPackageid", query = "SELECT p FROM Packageattraction p WHERE p.packageattractionPK.packageid = :packageid"),
    @NamedQuery(name = "Packageattraction.findByAttractionid", query = "SELECT p FROM Packageattraction p WHERE p.packageattractionPK.attractionid = :attractionid"),
    @NamedQuery(name = "Packageattraction.findByCreatedby", query = "SELECT p FROM Packageattraction p WHERE p.createdby = :createdby"),
    @NamedQuery(name = "Packageattraction.findByCreatedon", query = "SELECT p FROM Packageattraction p WHERE p.createdon = :createdon"),
    @NamedQuery(name = "Packageattraction.findByModifiedby", query = "SELECT p FROM Packageattraction p WHERE p.modifiedby = :modifiedby"),
    @NamedQuery(name = "Packageattraction.findByModifiedon", query = "SELECT p FROM Packageattraction p WHERE p.modifiedon = :modifiedon")})
public class Packageattraction implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PackageattractionPK packageattractionPK;
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
    @JoinColumn(name = "PACKAGEID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Packages packages;
    @JoinColumn(name = "ATTRACTIONID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Attraction attraction;

    public Packageattraction() {
    }

    public Packageattraction(PackageattractionPK packageattractionPK) {
        this.packageattractionPK = packageattractionPK;
    }

    public Packageattraction(PackageattractionPK packageattractionPK, BigInteger createdby, Date createdon, BigInteger modifiedby, Date modifiedon) {
        this.packageattractionPK = packageattractionPK;
        this.createdby = createdby;
        this.createdon = createdon;
        this.modifiedby = modifiedby;
        this.modifiedon = modifiedon;
    }

    public Packageattraction(BigInteger packageid, BigInteger attractionid) {
        this.packageattractionPK = new PackageattractionPK(packageid, attractionid);
    }

    public PackageattractionPK getPackageattractionPK() {
        return packageattractionPK;
    }

    public void setPackageattractionPK(PackageattractionPK packageattractionPK) {
        this.packageattractionPK = packageattractionPK;
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

    public Packages getPackages() {
        return packages;
    }

    public void setPackages(Packages packages) {
        this.packages = packages;
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
        hash += (packageattractionPK != null ? packageattractionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Packageattraction)) {
            return false;
        }
        Packageattraction other = (Packageattraction) object;
        if ((this.packageattractionPK == null && other.packageattractionPK != null) || (this.packageattractionPK != null && !this.packageattractionPK.equals(other.packageattractionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.chooseadventure.entity.Packageattraction[ packageattractionPK=" + packageattractionPK + " ]";
    }
    
}
