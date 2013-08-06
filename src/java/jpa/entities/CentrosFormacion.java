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
@Table(name = "centros_formacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CentrosFormacion.findAll", query = "SELECT c FROM CentrosFormacion c"),
    @NamedQuery(name = "CentrosFormacion.findByCodCen", query = "SELECT c FROM CentrosFormacion c WHERE c.codCen = :codCen"),
    @NamedQuery(name = "CentrosFormacion.findByNomCen", query = "SELECT c FROM CentrosFormacion c WHERE c.nomCen = :nomCen"),
    @NamedQuery(name = "CentrosFormacion.findByDirCen", query = "SELECT c FROM CentrosFormacion c WHERE c.dirCen = :dirCen")})
public class CentrosFormacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "cod_cen")
    private String codCen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 99)
    @Column(name = "nom_cen")
    private String nomCen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 90)
    @Column(name = "dir_cen")
    private String dirCen;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCen")
    private List<Programas> programasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCen")
    private List<PraxisPedagogica> praxisPedagogicaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCen")
    private List<SeguimientoInstructores> seguimientoInstructoresList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCen")
    private List<SeguimientoProyectos> seguimientoProyectosList;
    @JoinColumn(name = "cod_reg", referencedColumnName = "cod_reg")
    @ManyToOne(optional = false)
    private Regionales codReg;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCen")
    private List<SeguimientosProductiva> seguimientosProductivaList;

    public CentrosFormacion() {
    }

    public CentrosFormacion(String codCen) {
        this.codCen = codCen;
    }

    public CentrosFormacion(String codCen, String nomCen, String dirCen) {
        this.codCen = codCen;
        this.nomCen = nomCen;
        this.dirCen = dirCen;
    }

    public String getCodCen() {
        return codCen;
    }

    public void setCodCen(String codCen) {
        this.codCen = codCen;
    }

    public String getNomCen() {
        return nomCen;
    }

    public void setNomCen(String nomCen) {
        this.nomCen = nomCen;
    }

    public String getDirCen() {
        return dirCen;
    }

    public void setDirCen(String dirCen) {
        this.dirCen = dirCen;
    }

    @XmlTransient
    public List<Programas> getProgramasList() {
        return programasList;
    }

    public void setProgramasList(List<Programas> programasList) {
        this.programasList = programasList;
    }

    @XmlTransient
    public List<PraxisPedagogica> getPraxisPedagogicaList() {
        return praxisPedagogicaList;
    }

    public void setPraxisPedagogicaList(List<PraxisPedagogica> praxisPedagogicaList) {
        this.praxisPedagogicaList = praxisPedagogicaList;
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

    public Regionales getCodReg() {
        return codReg;
    }

    public void setCodReg(Regionales codReg) {
        this.codReg = codReg;
    }

    @XmlTransient
    public List<SeguimientosProductiva> getSeguimientosProductivaList() {
        return seguimientosProductivaList;
    }

    public void setSeguimientosProductivaList(List<SeguimientosProductiva> seguimientosProductivaList) {
        this.seguimientosProductivaList = seguimientosProductivaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCen != null ? codCen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CentrosFormacion)) {
            return false;
        }
        CentrosFormacion other = (CentrosFormacion) object;
        if ((this.codCen == null && other.codCen != null) || (this.codCen != null && !this.codCen.equals(other.codCen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.CentrosFormacion[ codCen=" + codCen + " ]";
    }
    
}
