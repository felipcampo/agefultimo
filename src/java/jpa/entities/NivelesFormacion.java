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
@Table(name = "niveles_formacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NivelesFormacion.findAll", query = "SELECT n FROM NivelesFormacion n"),
    @NamedQuery(name = "NivelesFormacion.findByCodNivFor", query = "SELECT n FROM NivelesFormacion n WHERE n.codNivFor = :codNivFor"),
    @NamedQuery(name = "NivelesFormacion.findByNomNivFor", query = "SELECT n FROM NivelesFormacion n WHERE n.nomNivFor = :nomNivFor")})
public class NivelesFormacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_niv_for")
    private Integer codNivFor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 26)
    @Column(name = "nom_niv_for")
    private String nomNivFor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codNivFor")
    private List<FichasCaracterizacion> fichasCaracterizacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codNivFor")
    private List<SeguimientoInstructores> seguimientoInstructoresList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codNivFor")
    private List<SeguimientoProyectos> seguimientoProyectosList;

    public NivelesFormacion() {
    }

    public NivelesFormacion(Integer codNivFor) {
        this.codNivFor = codNivFor;
    }

    public NivelesFormacion(Integer codNivFor, String nomNivFor) {
        this.codNivFor = codNivFor;
        this.nomNivFor = nomNivFor;
    }

    public Integer getCodNivFor() {
        return codNivFor;
    }

    public void setCodNivFor(Integer codNivFor) {
        this.codNivFor = codNivFor;
    }

    public String getNomNivFor() {
        return nomNivFor;
    }

    public void setNomNivFor(String nomNivFor) {
        this.nomNivFor = nomNivFor;
    }

    @XmlTransient
    public List<FichasCaracterizacion> getFichasCaracterizacionList() {
        return fichasCaracterizacionList;
    }

    public void setFichasCaracterizacionList(List<FichasCaracterizacion> fichasCaracterizacionList) {
        this.fichasCaracterizacionList = fichasCaracterizacionList;
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
        hash += (codNivFor != null ? codNivFor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NivelesFormacion)) {
            return false;
        }
        NivelesFormacion other = (NivelesFormacion) object;
        if ((this.codNivFor == null && other.codNivFor != null) || (this.codNivFor != null && !this.codNivFor.equals(other.codNivFor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.NivelesFormacion[ codNivFor=" + codNivFor + " ]";
    }
    
}
