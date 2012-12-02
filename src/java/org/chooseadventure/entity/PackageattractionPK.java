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
public class PackageattractionPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "PACKAGEID")
    private BigInteger packageid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ATTRACTIONID")
    private BigInteger attractionid;

    public PackageattractionPK() {
    }

    public PackageattractionPK(BigInteger packageid, BigInteger attractionid) {
        this.packageid = packageid;
        this.attractionid = attractionid;
    }

    public BigInteger getPackageid() {
        return packageid;
    }

    public void setPackageid(BigInteger packageid) {
        this.packageid = packageid;
    }

    public BigInteger getAttractionid() {
        return attractionid;
    }

    public void setAttractionid(BigInteger attractionid) {
        this.attractionid = attractionid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (packageid != null ? packageid.hashCode() : 0);
        hash += (attractionid != null ? attractionid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PackageattractionPK)) {
            return false;
        }
        PackageattractionPK other = (PackageattractionPK) object;
        if ((this.packageid == null && other.packageid != null) || (this.packageid != null && !this.packageid.equals(other.packageid))) {
            return false;
        }
        if ((this.attractionid == null && other.attractionid != null) || (this.attractionid != null && !this.attractionid.equals(other.attractionid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.chooseadventure.entity.PackageattractionPK[ packageid=" + packageid + ", attractionid=" + attractionid + " ]";
    }
    
}
