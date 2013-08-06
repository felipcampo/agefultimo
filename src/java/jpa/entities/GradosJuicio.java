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
@Table(name = "grados_juicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GradosJuicio.findAll", query = "SELECT g FROM GradosJuicio g"),
    @NamedQuery(name = "GradosJuicio.findByCodGraJui", query = "SELECT g FROM GradosJuicio g WHERE g.codGraJui = :codGraJui"),
    @NamedQuery(name = "GradosJuicio.findByNomGraJui", query = "SELECT g FROM GradosJuicio g WHERE g.nomGraJui = :nomGraJui")})
public class GradosJuicio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "cod_gra_jui")
    private String codGraJui;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nom_gra_jui")
    private String nomGraJui;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codGraJui")
    private List<SeguimientoInstructores> seguimientoInstructoresList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codGraJui")
    private List<SeguimientoProyectos> seguimientoProyectosList;

    public GradosJuicio() {
    }

    public GradosJuicio(String codGraJui) {
        this.codGraJui = codGraJui;
    }

    public GradosJuicio(String codGraJui, String nomGraJui) {
        this.codGraJui = codGraJui;
        this.nomGraJui = nomGraJui;
    }

    public String getCodGraJui() {
        return codGraJui;
    }

    public void setCodGraJui(String codGraJui) {
        this.codGraJui = codGraJui;
    }

    public String getNomGraJui() {
        return nomGraJui;
    }

    public void setNomGraJui(String nomGraJui) {
        this.nomGraJui = nomGraJui;
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
        hash += (codGraJui != null ? codGraJui.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GradosJuicio)) {
            return false;
        }
        GradosJuicio other = (GradosJuicio) object;
        if ((this.codGraJui == null && other.codGraJui != null) || (this.codGraJui != null && !this.codGraJui.equals(other.codGraJui))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.GradosJuicio[ codGraJui=" + codGraJui + " ]";
    }
    
}
