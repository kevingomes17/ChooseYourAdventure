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
public class EmployeeTeamPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "EMPLOYEEID")
    private BigInteger employeeid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TEAMID")
    private BigInteger teamid;

    public EmployeeTeamPK() {
    }

    public EmployeeTeamPK(BigInteger employeeid, BigInteger teamid) {
        this.employeeid = employeeid;
        this.teamid = teamid;
    }

    public BigInteger getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(BigInteger employeeid) {
        this.employeeid = employeeid;
    }

    public BigInteger getTeamid() {
        return teamid;
    }

    public void setTeamid(BigInteger teamid) {
        this.teamid = teamid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeid != null ? employeeid.hashCode() : 0);
        hash += (teamid != null ? teamid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeeTeamPK)) {
            return false;
        }
        EmployeeTeamPK other = (EmployeeTeamPK) object;
        if ((this.employeeid == null && other.employeeid != null) || (this.employeeid != null && !this.employeeid.equals(other.employeeid))) {
            return false;
        }
        if ((this.teamid == null && other.teamid != null) || (this.teamid != null && !this.teamid.equals(other.teamid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.chooseadventure.entity.EmployeeTeamPK[ employeeid=" + employeeid + ", teamid=" + teamid + " ]";
    }
    
}
