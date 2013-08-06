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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "estados_medidas_formativas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadosMedidasFormativas.findAll", query = "SELECT e FROM EstadosMedidasFormativas e"),
    @NamedQuery(name = "EstadosMedidasFormativas.findByCodEst", query = "SELECT e FROM EstadosMedidasFormativas e WHERE e.codEst = :codEst"),
    @NamedQuery(name = "EstadosMedidasFormativas.findByNomEst", query = "SELECT e FROM EstadosMedidasFormativas e WHERE e.nomEst = :nomEst")})
public class EstadosMedidasFormativas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "cod_est")
    private String codEst;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "nom_est")
    private String nomEst;
    @JoinTable(name = "estados_llamados", joinColumns = {
        @JoinColumn(name = "cod_est", referencedColumnName = "cod_est")}, inverseJoinColumns = {
        @JoinColumn(name = "num_acc", referencedColumnName = "num_acc")})
    @ManyToMany
    private List<LlamadosAtencionVerbal> llamadosAtencionVerbalList;
    @JoinTable(name = "estados_planes", joinColumns = {
        @JoinColumn(name = "cod_est", referencedColumnName = "cod_est")}, inverseJoinColumns = {
        @JoinColumn(name = "cod_pla_mej", referencedColumnName = "cod_pla_mej")})
    @ManyToMany
    private List<PlanesMejoramiento> planesMejoramientoList;

    public EstadosMedidasFormativas() {
    }

    public EstadosMedidasFormativas(String codEst) {
        this.codEst = codEst;
    }

    public EstadosMedidasFormativas(String codEst, String nomEst) {
        this.codEst = codEst;
        this.nomEst = nomEst;
    }

    public String getCodEst() {
        return codEst;
    }

    public void setCodEst(String codEst) {
        this.codEst = codEst;
    }

    public String getNomEst() {
        return nomEst;
    }

    public void setNomEst(String nomEst) {
        this.nomEst = nomEst;
    }

    @XmlTransient
    public List<LlamadosAtencionVerbal> getLlamadosAtencionVerbalList() {
        return llamadosAtencionVerbalList;
    }

    public void setLlamadosAtencionVerbalList(List<LlamadosAtencionVerbal> llamadosAtencionVerbalList) {
        this.llamadosAtencionVerbalList = llamadosAtencionVerbalList;
    }

    @XmlTransient
    public List<PlanesMejoramiento> getPlanesMejoramientoList() {
        return planesMejoramientoList;
    }

    public void setPlanesMejoramientoList(List<PlanesMejoramiento> planesMejoramientoList) {
        this.planesMejoramientoList = planesMejoramientoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEst != null ? codEst.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadosMedidasFormativas)) {
            return false;
        }
        EstadosMedidasFormativas other = (EstadosMedidasFormativas) object;
        if ((this.codEst == null && other.codEst != null) || (this.codEst != null && !this.codEst.equals(other.codEst))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.EstadosMedidasFormativas[ codEst=" + codEst + " ]";
    }
    
}
