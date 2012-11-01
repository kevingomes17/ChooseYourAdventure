/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.chooseadventure.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kevingomes17
 */
@Entity
@Table(name = "ACTIVITYLOG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Activitylog.findAll", query = "SELECT a FROM Activitylog a"),
    @NamedQuery(name = "Activitylog.findById", query = "SELECT a FROM Activitylog a WHERE a.id = :id"),
    @NamedQuery(name = "Activitylog.findByDescription", query = "SELECT a FROM Activitylog a WHERE a.description = :description"),
    @NamedQuery(name = "Activitylog.findByCreatedby", query = "SELECT a FROM Activitylog a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "Activitylog.findByCreatedon", query = "SELECT a FROM Activitylog a WHERE a.createdon = :createdon"),
    @NamedQuery(name = "Activitylog.findByModifiedby", query = "SELECT a FROM Activitylog a WHERE a.modifiedby = :modifiedby"),
    @NamedQuery(name = "Activitylog.findByModifiedon", query = "SELECT a FROM Activitylog a WHERE a.modifiedon = :modifiedon")})
public class Activitylog implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 200)
    @Column(name = "DESCRIPTION")
    private String description;
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
    @JoinColumn(name = "USERID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Userbase userid;
    @JoinColumn(name = "ACTIVITYTYPEID", referencedColumnName = "ID")
    @ManyToOne
    private Activitytype activitytypeid;

    public Activitylog() {
    }

    public Activitylog(BigDecimal id) {
        this.id = id;
    }

    public Activitylog(BigDecimal id, BigInteger createdby, Date createdon, BigInteger modifiedby, Date modifiedon) {
        this.id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Userbase getUserid() {
        return userid;
    }

    public void setUserid(Userbase userid) {
        this.userid = userid;
    }

    public Activitytype getActivitytypeid() {
        return activitytypeid;
    }

    public void setActivitytypeid(Activitytype activitytypeid) {
        this.activitytypeid = activitytypeid;
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
        if (!(object instanceof Activitylog)) {
            return false;
        }
        Activitylog other = (Activitylog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.chooseadventure.entity.Activitylog[ id=" + id + " ]";
    }
    
}
