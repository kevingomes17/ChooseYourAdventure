/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.chooseadventure.entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author kevingomes17
 */
@Embeddable
public class DiscussiontopicbyattractionPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ATTRACTIONID")
    private BigInteger attractionid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DISCUSSIONTOPICID")
    private BigInteger discussiontopicid;

    public DiscussiontopicbyattractionPK() {
    }

    public DiscussiontopicbyattractionPK(BigInteger attractionid, BigInteger discussiontopicid) {
        this.attractionid = attractionid;
        this.discussiontopicid = discussiontopicid;
    }

    public BigInteger getAttractionid() {
        return attractionid;
    }

    public void setAttractionid(BigInteger attractionid) {
        this.attractionid = attractionid;
    }

    public BigInteger getDiscussiontopicid() {
        return discussiontopicid;
    }

    public void setDiscussiontopicid(BigInteger discussiontopicid) {
        this.discussiontopicid = discussiontopicid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (attractionid != null ? attractionid.hashCode() : 0);
        hash += (discussiontopicid != null ? discussiontopicid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiscussiontopicbyattractionPK)) {
            return false;
        }
        DiscussiontopicbyattractionPK other = (DiscussiontopicbyattractionPK) object;
        if ((this.attractionid == null && other.attractionid != null) || (this.attractionid != null && !this.attractionid.equals(other.attractionid))) {
            return false;
        }
        if ((this.discussiontopicid == null && other.discussiontopicid != null) || (this.discussiontopicid != null && !this.discussiontopicid.equals(other.discussiontopicid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.chooseadventure.entity.DiscussiontopicbyattractionPK[ attractionid=" + attractionid + ", discussiontopicid=" + discussiontopicid + " ]";
    }
    
}
