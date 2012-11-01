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
public class EmployeerolePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "EMPLOYEEID")
    private BigInteger employeeid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ROLEID")
    private BigInteger roleid;

    public EmployeerolePK() {
    }

    public EmployeerolePK(BigInteger employeeid, BigInteger roleid) {
        this.employeeid = employeeid;
        this.roleid = roleid;
    }

    public BigInteger getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(BigInteger employeeid) {
        this.employeeid = employeeid;
    }

    public BigInteger getRoleid() {
        return roleid;
    }

    public void setRoleid(BigInteger roleid) {
        this.roleid = roleid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeid != null ? employeeid.hashCode() : 0);
        hash += (roleid != null ? roleid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeerolePK)) {
            return false;
        }
        EmployeerolePK other = (EmployeerolePK) object;
        if ((this.employeeid == null && other.employeeid != null) || (this.employeeid != null && !this.employeeid.equals(other.employeeid))) {
            return false;
        }
        if ((this.roleid == null && other.roleid != null) || (this.roleid != null && !this.roleid.equals(other.roleid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.chooseadventure.entity.EmployeerolePK[ employeeid=" + employeeid + ", roleid=" + roleid + " ]";
    }
    
}
