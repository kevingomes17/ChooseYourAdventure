/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.chooseadventure.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kevingomes17
 */
@Entity
@Table(name = "DISCOUNT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Discount.findAll", query = "SELECT d FROM Discount d"),
    @NamedQuery(name = "Discount.findById", query = "SELECT d FROM Discount d WHERE d.id = :id"),
    @NamedQuery(name = "Discount.findByName", query = "SELECT d FROM Discount d WHERE d.name = :name"),
    @NamedQuery(name = "Discount.findByFormula", query = "SELECT d FROM Discount d WHERE d.formula = :formula"),
    @NamedQuery(name = "Discount.findByFormulavalue", query = "SELECT d FROM Discount d WHERE d.formulavalue = :formulavalue"),
    @NamedQuery(name = "Discount.findByNooftransactions", query = "SELECT d FROM Discount d WHERE d.nooftransactions = :nooftransactions"),
    @NamedQuery(name = "Discount.findByIsactive", query = "SELECT d FROM Discount d WHERE d.isactive = :isactive"),
    @NamedQuery(name = "Discount.findByCreatedby", query = "SELECT d FROM Discount d WHERE d.createdby = :createdby"),
    @NamedQuery(name = "Discount.findByCreatedon", query = "SELECT d FROM Discount d WHERE d.createdon = :createdon"),
    @NamedQuery(name = "Discount.findByModifiedby", query = "SELECT d FROM Discount d WHERE d.modifiedby = :modifiedby"),
    @NamedQuery(name = "Discount.findByModifiedon", query = "SELECT d FROM Discount d WHERE d.modifiedon = :modifiedon")})
public class Discount implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "FORMULA")
    private String formula;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FORMULAVALUE")
    private BigDecimal formulavalue;
    @Column(name = "NOOFTRANSACTIONS")
    private BigInteger nooftransactions;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ISACTIVE")
    private BigInteger isactive;
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
    @JoinColumn(name = "MEMBERSHIPTYPEID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private MembershipType membershiptypeid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "discount")
    private Collection<Transactiondiscount> transactiondiscountCollection;

    public Discount() {
    }

    public Discount(BigDecimal id) {
        this.id = id;
    }

    public Discount(BigDecimal id, String name, String formula, BigDecimal formulavalue, BigInteger isactive, BigInteger createdby, Date createdon, BigInteger modifiedby, Date modifiedon) {
        this.id = id;
        this.name = name;
        this.formula = formula;
        this.formulavalue = formulavalue;
        this.isactive = isactive;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public BigDecimal getFormulavalue() {
        return formulavalue;
    }

    public void setFormulavalue(BigDecimal formulavalue) {
        this.formulavalue = formulavalue;
    }

    public BigInteger getNooftransactions() {
        return nooftransactions;
    }

    public void setNooftransactions(BigInteger nooftransactions) {
        this.nooftransactions = nooftransactions;
    }

    public BigInteger getIsactive() {
        return isactive;
    }

    public void setIsactive(BigInteger isactive) {
        this.isactive = isactive;
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

    public MembershipType getMembershiptypeid() {
        return membershiptypeid;
    }

    public void setMembershiptypeid(MembershipType membershiptypeid) {
        this.membershiptypeid = membershiptypeid;
    }

    @XmlTransient
    public Collection<Transactiondiscount> getTransactiondiscountCollection() {
        return transactiondiscountCollection;
    }

    public void setTransactiondiscountCollection(Collection<Transactiondiscount> transactiondiscountCollection) {
        this.transactiondiscountCollection = transactiondiscountCollection;
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
        if (!(object instanceof Discount)) {
            return false;
        }
        Discount other = (Discount) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.chooseadventure.entity.Discount[ id=" + id + " ]";
    }
    
}
