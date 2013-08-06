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
@Table(name = "aportantes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aportantes.findAll", query = "SELECT a FROM Aportantes a"),
    @NamedQuery(name = "Aportantes.findByCodApo", query = "SELECT a FROM Aportantes a WHERE a.codApo = :codApo"),
    @NamedQuery(name = "Aportantes.findByNomApo", query = "SELECT a FROM Aportantes a WHERE a.nomApo = :nomApo")})
public class Aportantes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_apo")
    private Integer codApo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nom_apo")
    private String nomApo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codApo")
    private List<MatrizCaracterizacion> matrizCaracterizacionList;

    public Aportantes() {
    }

    public Aportantes(Integer codApo) {
        this.codApo = codApo;
    }

    public Aportantes(Integer codApo, String nomApo) {
        this.codApo = codApo;
        this.nomApo = nomApo;
    }

    public Integer getCodApo() {
        return codApo;
    }

    public void setCodApo(Integer codApo) {
        this.codApo = codApo;
    }

    public String getNomApo() {
        return nomApo;
    }

    public void setNomApo(String nomApo) {
        this.nomApo = nomApo;
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
        hash += (codApo != null ? codApo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aportantes)) {
            return false;
        }
        Aportantes other = (Aportantes) object;
        if ((this.codApo == null && other.codApo != null) || (this.codApo != null && !this.codApo.equals(other.codApo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Aportantes[ codApo=" + codApo + " ]";
    }
    
}
