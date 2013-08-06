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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "estados_aprendiz")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadosAprendiz.findAll", query = "SELECT e FROM EstadosAprendiz e"),
    @NamedQuery(name = "EstadosAprendiz.findByCodEstApr", query = "SELECT e FROM EstadosAprendiz e WHERE e.codEstApr = :codEstApr"),
    @NamedQuery(name = "EstadosAprendiz.findByNomEstApr", query = "SELECT e FROM EstadosAprendiz e WHERE e.nomEstApr = :nomEstApr")})
public class EstadosAprendiz implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_est_apr")
    private Short codEstApr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nom_est_apr")
    private String nomEstApr;
    @JoinTable(name = "roles_estados", joinColumns = {
        @JoinColumn(name = "cod_est_apr", referencedColumnName = "cod_est_apr")}, inverseJoinColumns = {
        @JoinColumn(name = "cod_rol", referencedColumnName = "cod_rol")})
    @ManyToMany
    private List<Roles> rolesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codEstApr")
    private List<FichasUsuarios> fichasUsuariosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codEstApr")
    private List<SeguimientoProyectos> seguimientoProyectosList;

    public EstadosAprendiz() {
    }

    public EstadosAprendiz(Short codEstApr) {
        this.codEstApr = codEstApr;
    }

    public EstadosAprendiz(Short codEstApr, String nomEstApr) {
        this.codEstApr = codEstApr;
        this.nomEstApr = nomEstApr;
    }

    public Short getCodEstApr() {
        return codEstApr;
    }

    public void setCodEstApr(Short codEstApr) {
        this.codEstApr = codEstApr;
    }

    public String getNomEstApr() {
        return nomEstApr;
    }

    public void setNomEstApr(String nomEstApr) {
        this.nomEstApr = nomEstApr;
    }

    @XmlTransient
    public List<Roles> getRolesList() {
        return rolesList;
    }

    public void setRolesList(List<Roles> rolesList) {
        this.rolesList = rolesList;
    }

    @XmlTransient
    public List<FichasUsuarios> getFichasUsuariosList() {
        return fichasUsuariosList;
    }

    public void setFichasUsuariosList(List<FichasUsuarios> fichasUsuariosList) {
        this.fichasUsuariosList = fichasUsuariosList;
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
        hash += (codEstApr != null ? codEstApr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadosAprendiz)) {
            return false;
        }
        EstadosAprendiz other = (EstadosAprendiz) object;
        if ((this.codEstApr == null && other.codEstApr != null) || (this.codEstApr != null && !this.codEstApr.equals(other.codEstApr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.EstadosAprendiz[ codEstApr=" + codEstApr + " ]";
    }
    
}
