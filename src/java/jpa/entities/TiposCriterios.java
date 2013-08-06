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
@Table(name = "tipos_criterios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposCriterios.findAll", query = "SELECT t FROM TiposCriterios t"),
    @NamedQuery(name = "TiposCriterios.findByCodTipCri", query = "SELECT t FROM TiposCriterios t WHERE t.codTipCri = :codTipCri"),
    @NamedQuery(name = "TiposCriterios.findByNomTipCri", query = "SELECT t FROM TiposCriterios t WHERE t.nomTipCri = :nomTipCri")})
public class TiposCriterios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "cod_tip_cri")
    private String codTipCri;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nom_tip_cri")
    private String nomTipCri;
    @OneToMany(mappedBy = "codTipCri")
    private List<CriteriosEvaluacion> criteriosEvaluacionList;

    public TiposCriterios() {
    }

    public TiposCriterios(String codTipCri) {
        this.codTipCri = codTipCri;
    }

    public TiposCriterios(String codTipCri, String nomTipCri) {
        this.codTipCri = codTipCri;
        this.nomTipCri = nomTipCri;
    }

    public String getCodTipCri() {
        return codTipCri;
    }

    public void setCodTipCri(String codTipCri) {
        this.codTipCri = codTipCri;
    }

    public String getNomTipCri() {
        return nomTipCri;
    }

    public void setNomTipCri(String nomTipCri) {
        this.nomTipCri = nomTipCri;
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
        hash += (codTipCri != null ? codTipCri.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposCriterios)) {
            return false;
        }
        TiposCriterios other = (TiposCriterios) object;
        if ((this.codTipCri == null && other.codTipCri != null) || (this.codTipCri != null && !this.codTipCri.equals(other.codTipCri))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.TiposCriterios[ codTipCri=" + codTipCri + " ]";
    }
    
}
