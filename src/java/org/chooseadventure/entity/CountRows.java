/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.chooseadventure.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author kevingomes17
 */
@Entity
public class CountRows implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id    
    private Long count;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (count != null ? count.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CountRows)) {
            return false;
        }
        CountRows other = (CountRows) object;
        if ((this.count == null && other.count != null) || (this.count != null && !this.count.equals(other.count))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.chooseadventure.entity.CountRows[ id=" + count + " ]";
    }
    
}
