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
@Table(name = "EMPLOYEEROLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employeerole.findAll", query = "SELECT e FROM Employeerole e"),
    @NamedQuery(name = "Employeerole.findByEmployeeid", query = "SELECT e FROM Employeerole e WHERE e.employeerolePK.employeeid = :employeeid"),
    @NamedQuery(name = "Employeerole.findByRoleid", query = "SELECT e FROM Employeerole e WHERE e.employeerolePK.roleid = :roleid"),
    @NamedQuery(name = "Employeerole.findByCreatedby", query = "SELECT e FROM Employeerole e WHERE e.createdby = :createdby"),
    @NamedQuery(name = "Employeerole.findByCreatedon", query = "SELECT e FROM Employeerole e WHERE e.createdon = :createdon"),
    @NamedQuery(name = "Employeerole.findByModifiedby", query = "SELECT e FROM Employeerole e WHERE e.modifiedby = :modifiedby"),
    @NamedQuery(name = "Employeerole.findByModifiedon", query = "SELECT e FROM Employeerole e WHERE e.modifiedon = :modifiedon")})
public class Employeerole implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmployeerolePK employeerolePK;
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
    @JoinColumn(name = "ROLEID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Role role;

    public Employeerole() {
    }

    public Employeerole(EmployeerolePK employeerolePK) {
        this.employeerolePK = employeerolePK;
    }

    public Employeerole(EmployeerolePK employeerolePK, BigInteger createdby, Date createdon, BigInteger modifiedby, Date modifiedon) {
        this.employeerolePK = employeerolePK;
        this.createdby = createdby;
        this.createdon = createdon;
        this.modifiedby = modifiedby;
        this.modifiedon = modifiedon;
    }

    public Employeerole(BigInteger employeeid, BigInteger roleid) {
        this.employeerolePK = new EmployeerolePK(employeeid, roleid);
    }

    public EmployeerolePK getEmployeerolePK() {
        return employeerolePK;
    }

    public void setEmployeerolePK(EmployeerolePK employeerolePK) {
        this.employeerolePK = employeerolePK;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeerolePK != null ? employeerolePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employeerole)) {
            return false;
        }
        Employeerole other = (Employeerole) object;
        if ((this.employeerolePK == null && other.employeerolePK != null) || (this.employeerolePK != null && !this.employeerolePK.equals(other.employeerolePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.chooseadventure.entity.Employeerole[ employeerolePK=" + employeerolePK + " ]";
    }
    
}
