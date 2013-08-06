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
@Table(name = "comunas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comunas.findAll", query = "SELECT c FROM Comunas c"),
    @NamedQuery(name = "Comunas.findByNumCom", query = "SELECT c FROM Comunas c WHERE c.numCom = :numCom")})
public class Comunas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "num_com")
    private String numCom;
    @ManyToMany(mappedBy = "comunasList")
    private List<Ciudades> ciudadesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numCom")
    private List<Barrios> barriosList;
    @JoinColumn(name = "cod_ciu", referencedColumnName = "cod_ciu")
    @ManyToOne(optional = false)
    private Ciudades codCiu;

    public Comunas() {
    }

    public Comunas(String numCom) {
        this.numCom = numCom;
    }

    public String getNumCom() {
        return numCom;
    }

    public void setNumCom(String numCom) {
        this.numCom = numCom;
    }

    @XmlTransient
    public List<Ciudades> getCiudadesList() {
        return ciudadesList;
    }

    public void setCiudadesList(List<Ciudades> ciudadesList) {
        this.ciudadesList = ciudadesList;
    }

    @XmlTransient
    public List<Barrios> getBarriosList() {
        return barriosList;
    }

    public void setBarriosList(List<Barrios> barriosList) {
        this.barriosList = barriosList;
    }

    public Ciudades getCodCiu() {
        return codCiu;
    }

    public void setCodCiu(Ciudades codCiu) {
        this.codCiu = codCiu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numCom != null ? numCom.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comunas)) {
            return false;
        }
        Comunas other = (Comunas) object;
        if ((this.numCom == null && other.numCom != null) || (this.numCom != null && !this.numCom.equals(other.numCom))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Comunas[ numCom=" + numCom + " ]";
    }
    
}
