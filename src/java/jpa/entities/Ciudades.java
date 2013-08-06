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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "ciudades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciudades.findAll", query = "SELECT c FROM Ciudades c"),
    @NamedQuery(name = "Ciudades.findByCodCiu", query = "SELECT c FROM Ciudades c WHERE c.codCiu = :codCiu"),
    @NamedQuery(name = "Ciudades.findByNomCiu", query = "SELECT c FROM Ciudades c WHERE c.nomCiu = :nomCiu")})
public class Ciudades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "cod_ciu")
    private String codCiu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "nom_ciu")
    private String nomCiu;
    @JoinTable(name = "comunas_ciudades", joinColumns = {
        @JoinColumn(name = "cod_ciu", referencedColumnName = "cod_ciu")}, inverseJoinColumns = {
        @JoinColumn(name = "num_com", referencedColumnName = "num_com")})
    @ManyToMany
    private List<Comunas> comunasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCiu")
    private List<Comunas> comunasList1;
    @JoinColumn(name = "cod_dep", referencedColumnName = "cod_dep")
    @ManyToOne(optional = false)
    private Departamentos codDep;

    public Ciudades() {
    }

    public Ciudades(String codCiu) {
        this.codCiu = codCiu;
    }

    public Ciudades(String codCiu, String nomCiu) {
        this.codCiu = codCiu;
        this.nomCiu = nomCiu;
    }

    public String getCodCiu() {
        return codCiu;
    }

    public void setCodCiu(String codCiu) {
        this.codCiu = codCiu;
    }

    public String getNomCiu() {
        return nomCiu;
    }

    public void setNomCiu(String nomCiu) {
        this.nomCiu = nomCiu;
    }

    @XmlTransient
    public List<Comunas> getComunasList() {
        return comunasList;
    }

    public void setComunasList(List<Comunas> comunasList) {
        this.comunasList = comunasList;
    }

    @XmlTransient
    public List<Comunas> getComunasList1() {
        return comunasList1;
    }

    public void setComunasList1(List<Comunas> comunasList1) {
        this.comunasList1 = comunasList1;
    }

    public Departamentos getCodDep() {
        return codDep;
    }

    public void setCodDep(Departamentos codDep) {
        this.codDep = codDep;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCiu != null ? codCiu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciudades)) {
            return false;
        }
        Ciudades other = (Ciudades) object;
        if ((this.codCiu == null && other.codCiu != null) || (this.codCiu != null && !this.codCiu.equals(other.codCiu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Ciudades[ codCiu=" + codCiu + " ]";
    }
    
}
