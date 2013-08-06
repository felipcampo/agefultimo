/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "estados_aspirantes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadosAspirantes.findAll", query = "SELECT e FROM EstadosAspirantes e"),
    @NamedQuery(name = "EstadosAspirantes.findByIdEstAsp", query = "SELECT e FROM EstadosAspirantes e WHERE e.idEstAsp = :idEstAsp"),
    @NamedQuery(name = "EstadosAspirantes.findByNomEstAsp", query = "SELECT e FROM EstadosAspirantes e WHERE e.nomEstAsp = :nomEstAsp")})
public class EstadosAspirantes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_est_asp")
    private Integer idEstAsp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nom_est_asp")
    private String nomEstAsp;
    @JoinColumn(name = "id_usu", referencedColumnName = "id_usu")
    @ManyToOne(optional = false)
    private Usuarios idUsu;

    public EstadosAspirantes() {
    }

    public EstadosAspirantes(Integer idEstAsp) {
        this.idEstAsp = idEstAsp;
    }

    public EstadosAspirantes(Integer idEstAsp, String nomEstAsp) {
        this.idEstAsp = idEstAsp;
        this.nomEstAsp = nomEstAsp;
    }

    public Integer getIdEstAsp() {
        return idEstAsp;
    }

    public void setIdEstAsp(Integer idEstAsp) {
        this.idEstAsp = idEstAsp;
    }

    public String getNomEstAsp() {
        return nomEstAsp;
    }

    public void setNomEstAsp(String nomEstAsp) {
        this.nomEstAsp = nomEstAsp;
    }

    public Usuarios getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(Usuarios idUsu) {
        this.idUsu = idUsu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstAsp != null ? idEstAsp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadosAspirantes)) {
            return false;
        }
        EstadosAspirantes other = (EstadosAspirantes) object;
        if ((this.idEstAsp == null && other.idEstAsp != null) || (this.idEstAsp != null && !this.idEstAsp.equals(other.idEstAsp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.EstadosAspirantes[ idEstAsp=" + idEstAsp + " ]";
    }
    
}
