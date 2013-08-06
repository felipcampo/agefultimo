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
@Table(name = "tipos_casos_bienestar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposCasosBienestar.findAll", query = "SELECT t FROM TiposCasosBienestar t"),
    @NamedQuery(name = "TiposCasosBienestar.findByCodTipBie", query = "SELECT t FROM TiposCasosBienestar t WHERE t.codTipBie = :codTipBie"),
    @NamedQuery(name = "TiposCasosBienestar.findByNomTipBie", query = "SELECT t FROM TiposCasosBienestar t WHERE t.nomTipBie = :nomTipBie")})
public class TiposCasosBienestar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_tip_bie")
    private Integer codTipBie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nom_tip_bie")
    private String nomTipBie;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codTipBie")
    private List<Remisiones> remisionesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codTipBie")
    private List<CasosBienestar> casosBienestarList;

    public TiposCasosBienestar() {
    }

    public TiposCasosBienestar(Integer codTipBie) {
        this.codTipBie = codTipBie;
    }

    public TiposCasosBienestar(Integer codTipBie, String nomTipBie) {
        this.codTipBie = codTipBie;
        this.nomTipBie = nomTipBie;
    }

    public Integer getCodTipBie() {
        return codTipBie;
    }

    public void setCodTipBie(Integer codTipBie) {
        this.codTipBie = codTipBie;
    }

    public String getNomTipBie() {
        return nomTipBie;
    }

    public void setNomTipBie(String nomTipBie) {
        this.nomTipBie = nomTipBie;
    }

    @XmlTransient
    public List<Remisiones> getRemisionesList() {
        return remisionesList;
    }

    public void setRemisionesList(List<Remisiones> remisionesList) {
        this.remisionesList = remisionesList;
    }

    @XmlTransient
    public List<CasosBienestar> getCasosBienestarList() {
        return casosBienestarList;
    }

    public void setCasosBienestarList(List<CasosBienestar> casosBienestarList) {
        this.casosBienestarList = casosBienestarList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTipBie != null ? codTipBie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposCasosBienestar)) {
            return false;
        }
        TiposCasosBienestar other = (TiposCasosBienestar) object;
        if ((this.codTipBie == null && other.codTipBie != null) || (this.codTipBie != null && !this.codTipBie.equals(other.codTipBie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.TiposCasosBienestar[ codTipBie=" + codTipBie + " ]";
    }
    
}
