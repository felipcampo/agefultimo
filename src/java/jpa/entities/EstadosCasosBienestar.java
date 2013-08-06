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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "estados_casos_bienestar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadosCasosBienestar.findAll", query = "SELECT e FROM EstadosCasosBienestar e"),
    @NamedQuery(name = "EstadosCasosBienestar.findByCodEstBie", query = "SELECT e FROM EstadosCasosBienestar e WHERE e.codEstBie = :codEstBie"),
    @NamedQuery(name = "EstadosCasosBienestar.findByNomEstBie", query = "SELECT e FROM EstadosCasosBienestar e WHERE e.nomEstBie = :nomEstBie")})
public class EstadosCasosBienestar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_est_bie")
    private Integer codEstBie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nom_est_bie")
    private String nomEstBie;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codEstBie")
    private List<CasosBienestar> casosBienestarList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codEstBie")
    private List<ControlAprendiz> controlAprendizList;

    public EstadosCasosBienestar() {
    }

    public EstadosCasosBienestar(Integer codEstBie) {
        this.codEstBie = codEstBie;
    }

    public EstadosCasosBienestar(Integer codEstBie, String nomEstBie) {
        this.codEstBie = codEstBie;
        this.nomEstBie = nomEstBie;
    }

    public Integer getCodEstBie() {
        return codEstBie;
    }

    public void setCodEstBie(Integer codEstBie) {
        this.codEstBie = codEstBie;
    }

    public String getNomEstBie() {
        return nomEstBie;
    }

    public void setNomEstBie(String nomEstBie) {
        this.nomEstBie = nomEstBie;
    }

    @XmlTransient
    public List<CasosBienestar> getCasosBienestarList() {
        return casosBienestarList;
    }

    public void setCasosBienestarList(List<CasosBienestar> casosBienestarList) {
        this.casosBienestarList = casosBienestarList;
    }

    @XmlTransient
    public List<ControlAprendiz> getControlAprendizList() {
        return controlAprendizList;
    }

    public void setControlAprendizList(List<ControlAprendiz> controlAprendizList) {
        this.controlAprendizList = controlAprendizList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEstBie != null ? codEstBie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadosCasosBienestar)) {
            return false;
        }
        EstadosCasosBienestar other = (EstadosCasosBienestar) object;
        if ((this.codEstBie == null && other.codEstBie != null) || (this.codEstBie != null && !this.codEstBie.equals(other.codEstBie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.EstadosCasosBienestar[ codEstBie=" + codEstBie + " ]";
    }
    
}
