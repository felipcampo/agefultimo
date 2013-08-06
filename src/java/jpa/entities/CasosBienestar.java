/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "casos_bienestar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CasosBienestar.findAll", query = "SELECT c FROM CasosBienestar c"),
    @NamedQuery(name = "CasosBienestar.findByCodCasBie", query = "SELECT c FROM CasosBienestar c WHERE c.codCasBie = :codCasBie"),
    @NamedQuery(name = "CasosBienestar.findByFecIniCas", query = "SELECT c FROM CasosBienestar c WHERE c.fecIniCas = :fecIniCas"),
    @NamedQuery(name = "CasosBienestar.findByFecFinCas", query = "SELECT c FROM CasosBienestar c WHERE c.fecFinCas = :fecFinCas")})
public class CasosBienestar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "cod_cas_bie")
    private String codCasBie;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_ini_cas")
    @Temporal(TemporalType.DATE)
    private Date fecIniCas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_fin_cas")
    @Temporal(TemporalType.DATE)
    private Date fecFinCas;
    @JoinColumn(name = "cod_tip_bie", referencedColumnName = "cod_tip_bie")
    @ManyToOne(optional = false)
    private TiposCasosBienestar codTipBie;
    @JoinColumn(name = "cod_est_bie", referencedColumnName = "cod_est_bie")
    @ManyToOne(optional = false)
    private EstadosCasosBienestar codEstBie;

    public CasosBienestar() {
    }

    public CasosBienestar(String codCasBie) {
        this.codCasBie = codCasBie;
    }

    public CasosBienestar(String codCasBie, Date fecIniCas, Date fecFinCas) {
        this.codCasBie = codCasBie;
        this.fecIniCas = fecIniCas;
        this.fecFinCas = fecFinCas;
    }

    public String getCodCasBie() {
        return codCasBie;
    }

    public void setCodCasBie(String codCasBie) {
        this.codCasBie = codCasBie;
    }

    public Date getFecIniCas() {
        return fecIniCas;
    }

    public void setFecIniCas(Date fecIniCas) {
        this.fecIniCas = fecIniCas;
    }

    public Date getFecFinCas() {
        return fecFinCas;
    }

    public void setFecFinCas(Date fecFinCas) {
        this.fecFinCas = fecFinCas;
    }

    public TiposCasosBienestar getCodTipBie() {
        return codTipBie;
    }

    public void setCodTipBie(TiposCasosBienestar codTipBie) {
        this.codTipBie = codTipBie;
    }

    public EstadosCasosBienestar getCodEstBie() {
        return codEstBie;
    }

    public void setCodEstBie(EstadosCasosBienestar codEstBie) {
        this.codEstBie = codEstBie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCasBie != null ? codCasBie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CasosBienestar)) {
            return false;
        }
        CasosBienestar other = (CasosBienestar) object;
        if ((this.codCasBie == null && other.codCasBie != null) || (this.codCasBie != null && !this.codCasBie.equals(other.codCasBie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.CasosBienestar[ codCasBie=" + codCasBie + " ]";
    }
    
}
