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
@Table(name = "estados_juicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadosJuicio.findAll", query = "SELECT e FROM EstadosJuicio e"),
    @NamedQuery(name = "EstadosJuicio.findByCodEstJui", query = "SELECT e FROM EstadosJuicio e WHERE e.codEstJui = :codEstJui"),
    @NamedQuery(name = "EstadosJuicio.findByNomEstJui", query = "SELECT e FROM EstadosJuicio e WHERE e.nomEstJui = :nomEstJui")})
public class EstadosJuicio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "cod_est_jui")
    private String codEstJui;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nom_est_jui")
    private String nomEstJui;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codEstJui")
    private List<SeguimientoInstructores> seguimientoInstructoresList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codEstJui")
    private List<SeguimientoProyectos> seguimientoProyectosList;

    public EstadosJuicio() {
    }

    public EstadosJuicio(String codEstJui) {
        this.codEstJui = codEstJui;
    }

    public EstadosJuicio(String codEstJui, String nomEstJui) {
        this.codEstJui = codEstJui;
        this.nomEstJui = nomEstJui;
    }

    public String getCodEstJui() {
        return codEstJui;
    }

    public void setCodEstJui(String codEstJui) {
        this.codEstJui = codEstJui;
    }

    public String getNomEstJui() {
        return nomEstJui;
    }

    public void setNomEstJui(String nomEstJui) {
        this.nomEstJui = nomEstJui;
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
        hash += (codEstJui != null ? codEstJui.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadosJuicio)) {
            return false;
        }
        EstadosJuicio other = (EstadosJuicio) object;
        if ((this.codEstJui == null && other.codEstJui != null) || (this.codEstJui != null && !this.codEstJui.equals(other.codEstJui))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.EstadosJuicio[ codEstJui=" + codEstJui + " ]";
    }
    
}
