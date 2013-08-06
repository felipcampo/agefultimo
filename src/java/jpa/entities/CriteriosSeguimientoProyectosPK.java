/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Usuario
 */
@Embeddable
public class CriteriosSeguimientoProyectosPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_cri")
    private String codCri;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_seg")
    private String codSeg;

    public CriteriosSeguimientoProyectosPK() {
    }

    public CriteriosSeguimientoProyectosPK(String codCri, String codSeg) {
        this.codCri = codCri;
        this.codSeg = codSeg;
    }

    public String getCodCri() {
        return codCri;
    }

    public void setCodCri(String codCri) {
        this.codCri = codCri;
    }

    public String getCodSeg() {
        return codSeg;
    }

    public void setCodSeg(String codSeg) {
        this.codSeg = codSeg;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCri != null ? codCri.hashCode() : 0);
        hash += (codSeg != null ? codSeg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CriteriosSeguimientoProyectosPK)) {
            return false;
        }
        CriteriosSeguimientoProyectosPK other = (CriteriosSeguimientoProyectosPK) object;
        if ((this.codCri == null && other.codCri != null) || (this.codCri != null && !this.codCri.equals(other.codCri))) {
            return false;
        }
        if ((this.codSeg == null && other.codSeg != null) || (this.codSeg != null && !this.codSeg.equals(other.codSeg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.CriteriosSeguimientoProyectosPK[ codCri=" + codCri + ", codSeg=" + codSeg + " ]";
    }
    
}
