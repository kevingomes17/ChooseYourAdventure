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
@Table(name = "ATTRACTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Attraction.findAll", query = "SELECT a FROM Attraction a"),
    @NamedQuery(name = "Attraction.findById", query = "SELECT a FROM Attraction a WHERE a.id = :id"),
    @NamedQuery(name = "Attraction.findByCode", query = "SELECT a FROM Attraction a WHERE a.code = :code"),
    @NamedQuery(name = "Attraction.findByName", query = "SELECT a FROM Attraction a WHERE a.name = :name"),
    @NamedQuery(name = "Attraction.findByAddress", query = "SELECT a FROM Attraction a WHERE a.address = :address"),
    @NamedQuery(name = "Attraction.findByDescription", query = "SELECT a FROM Attraction a WHERE a.description = :description"),
    @NamedQuery(name = "Attraction.findByDefaultNoTickets", query = "SELECT a FROM Attraction a WHERE a.defaultNoTickets = :defaultNoTickets"),
    @NamedQuery(name = "Attraction.findByTimings", query = "SELECT a FROM Attraction a WHERE a.timings = :timings"),
    @NamedQuery(name = "Attraction.findByCommission", query = "SELECT a FROM Attraction a WHERE a.commission = :commission"),
    @NamedQuery(name = "Attraction.findByCostperticket", query = "SELECT a FROM Attraction a WHERE a.costperticket = :costperticket"),
    @NamedQuery(name = "Attraction.findByCreatedby", query = "SELECT a FROM Attraction a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "Attraction.findByCreatedon", query = "SELECT a FROM Attraction a WHERE a.createdon = :createdon"),
    @NamedQuery(name = "Attraction.findByModifiedby", query = "SELECT a FROM Attraction a WHERE a.modifiedby = :modifiedby"),
    @NamedQuery(name = "Attraction.findByModifiedon", query = "SELECT a FROM Attraction a WHERE a.modifiedon = :modifiedon")})
public class Attraction implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CODE")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NAME")
    private String name;
    @Size(max = 70)
    @Column(name = "ADDRESS")
    private String address;
    @Size(max = 2000)
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DEFAULT_NO_TICKETS")
    private BigInteger defaultNoTickets;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "TIMINGS")
    private String timings;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COMMISSION")
    private BigDecimal commission;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COSTPERTICKET")
    private BigDecimal costperticket;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATEDBY")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdby;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATEDON")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdon;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MODIFIEDBY")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedby;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MODIFIEDON")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedon;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "attraction")
    private Collection<Discussiontopicbyattraction> discussiontopicbyattractionCollection;
    @OneToMany(mappedBy = "attractionid")
    private Collection<Attractionvisited> attractionvisitedCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "attraction")
    private Collection<Packageattraction> packageattractionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "attractionid")
    private Collection<Ticketsavailable> ticketsavailableCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "attraction")
    private Collection<Attractionemployee> attractionemployeeCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "attraction")
    private Attractionmanagement attractionmanagement;
    @JoinColumn(name = "DIRECTORID", referencedColumnName = "USERID")
    @ManyToOne
    private Useremployee directorid;
    @JoinColumn(name = "COMPANYID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Company companyid;
    @JoinColumn(name = "CITYID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private City cityid;
    @JoinColumn(name = "ATTRACTIONTYPEID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Attractiontype attractiontypeid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "attractionid")
    private Collection<Attractionreview> attractionreviewCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "attractionid")
    private Collection<Transactionattraction> transactionattractionCollection;

    public Attraction() {
    }

    public Attraction(BigDecimal id) {
        this.id = id;
    }

    public Attraction(BigDecimal id, String code, String name, BigInteger defaultNoTickets, String timings, BigDecimal commission, BigDecimal costperticket, Date createdby, Date createdon, Date modifiedby, Date modifiedon) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.defaultNoTickets = defaultNoTickets;
        this.timings = timings;
        this.commission = commission;
        this.costperticket = costperticket;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigInteger getDefaultNoTickets() {
        return defaultNoTickets;
    }

    public void setDefaultNoTickets(BigInteger defaultNoTickets) {
        this.defaultNoTickets = defaultNoTickets;
    }

    public String getTimings() {
        return timings;
    }

    public void setTimings(String timings) {
        this.timings = timings;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public BigDecimal getCostperticket() {
        return costperticket;
    }

    public void setCostperticket(BigDecimal costperticket) {
        this.costperticket = costperticket;
    }

    public Date getCreatedby() {
        return createdby;
    }

    public void setCreatedby(Date createdby) {
        this.createdby = createdby;
    }

    public Date getCreatedon() {
        return createdon;
    }

    public void setCreatedon(Date createdon) {
        this.createdon = createdon;
    }

    public Date getModifiedby() {
        return modifiedby;
    }

    public void setModifiedby(Date modifiedby) {
        this.modifiedby = modifiedby;
    }

    public Date getModifiedon() {
        return modifiedon;
    }

    public void setModifiedon(Date modifiedon) {
        this.modifiedon = modifiedon;
    }

    @XmlTransient
    public Collection<Discussiontopicbyattraction> getDiscussiontopicbyattractionCollection() {
        return discussiontopicbyattractionCollection;
    }

    public void setDiscussiontopicbyattractionCollection(Collection<Discussiontopicbyattraction> discussiontopicbyattractionCollection) {
        this.discussiontopicbyattractionCollection = discussiontopicbyattractionCollection;
    }

    @XmlTransient
    public Collection<Attractionvisited> getAttractionvisitedCollection() {
        return attractionvisitedCollection;
    }

    public void setAttractionvisitedCollection(Collection<Attractionvisited> attractionvisitedCollection) {
        this.attractionvisitedCollection = attractionvisitedCollection;
    }

    @XmlTransient
    public Collection<Packageattraction> getPackageattractionCollection() {
        return packageattractionCollection;
    }

    public void setPackageattractionCollection(Collection<Packageattraction> packageattractionCollection) {
        this.packageattractionCollection = packageattractionCollection;
    }

    @XmlTransient
    public Collection<Ticketsavailable> getTicketsavailableCollection() {
        return ticketsavailableCollection;
    }

    public void setTicketsavailableCollection(Collection<Ticketsavailable> ticketsavailableCollection) {
        this.ticketsavailableCollection = ticketsavailableCollection;
    }

    @XmlTransient
    public Collection<Attractionemployee> getAttractionemployeeCollection() {
        return attractionemployeeCollection;
    }

    public void setAttractionemployeeCollection(Collection<Attractionemployee> attractionemployeeCollection) {
        this.attractionemployeeCollection = attractionemployeeCollection;
    }

    public Attractionmanagement getAttractionmanagement() {
        return attractionmanagement;
    }

    public void setAttractionmanagement(Attractionmanagement attractionmanagement) {
        this.attractionmanagement = attractionmanagement;
    }

    public Useremployee getDirectorid() {
        return directorid;
    }

    public void setDirectorid(Useremployee directorid) {
        this.directorid = directorid;
    }

    public Company getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Company companyid) {
        this.companyid = companyid;
    }

    public City getCityid() {
        return cityid;
    }

    public void setCityid(City cityid) {
        this.cityid = cityid;
    }

    public Attractiontype getAttractiontypeid() {
        return attractiontypeid;
    }

    public void setAttractiontypeid(Attractiontype attractiontypeid) {
        this.attractiontypeid = attractiontypeid;
    }

    @XmlTransient
    public Collection<Attractionreview> getAttractionreviewCollection() {
        return attractionreviewCollection;
    }

    public void setAttractionreviewCollection(Collection<Attractionreview> attractionreviewCollection) {
        this.attractionreviewCollection = attractionreviewCollection;
    }

    @XmlTransient
    public Collection<Transactionattraction> getTransactionattractionCollection() {
        return transactionattractionCollection;
    }

    public void setTransactionattractionCollection(Collection<Transactionattraction> transactionattractionCollection) {
        this.transactionattractionCollection = transactionattractionCollection;
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
        if (!(object instanceof Attraction)) {
            return false;
        }
        Attraction other = (Attraction) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.chooseadventure.entity.Attraction[ id=" + id + " ]";
    }
    
}
