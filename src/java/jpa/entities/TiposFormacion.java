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
@Table(name = "tipos_formacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposFormacion.findAll", query = "SELECT t FROM TiposFormacion t"),
    @NamedQuery(name = "TiposFormacion.findByCodTipFor", query = "SELECT t FROM TiposFormacion t WHERE t.codTipFor = :codTipFor"),
    @NamedQuery(name = "TiposFormacion.findByNomTipFor", query = "SELECT t FROM TiposFormacion t WHERE t.nomTipFor = :nomTipFor")})
public class TiposFormacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_tip_for")
    private Integer codTipFor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "nom_tip_for")
    private String nomTipFor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codTipFor")
    private List<FichasCaracterizacion> fichasCaracterizacionList;

    public TiposFormacion() {
    }

    public TiposFormacion(Integer codTipFor) {
        this.codTipFor = codTipFor;
    }

    public TiposFormacion(Integer codTipFor, String nomTipFor) {
        this.codTipFor = codTipFor;
        this.nomTipFor = nomTipFor;
    }

    public Integer getCodTipFor() {
        return codTipFor;
    }

    public void setCodTipFor(Integer codTipFor) {
        this.codTipFor = codTipFor;
    }

    public String getNomTipFor() {
        return nomTipFor;
    }

    public void setNomTipFor(String nomTipFor) {
        this.nomTipFor = nomTipFor;
    }

    @XmlTransient
    public List<FichasCaracterizacion> getFichasCaracterizacionList() {
        return fichasCaracterizacionList;
    }

    public void setFichasCaracterizacionList(List<FichasCaracterizacion> fichasCaracterizacionList) {
        this.fichasCaracterizacionList = fichasCaracterizacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTipFor != null ? codTipFor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposFormacion)) {
            return false;
        }
        TiposFormacion other = (TiposFormacion) object;
        if ((this.codTipFor == null && other.codTipFor != null) || (this.codTipFor != null && !this.codTipFor.equals(other.codTipFor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.TiposFormacion[ codTipFor=" + codTipFor + " ]";
    }
    
}
