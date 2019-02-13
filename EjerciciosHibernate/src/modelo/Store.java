package modelo;
// Generated 13-feb-2019 13:08:20 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Store generated by hbm2java
 */
@Entity
@Table(name="store"
    ,catalog="sakila"
    , uniqueConstraints = @UniqueConstraint(columnNames="manager_staff_id") 
)
public class Store  implements java.io.Serializable {


     private byte storeId;
     private Address address;
     private Staff staff;
     private Date lastUpdate;
     private Set staffs = new HashSet(0);
     private Set customers = new HashSet(0);

    public Store() {
    }

	
    public Store(byte storeId, Address address, Staff staff, Date lastUpdate) {
        this.storeId = storeId;
        this.address = address;
        this.staff = staff;
        this.lastUpdate = lastUpdate;
    }
    public Store(byte storeId, Address address, Staff staff, Date lastUpdate, Set staffs, Set customers) {
       this.storeId = storeId;
       this.address = address;
       this.staff = staff;
       this.lastUpdate = lastUpdate;
       this.staffs = staffs;
       this.customers = customers;
    }
   
     @Id 

    
    @Column(name="store_id", unique=true, nullable=false)
    public byte getStoreId() {
        return this.storeId;
    }
    
    public void setStoreId(byte storeId) {
        this.storeId = storeId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="address_id", nullable=false)
    public Address getAddress() {
        return this.address;
    }
    
    public void setAddress(Address address) {
        this.address = address;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="manager_staff_id", unique=true, nullable=false)
    public Staff getStaff() {
        return this.staff;
    }
    
    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="last_update", nullable=false, length=26)
    public Date getLastUpdate() {
        return this.lastUpdate;
    }
    
    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="store")
    public Set getStaffs() {
        return this.staffs;
    }
    
    public void setStaffs(Set staffs) {
        this.staffs = staffs;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="store")
    public Set getCustomers() {
        return this.customers;
    }
    
    public void setCustomers(Set customers) {
        this.customers = customers;
    }




}


