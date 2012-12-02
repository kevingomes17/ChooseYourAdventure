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
@Table(name = "DISCUSSIONTOPICBYATTRACTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Discussiontopicbyattraction.findAll", query = "SELECT d FROM Discussiontopicbyattraction d"),
    @NamedQuery(name = "Discussiontopicbyattraction.findByAttractionid", query = "SELECT d FROM Discussiontopicbyattraction d WHERE d.discussiontopicbyattractionPK.attractionid = :attractionid"),
    @NamedQuery(name = "Discussiontopicbyattraction.findByDiscussiontopicid", query = "SELECT d FROM Discussiontopicbyattraction d WHERE d.discussiontopicbyattractionPK.discussiontopicid = :discussiontopicid"),
    @NamedQuery(name = "Discussiontopicbyattraction.findByCreatedby", query = "SELECT d FROM Discussiontopicbyattraction d WHERE d.createdby = :createdby"),
    @NamedQuery(name = "Discussiontopicbyattraction.findByCreatedon", query = "SELECT d FROM Discussiontopicbyattraction d WHERE d.createdon = :createdon"),
    @NamedQuery(name = "Discussiontopicbyattraction.findByModifiedby", query = "SELECT d FROM Discussiontopicbyattraction d WHERE d.modifiedby = :modifiedby"),
    @NamedQuery(name = "Discussiontopicbyattraction.findByModifiedon", query = "SELECT d FROM Discussiontopicbyattraction d WHERE d.modifiedon = :modifiedon")})
public class Discussiontopicbyattraction implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DiscussiontopicbyattractionPK discussiontopicbyattractionPK;
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
    @JoinColumn(name = "ATTRACTIONID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Attraction attraction;

    public Discussiontopicbyattraction() {
    }

    public Discussiontopicbyattraction(DiscussiontopicbyattractionPK discussiontopicbyattractionPK) {
        this.discussiontopicbyattractionPK = discussiontopicbyattractionPK;
    }

    public Discussiontopicbyattraction(DiscussiontopicbyattractionPK discussiontopicbyattractionPK, BigInteger createdby, Date createdon, BigInteger modifiedby, Date modifiedon) {
        this.discussiontopicbyattractionPK = discussiontopicbyattractionPK;
        this.createdby = createdby;
        this.createdon = createdon;
        this.modifiedby = modifiedby;
        this.modifiedon = modifiedon;
    }

    public Discussiontopicbyattraction(BigInteger attractionid, BigInteger discussiontopicid) {
        this.discussiontopicbyattractionPK = new DiscussiontopicbyattractionPK(attractionid, discussiontopicid);
    }

    public DiscussiontopicbyattractionPK getDiscussiontopicbyattractionPK() {
        return discussiontopicbyattractionPK;
    }

    public void setDiscussiontopicbyattractionPK(DiscussiontopicbyattractionPK discussiontopicbyattractionPK) {
        this.discussiontopicbyattractionPK = discussiontopicbyattractionPK;
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

    public Attraction getAttraction() {
        return attraction;
    }

    public void setAttraction(Attraction attraction) {
        this.attraction = attraction;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (discussiontopicbyattractionPK != null ? discussiontopicbyattractionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Discussiontopicbyattraction)) {
            return false;
        }
        Discussiontopicbyattraction other = (Discussiontopicbyattraction) object;
        if ((this.discussiontopicbyattractionPK == null && other.discussiontopicbyattractionPK != null) || (this.discussiontopicbyattractionPK != null && !this.discussiontopicbyattractionPK.equals(other.discussiontopicbyattractionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.chooseadventure.entity.Discussiontopicbyattraction[ discussiontopicbyattractionPK=" + discussiontopicbyattractionPK + " ]";
    }
    
}
