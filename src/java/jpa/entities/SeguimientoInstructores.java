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
@Table(name = "seguimiento_instructores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeguimientoInstructores.findAll", query = "SELECT s FROM SeguimientoInstructores s"),
    @NamedQuery(name = "SeguimientoInstructores.findByCodSegIns", query = "SELECT s FROM SeguimientoInstructores s WHERE s.codSegIns = :codSegIns"),
    @NamedQuery(name = "SeguimientoInstructores.findByFecSegIns", query = "SELECT s FROM SeguimientoInstructores s WHERE s.fecSegIns = :fecSegIns"),
    @NamedQuery(name = "SeguimientoInstructores.findByHorIni", query = "SELECT s FROM SeguimientoInstructores s WHERE s.horIni = :horIni"),
    @NamedQuery(name = "SeguimientoInstructores.findByHorFin", query = "SELECT s FROM SeguimientoInstructores s WHERE s.horFin = :horFin"),
    @NamedQuery(name = "SeguimientoInstructores.findByArea", query = "SELECT s FROM SeguimientoInstructores s WHERE s.area = :area"),
    @NamedQuery(name = "SeguimientoInstructores.findByNomIns", query = "SELECT s FROM SeguimientoInstructores s WHERE s.nomIns = :nomIns")})
public class SeguimientoInstructores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_seg_ins")
    private String codSegIns;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_seg_ins")
    @Temporal(TemporalType.DATE)
    private Date fecSegIns;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hor_ini")
    @Temporal(TemporalType.TIME)
    private Date horIni;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hor_fin")
    @Temporal(TemporalType.TIME)
    private Date horFin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "area")
    private String area;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nom_ins")
    private String nomIns;
    @JoinColumn(name = "id_usu", referencedColumnName = "id_usu")
    @ManyToOne(optional = false)
    private Usuarios idUsu;
    @JoinColumn(name = "cod_tit_cri", referencedColumnName = "cod_tit_cri")
    @ManyToOne(optional = false)
    private TituloCriterios codTitCri;
    @JoinColumn(name = "cod_tip_jui", referencedColumnName = "cod_tip_jui")
    @ManyToOne(optional = false)
    private TiposJuicio codTipJui;
    @JoinColumn(name = "cod_reg", referencedColumnName = "cod_reg")
    @ManyToOne(optional = false)
    private Regionales codReg;
    @JoinColumn(name = "cod_pro", referencedColumnName = "cod_pro")
    @ManyToOne(optional = false)
    private Proyectos codPro;
    @JoinColumn(name = "cod_niv_for", referencedColumnName = "cod_niv_for")
    @ManyToOne(optional = false)
    private NivelesFormacion codNivFor;
    @JoinColumn(name = "cod_gra_jui", referencedColumnName = "cod_gra_jui")
    @ManyToOne(optional = false)
    private GradosJuicio codGraJui;
    @JoinColumn(name = "cod_fic", referencedColumnName = "cod_fic")
    @ManyToOne(optional = false)
    private FichasCaracterizacion codFic;
    @JoinColumn(name = "cod_est_jui", referencedColumnName = "cod_est_jui")
    @ManyToOne(optional = false)
    private EstadosJuicio codEstJui;
    @JoinColumn(name = "cod_cen", referencedColumnName = "cod_cen")
    @ManyToOne(optional = false)
    private CentrosFormacion codCen;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codSegIns")
    private List<CriteriosSeguimientoInstructores> criteriosSeguimientoInstructoresList;

    public SeguimientoInstructores() {
    }

    public SeguimientoInstructores(String codSegIns) {
        this.codSegIns = codSegIns;
    }

    public SeguimientoInstructores(String codSegIns, Date fecSegIns, Date horIni, Date horFin, String area, String nomIns) {
        this.codSegIns = codSegIns;
        this.fecSegIns = fecSegIns;
        this.horIni = horIni;
        this.horFin = horFin;
        this.area = area;
        this.nomIns = nomIns;
    }

    public String getCodSegIns() {
        return codSegIns;
    }

    public void setCodSegIns(String codSegIns) {
        this.codSegIns = codSegIns;
    }

    public Date getFecSegIns() {
        return fecSegIns;
    }

    public void setFecSegIns(Date fecSegIns) {
        this.fecSegIns = fecSegIns;
    }

    public Date getHorIni() {
        return horIni;
    }

    public void setHorIni(Date horIni) {
        this.horIni = horIni;
    }

    public Date getHorFin() {
        return horFin;
    }

    public void setHorFin(Date horFin) {
        this.horFin = horFin;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getNomIns() {
        return nomIns;
    }

    public void setNomIns(String nomIns) {
        this.nomIns = nomIns;
    }

    public Usuarios getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(Usuarios idUsu) {
        this.idUsu = idUsu;
    }

    public TituloCriterios getCodTitCri() {
        return codTitCri;
    }

    public void setCodTitCri(TituloCriterios codTitCri) {
        this.codTitCri = codTitCri;
    }

    public TiposJuicio getCodTipJui() {
        return codTipJui;
    }

    public void setCodTipJui(TiposJuicio codTipJui) {
        this.codTipJui = codTipJui;
    }

    public Regionales getCodReg() {
        return codReg;
    }

    public void setCodReg(Regionales codReg) {
        this.codReg = codReg;
    }

    public Proyectos getCodPro() {
        return codPro;
    }

    public void setCodPro(Proyectos codPro) {
        this.codPro = codPro;
    }

    public NivelesFormacion getCodNivFor() {
        return codNivFor;
    }

    public void setCodNivFor(NivelesFormacion codNivFor) {
        this.codNivFor = codNivFor;
    }

    public GradosJuicio getCodGraJui() {
        return codGraJui;
    }

    public void setCodGraJui(GradosJuicio codGraJui) {
        this.codGraJui = codGraJui;
    }

    public FichasCaracterizacion getCodFic() {
        return codFic;
    }

    public void setCodFic(FichasCaracterizacion codFic) {
        this.codFic = codFic;
    }

    public EstadosJuicio getCodEstJui() {
        return codEstJui;
    }

    public void setCodEstJui(EstadosJuicio codEstJui) {
        this.codEstJui = codEstJui;
    }

    public CentrosFormacion getCodCen() {
        return codCen;
    }

    public void setCodCen(CentrosFormacion codCen) {
        this.codCen = codCen;
    }

    @XmlTransient
    public List<CriteriosSeguimientoInstructores> getCriteriosSeguimientoInstructoresList() {
        return criteriosSeguimientoInstructoresList;
    }

    public void setCriteriosSeguimientoInstructoresList(List<CriteriosSeguimientoInstructores> criteriosSeguimientoInstructoresList) {
        this.criteriosSeguimientoInstructoresList = criteriosSeguimientoInstructoresList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codSegIns != null ? codSegIns.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeguimientoInstructores)) {
            return false;
        }
        SeguimientoInstructores other = (SeguimientoInstructores) object;
        if ((this.codSegIns == null && other.codSegIns != null) || (this.codSegIns != null && !this.codSegIns.equals(other.codSegIns))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.SeguimientoInstructores[ codSegIns=" + codSegIns + " ]";
    }
    
}
