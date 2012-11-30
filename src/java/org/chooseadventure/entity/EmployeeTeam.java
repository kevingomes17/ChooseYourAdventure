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
@Table(name = "EMPLOYEE_TEAM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeeTeam.findAll", query = "SELECT e FROM EmployeeTeam e"),
    @NamedQuery(name = "EmployeeTeam.findByEmployeeid", query = "SELECT e FROM EmployeeTeam e WHERE e.employeeTeamPK.employeeid = :employeeid"),
    @NamedQuery(name = "EmployeeTeam.findByTeamid", query = "SELECT e FROM EmployeeTeam e WHERE e.employeeTeamPK.teamid = :teamid"),
    @NamedQuery(name = "EmployeeTeam.findByCreatedby", query = "SELECT e FROM EmployeeTeam e WHERE e.createdby = :createdby"),
    @NamedQuery(name = "EmployeeTeam.findByCreatedon", query = "SELECT e FROM EmployeeTeam e WHERE e.createdon = :createdon"),
    @NamedQuery(name = "EmployeeTeam.findByModifiedby", query = "SELECT e FROM EmployeeTeam e WHERE e.modifiedby = :modifiedby"),
    @NamedQuery(name = "EmployeeTeam.findByModifiedon", query = "SELECT e FROM EmployeeTeam e WHERE e.modifiedon = :modifiedon")})
public class EmployeeTeam implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmployeeTeamPK employeeTeamPK;
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
    @JoinColumn(name = "EMPLOYEEID", referencedColumnName = "USERID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Useremployee useremployee;
    @JoinColumn(name = "TEAMID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Team team;

    public EmployeeTeam() {
    }

    public EmployeeTeam(EmployeeTeamPK employeeTeamPK) {
        this.employeeTeamPK = employeeTeamPK;
    }

    public EmployeeTeam(EmployeeTeamPK employeeTeamPK, BigInteger createdby, Date createdon, BigInteger modifiedby, Date modifiedon) {
        this.employeeTeamPK = employeeTeamPK;
        this.createdby = createdby;
        this.createdon = createdon;
        this.modifiedby = modifiedby;
        this.modifiedon = modifiedon;
    }

    public EmployeeTeam(BigInteger employeeid, BigInteger teamid) {
        this.employeeTeamPK = new EmployeeTeamPK(employeeid, teamid);
    }

    public EmployeeTeamPK getEmployeeTeamPK() {
        return employeeTeamPK;
    }

    public void setEmployeeTeamPK(EmployeeTeamPK employeeTeamPK) {
        this.employeeTeamPK = employeeTeamPK;
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

    public Useremployee getUseremployee() {
        return useremployee;
    }

    public void setUseremployee(Useremployee useremployee) {
        this.useremployee = useremployee;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeTeamPK != null ? employeeTeamPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeeTeam)) {
            return false;
        }
        EmployeeTeam other = (EmployeeTeam) object;
        if ((this.employeeTeamPK == null && other.employeeTeamPK != null) || (this.employeeTeamPK != null && !this.employeeTeamPK.equals(other.employeeTeamPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.chooseadventure.entity.EmployeeTeam[ employeeTeamPK=" + employeeTeamPK + " ]";
    }
    
}
