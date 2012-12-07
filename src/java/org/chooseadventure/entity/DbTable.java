/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.chooseadventure.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kevingomes17
 */
@Entity
@Table(name = "all_tables")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DbTable.findAll", query = "SELECT a FROM DbTable a WHERE a.owner like 'KGOMES'")
})
public class DbTable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id    
    @Column(name = "TABLE_NAME")
    private String tableName;
    
    @Column(name = "OWNER")
    private String owner;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tableName != null ? tableName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DbTable)) {
            return false;
        }
        DbTable other = (DbTable) object;
        if ((this.tableName == null && other.tableName != null) || (this.tableName != null && !this.tableName.equals(other.tableName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.chooseadventure.entity.DbTable[ id=" + tableName + " ]";
    }
    
}
