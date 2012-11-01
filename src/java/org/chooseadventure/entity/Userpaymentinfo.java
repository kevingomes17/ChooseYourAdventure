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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
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
@Table(name = "USERPAYMENTINFO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userpaymentinfo.findAll", query = "SELECT u FROM Userpaymentinfo u"),
    @NamedQuery(name = "Userpaymentinfo.findByUserid", query = "SELECT u FROM Userpaymentinfo u WHERE u.userid = :userid"),
    @NamedQuery(name = "Userpaymentinfo.findByCreditcardnumber", query = "SELECT u FROM Userpaymentinfo u WHERE u.creditcardnumber = :creditcardnumber"),
    @NamedQuery(name = "Userpaymentinfo.findByExpirydate", query = "SELECT u FROM Userpaymentinfo u WHERE u.expirydate = :expirydate"),
    @NamedQuery(name = "Userpaymentinfo.findByCode", query = "SELECT u FROM Userpaymentinfo u WHERE u.code = :code"),
    @NamedQuery(name = "Userpaymentinfo.findByCreatedby", query = "SELECT u FROM Userpaymentinfo u WHERE u.createdby = :createdby"),
    @NamedQuery(name = "Userpaymentinfo.findByCreatedon", query = "SELECT u FROM Userpaymentinfo u WHERE u.createdon = :createdon"),
    @NamedQuery(name = "Userpaymentinfo.findByModifiedby", query = "SELECT u FROM Userpaymentinfo u WHERE u.modifiedby = :modifiedby"),
    @NamedQuery(name = "Userpaymentinfo.findByModifiedon", query = "SELECT u FROM Userpaymentinfo u WHERE u.modifiedon = :modifiedon")})
public class Userpaymentinfo implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "USERID")
    private BigDecimal userid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREDITCARDNUMBER")
    private BigInteger creditcardnumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EXPIRYDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expirydate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODE")
    private BigInteger code;
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
    @JoinColumn(name = "USERID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Userbase userbase;

    public Userpaymentinfo() {
    }

    public Userpaymentinfo(BigDecimal userid) {
        this.userid = userid;
    }

    public Userpaymentinfo(BigDecimal userid, BigInteger creditcardnumber, Date expirydate, BigInteger code, BigInteger createdby, Date createdon, BigInteger modifiedby, Date modifiedon) {
        this.userid = userid;
        this.creditcardnumber = creditcardnumber;
        this.expirydate = expirydate;
        this.code = code;
        this.createdby = createdby;
        this.createdon = createdon;
        this.modifiedby = modifiedby;
        this.modifiedon = modifiedon;
    }

    public BigDecimal getUserid() {
        return userid;
    }

    public void setUserid(BigDecimal userid) {
        this.userid = userid;
    }

    public BigInteger getCreditcardnumber() {
        return creditcardnumber;
    }

    public void setCreditcardnumber(BigInteger creditcardnumber) {
        this.creditcardnumber = creditcardnumber;
    }

    public Date getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(Date expirydate) {
        this.expirydate = expirydate;
    }

    public BigInteger getCode() {
        return code;
    }

    public void setCode(BigInteger code) {
        this.code = code;
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

    public Userbase getUserbase() {
        return userbase;
    }

    public void setUserbase(Userbase userbase) {
        this.userbase = userbase;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userpaymentinfo)) {
            return false;
        }
        Userpaymentinfo other = (Userpaymentinfo) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.chooseadventure.entity.Userpaymentinfo[ userid=" + userid + " ]";
    }
    
}
