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
@Table(name = "DISCUSSIONTOPICBYCITY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Discussiontopicbycity.findAll", query = "SELECT d FROM Discussiontopicbycity d"),
    @NamedQuery(name = "Discussiontopicbycity.findByCityid", query = "SELECT d FROM Discussiontopicbycity d WHERE d.discussiontopicbycityPK.cityid = :cityid"),
    @NamedQuery(name = "Discussiontopicbycity.findByDiscussiontopicid", query = "SELECT d FROM Discussiontopicbycity d WHERE d.discussiontopicbycityPK.discussiontopicid = :discussiontopicid"),
    @NamedQuery(name = "Discussiontopicbycity.findByCreatedby", query = "SELECT d FROM Discussiontopicbycity d WHERE d.createdby = :createdby"),
    @NamedQuery(name = "Discussiontopicbycity.findByCreatedon", query = "SELECT d FROM Discussiontopicbycity d WHERE d.createdon = :createdon"),
    @NamedQuery(name = "Discussiontopicbycity.findByModifiedby", query = "SELECT d FROM Discussiontopicbycity d WHERE d.modifiedby = :modifiedby"),
    @NamedQuery(name = "Discussiontopicbycity.findByModifiedon", query = "SELECT d FROM Discussiontopicbycity d WHERE d.modifiedon = :modifiedon")})
public class Discussiontopicbycity implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DiscussiontopicbycityPK discussiontopicbycityPK;
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
    @JoinColumn(name = "DISCUSSIONTOPICID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Discussiontopic discussiontopic;
    @JoinColumn(name = "CITYID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private City city;

    public Discussiontopicbycity() {
    }

    public Discussiontopicbycity(DiscussiontopicbycityPK discussiontopicbycityPK) {
        this.discussiontopicbycityPK = discussiontopicbycityPK;
    }

    public Discussiontopicbycity(DiscussiontopicbycityPK discussiontopicbycityPK, BigInteger createdby, Date createdon, BigInteger modifiedby, Date modifiedon) {
        this.discussiontopicbycityPK = discussiontopicbycityPK;
        this.createdby = createdby;
        this.createdon = createdon;
        this.modifiedby = modifiedby;
        this.modifiedon = modifiedon;
    }

    public Discussiontopicbycity(BigInteger cityid, BigInteger discussiontopicid) {
        this.discussiontopicbycityPK = new DiscussiontopicbycityPK(cityid, discussiontopicid);
    }

    public DiscussiontopicbycityPK getDiscussiontopicbycityPK() {
        return discussiontopicbycityPK;
    }

    public void setDiscussiontopicbycityPK(DiscussiontopicbycityPK discussiontopicbycityPK) {
        this.discussiontopicbycityPK = discussiontopicbycityPK;
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

    public Discussiontopic getDiscussiontopic() {
        return discussiontopic;
    }

    public void setDiscussiontopic(Discussiontopic discussiontopic) {
        this.discussiontopic = discussiontopic;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (discussiontopicbycityPK != null ? discussiontopicbycityPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Discussiontopicbycity)) {
            return false;
        }
        Discussiontopicbycity other = (Discussiontopicbycity) object;
        if ((this.discussiontopicbycityPK == null && other.discussiontopicbycityPK != null) || (this.discussiontopicbycityPK != null && !this.discussiontopicbycityPK.equals(other.discussiontopicbycityPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.chooseadventure.entity.Discussiontopicbycity[ discussiontopicbycityPK=" + discussiontopicbycityPK + " ]";
    }
    
}
