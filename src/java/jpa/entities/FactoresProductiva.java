/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "factores_productiva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FactoresProductiva.findAll", query = "SELECT f FROM FactoresProductiva f"),
    @NamedQuery(name = "FactoresProductiva.findByIdFep", query = "SELECT f FROM FactoresProductiva f WHERE f.idFep = :idFep"),
    @NamedQuery(name = "FactoresProductiva.findByNomFed", query = "SELECT f FROM FactoresProductiva f WHERE f.nomFed = :nomFed")})
public class FactoresProductiva implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id_fep")
    private String idFep;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nom_fed")
    private String nomFed;
    @OneToMany(mappedBy = "idFep")
    private List<CriteriosEvaluacion> criteriosEvaluacionList;

    public FactoresProductiva() {
    }

    public FactoresProductiva(String idFep) {
        this.idFep = idFep;
    }

    public FactoresProductiva(String idFep, String nomFed) {
        this.idFep = idFep;
        this.nomFed = nomFed;
    }

    public String getIdFep() {
        return idFep;
    }

    public void setIdFep(String idFep) {
        this.idFep = idFep;
    }

    public String getNomFed() {
        return nomFed;
    }

    public void setNomFed(String nomFed) {
        this.nomFed = nomFed;
    }

    @XmlTransient
    public List<CriteriosEvaluacion> getCriteriosEvaluacionList() {
        return criteriosEvaluacionList;
    }

    public void setCriteriosEvaluacionList(List<CriteriosEvaluacion> criteriosEvaluacionList) {
        this.criteriosEvaluacionList = criteriosEvaluacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFep != null ? idFep.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FactoresProductiva)) {
            return false;
        }
        FactoresProductiva other = (FactoresProductiva) object;
        if ((this.idFep == null && other.idFep != null) || (this.idFep != null && !this.idFep.equals(other.idFep))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.FactoresProductiva[ idFep=" + idFep + " ]";
    }
    
}
