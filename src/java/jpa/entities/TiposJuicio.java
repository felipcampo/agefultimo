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
@Table(name = "tipos_juicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposJuicio.findAll", query = "SELECT t FROM TiposJuicio t"),
    @NamedQuery(name = "TiposJuicio.findByCodTipJui", query = "SELECT t FROM TiposJuicio t WHERE t.codTipJui = :codTipJui"),
    @NamedQuery(name = "TiposJuicio.findByNomTipJui", query = "SELECT t FROM TiposJuicio t WHERE t.nomTipJui = :nomTipJui")})
public class TiposJuicio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "cod_tip_jui")
    private String codTipJui;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nom_tip_jui")
    private String nomTipJui;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codTipJui")
    private List<SeguimientoInstructores> seguimientoInstructoresList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codTipJui")
    private List<SeguimientoProyectos> seguimientoProyectosList;

    public TiposJuicio() {
    }

    public TiposJuicio(String codTipJui) {
        this.codTipJui = codTipJui;
    }

    public TiposJuicio(String codTipJui, String nomTipJui) {
        this.codTipJui = codTipJui;
        this.nomTipJui = nomTipJui;
    }

    public String getCodTipJui() {
        return codTipJui;
    }

    public void setCodTipJui(String codTipJui) {
        this.codTipJui = codTipJui;
    }

    public String getNomTipJui() {
        return nomTipJui;
    }

    public void setNomTipJui(String nomTipJui) {
        this.nomTipJui = nomTipJui;
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
        hash += (codTipJui != null ? codTipJui.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposJuicio)) {
            return false;
        }
        TiposJuicio other = (TiposJuicio) object;
        if ((this.codTipJui == null && other.codTipJui != null) || (this.codTipJui != null && !this.codTipJui.equals(other.codTipJui))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.TiposJuicio[ codTipJui=" + codTipJui + " ]";
    }
    
}
