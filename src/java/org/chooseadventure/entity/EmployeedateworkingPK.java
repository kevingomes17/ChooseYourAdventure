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
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author kevingomes17
 */
@Embeddable
public class EmployeedateworkingPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "DAYOFF")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dayoff;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USERID")
    private BigInteger userid;

    public EmployeedateworkingPK() {
    }

    public EmployeedateworkingPK(Date dayoff, BigInteger userid) {
        this.dayoff = dayoff;
        this.userid = userid;
    }

    public Date getDayoff() {
        return dayoff;
    }

    public void setDayoff(Date dayoff) {
        this.dayoff = dayoff;
    }

    public BigInteger getUserid() {
        return userid;
    }

    public void setUserid(BigInteger userid) {
        this.userid = userid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dayoff != null ? dayoff.hashCode() : 0);
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeedateworkingPK)) {
            return false;
        }
        EmployeedateworkingPK other = (EmployeedateworkingPK) object;
        if ((this.dayoff == null && other.dayoff != null) || (this.dayoff != null && !this.dayoff.equals(other.dayoff))) {
            return false;
        }
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.chooseadventure.entity.EmployeedateworkingPK[ dayoff=" + dayoff + ", userid=" + userid + " ]";
    }
    
}
