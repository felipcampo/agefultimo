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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "incidentes_productiva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IncidentesProductiva.findAll", query = "SELECT i FROM IncidentesProductiva i"),
    @NamedQuery(name = "IncidentesProductiva.findByCodInc", query = "SELECT i FROM IncidentesProductiva i WHERE i.codInc = :codInc"),
    @NamedQuery(name = "IncidentesProductiva.findByTipInc", query = "SELECT i FROM IncidentesProductiva i WHERE i.tipInc = :tipInc"),
    @NamedQuery(name = "IncidentesProductiva.findByDetInc", query = "SELECT i FROM IncidentesProductiva i WHERE i.detInc = :detInc"),
    @NamedQuery(name = "IncidentesProductiva.findByFecInc", query = "SELECT i FROM IncidentesProductiva i WHERE i.fecInc = :fecInc")})
public class IncidentesProductiva implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "cod_inc")
    private String codInc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "tip_inc")
    private String tipInc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "det_inc")
    private String detInc;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "sol_inc")
    private String solInc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_inc")
    @Temporal(TemporalType.DATE)
    private Date fecInc;
    @JoinColumn(name = "cod_vis", referencedColumnName = "cod_vis")
    @ManyToOne(optional = false)
    private VisitaEtapaProductiva codVis;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codInc")
    private List<SeguimientosProductiva> seguimientosProductivaList;

    public IncidentesProductiva() {
    }

    public IncidentesProductiva(String codInc) {
        this.codInc = codInc;
    }

    public IncidentesProductiva(String codInc, String tipInc, String detInc, String solInc, Date fecInc) {
        this.codInc = codInc;
        this.tipInc = tipInc;
        this.detInc = detInc;
        this.solInc = solInc;
        this.fecInc = fecInc;
    }

    public String getCodInc() {
        return codInc;
    }

    public void setCodInc(String codInc) {
        this.codInc = codInc;
    }

    public String getTipInc() {
        return tipInc;
    }

    public void setTipInc(String tipInc) {
        this.tipInc = tipInc;
    }

    public String getDetInc() {
        return detInc;
    }

    public void setDetInc(String detInc) {
        this.detInc = detInc;
    }

    public String getSolInc() {
        return solInc;
    }

    public void setSolInc(String solInc) {
        this.solInc = solInc;
    }

    public Date getFecInc() {
        return fecInc;
    }

    public void setFecInc(Date fecInc) {
        this.fecInc = fecInc;
    }

    public VisitaEtapaProductiva getCodVis() {
        return codVis;
    }

    public void setCodVis(VisitaEtapaProductiva codVis) {
        this.codVis = codVis;
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
        hash += (codInc != null ? codInc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IncidentesProductiva)) {
            return false;
        }
        IncidentesProductiva other = (IncidentesProductiva) object;
        if ((this.codInc == null && other.codInc != null) || (this.codInc != null && !this.codInc.equals(other.codInc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.IncidentesProductiva[ codInc=" + codInc + " ]";
    }
    
}
