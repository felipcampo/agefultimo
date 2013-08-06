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
@Table(name = "evaluacion_criterios_seguimiento_instructores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EvaluacionCriteriosSeguimientoInstructores.findAll", query = "SELECT e FROM EvaluacionCriteriosSeguimientoInstructores e"),
    @NamedQuery(name = "EvaluacionCriteriosSeguimientoInstructores.findByCodEvaCriIns", query = "SELECT e FROM EvaluacionCriteriosSeguimientoInstructores e WHERE e.codEvaCriIns = :codEvaCriIns"),
    @NamedQuery(name = "EvaluacionCriteriosSeguimientoInstructores.findByNomEvaCriIns", query = "SELECT e FROM EvaluacionCriteriosSeguimientoInstructores e WHERE e.nomEvaCriIns = :nomEvaCriIns")})
public class EvaluacionCriteriosSeguimientoInstructores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "cod_eva_cri_ins")
    private String codEvaCriIns;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nom_eva_cri_ins")
    private String nomEvaCriIns;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codEvaCriIns")
    private List<CriteriosSeguimientoInstructores> criteriosSeguimientoInstructoresList;

    public EvaluacionCriteriosSeguimientoInstructores() {
    }

    public EvaluacionCriteriosSeguimientoInstructores(String codEvaCriIns) {
        this.codEvaCriIns = codEvaCriIns;
    }

    public EvaluacionCriteriosSeguimientoInstructores(String codEvaCriIns, String nomEvaCriIns) {
        this.codEvaCriIns = codEvaCriIns;
        this.nomEvaCriIns = nomEvaCriIns;
    }

    public String getCodEvaCriIns() {
        return codEvaCriIns;
    }

    public void setCodEvaCriIns(String codEvaCriIns) {
        this.codEvaCriIns = codEvaCriIns;
    }

    public String getNomEvaCriIns() {
        return nomEvaCriIns;
    }

    public void setNomEvaCriIns(String nomEvaCriIns) {
        this.nomEvaCriIns = nomEvaCriIns;
    }

    @XmlTransient
    public List<CriteriosSeguimientoInstructores> getCriteriosSeguimientoInstructoresList() {
        return criteriosSeguimientoInstructoresList;
    }

    public void setCriteriosSeguimientoInstructoresList(List<CriteriosSeguimientoInstructores> criteriosSeguimientoInstructoresList) {
        this.criteriosSeguimientoInstructoresList = criteriosSeguimientoInstructoresList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEvaCriIns != null ? codEvaCriIns.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaluacionCriteriosSeguimientoInstructores)) {
            return false;
        }
        EvaluacionCriteriosSeguimientoInstructores other = (EvaluacionCriteriosSeguimientoInstructores) object;
        if ((this.codEvaCriIns == null && other.codEvaCriIns != null) || (this.codEvaCriIns != null && !this.codEvaCriIns.equals(other.codEvaCriIns))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.EvaluacionCriteriosSeguimientoInstructores[ codEvaCriIns=" + codEvaCriIns + " ]";
    }
    
}
