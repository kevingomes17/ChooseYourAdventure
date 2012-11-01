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
public class EmployeebossPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "EMPLOYEEID")
    private BigInteger employeeid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BOSSEMPLOYEEID")
    private BigInteger bossemployeeid;

    public EmployeebossPK() {
    }

    public EmployeebossPK(BigInteger employeeid, BigInteger bossemployeeid) {
        this.employeeid = employeeid;
        this.bossemployeeid = bossemployeeid;
    }

    public BigInteger getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(BigInteger employeeid) {
        this.employeeid = employeeid;
    }

    public BigInteger getBossemployeeid() {
        return bossemployeeid;
    }

    public void setBossemployeeid(BigInteger bossemployeeid) {
        this.bossemployeeid = bossemployeeid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeid != null ? employeeid.hashCode() : 0);
        hash += (bossemployeeid != null ? bossemployeeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeebossPK)) {
            return false;
        }
        EmployeebossPK other = (EmployeebossPK) object;
        if ((this.employeeid == null && other.employeeid != null) || (this.employeeid != null && !this.employeeid.equals(other.employeeid))) {
            return false;
        }
        if ((this.bossemployeeid == null && other.bossemployeeid != null) || (this.bossemployeeid != null && !this.bossemployeeid.equals(other.bossemployeeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.chooseadventure.entity.EmployeebossPK[ employeeid=" + employeeid + ", bossemployeeid=" + bossemployeeid + " ]";
    }
    
}
