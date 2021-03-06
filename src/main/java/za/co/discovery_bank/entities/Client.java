/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.discovery_bank.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author ayuk
 */
@Entity
@Table(catalog = "spring_discovery", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
    @NamedQuery(name = "Client.findByClientId", query = "SELECT c FROM Client c WHERE c.clientId = :clientId"),
    @NamedQuery(name = "Client.findByTitle", query = "SELECT c FROM Client c WHERE c.title = :title"),
    @NamedQuery(name = "Client.findByName", query = "SELECT c FROM Client c WHERE c.name = :name"),
    @NamedQuery(name = "Client.findBySurname", query = "SELECT c FROM Client c WHERE c.surname = :surname"),
    @NamedQuery(name = "Client.findByDob", query = "SELECT c FROM Client c WHERE c.dob = :dob")})
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CLIENT_ID", nullable = false)
    private Integer clientId;
    @Size(max = 10)
    @Column(length = 10)
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(nullable = false, length = 255)
    private String name;
    @Size(max = 100)
    @Column(length = 100)
    private String surname;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dob;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientId")
    private Collection<ClientAccount> clientAccountCollection;
    @JoinColumn(name = "CLIENT_SUB_TYPE_CODE", referencedColumnName = "CLIENT_SUB_TYPE_CODE", nullable = false)
    @ManyToOne(optional = false)
    private ClientSubType clientSubTypeCode;

    public Client() {
    }

    public Client(Integer clientId) {
        this.clientId = clientId;
    }

    public Client(Integer clientId, String name, Date dob) {
        this.clientId = clientId;
        this.name = name;
        this.dob = dob;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @XmlTransient
    public Collection<ClientAccount> getClientAccountCollection() {
        return clientAccountCollection;
    }

    public void setClientAccountCollection(Collection<ClientAccount> clientAccountCollection) {
        this.clientAccountCollection = clientAccountCollection;
    }

    public ClientSubType getClientSubTypeCode() {
        return clientSubTypeCode;
    }

    public void setClientSubTypeCode(ClientSubType clientSubTypeCode) {
        this.clientSubTypeCode = clientSubTypeCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientId != null ? clientId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.clientId == null && other.clientId != null) || (this.clientId != null && !this.clientId.equals(other.clientId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.co.discovery_bank.entities.Client[ clientId=" + clientId + " ]";
    }
    
}
