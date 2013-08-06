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
@Table(name = "deserciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Deserciones.findAll", query = "SELECT d FROM Deserciones d"),
    @NamedQuery(name = "Deserciones.findByCodDes", query = "SELECT d FROM Deserciones d WHERE d.codDes = :codDes"),
    @NamedQuery(name = "Deserciones.findByNumDes", query = "SELECT d FROM Deserciones d WHERE d.numDes = :numDes"),
    @NamedQuery(name = "Deserciones.findByDiasDes", query = "SELECT d FROM Deserciones d WHERE d.diasDes = :diasDes"),
    @NamedQuery(name = "Deserciones.findByFecIni", query = "SELECT d FROM Deserciones d WHERE d.fecIni = :fecIni"),
    @NamedQuery(name = "Deserciones.findByFecFin", query = "SELECT d FROM Deserciones d WHERE d.fecFin = :fecFin")})
public class Deserciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "cod_des")
    private String codDes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_des")
    private int numDes;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "causas")
    private String causas;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "observaciones")
    private String observaciones;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "dias_des")
    private String diasDes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_ini")
    @Temporal(TemporalType.DATE)
    private Date fecIni;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_fin")
    @Temporal(TemporalType.DATE)
    private Date fecFin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codDes")
    private List<ReportesNovedades> reportesNovedadesList;

    public Deserciones() {
    }

    public Deserciones(String codDes) {
        this.codDes = codDes;
    }

    public Deserciones(String codDes, int numDes, String causas, String observaciones, String diasDes, Date fecIni, Date fecFin) {
        this.codDes = codDes;
        this.numDes = numDes;
        this.causas = causas;
        this.observaciones = observaciones;
        this.diasDes = diasDes;
        this.fecIni = fecIni;
        this.fecFin = fecFin;
    }

    public String getCodDes() {
        return codDes;
    }

    public void setCodDes(String codDes) {
        this.codDes = codDes;
    }

    public int getNumDes() {
        return numDes;
    }

    public void setNumDes(int numDes) {
        this.numDes = numDes;
    }

    public String getCausas() {
        return causas;
    }

    public void setCausas(String causas) {
        this.causas = causas;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getDiasDes() {
        return diasDes;
    }

    public void setDiasDes(String diasDes) {
        this.diasDes = diasDes;
    }

    public Date getFecIni() {
        return fecIni;
    }

    public void setFecIni(Date fecIni) {
        this.fecIni = fecIni;
    }

    public Date getFecFin() {
        return fecFin;
    }

    public void setFecFin(Date fecFin) {
        this.fecFin = fecFin;
    }

    @XmlTransient
    public List<ReportesNovedades> getReportesNovedadesList() {
        return reportesNovedadesList;
    }

    public void setReportesNovedadesList(List<ReportesNovedades> reportesNovedadesList) {
        this.reportesNovedadesList = reportesNovedadesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDes != null ? codDes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Deserciones)) {
            return false;
        }
        Deserciones other = (Deserciones) object;
        if ((this.codDes == null && other.codDes != null) || (this.codDes != null && !this.codDes.equals(other.codDes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Deserciones[ codDes=" + codDes + " ]";
    }
    
}
