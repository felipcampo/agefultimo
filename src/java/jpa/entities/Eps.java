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
@Table(name = "eps")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Eps.findAll", query = "SELECT e FROM Eps e"),
    @NamedQuery(name = "Eps.findByCodEps", query = "SELECT e FROM Eps e WHERE e.codEps = :codEps"),
    @NamedQuery(name = "Eps.findByNomEps", query = "SELECT e FROM Eps e WHERE e.nomEps = :nomEps")})
public class Eps implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_eps")
    private Integer codEps;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "nom_eps")
    private String nomEps;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codEps")
    private List<MatrizCaracterizacion> matrizCaracterizacionList;

    public Eps() {
    }

    public Eps(Integer codEps) {
        this.codEps = codEps;
    }

    public Eps(Integer codEps, String nomEps) {
        this.codEps = codEps;
        this.nomEps = nomEps;
    }

    public Integer getCodEps() {
        return codEps;
    }

    public void setCodEps(Integer codEps) {
        this.codEps = codEps;
    }

    public String getNomEps() {
        return nomEps;
    }

    public void setNomEps(String nomEps) {
        this.nomEps = nomEps;
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
        hash += (codEps != null ? codEps.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Eps)) {
            return false;
        }
        Eps other = (Eps) object;
        if ((this.codEps == null && other.codEps != null) || (this.codEps != null && !this.codEps.equals(other.codEps))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Eps[ codEps=" + codEps + " ]";
    }
    
}
