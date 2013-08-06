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
@Table(name = "seguimientos_productiva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeguimientosProductiva.findAll", query = "SELECT s FROM SeguimientosProductiva s"),
    @NamedQuery(name = "SeguimientosProductiva.findByCodSegPro", query = "SELECT s FROM SeguimientosProductiva s WHERE s.codSegPro = :codSegPro"),
    @NamedQuery(name = "SeguimientosProductiva.findByJuiEva", query = "SELECT s FROM SeguimientosProductiva s WHERE s.juiEva = :juiEva"),
    @NamedQuery(name = "SeguimientosProductiva.findByReqMej", query = "SELECT s FROM SeguimientosProductiva s WHERE s.reqMej = :reqMej"),
    @NamedQuery(name = "SeguimientosProductiva.findByRecEsp", query = "SELECT s FROM SeguimientosProductiva s WHERE s.recEsp = :recEsp"),
    @NamedQuery(name = "SeguimientosProductiva.findByTipInf", query = "SELECT s FROM SeguimientosProductiva s WHERE s.tipInf = :tipInf"),
    @NamedQuery(name = "SeguimientosProductiva.findByFecRepIni", query = "SELECT s FROM SeguimientosProductiva s WHERE s.fecRepIni = :fecRepIni"),
    @NamedQuery(name = "SeguimientosProductiva.findByFecRepFin", query = "SELECT s FROM SeguimientosProductiva s WHERE s.fecRepFin = :fecRepFin")})
public class SeguimientosProductiva implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_seg_pro")
    private String codSegPro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "jui_eva")
    private boolean juiEva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "req_mej")
    private boolean reqMej;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rec_esp")
    private boolean recEsp;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "esp_rec")
    private String espRec;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "tip_inf")
    private String tipInf;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_rep_ini")
    @Temporal(TemporalType.DATE)
    private Date fecRepIni;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_rep_fin")
    @Temporal(TemporalType.DATE)
    private Date fecRepFin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codSegPro")
    private List<CriteriosSeguimientos> criteriosSeguimientosList;
    @JoinColumn(name = "nit_emp", referencedColumnName = "nit_emp")
    @ManyToOne(optional = false)
    private Empresas nitEmp;
    @JoinColumn(name = "id_usu", referencedColumnName = "id_usu")
    @ManyToOne(optional = false)
    private Usuarios idUsu;
    @JoinColumn(name = "cod_mod", referencedColumnName = "cod_mod")
    @ManyToOne(optional = false)
    private ModalidadesProductiva codMod;
    @JoinColumn(name = "cod_inc", referencedColumnName = "cod_inc")
    @ManyToOne(optional = false)
    private IncidentesProductiva codInc;
    @JoinColumn(name = "cod_fic", referencedColumnName = "cod_fic")
    @ManyToOne(optional = false)
    private FichasCaracterizacion codFic;
    @JoinColumn(name = "cod_cpt", referencedColumnName = "cod_cpt")
    @ManyToOne(optional = false)
    private ConcertacionPlanTrabajoProductiva codCpt;
    @JoinColumn(name = "cod_cen", referencedColumnName = "cod_cen")
    @ManyToOne(optional = false)
    private CentrosFormacion codCen;

    public SeguimientosProductiva() {
    }

    public SeguimientosProductiva(String codSegPro) {
        this.codSegPro = codSegPro;
    }

    public SeguimientosProductiva(String codSegPro, boolean juiEva, boolean reqMej, boolean recEsp, String espRec, String tipInf, Date fecRepIni, Date fecRepFin) {
        this.codSegPro = codSegPro;
        this.juiEva = juiEva;
        this.reqMej = reqMej;
        this.recEsp = recEsp;
        this.espRec = espRec;
        this.tipInf = tipInf;
        this.fecRepIni = fecRepIni;
        this.fecRepFin = fecRepFin;
    }

    public String getCodSegPro() {
        return codSegPro;
    }

    public void setCodSegPro(String codSegPro) {
        this.codSegPro = codSegPro;
    }

    public boolean getJuiEva() {
        return juiEva;
    }

    public void setJuiEva(boolean juiEva) {
        this.juiEva = juiEva;
    }

    public boolean getReqMej() {
        return reqMej;
    }

    public void setReqMej(boolean reqMej) {
        this.reqMej = reqMej;
    }

    public boolean getRecEsp() {
        return recEsp;
    }

    public void setRecEsp(boolean recEsp) {
        this.recEsp = recEsp;
    }

    public String getEspRec() {
        return espRec;
    }

    public void setEspRec(String espRec) {
        this.espRec = espRec;
    }

    public String getTipInf() {
        return tipInf;
    }

    public void setTipInf(String tipInf) {
        this.tipInf = tipInf;
    }

    public Date getFecRepIni() {
        return fecRepIni;
    }

    public void setFecRepIni(Date fecRepIni) {
        this.fecRepIni = fecRepIni;
    }

    public Date getFecRepFin() {
        return fecRepFin;
    }

    public void setFecRepFin(Date fecRepFin) {
        this.fecRepFin = fecRepFin;
    }

    @XmlTransient
    public List<CriteriosSeguimientos> getCriteriosSeguimientosList() {
        return criteriosSeguimientosList;
    }

    public void setCriteriosSeguimientosList(List<CriteriosSeguimientos> criteriosSeguimientosList) {
        this.criteriosSeguimientosList = criteriosSeguimientosList;
    }

    public Empresas getNitEmp() {
        return nitEmp;
    }

    public void setNitEmp(Empresas nitEmp) {
        this.nitEmp = nitEmp;
    }

    public Usuarios getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(Usuarios idUsu) {
        this.idUsu = idUsu;
    }

    public ModalidadesProductiva getCodMod() {
        return codMod;
    }

    public void setCodMod(ModalidadesProductiva codMod) {
        this.codMod = codMod;
    }

    public IncidentesProductiva getCodInc() {
        return codInc;
    }

    public void setCodInc(IncidentesProductiva codInc) {
        this.codInc = codInc;
    }

    public FichasCaracterizacion getCodFic() {
        return codFic;
    }

    public void setCodFic(FichasCaracterizacion codFic) {
        this.codFic = codFic;
    }

    public ConcertacionPlanTrabajoProductiva getCodCpt() {
        return codCpt;
    }

    public void setCodCpt(ConcertacionPlanTrabajoProductiva codCpt) {
        this.codCpt = codCpt;
    }

    public CentrosFormacion getCodCen() {
        return codCen;
    }

    public void setCodCen(CentrosFormacion codCen) {
        this.codCen = codCen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codSegPro != null ? codSegPro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeguimientosProductiva)) {
            return false;
        }
        SeguimientosProductiva other = (SeguimientosProductiva) object;
        if ((this.codSegPro == null && other.codSegPro != null) || (this.codSegPro != null && !this.codSegPro.equals(other.codSegPro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.SeguimientosProductiva[ codSegPro=" + codSegPro + " ]";
    }
    
}
