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
@Table(name = "actividades_proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActividadesProyecto.findAll", query = "SELECT a FROM ActividadesProyecto a"),
    @NamedQuery(name = "ActividadesProyecto.findByCodActPro", query = "SELECT a FROM ActividadesProyecto a WHERE a.codActPro = :codActPro"),
    @NamedQuery(name = "ActividadesProyecto.findByNomActPro", query = "SELECT a FROM ActividadesProyecto a WHERE a.nomActPro = :nomActPro")})
public class ActividadesProyecto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_act_pro")
    private String codActPro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nom_act_pro")
    private String nomActPro;
    @JoinTable(name = "actividades_criterios", joinColumns = {
        @JoinColumn(name = "cod_act_pro", referencedColumnName = "cod_act_pro")}, inverseJoinColumns = {
        @JoinColumn(name = "cod_cri", referencedColumnName = "cod_cri")})
    @ManyToMany
    private List<CriteriosEvaluacion> criteriosEvaluacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codActPro")
    private List<EvaluacionesSeguimientos> evaluacionesSeguimientosList;
    @JoinColumn(name = "cod_fas_pro", referencedColumnName = "cod_fas_pro")
    @ManyToOne(optional = false)
    private FasesProyecto codFasPro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codActPro")
    private List<SubactividadesProyecto> subactividadesProyectoList;

    public ActividadesProyecto() {
    }

    public ActividadesProyecto(String codActPro) {
        this.codActPro = codActPro;
    }

    public ActividadesProyecto(String codActPro, String nomActPro) {
        this.codActPro = codActPro;
        this.nomActPro = nomActPro;
    }

    public String getCodActPro() {
        return codActPro;
    }

    public void setCodActPro(String codActPro) {
        this.codActPro = codActPro;
    }

    public String getNomActPro() {
        return nomActPro;
    }

    public void setNomActPro(String nomActPro) {
        this.nomActPro = nomActPro;
    }

    @XmlTransient
    public List<CriteriosEvaluacion> getCriteriosEvaluacionList() {
        return criteriosEvaluacionList;
    }

    public void setCriteriosEvaluacionList(List<CriteriosEvaluacion> criteriosEvaluacionList) {
        this.criteriosEvaluacionList = criteriosEvaluacionList;
    }

    @XmlTransient
    public List<EvaluacionesSeguimientos> getEvaluacionesSeguimientosList() {
        return evaluacionesSeguimientosList;
    }

    public void setEvaluacionesSeguimientosList(List<EvaluacionesSeguimientos> evaluacionesSeguimientosList) {
        this.evaluacionesSeguimientosList = evaluacionesSeguimientosList;
    }

    public FasesProyecto getCodFasPro() {
        return codFasPro;
    }

    public void setCodFasPro(FasesProyecto codFasPro) {
        this.codFasPro = codFasPro;
    }

    @XmlTransient
    public List<SubactividadesProyecto> getSubactividadesProyectoList() {
        return subactividadesProyectoList;
    }

    public void setSubactividadesProyectoList(List<SubactividadesProyecto> subactividadesProyectoList) {
        this.subactividadesProyectoList = subactividadesProyectoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codActPro != null ? codActPro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActividadesProyecto)) {
            return false;
        }
        ActividadesProyecto other = (ActividadesProyecto) object;
        if ((this.codActPro == null && other.codActPro != null) || (this.codActPro != null && !this.codActPro.equals(other.codActPro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.ActividadesProyecto[ codActPro=" + codActPro + " ]";
    }
    
}
