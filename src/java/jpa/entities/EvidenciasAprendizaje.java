/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "evidencias_aprendizaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EvidenciasAprendizaje.findAll", query = "SELECT e FROM EvidenciasAprendizaje e"),
    @NamedQuery(name = "EvidenciasAprendizaje.findByCodEviApr", query = "SELECT e FROM EvidenciasAprendizaje e WHERE e.codEviApr = :codEviApr"),
    @NamedQuery(name = "EvidenciasAprendizaje.findByNomEviApr", query = "SELECT e FROM EvidenciasAprendizaje e WHERE e.nomEviApr = :nomEviApr"),
    @NamedQuery(name = "EvidenciasAprendizaje.findByFecEviApr", query = "SELECT e FROM EvidenciasAprendizaje e WHERE e.fecEviApr = :fecEviApr"),
    @NamedQuery(name = "EvidenciasAprendizaje.findByPertinente", query = "SELECT e FROM EvidenciasAprendizaje e WHERE e.pertinente = :pertinente"),
    @NamedQuery(name = "EvidenciasAprendizaje.findByCalidad", query = "SELECT e FROM EvidenciasAprendizaje e WHERE e.calidad = :calidad"),
    @NamedQuery(name = "EvidenciasAprendizaje.findByValidez", query = "SELECT e FROM EvidenciasAprendizaje e WHERE e.validez = :validez"),
    @NamedQuery(name = "EvidenciasAprendizaje.findByAutentico", query = "SELECT e FROM EvidenciasAprendizaje e WHERE e.autentico = :autentico")})
public class EvidenciasAprendizaje implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "cod_evi_apr")
    private String codEviApr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nom_evi_apr")
    private String nomEviApr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_evi_apr")
    @Temporal(TemporalType.DATE)
    private Date fecEviApr;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "des_evi_apr")
    private String desEviApr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pertinente")
    private boolean pertinente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "calidad")
    private boolean calidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "validez")
    private boolean validez;
    @Basic(optional = false)
    @NotNull
    @Column(name = "autentico")
    private boolean autentico;
    @ManyToMany(mappedBy = "evidenciasAprendizajeList")
    private List<CriteriosEvaluacion> criteriosEvaluacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codEviApr")
    private List<EvaluacionesSeguimientos> evaluacionesSeguimientosList;
    @JoinColumn(name = "cod_sub_pro", referencedColumnName = "cod_sub_pro")
    @ManyToOne(optional = false)
    private SubactividadesProyecto codSubPro;
    @JoinColumn(name = "cod_res_apr", referencedColumnName = "cod_res_apr")
    @ManyToOne(optional = false)
    private ResultadosAprendizaje codResApr;
    @JoinColumn(name = "cod_amb", referencedColumnName = "cod_amb")
    @ManyToOne(optional = false)
    private Ambientes codAmb;

    public EvidenciasAprendizaje() {
    }

    public EvidenciasAprendizaje(String codEviApr) {
        this.codEviApr = codEviApr;
    }

    public EvidenciasAprendizaje(String codEviApr, String nomEviApr, Date fecEviApr, String desEviApr, boolean pertinente, boolean calidad, boolean validez, boolean autentico) {
        this.codEviApr = codEviApr;
        this.nomEviApr = nomEviApr;
        this.fecEviApr = fecEviApr;
        this.desEviApr = desEviApr;
        this.pertinente = pertinente;
        this.calidad = calidad;
        this.validez = validez;
        this.autentico = autentico;
    }

    public String getCodEviApr() {
        return codEviApr;
    }

    public void setCodEviApr(String codEviApr) {
        this.codEviApr = codEviApr;
    }

    public String getNomEviApr() {
        return nomEviApr;
    }

    public void setNomEviApr(String nomEviApr) {
        this.nomEviApr = nomEviApr;
    }

    public Date getFecEviApr() {
        return fecEviApr;
    }

    public void setFecEviApr(Date fecEviApr) {
        this.fecEviApr = fecEviApr;
    }

    public String getDesEviApr() {
        return desEviApr;
    }

    public void setDesEviApr(String desEviApr) {
        this.desEviApr = desEviApr;
    }

    public boolean getPertinente() {
        return pertinente;
    }

    public void setPertinente(boolean pertinente) {
        this.pertinente = pertinente;
    }

    public boolean getCalidad() {
        return calidad;
    }

    public void setCalidad(boolean calidad) {
        this.calidad = calidad;
    }

    public boolean getValidez() {
        return validez;
    }

    public void setValidez(boolean validez) {
        this.validez = validez;
    }

    public boolean getAutentico() {
        return autentico;
    }

    public void setAutentico(boolean autentico) {
        this.autentico = autentico;
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

    public SubactividadesProyecto getCodSubPro() {
        return codSubPro;
    }

    public void setCodSubPro(SubactividadesProyecto codSubPro) {
        this.codSubPro = codSubPro;
    }

    public ResultadosAprendizaje getCodResApr() {
        return codResApr;
    }

    public void setCodResApr(ResultadosAprendizaje codResApr) {
        this.codResApr = codResApr;
    }

    public Ambientes getCodAmb() {
        return codAmb;
    }

    public void setCodAmb(Ambientes codAmb) {
        this.codAmb = codAmb;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEviApr != null ? codEviApr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvidenciasAprendizaje)) {
            return false;
        }
        EvidenciasAprendizaje other = (EvidenciasAprendizaje) object;
        if ((this.codEviApr == null && other.codEviApr != null) || (this.codEviApr != null && !this.codEviApr.equals(other.codEviApr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.EvidenciasAprendizaje[ codEviApr=" + codEviApr + " ]";
    }
    
}
