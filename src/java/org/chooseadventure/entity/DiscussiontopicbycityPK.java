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
public class DiscussiontopicbycityPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "CITYID")
    private BigInteger cityid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DISCUSSIONTOPICID")
    private BigInteger discussiontopicid;

    public DiscussiontopicbycityPK() {
    }

    public DiscussiontopicbycityPK(BigInteger cityid, BigInteger discussiontopicid) {
        this.cityid = cityid;
        this.discussiontopicid = discussiontopicid;
    }

    public BigInteger getCityid() {
        return cityid;
    }

    public void setCityid(BigInteger cityid) {
        this.cityid = cityid;
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
        hash += (cityid != null ? cityid.hashCode() : 0);
        hash += (discussiontopicid != null ? discussiontopicid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiscussiontopicbycityPK)) {
            return false;
        }
        DiscussiontopicbycityPK other = (DiscussiontopicbycityPK) object;
        if ((this.cityid == null && other.cityid != null) || (this.cityid != null && !this.cityid.equals(other.cityid))) {
            return false;
        }
        if ((this.discussiontopicid == null && other.discussiontopicid != null) || (this.discussiontopicid != null && !this.discussiontopicid.equals(other.discussiontopicid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.chooseadventure.entity.DiscussiontopicbycityPK[ cityid=" + cityid + ", discussiontopicid=" + discussiontopicid + " ]";
    }
    
}
