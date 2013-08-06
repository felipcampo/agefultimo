/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "criterios_seguimiento_proyectos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CriteriosSeguimientoProyectos.findAll", query = "SELECT c FROM CriteriosSeguimientoProyectos c"),
    @NamedQuery(name = "CriteriosSeguimientoProyectos.findByCodCri", query = "SELECT c FROM CriteriosSeguimientoProyectos c WHERE c.criteriosSeguimientoProyectosPK.codCri = :codCri"),
    @NamedQuery(name = "CriteriosSeguimientoProyectos.findByCodSeg", query = "SELECT c FROM CriteriosSeguimientoProyectos c WHERE c.criteriosSeguimientoProyectosPK.codSeg = :codSeg")})
public class CriteriosSeguimientoProyectos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CriteriosSeguimientoProyectosPK criteriosSeguimientoProyectosPK;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "obs_cri_seg")
    private String obsCriSeg;
    @JoinColumn(name = "cod_seg", referencedColumnName = "cod_seg", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SeguimientoProyectos seguimientoProyectos;
    @JoinColumn(name = "cod_eva_cri", referencedColumnName = "cod_eva_cri")
    @ManyToOne(optional = false)
    private EvaluacionesCriteriosSeguimientoProyectos codEvaCri;
    @JoinColumn(name = "cod_cri", referencedColumnName = "cod_cri", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CriteriosEvaluacion criteriosEvaluacion;

    public CriteriosSeguimientoProyectos() {
    }

    public CriteriosSeguimientoProyectos(CriteriosSeguimientoProyectosPK criteriosSeguimientoProyectosPK) {
        this.criteriosSeguimientoProyectosPK = criteriosSeguimientoProyectosPK;
    }

    public CriteriosSeguimientoProyectos(CriteriosSeguimientoProyectosPK criteriosSeguimientoProyectosPK, String obsCriSeg) {
        this.criteriosSeguimientoProyectosPK = criteriosSeguimientoProyectosPK;
        this.obsCriSeg = obsCriSeg;
    }

    public CriteriosSeguimientoProyectos(String codCri, String codSeg) {
        this.criteriosSeguimientoProyectosPK = new CriteriosSeguimientoProyectosPK(codCri, codSeg);
    }

    public CriteriosSeguimientoProyectosPK getCriteriosSeguimientoProyectosPK() {
        return criteriosSeguimientoProyectosPK;
    }

    public void setCriteriosSeguimientoProyectosPK(CriteriosSeguimientoProyectosPK criteriosSeguimientoProyectosPK) {
        this.criteriosSeguimientoProyectosPK = criteriosSeguimientoProyectosPK;
    }

    public String getObsCriSeg() {
        return obsCriSeg;
    }

    public void setObsCriSeg(String obsCriSeg) {
        this.obsCriSeg = obsCriSeg;
    }

    public SeguimientoProyectos getSeguimientoProyectos() {
        return seguimientoProyectos;
    }

    public void setSeguimientoProyectos(SeguimientoProyectos seguimientoProyectos) {
        this.seguimientoProyectos = seguimientoProyectos;
    }

    public EvaluacionesCriteriosSeguimientoProyectos getCodEvaCri() {
        return codEvaCri;
    }

    public void setCodEvaCri(EvaluacionesCriteriosSeguimientoProyectos codEvaCri) {
        this.codEvaCri = codEvaCri;
    }

    public CriteriosEvaluacion getCriteriosEvaluacion() {
        return criteriosEvaluacion;
    }

    public void setCriteriosEvaluacion(CriteriosEvaluacion criteriosEvaluacion) {
        this.criteriosEvaluacion = criteriosEvaluacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (criteriosSeguimientoProyectosPK != null ? criteriosSeguimientoProyectosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CriteriosSeguimientoProyectos)) {
            return false;
        }
        CriteriosSeguimientoProyectos other = (CriteriosSeguimientoProyectos) object;
        if ((this.criteriosSeguimientoProyectosPK == null && other.criteriosSeguimientoProyectosPK != null) || (this.criteriosSeguimientoProyectosPK != null && !this.criteriosSeguimientoProyectosPK.equals(other.criteriosSeguimientoProyectosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.CriteriosSeguimientoProyectos[ criteriosSeguimientoProyectosPK=" + criteriosSeguimientoProyectosPK + " ]";
    }
    
}
