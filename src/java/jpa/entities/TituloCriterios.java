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
@Table(name = "titulo_criterios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TituloCriterios.findAll", query = "SELECT t FROM TituloCriterios t"),
    @NamedQuery(name = "TituloCriterios.findByCodTitCri", query = "SELECT t FROM TituloCriterios t WHERE t.codTitCri = :codTitCri"),
    @NamedQuery(name = "TituloCriterios.findByNomTitCri", query = "SELECT t FROM TituloCriterios t WHERE t.nomTitCri = :nomTitCri")})
public class TituloCriterios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "cod_tit_cri")
    private String codTitCri;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nom_tit_cri")
    private String nomTitCri;
    @OneToMany(mappedBy = "codTitCri")
    private List<CriteriosEvaluacion> criteriosEvaluacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codTitCri")
    private List<SeguimientoInstructores> seguimientoInstructoresList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codTitCri")
    private List<SeguimientoProyectos> seguimientoProyectosList;

    public TituloCriterios() {
    }

    public TituloCriterios(String codTitCri) {
        this.codTitCri = codTitCri;
    }

    public TituloCriterios(String codTitCri, String nomTitCri) {
        this.codTitCri = codTitCri;
        this.nomTitCri = nomTitCri;
    }

    public String getCodTitCri() {
        return codTitCri;
    }

    public void setCodTitCri(String codTitCri) {
        this.codTitCri = codTitCri;
    }

    public String getNomTitCri() {
        return nomTitCri;
    }

    public void setNomTitCri(String nomTitCri) {
        this.nomTitCri = nomTitCri;
    }

    @XmlTransient
    public List<CriteriosEvaluacion> getCriteriosEvaluacionList() {
        return criteriosEvaluacionList;
    }

    public void setCriteriosEvaluacionList(List<CriteriosEvaluacion> criteriosEvaluacionList) {
        this.criteriosEvaluacionList = criteriosEvaluacionList;
    }

    @XmlTransient
    public List<SeguimientoInstructores> getSeguimientoInstructoresList() {
        return seguimientoInstructoresList;
    }

    public void setSeguimientoInstructoresList(List<SeguimientoInstructores> seguimientoInstructoresList) {
        this.seguimientoInstructoresList = seguimientoInstructoresList;
    }

    @XmlTransient
    public List<SeguimientoProyectos> getSeguimientoProyectosList() {
        return seguimientoProyectosList;
    }

    public void setSeguimientoProyectosList(List<SeguimientoProyectos> seguimientoProyectosList) {
        this.seguimientoProyectosList = seguimientoProyectosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTitCri != null ? codTitCri.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TituloCriterios)) {
            return false;
        }
        TituloCriterios other = (TituloCriterios) object;
        if ((this.codTitCri == null && other.codTitCri != null) || (this.codTitCri != null && !this.codTitCri.equals(other.codTitCri))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.TituloCriterios[ codTitCri=" + codTitCri + " ]";
    }
    
}
