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
@Table(name = "evaluaciones_criterios_seguimiento_proyectos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EvaluacionesCriteriosSeguimientoProyectos.findAll", query = "SELECT e FROM EvaluacionesCriteriosSeguimientoProyectos e"),
    @NamedQuery(name = "EvaluacionesCriteriosSeguimientoProyectos.findByCodEvaCri", query = "SELECT e FROM EvaluacionesCriteriosSeguimientoProyectos e WHERE e.codEvaCri = :codEvaCri"),
    @NamedQuery(name = "EvaluacionesCriteriosSeguimientoProyectos.findByNomEvaCri", query = "SELECT e FROM EvaluacionesCriteriosSeguimientoProyectos e WHERE e.nomEvaCri = :nomEvaCri")})
public class EvaluacionesCriteriosSeguimientoProyectos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "cod_eva_cri")
    private String codEvaCri;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nom_eva_cri")
    private String nomEvaCri;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codEvaCri")
    private List<CriteriosSeguimientoProyectos> criteriosSeguimientoProyectosList;

    public EvaluacionesCriteriosSeguimientoProyectos() {
    }

    public EvaluacionesCriteriosSeguimientoProyectos(String codEvaCri) {
        this.codEvaCri = codEvaCri;
    }

    public EvaluacionesCriteriosSeguimientoProyectos(String codEvaCri, String nomEvaCri) {
        this.codEvaCri = codEvaCri;
        this.nomEvaCri = nomEvaCri;
    }

    public String getCodEvaCri() {
        return codEvaCri;
    }

    public void setCodEvaCri(String codEvaCri) {
        this.codEvaCri = codEvaCri;
    }

    public String getNomEvaCri() {
        return nomEvaCri;
    }

    public void setNomEvaCri(String nomEvaCri) {
        this.nomEvaCri = nomEvaCri;
    }

    @XmlTransient
    public List<CriteriosSeguimientoProyectos> getCriteriosSeguimientoProyectosList() {
        return criteriosSeguimientoProyectosList;
    }

    public void setCriteriosSeguimientoProyectosList(List<CriteriosSeguimientoProyectos> criteriosSeguimientoProyectosList) {
        this.criteriosSeguimientoProyectosList = criteriosSeguimientoProyectosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEvaCri != null ? codEvaCri.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaluacionesCriteriosSeguimientoProyectos)) {
            return false;
        }
        EvaluacionesCriteriosSeguimientoProyectos other = (EvaluacionesCriteriosSeguimientoProyectos) object;
        if ((this.codEvaCri == null && other.codEvaCri != null) || (this.codEvaCri != null && !this.codEvaCri.equals(other.codEvaCri))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.EvaluacionesCriteriosSeguimientoProyectos[ codEvaCri=" + codEvaCri + " ]";
    }
    
}
