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
@Table(name = "nucleos_familiares")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NucleosFamiliares.findAll", query = "SELECT n FROM NucleosFamiliares n"),
    @NamedQuery(name = "NucleosFamiliares.findByCodNucFam", query = "SELECT n FROM NucleosFamiliares n WHERE n.codNucFam = :codNucFam"),
    @NamedQuery(name = "NucleosFamiliares.findByNomNucFam", query = "SELECT n FROM NucleosFamiliares n WHERE n.nomNucFam = :nomNucFam")})
public class NucleosFamiliares implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_nuc_fam")
    private Integer codNucFam;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "nom_nuc_fam")
    private String nomNucFam;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codNucFam")
    private List<MatrizCaracterizacion> matrizCaracterizacionList;

    public NucleosFamiliares() {
    }

    public NucleosFamiliares(Integer codNucFam) {
        this.codNucFam = codNucFam;
    }

    public NucleosFamiliares(Integer codNucFam, String nomNucFam) {
        this.codNucFam = codNucFam;
        this.nomNucFam = nomNucFam;
    }

    public Integer getCodNucFam() {
        return codNucFam;
    }

    public void setCodNucFam(Integer codNucFam) {
        this.codNucFam = codNucFam;
    }

    public String getNomNucFam() {
        return nomNucFam;
    }

    public void setNomNucFam(String nomNucFam) {
        this.nomNucFam = nomNucFam;
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
        hash += (codNucFam != null ? codNucFam.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NucleosFamiliares)) {
            return false;
        }
        NucleosFamiliares other = (NucleosFamiliares) object;
        if ((this.codNucFam == null && other.codNucFam != null) || (this.codNucFam != null && !this.codNucFam.equals(other.codNucFam))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.NucleosFamiliares[ codNucFam=" + codNucFam + " ]";
    }
    
}
