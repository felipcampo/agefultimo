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
import javax.persistence.ManyToMany;
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
@Table(name = "fichas_caracterizacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FichasCaracterizacion.findAll", query = "SELECT f FROM FichasCaracterizacion f"),
    @NamedQuery(name = "FichasCaracterizacion.findByCodFic", query = "SELECT f FROM FichasCaracterizacion f WHERE f.codFic = :codFic"),
    @NamedQuery(name = "FichasCaracterizacion.findByFecIni", query = "SELECT f FROM FichasCaracterizacion f WHERE f.fecIni = :fecIni"),
    @NamedQuery(name = "FichasCaracterizacion.findByFecFin", query = "SELECT f FROM FichasCaracterizacion f WHERE f.fecFin = :fecFin"),
    @NamedQuery(name = "FichasCaracterizacion.findByFecIniEtaLec", query = "SELECT f FROM FichasCaracterizacion f WHERE f.fecIniEtaLec = :fecIniEtaLec"),
    @NamedQuery(name = "FichasCaracterizacion.findByFecFinEtaLec", query = "SELECT f FROM FichasCaracterizacion f WHERE f.fecFinEtaLec = :fecFinEtaLec"),
    @NamedQuery(name = "FichasCaracterizacion.findByFecIniEtaPro", query = "SELECT f FROM FichasCaracterizacion f WHERE f.fecIniEtaPro = :fecIniEtaPro"),
    @NamedQuery(name = "FichasCaracterizacion.findByFecFinEtaPro", query = "SELECT f FROM FichasCaracterizacion f WHERE f.fecFinEtaPro = :fecFinEtaPro"),
    @NamedQuery(name = "FichasCaracterizacion.findByNumCupIns", query = "SELECT f FROM FichasCaracterizacion f WHERE f.numCupIns = :numCupIns"),
    @NamedQuery(name = "FichasCaracterizacion.findByNumCupFic", query = "SELECT f FROM FichasCaracterizacion f WHERE f.numCupFic = :numCupFic"),
    @NamedQuery(name = "FichasCaracterizacion.findByJorFic", query = "SELECT f FROM FichasCaracterizacion f WHERE f.jorFic = :jorFic")})
public class FichasCaracterizacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_fic")
    private Integer codFic;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_ini_eta_lec")
    @Temporal(TemporalType.DATE)
    private Date fecIniEtaLec;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_fin_eta_lec")
    @Temporal(TemporalType.DATE)
    private Date fecFinEtaLec;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_ini_eta_pro")
    @Temporal(TemporalType.DATE)
    private Date fecIniEtaPro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_fin_eta_pro")
    @Temporal(TemporalType.DATE)
    private Date fecFinEtaPro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_cup_ins")
    private int numCupIns;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_cup_fic")
    private int numCupFic;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "jor_fic")
    private String jorFic;
    @ManyToMany(mappedBy = "fichasCaracterizacionList")
    private List<EstadosFichas> estadosFichasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codFic")
    private List<EvaluacionesSeguimientos> evaluacionesSeguimientosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codFic")
    private List<MatrizCaracterizacion> matrizCaracterizacionList;
    @JoinColumn(name = "cod_tip_for", referencedColumnName = "cod_tip_for")
    @ManyToOne(optional = false)
    private TiposFormacion codTipFor;
    @JoinColumn(name = "cod_pro", referencedColumnName = "cod_pro")
    @ManyToOne(optional = false)
    private Proyectos codPro;
    @JoinColumn(name = "cod_prg", referencedColumnName = "cod_prg")
    @ManyToOne(optional = false)
    private Programas codPrg;
    @JoinColumn(name = "cod_ofe", referencedColumnName = "cod_ofe")
    @ManyToOne(optional = false)
    private TiposOferta codOfe;
    @JoinColumn(name = "cod_niv_for", referencedColumnName = "cod_niv_for")
    @ManyToOne(optional = false)
    private NivelesFormacion codNivFor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codFic")
    private List<LlamadosAtencionVerbal> llamadosAtencionVerbalList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fichasCaracterizacion")
    private List<FichasUsuarios> fichasUsuariosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codFic")
    private List<Comites> comitesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codFic")
    private List<ReportesNovedades> reportesNovedadesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codFic")
    private List<PlanesMejoramiento> planesMejoramientoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codFic")
    private List<SeguimientoInstructores> seguimientoInstructoresList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codFic")
    private List<SeguimientoProyectos> seguimientoProyectosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codFic")
    private List<SeguimientosProductiva> seguimientosProductivaList;

    public FichasCaracterizacion() {
    }

    public FichasCaracterizacion(Integer codFic) {
        this.codFic = codFic;
    }

    public FichasCaracterizacion(Integer codFic, Date fecIni, Date fecFin, Date fecIniEtaLec, Date fecFinEtaLec, Date fecIniEtaPro, Date fecFinEtaPro, int numCupIns, int numCupFic, String jorFic) {
        this.codFic = codFic;
        this.fecIni = fecIni;
        this.fecFin = fecFin;
        this.fecIniEtaLec = fecIniEtaLec;
        this.fecFinEtaLec = fecFinEtaLec;
        this.fecIniEtaPro = fecIniEtaPro;
        this.fecFinEtaPro = fecFinEtaPro;
        this.numCupIns = numCupIns;
        this.numCupFic = numCupFic;
        this.jorFic = jorFic;
    }

    public Integer getCodFic() {
        return codFic;
    }

    public void setCodFic(Integer codFic) {
        this.codFic = codFic;
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

    public Date getFecIniEtaLec() {
        return fecIniEtaLec;
    }

    public void setFecIniEtaLec(Date fecIniEtaLec) {
        this.fecIniEtaLec = fecIniEtaLec;
    }

    public Date getFecFinEtaLec() {
        return fecFinEtaLec;
    }

    public void setFecFinEtaLec(Date fecFinEtaLec) {
        this.fecFinEtaLec = fecFinEtaLec;
    }

    public Date getFecIniEtaPro() {
        return fecIniEtaPro;
    }

    public void setFecIniEtaPro(Date fecIniEtaPro) {
        this.fecIniEtaPro = fecIniEtaPro;
    }

    public Date getFecFinEtaPro() {
        return fecFinEtaPro;
    }

    public void setFecFinEtaPro(Date fecFinEtaPro) {
        this.fecFinEtaPro = fecFinEtaPro;
    }

    public int getNumCupIns() {
        return numCupIns;
    }

    public void setNumCupIns(int numCupIns) {
        this.numCupIns = numCupIns;
    }

    public int getNumCupFic() {
        return numCupFic;
    }

    public void setNumCupFic(int numCupFic) {
        this.numCupFic = numCupFic;
    }

    public String getJorFic() {
        return jorFic;
    }

    public void setJorFic(String jorFic) {
        this.jorFic = jorFic;
    }

    @XmlTransient
    public List<EstadosFichas> getEstadosFichasList() {
        return estadosFichasList;
    }

    public void setEstadosFichasList(List<EstadosFichas> estadosFichasList) {
        this.estadosFichasList = estadosFichasList;
    }

    @XmlTransient
    public List<EvaluacionesSeguimientos> getEvaluacionesSeguimientosList() {
        return evaluacionesSeguimientosList;
    }

    public void setEvaluacionesSeguimientosList(List<EvaluacionesSeguimientos> evaluacionesSeguimientosList) {
        this.evaluacionesSeguimientosList = evaluacionesSeguimientosList;
    }

    @XmlTransient
    public List<MatrizCaracterizacion> getMatrizCaracterizacionList() {
        return matrizCaracterizacionList;
    }

    public void setMatrizCaracterizacionList(List<MatrizCaracterizacion> matrizCaracterizacionList) {
        this.matrizCaracterizacionList = matrizCaracterizacionList;
    }

    public TiposFormacion getCodTipFor() {
        return codTipFor;
    }

    public void setCodTipFor(TiposFormacion codTipFor) {
        this.codTipFor = codTipFor;
    }

    public Proyectos getCodPro() {
        return codPro;
    }

    public void setCodPro(Proyectos codPro) {
        this.codPro = codPro;
    }

    public Programas getCodPrg() {
        return codPrg;
    }

    public void setCodPrg(Programas codPrg) {
        this.codPrg = codPrg;
    }

    public TiposOferta getCodOfe() {
        return codOfe;
    }

    public void setCodOfe(TiposOferta codOfe) {
        this.codOfe = codOfe;
    }

    public NivelesFormacion getCodNivFor() {
        return codNivFor;
    }

    public void setCodNivFor(NivelesFormacion codNivFor) {
        this.codNivFor = codNivFor;
    }

    @XmlTransient
    public List<LlamadosAtencionVerbal> getLlamadosAtencionVerbalList() {
        return llamadosAtencionVerbalList;
    }

    public void setLlamadosAtencionVerbalList(List<LlamadosAtencionVerbal> llamadosAtencionVerbalList) {
        this.llamadosAtencionVerbalList = llamadosAtencionVerbalList;
    }

    @XmlTransient
    public List<FichasUsuarios> getFichasUsuariosList() {
        return fichasUsuariosList;
    }

    public void setFichasUsuariosList(List<FichasUsuarios> fichasUsuariosList) {
        this.fichasUsuariosList = fichasUsuariosList;
    }

    @XmlTransient
    public List<Comites> getComitesList() {
        return comitesList;
    }

    public void setComitesList(List<Comites> comitesList) {
        this.comitesList = comitesList;
    }

    @XmlTransient
    public List<ReportesNovedades> getReportesNovedadesList() {
        return reportesNovedadesList;
    }

    public void setReportesNovedadesList(List<ReportesNovedades> reportesNovedadesList) {
        this.reportesNovedadesList = reportesNovedadesList;
    }

    @XmlTransient
    public List<PlanesMejoramiento> getPlanesMejoramientoList() {
        return planesMejoramientoList;
    }

    public void setPlanesMejoramientoList(List<PlanesMejoramiento> planesMejoramientoList) {
        this.planesMejoramientoList = planesMejoramientoList;
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
        hash += (codFic != null ? codFic.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FichasCaracterizacion)) {
            return false;
        }
        FichasCaracterizacion other = (FichasCaracterizacion) object;
        if ((this.codFic == null && other.codFic != null) || (this.codFic != null && !this.codFic.equals(other.codFic))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.FichasCaracterizacion[ codFic=" + codFic + " ]";
    }
    
}
