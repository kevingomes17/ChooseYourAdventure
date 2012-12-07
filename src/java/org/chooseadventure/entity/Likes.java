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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
 * @author root
 */
@Entity
@Table(name = "LIKES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Likes.findAll", query = "SELECT l FROM Likes l"),
    @NamedQuery(name = "Likes.findById", query = "SELECT l FROM Likes l WHERE l.id = :id"),
    @NamedQuery(name = "Likes.findByContenttype", query = "SELECT l FROM Likes l WHERE l.contenttype = :contenttype"),
    @NamedQuery(name = "Likes.findPerContentType", query = "SELECT l FROM Likes l WHERE l.contenttype = :contenttype and l.foreignid = :foreignid and l.likeordislike = :likeordislike"),
    @NamedQuery(name = "Likes.findByLikeordislike", query = "SELECT l FROM Likes l WHERE l.likeordislike = :likeordislike"),
    @NamedQuery(name = "Likes.findByForeignid", query = "SELECT l FROM Likes l WHERE l.foreignid = :foreignid"),
    @NamedQuery(name = "Likes.findByCreatedby", query = "SELECT l FROM Likes l WHERE l.createdby = :createdby"),
    @NamedQuery(name = "Likes.findByCreatedon", query = "SELECT l FROM Likes l WHERE l.createdon = :createdon"),
    @NamedQuery(name = "Likes.findByModifiedby", query = "SELECT l FROM Likes l WHERE l.modifiedby = :modifiedby"),
    @NamedQuery(name = "Likes.findByModifiedon", query = "SELECT l FROM Likes l WHERE l.modifiedon = :modifiedon")})
public class Likes implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_LIKES_ID")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONTENTTYPE")
    private int contenttype;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LIKEORDISLIKE")
    private BigInteger likeordislike;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FOREIGNID")
    private int foreignid;
    @Column(name = "CREATEDBY")
    private BigInteger createdby;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATEDON")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdon;
    @Column(name = "MODIFIEDBY")
    private BigInteger modifiedby;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MODIFIEDON")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedon;
    @JoinColumn(name = "USERID", referencedColumnName = "ID")
    @ManyToOne
    private Userbase userid;

    public Likes() {
    }

    public Likes(BigDecimal id) {
        this.id = id;
    }

    public Likes(BigDecimal id, int contenttype, BigInteger likeordislike, int foreignid, Date createdon, Date modifiedon) {
        this.id = id;
        this.contenttype = contenttype;
        this.likeordislike = likeordislike;
        this.foreignid = foreignid;
        this.createdon = createdon;
        this.modifiedon = modifiedon;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public int getContenttype() {
        return contenttype;
    }

    public void setContenttype(int contenttype) {
        this.contenttype = contenttype;
    }

    public BigInteger getLikeordislike() {
        return likeordislike;
    }

    public void setLikeordislike(BigInteger likeordislike) {
        this.likeordislike = likeordislike;
    }

    public int getForeignid() {
        return foreignid;
    }

    public void setForeignid(int foreignid) {
        this.foreignid = foreignid;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Likes)) {
            return false;
        }
        Likes other = (Likes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.chooseadventure.entity.Likes[ id=" + id + " ]";
    }
}
