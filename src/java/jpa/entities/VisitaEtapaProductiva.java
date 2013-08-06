/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "visita_etapa_productiva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VisitaEtapaProductiva.findAll", query = "SELECT v FROM VisitaEtapaProductiva v"),
    @NamedQuery(name = "VisitaEtapaProductiva.findByCodVis", query = "SELECT v FROM VisitaEtapaProductiva v WHERE v.codVis = :codVis"),
    @NamedQuery(name = "VisitaEtapaProductiva.findByFecVis", query = "SELECT v FROM VisitaEtapaProductiva v WHERE v.fecVis = :fecVis"),
    @NamedQuery(name = "VisitaEtapaProductiva.findByEstVis", query = "SELECT v FROM VisitaEtapaProductiva v WHERE v.estVis = :estVis"),
    @NamedQuery(name = "VisitaEtapaProductiva.findByDisFec", query = "SELECT v FROM VisitaEtapaProductiva v WHERE v.disFec = :disFec")})
public class VisitaEtapaProductiva implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_vis")
    private String codVis;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_vis")
    @Temporal(TemporalType.DATE)
    private Date fecVis;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "est_vis")
    private String estVis;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dis_fec")
    private boolean disFec;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codVis")
    private List<IncidentesProductiva> incidentesProductivaList;

    public VisitaEtapaProductiva() {
    }

    public VisitaEtapaProductiva(String codVis) {
        this.codVis = codVis;
    }

    public VisitaEtapaProductiva(String codVis, Date fecVis, String estVis, boolean disFec) {
        this.codVis = codVis;
        this.fecVis = fecVis;
        this.estVis = estVis;
        this.disFec = disFec;
    }

    public String getCodVis() {
        return codVis;
    }

    public void setCodVis(String codVis) {
        this.codVis = codVis;
    }

    public Date getFecVis() {
        return fecVis;
    }

    public void setFecVis(Date fecVis) {
        this.fecVis = fecVis;
    }

    public String getEstVis() {
        return estVis;
    }

    public void setEstVis(String estVis) {
        this.estVis = estVis;
    }

    public boolean getDisFec() {
        return disFec;
    }

    public void setDisFec(boolean disFec) {
        this.disFec = disFec;
    }

    @XmlTransient
    public List<IncidentesProductiva> getIncidentesProductivaList() {
        return incidentesProductivaList;
    }

    public void setIncidentesProductivaList(List<IncidentesProductiva> incidentesProductivaList) {
        this.incidentesProductivaList = incidentesProductivaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codVis != null ? codVis.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VisitaEtapaProductiva)) {
            return false;
        }
        VisitaEtapaProductiva other = (VisitaEtapaProductiva) object;
        if ((this.codVis == null && other.codVis != null) || (this.codVis != null && !this.codVis.equals(other.codVis))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.VisitaEtapaProductiva[ codVis=" + codVis + " ]";
    }
    
}
