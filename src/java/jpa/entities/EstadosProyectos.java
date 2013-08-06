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
@Table(name = "estados_proyectos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadosProyectos.findAll", query = "SELECT e FROM EstadosProyectos e"),
    @NamedQuery(name = "EstadosProyectos.findByCodEstPro", query = "SELECT e FROM EstadosProyectos e WHERE e.codEstPro = :codEstPro"),
    @NamedQuery(name = "EstadosProyectos.findByNomEstPro", query = "SELECT e FROM EstadosProyectos e WHERE e.nomEstPro = :nomEstPro")})
public class EstadosProyectos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_est_pro")
    private Short codEstPro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nom_est_pro")
    private String nomEstPro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codEstPro")
    private List<Proyectos> proyectosList;

    public EstadosProyectos() {
    }

    public EstadosProyectos(Short codEstPro) {
        this.codEstPro = codEstPro;
    }

    public EstadosProyectos(Short codEstPro, String nomEstPro) {
        this.codEstPro = codEstPro;
        this.nomEstPro = nomEstPro;
    }

    public Short getCodEstPro() {
        return codEstPro;
    }

    public void setCodEstPro(Short codEstPro) {
        this.codEstPro = codEstPro;
    }

    public String getNomEstPro() {
        return nomEstPro;
    }

    public void setNomEstPro(String nomEstPro) {
        this.nomEstPro = nomEstPro;
    }

    @XmlTransient
    public List<Proyectos> getProyectosList() {
        return proyectosList;
    }

    public void setProyectosList(List<Proyectos> proyectosList) {
        this.proyectosList = proyectosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEstPro != null ? codEstPro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadosProyectos)) {
            return false;
        }
        EstadosProyectos other = (EstadosProyectos) object;
        if ((this.codEstPro == null && other.codEstPro != null) || (this.codEstPro != null && !this.codEstPro.equals(other.codEstPro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.EstadosProyectos[ codEstPro=" + codEstPro + " ]";
    }
    
}
