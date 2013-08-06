/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "criterios_seguimiento_instructores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CriteriosSeguimientoInstructores.findAll", query = "SELECT c FROM CriteriosSeguimientoInstructores c"),
    @NamedQuery(name = "CriteriosSeguimientoInstructores.findByCodSeg", query = "SELECT c FROM CriteriosSeguimientoInstructores c WHERE c.codSeg = :codSeg")})
public class CriteriosSeguimientoInstructores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_seg")
    private Integer codSeg;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "obs_cri_ins")
    private String obsCriIns;
    @JoinColumn(name = "cod_seg_ins", referencedColumnName = "cod_seg_ins")
    @ManyToOne(optional = false)
    private SeguimientoInstructores codSegIns;
    @JoinColumn(name = "cod_cri", referencedColumnName = "cod_cri")
    @ManyToOne(optional = false)
    private CriteriosEvaluacion codCri;
    @JoinColumn(name = "cod_eva_cri_ins", referencedColumnName = "cod_eva_cri_ins")
    @ManyToOne(optional = false)
    private EvaluacionCriteriosSeguimientoInstructores codEvaCriIns;

    public CriteriosSeguimientoInstructores() {
    }

    public CriteriosSeguimientoInstructores(Integer codSeg) {
        this.codSeg = codSeg;
    }

    public CriteriosSeguimientoInstructores(Integer codSeg, String obsCriIns) {
        this.codSeg = codSeg;
        this.obsCriIns = obsCriIns;
    }

    public Integer getCodSeg() {
        return codSeg;
    }

    public void setCodSeg(Integer codSeg) {
        this.codSeg = codSeg;
    }

    public String getObsCriIns() {
        return obsCriIns;
    }

    public void setObsCriIns(String obsCriIns) {
        this.obsCriIns = obsCriIns;
    }

    public SeguimientoInstructores getCodSegIns() {
        return codSegIns;
    }

    public void setCodSegIns(SeguimientoInstructores codSegIns) {
        this.codSegIns = codSegIns;
    }

    public CriteriosEvaluacion getCodCri() {
        return codCri;
    }

    public void setCodCri(CriteriosEvaluacion codCri) {
        this.codCri = codCri;
    }

    public EvaluacionCriteriosSeguimientoInstructores getCodEvaCriIns() {
        return codEvaCriIns;
    }

    public void setCodEvaCriIns(EvaluacionCriteriosSeguimientoInstructores codEvaCriIns) {
        this.codEvaCriIns = codEvaCriIns;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codSeg != null ? codSeg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CriteriosSeguimientoInstructores)) {
            return false;
        }
        CriteriosSeguimientoInstructores other = (CriteriosSeguimientoInstructores) object;
        if ((this.codSeg == null && other.codSeg != null) || (this.codSeg != null && !this.codSeg.equals(other.codSeg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.CriteriosSeguimientoInstructores[ codSeg=" + codSeg + " ]";
    }
    
}
