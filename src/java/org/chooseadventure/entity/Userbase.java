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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "USERBASE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userbase.findAll", query = "SELECT u FROM Userbase u"),
    @NamedQuery(name = "Userbase.findById", query = "SELECT u FROM Userbase u WHERE u.id = :id"),
    @NamedQuery(name = "Userbase.findByDisplayname", query = "SELECT u FROM Userbase u WHERE u.displayname = :displayname"),
    @NamedQuery(name = "Userbase.findByEmail", query = "SELECT u FROM Userbase u WHERE u.email = :email"),
    @NamedQuery(name = "Userbase.findByPassword", query = "SELECT u FROM Userbase u WHERE u.password = :password"),
    @NamedQuery(name = "Userbase.findByAddress", query = "SELECT u FROM Userbase u WHERE u.address = :address"),
    @NamedQuery(name = "Userbase.findByCity", query = "SELECT u FROM Userbase u WHERE u.city = :city"),
    @NamedQuery(name = "Userbase.findByZipcode", query = "SELECT u FROM Userbase u WHERE u.zipcode = :zipcode"),
    @NamedQuery(name = "Userbase.findByCreatedby", query = "SELECT u FROM Userbase u WHERE u.createdby = :createdby"),
    @NamedQuery(name = "Userbase.findByCreatedon", query = "SELECT u FROM Userbase u WHERE u.createdon = :createdon"),
    @NamedQuery(name = "Userbase.findByModifiedby", query = "SELECT u FROM Userbase u WHERE u.modifiedby = :modifiedby"),
    @NamedQuery(name = "Userbase.findByModifiedon", query = "SELECT u FROM Userbase u WHERE u.modifiedon = :modifiedon")})
public class Userbase implements Serializable {
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
    @Column(name = "DISPLAYNAME")
    private String displayname;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "ADDRESS")
    private String address;
    @Size(max = 50)
    @Column(name = "CITY")
    private String city;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ZIPCODE")
    private String zipcode;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userid")
    private Collection<Transactioninfo> transactioninfoCollection;
    @OneToMany(mappedBy = "userid")
    private Collection<Attractionvisited> attractionvisitedCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "userbase")
    private Useremployee useremployee;
    @OneToMany(mappedBy = "userid")
    private Collection<Discussionthreadcomment> discussionthreadcommentCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "userbase")
    private Userpaymentinfo userpaymentinfo;
    @OneToMany(mappedBy = "userid")
    private Collection<Discussionthread> discussionthreadCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userid")
    private Collection<Comments> commentsCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "userbase")
    private Userwebsite userwebsite;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userid")
    private Collection<Attractionreview> attractionreviewCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userid")
    private Collection<Userphones> userphonesCollection;
    @OneToMany(mappedBy = "userid")
    private Collection<Likes> likesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userid")
    private Collection<Activitylog> activitylogCollection;

    public Userbase() {
    }

    public Userbase(BigDecimal id) {
        this.id = id;
    }

    public Userbase(BigDecimal id, String displayname, String email, String password, String address, String zipcode, BigInteger createdby, Date createdon, BigInteger modifiedby, Date modifiedon) {
        this.id = id;
        this.displayname = displayname;
        this.email = email;
        this.password = password;
        this.address = address;
        this.zipcode = zipcode;
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

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
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

    @XmlTransient
    public Collection<Transactioninfo> getTransactioninfoCollection() {
        return transactioninfoCollection;
    }

    public void setTransactioninfoCollection(Collection<Transactioninfo> transactioninfoCollection) {
        this.transactioninfoCollection = transactioninfoCollection;
    }

    @XmlTransient
    public Collection<Attractionvisited> getAttractionvisitedCollection() {
        return attractionvisitedCollection;
    }

    public void setAttractionvisitedCollection(Collection<Attractionvisited> attractionvisitedCollection) {
        this.attractionvisitedCollection = attractionvisitedCollection;
    }

    public Useremployee getUseremployee() {
        return useremployee;
    }

    public void setUseremployee(Useremployee useremployee) {
        this.useremployee = useremployee;
    }

    @XmlTransient
    public Collection<Discussionthreadcomment> getDiscussionthreadcommentCollection() {
        return discussionthreadcommentCollection;
    }

    public void setDiscussionthreadcommentCollection(Collection<Discussionthreadcomment> discussionthreadcommentCollection) {
        this.discussionthreadcommentCollection = discussionthreadcommentCollection;
    }

    public Userpaymentinfo getUserpaymentinfo() {
        return userpaymentinfo;
    }

    public void setUserpaymentinfo(Userpaymentinfo userpaymentinfo) {
        this.userpaymentinfo = userpaymentinfo;
    }

    @XmlTransient
    public Collection<Discussionthread> getDiscussionthreadCollection() {
        return discussionthreadCollection;
    }

    public void setDiscussionthreadCollection(Collection<Discussionthread> discussionthreadCollection) {
        this.discussionthreadCollection = discussionthreadCollection;
    }

    @XmlTransient
    public Collection<Comments> getCommentsCollection() {
        return commentsCollection;
    }

    public void setCommentsCollection(Collection<Comments> commentsCollection) {
        this.commentsCollection = commentsCollection;
    }

    public Userwebsite getUserwebsite() {
        return userwebsite;
    }

    public void setUserwebsite(Userwebsite userwebsite) {
        this.userwebsite = userwebsite;
    }

    @XmlTransient
    public Collection<Attractionreview> getAttractionreviewCollection() {
        return attractionreviewCollection;
    }

    public void setAttractionreviewCollection(Collection<Attractionreview> attractionreviewCollection) {
        this.attractionreviewCollection = attractionreviewCollection;
    }

    @XmlTransient
    public Collection<Userphones> getUserphonesCollection() {
        return userphonesCollection;
    }

    public void setUserphonesCollection(Collection<Userphones> userphonesCollection) {
        this.userphonesCollection = userphonesCollection;
    }

    @XmlTransient
    public Collection<Likes> getLikesCollection() {
        return likesCollection;
    }

    public void setLikesCollection(Collection<Likes> likesCollection) {
        this.likesCollection = likesCollection;
    }

    @XmlTransient
    public Collection<Activitylog> getActivitylogCollection() {
        return activitylogCollection;
    }

    public void setActivitylogCollection(Collection<Activitylog> activitylogCollection) {
        this.activitylogCollection = activitylogCollection;
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
        if (!(object instanceof Userbase)) {
            return false;
        }
        Userbase other = (Userbase) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.chooseadventure.entity.Userbase[ id=" + id + " ]";
    }
    
}
