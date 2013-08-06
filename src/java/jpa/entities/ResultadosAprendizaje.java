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
@Table(name = "resultados_aprendizaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResultadosAprendizaje.findAll", query = "SELECT r FROM ResultadosAprendizaje r"),
    @NamedQuery(name = "ResultadosAprendizaje.findByCodResApr", query = "SELECT r FROM ResultadosAprendizaje r WHERE r.codResApr = :codResApr")})
public class ResultadosAprendizaje implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_res_apr")
    private Integer codResApr;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "nom_res_apr")
    private String nomResApr;
    @ManyToMany(mappedBy = "resultadosAprendizajeList")
    private List<PlanesMejoramiento> planesMejoramientoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codResApr")
    private List<EvaluacionesSeguimientos> evaluacionesSeguimientosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codResApr")
    private List<EvidenciasAprendizaje> evidenciasAprendizajeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codResApr")
    private List<ReportesNovedades> reportesNovedadesList;
    @JoinColumn(name = "cod_com", referencedColumnName = "cod_com")
    @ManyToOne(optional = false)
    private Competencias codCom;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codResApr")
    private List<SeguimientoProyectos> seguimientoProyectosList;

    public ResultadosAprendizaje() {
    }

    public ResultadosAprendizaje(Integer codResApr) {
        this.codResApr = codResApr;
    }

    public ResultadosAprendizaje(Integer codResApr, String nomResApr) {
        this.codResApr = codResApr;
        this.nomResApr = nomResApr;
    }

    public Integer getCodResApr() {
        return codResApr;
    }

    public void setCodResApr(Integer codResApr) {
        this.codResApr = codResApr;
    }

    public String getNomResApr() {
        return nomResApr;
    }

    public void setNomResApr(String nomResApr) {
        this.nomResApr = nomResApr;
    }

    @XmlTransient
    public List<PlanesMejoramiento> getPlanesMejoramientoList() {
        return planesMejoramientoList;
    }

    public void setPlanesMejoramientoList(List<PlanesMejoramiento> planesMejoramientoList) {
        this.planesMejoramientoList = planesMejoramientoList;
    }

    @XmlTransient
    public List<EvaluacionesSeguimientos> getEvaluacionesSeguimientosList() {
        return evaluacionesSeguimientosList;
    }

    public void setEvaluacionesSeguimientosList(List<EvaluacionesSeguimientos> evaluacionesSeguimientosList) {
        this.evaluacionesSeguimientosList = evaluacionesSeguimientosList;
    }

    @XmlTransient
    public List<EvidenciasAprendizaje> getEvidenciasAprendizajeList() {
        return evidenciasAprendizajeList;
    }

    public void setEvidenciasAprendizajeList(List<EvidenciasAprendizaje> evidenciasAprendizajeList) {
        this.evidenciasAprendizajeList = evidenciasAprendizajeList;
    }

    @XmlTransient
    public List<ReportesNovedades> getReportesNovedadesList() {
        return reportesNovedadesList;
    }

    public void setReportesNovedadesList(List<ReportesNovedades> reportesNovedadesList) {
        this.reportesNovedadesList = reportesNovedadesList;
    }

    public Competencias getCodCom() {
        return codCom;
    }

    public void setCodCom(Competencias codCom) {
        this.codCom = codCom;
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
        hash += (codResApr != null ? codResApr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResultadosAprendizaje)) {
            return false;
        }
        ResultadosAprendizaje other = (ResultadosAprendizaje) object;
        if ((this.codResApr == null && other.codResApr != null) || (this.codResApr != null && !this.codResApr.equals(other.codResApr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.ResultadosAprendizaje[ codResApr=" + codResApr + " ]";
    }
    
}
