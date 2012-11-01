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
public class AttractionemployeePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "EMPLOYEEID")
    private BigInteger employeeid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ATTRACTIONID")
    private BigInteger attractionid;

    public AttractionemployeePK() {
    }

    public AttractionemployeePK(BigInteger employeeid, BigInteger attractionid) {
        this.employeeid = employeeid;
        this.attractionid = attractionid;
    }

    public BigInteger getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(BigInteger employeeid) {
        this.employeeid = employeeid;
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
        hash += (employeeid != null ? employeeid.hashCode() : 0);
        hash += (attractionid != null ? attractionid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AttractionemployeePK)) {
            return false;
        }
        AttractionemployeePK other = (AttractionemployeePK) object;
        if ((this.employeeid == null && other.employeeid != null) || (this.employeeid != null && !this.employeeid.equals(other.employeeid))) {
            return false;
        }
        if ((this.attractionid == null && other.attractionid != null) || (this.attractionid != null && !this.attractionid.equals(other.attractionid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.chooseadventure.entity.AttractionemployeePK[ employeeid=" + employeeid + ", attractionid=" + attractionid + " ]";
    }
    
}
