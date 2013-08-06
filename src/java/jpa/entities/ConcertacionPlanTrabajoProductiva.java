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
import javax.persistence.Lob;
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
@Table(name = "concertacion_plan_trabajo_productiva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConcertacionPlanTrabajoProductiva.findAll", query = "SELECT c FROM ConcertacionPlanTrabajoProductiva c"),
    @NamedQuery(name = "ConcertacionPlanTrabajoProductiva.findByCodCpt", query = "SELECT c FROM ConcertacionPlanTrabajoProductiva c WHERE c.codCpt = :codCpt"),
    @NamedQuery(name = "ConcertacionPlanTrabajoProductiva.findByEviApr", query = "SELECT c FROM ConcertacionPlanTrabajoProductiva c WHERE c.eviApr = :eviApr"),
    @NamedQuery(name = "ConcertacionPlanTrabajoProductiva.findByFecCpt", query = "SELECT c FROM ConcertacionPlanTrabajoProductiva c WHERE c.fecCpt = :fecCpt"),
    @NamedQuery(name = "ConcertacionPlanTrabajoProductiva.findByLugCpt", query = "SELECT c FROM ConcertacionPlanTrabajoProductiva c WHERE c.lugCpt = :lugCpt")})
public class ConcertacionPlanTrabajoProductiva implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_cpt")
    private String codCpt;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "act_des")
    private String actDes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "evi_apr")
    private String eviApr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_cpt")
    @Temporal(TemporalType.DATE)
    private Date fecCpt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "lug_cpt")
    private String lugCpt;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "obs_cpt")
    private String obsCpt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCpt")
    private List<SeguimientosProductiva> seguimientosProductivaList;

    public ConcertacionPlanTrabajoProductiva() {
    }

    public ConcertacionPlanTrabajoProductiva(String codCpt) {
        this.codCpt = codCpt;
    }

    public ConcertacionPlanTrabajoProductiva(String codCpt, String actDes, String eviApr, Date fecCpt, String lugCpt, String obsCpt) {
        this.codCpt = codCpt;
        this.actDes = actDes;
        this.eviApr = eviApr;
        this.fecCpt = fecCpt;
        this.lugCpt = lugCpt;
        this.obsCpt = obsCpt;
    }

    public String getCodCpt() {
        return codCpt;
    }

    public void setCodCpt(String codCpt) {
        this.codCpt = codCpt;
    }

    public String getActDes() {
        return actDes;
    }

    public void setActDes(String actDes) {
        this.actDes = actDes;
    }

    public String getEviApr() {
        return eviApr;
    }

    public void setEviApr(String eviApr) {
        this.eviApr = eviApr;
    }

    public Date getFecCpt() {
        return fecCpt;
    }

    public void setFecCpt(Date fecCpt) {
        this.fecCpt = fecCpt;
    }

    public String getLugCpt() {
        return lugCpt;
    }

    public void setLugCpt(String lugCpt) {
        this.lugCpt = lugCpt;
    }

    public String getObsCpt() {
        return obsCpt;
    }

    public void setObsCpt(String obsCpt) {
        this.obsCpt = obsCpt;
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
        hash += (codCpt != null ? codCpt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConcertacionPlanTrabajoProductiva)) {
            return false;
        }
        ConcertacionPlanTrabajoProductiva other = (ConcertacionPlanTrabajoProductiva) object;
        if ((this.codCpt == null && other.codCpt != null) || (this.codCpt != null && !this.codCpt.equals(other.codCpt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.ConcertacionPlanTrabajoProductiva[ codCpt=" + codCpt + " ]";
    }
    
}
