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
@Table(name = "ambientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ambientes.findAll", query = "SELECT a FROM Ambientes a"),
    @NamedQuery(name = "Ambientes.findByCodAmb", query = "SELECT a FROM Ambientes a WHERE a.codAmb = :codAmb"),
    @NamedQuery(name = "Ambientes.findByNomAmb", query = "SELECT a FROM Ambientes a WHERE a.nomAmb = :nomAmb")})
public class Ambientes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "cod_amb")
    private String codAmb;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nom_amb")
    private String nomAmb;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codAmb")
    private List<EvidenciasAprendizaje> evidenciasAprendizajeList;

    public Ambientes() {
    }

    public Ambientes(String codAmb) {
        this.codAmb = codAmb;
    }

    public Ambientes(String codAmb, String nomAmb) {
        this.codAmb = codAmb;
        this.nomAmb = nomAmb;
    }

    public String getCodAmb() {
        return codAmb;
    }

    public void setCodAmb(String codAmb) {
        this.codAmb = codAmb;
    }

    public String getNomAmb() {
        return nomAmb;
    }

    public void setNomAmb(String nomAmb) {
        this.nomAmb = nomAmb;
    }

    @XmlTransient
    public List<EvidenciasAprendizaje> getEvidenciasAprendizajeList() {
        return evidenciasAprendizajeList;
    }

    public void setEvidenciasAprendizajeList(List<EvidenciasAprendizaje> evidenciasAprendizajeList) {
        this.evidenciasAprendizajeList = evidenciasAprendizajeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codAmb != null ? codAmb.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ambientes)) {
            return false;
        }
        Ambientes other = (Ambientes) object;
        if ((this.codAmb == null && other.codAmb != null) || (this.codAmb != null && !this.codAmb.equals(other.codAmb))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Ambientes[ codAmb=" + codAmb + " ]";
    }
    
}
