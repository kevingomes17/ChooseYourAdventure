/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.chooseadventure.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kevingomes17
 */
@Entity
@Table(name = "USER_ROLES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserRoles.findAll", query = "SELECT u FROM UserRoles u"),
    @NamedQuery(name = "UserRoles.findByUserIdRoleId", query = "SELECT u FROM UserRoles u WHERE u.userRoleId = :userRoleId AND u.userId = :userId"),
    @NamedQuery(name = "UserRoles.findByUserRoleId", query = "SELECT u FROM UserRoles u WHERE u.userRoleId = :userRoleId"),
    @NamedQuery(name = "UserRoles.findByAuthority", query = "SELECT u FROM UserRoles u WHERE u.authority = :authority")})
public class UserRoles implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "USER_ROLE_ID")
    private BigDecimal userRoleId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "AUTHORITY")
    private String authority;
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private Users userId;

    public UserRoles() {
    }

    public UserRoles(BigDecimal userRoleId) {
        this.userRoleId = userRoleId;
    }

    public UserRoles(BigDecimal userRoleId, String authority) {
        this.userRoleId = userRoleId;
        this.authority = authority;
    }

    public BigDecimal getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(BigDecimal userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userRoleId != null ? userRoleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserRoles)) {
            return false;
        }
        UserRoles other = (UserRoles) object;
        if ((this.userRoleId == null && other.userRoleId != null) || (this.userRoleId != null && !this.userRoleId.equals(other.userRoleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.chooseadventure.entity.UserRoles[ userRoleId=" + userRoleId + " ]";
    }
    
}
