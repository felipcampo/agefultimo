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
import javax.persistence.JoinTable;
import javax.persistence.Lob;
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
@Table(name = "criterios_evaluacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CriteriosEvaluacion.findAll", query = "SELECT c FROM CriteriosEvaluacion c"),
    @NamedQuery(name = "CriteriosEvaluacion.findByCodCri", query = "SELECT c FROM CriteriosEvaluacion c WHERE c.codCri = :codCri"),
    @NamedQuery(name = "CriteriosEvaluacion.findByNomCri", query = "SELECT c FROM CriteriosEvaluacion c WHERE c.nomCri = :nomCri")})
public class CriteriosEvaluacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_cri")
    private String codCri;
    @Size(max = 45)
    @Column(name = "nom_cri")
    private String nomCri;
    @Lob
    @Size(max = 65535)
    @Column(name = "det_cri")
    private String detCri;
    @JoinTable(name = "evidencias_criterios", joinColumns = {
        @JoinColumn(name = "cod_cri", referencedColumnName = "cod_cri")}, inverseJoinColumns = {
        @JoinColumn(name = "cod_evi_apr", referencedColumnName = "cod_evi_apr")})
    @ManyToMany
    private List<EvidenciasAprendizaje> evidenciasAprendizajeList;
    @ManyToMany(mappedBy = "criteriosEvaluacionList")
    private List<ActividadesProyecto> actividadesProyectoList;
    @JoinColumn(name = "id_fep", referencedColumnName = "id_fep")
    @ManyToOne
    private FactoresProductiva idFep;
    @JoinColumn(name = "cod_tit_cri", referencedColumnName = "cod_tit_cri")
    @ManyToOne
    private TituloCriterios codTitCri;
    @JoinColumn(name = "cod_tip_cri", referencedColumnName = "cod_tip_cri")
    @ManyToOne
    private TiposCriterios codTipCri;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "criteriosEvaluacion")
    private List<CriteriosSeguimientoProyectos> criteriosSeguimientoProyectosList;
    @OneToMany(mappedBy = "codCri")
    private List<CriteriosSeguimientos> criteriosSeguimientosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCri")
    private List<CriteriosSeguimientoInstructores> criteriosSeguimientoInstructoresList;

    public CriteriosEvaluacion() {
    }

    public CriteriosEvaluacion(String codCri) {
        this.codCri = codCri;
    }

    public String getCodCri() {
        return codCri;
    }

    public void setCodCri(String codCri) {
        this.codCri = codCri;
    }

    public String getNomCri() {
        return nomCri;
    }

    public void setNomCri(String nomCri) {
        this.nomCri = nomCri;
    }

    public String getDetCri() {
        return detCri;
    }

    public void setDetCri(String detCri) {
        this.detCri = detCri;
    }

    @XmlTransient
    public List<EvidenciasAprendizaje> getEvidenciasAprendizajeList() {
        return evidenciasAprendizajeList;
    }

    public void setEvidenciasAprendizajeList(List<EvidenciasAprendizaje> evidenciasAprendizajeList) {
        this.evidenciasAprendizajeList = evidenciasAprendizajeList;
    }

    @XmlTransient
    public List<ActividadesProyecto> getActividadesProyectoList() {
        return actividadesProyectoList;
    }

    public void setActividadesProyectoList(List<ActividadesProyecto> actividadesProyectoList) {
        this.actividadesProyectoList = actividadesProyectoList;
    }

    public FactoresProductiva getIdFep() {
        return idFep;
    }

    public void setIdFep(FactoresProductiva idFep) {
        this.idFep = idFep;
    }

    public TituloCriterios getCodTitCri() {
        return codTitCri;
    }

    public void setCodTitCri(TituloCriterios codTitCri) {
        this.codTitCri = codTitCri;
    }

    public TiposCriterios getCodTipCri() {
        return codTipCri;
    }

    public void setCodTipCri(TiposCriterios codTipCri) {
        this.codTipCri = codTipCri;
    }

    @XmlTransient
    public List<CriteriosSeguimientoProyectos> getCriteriosSeguimientoProyectosList() {
        return criteriosSeguimientoProyectosList;
    }

    public void setCriteriosSeguimientoProyectosList(List<CriteriosSeguimientoProyectos> criteriosSeguimientoProyectosList) {
        this.criteriosSeguimientoProyectosList = criteriosSeguimientoProyectosList;
    }

    @XmlTransient
    public List<CriteriosSeguimientos> getCriteriosSeguimientosList() {
        return criteriosSeguimientosList;
    }

    public void setCriteriosSeguimientosList(List<CriteriosSeguimientos> criteriosSeguimientosList) {
        this.criteriosSeguimientosList = criteriosSeguimientosList;
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
        hash += (codCri != null ? codCri.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CriteriosEvaluacion)) {
            return false;
        }
        CriteriosEvaluacion other = (CriteriosEvaluacion) object;
        if ((this.codCri == null && other.codCri != null) || (this.codCri != null && !this.codCri.equals(other.codCri))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.CriteriosEvaluacion[ codCri=" + codCri + " ]";
    }
    
}
