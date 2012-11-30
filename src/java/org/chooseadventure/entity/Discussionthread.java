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
@Table(name = "DISCUSSIONTHREAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Discussionthread.findAll", query = "SELECT d FROM Discussionthread d"),
    @NamedQuery(name = "Discussionthread.findById", query = "SELECT d FROM Discussionthread d WHERE d.id = :id"),
    @NamedQuery(name = "Discussionthread.findByTitle", query = "SELECT d FROM Discussionthread d WHERE d.title = :title"),
    @NamedQuery(name = "Discussionthread.findByDescription", query = "SELECT d FROM Discussionthread d WHERE d.description = :description"),
    @NamedQuery(name = "Discussionthread.findByCreatedby", query = "SELECT d FROM Discussionthread d WHERE d.createdby = :createdby"),
    @NamedQuery(name = "Discussionthread.findByCreatedon", query = "SELECT d FROM Discussionthread d WHERE d.createdon = :createdon"),
    @NamedQuery(name = "Discussionthread.findByModifiedby", query = "SELECT d FROM Discussionthread d WHERE d.modifiedby = :modifiedby"),
    @NamedQuery(name = "Discussionthread.findByModifiedon", query = "SELECT d FROM Discussionthread d WHERE d.modifiedon = :modifiedon")})
public class Discussionthread implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 70)
    @Column(name = "TITLE")
    private String title;
    @Size(max = 2000)
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "threadid")
    private Collection<Discussionthreadcomment> discussionthreadcommentCollection;
    @JoinColumn(name = "USERID", referencedColumnName = "ID")
    @ManyToOne
    private Userbase userid;
    @JoinColumn(name = "TOPICID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Discussiontopic topicid;

    public Discussionthread() {
    }

    public Discussionthread(BigDecimal id) {
        this.id = id;
    }

    public Discussionthread(BigDecimal id, BigInteger createdby, Date createdon, BigInteger modifiedby, Date modifiedon) {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    @XmlTransient
    public Collection<Discussionthreadcomment> getDiscussionthreadcommentCollection() {
        return discussionthreadcommentCollection;
    }

    public void setDiscussionthreadcommentCollection(Collection<Discussionthreadcomment> discussionthreadcommentCollection) {
        this.discussionthreadcommentCollection = discussionthreadcommentCollection;
    }

    public Userbase getUserid() {
        return userid;
    }

    public void setUserid(Userbase userid) {
        this.userid = userid;
    }

    public Discussiontopic getTopicid() {
        return topicid;
    }

    public void setTopicid(Discussiontopic topicid) {
        this.topicid = topicid;
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
        if (!(object instanceof Discussionthread)) {
            return false;
        }
        Discussionthread other = (Discussionthread) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.chooseadventure.entity.Discussionthread[ id=" + id + " ]";
    }
    
}
