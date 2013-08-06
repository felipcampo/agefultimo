/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "ips")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ips.findAll", query = "SELECT i FROM Ips i"),
    @NamedQuery(name = "Ips.findByCodIps", query = "SELECT i FROM Ips i WHERE i.codIps = :codIps"),
    @NamedQuery(name = "Ips.findByNomIps", query = "SELECT i FROM Ips i WHERE i.nomIps = :nomIps")})
public class Ips implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_ips")
    private Integer codIps;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "nom_ips")
    private String nomIps;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codIps")
    private List<MatrizCaracterizacion> matrizCaracterizacionList;

    public Ips() {
    }

    public Ips(Integer codIps) {
        this.codIps = codIps;
    }

    public Ips(Integer codIps, String nomIps) {
        this.codIps = codIps;
        this.nomIps = nomIps;
    }

    public Integer getCodIps() {
        return codIps;
    }

    public void setCodIps(Integer codIps) {
        this.codIps = codIps;
    }

    public String getNomIps() {
        return nomIps;
    }

    public void setNomIps(String nomIps) {
        this.nomIps = nomIps;
    }

    @XmlTransient
    public List<MatrizCaracterizacion> getMatrizCaracterizacionList() {
        return matrizCaracterizacionList;
    }

    public void setMatrizCaracterizacionList(List<MatrizCaracterizacion> matrizCaracterizacionList) {
        this.matrizCaracterizacionList = matrizCaracterizacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codIps != null ? codIps.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ips)) {
            return false;
        }
        Ips other = (Ips) object;
        if ((this.codIps == null && other.codIps != null) || (this.codIps != null && !this.codIps.equals(other.codIps))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Ips[ codIps=" + codIps + " ]";
    }
    
}
