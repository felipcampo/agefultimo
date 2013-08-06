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
@Table(name = "seguimiento_proyectos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeguimientoProyectos.findAll", query = "SELECT s FROM SeguimientoProyectos s"),
    @NamedQuery(name = "SeguimientoProyectos.findByCodSeg", query = "SELECT s FROM SeguimientoProyectos s WHERE s.codSeg = :codSeg"),
    @NamedQuery(name = "SeguimientoProyectos.findByFecSeg", query = "SELECT s FROM SeguimientoProyectos s WHERE s.fecSeg = :fecSeg"),
    @NamedQuery(name = "SeguimientoProyectos.findByHorIni", query = "SELECT s FROM SeguimientoProyectos s WHERE s.horIni = :horIni"),
    @NamedQuery(name = "SeguimientoProyectos.findByHorFin", query = "SELECT s FROM SeguimientoProyectos s WHERE s.horFin = :horFin"),
    @NamedQuery(name = "SeguimientoProyectos.findByTotHor", query = "SELECT s FROM SeguimientoProyectos s WHERE s.totHor = :totHor"),
    @NamedQuery(name = "SeguimientoProyectos.findByCodPro", query = "SELECT s FROM SeguimientoProyectos s WHERE s.codPro = :codPro"),
    @NamedQuery(name = "SeguimientoProyectos.findByArea", query = "SELECT s FROM SeguimientoProyectos s WHERE s.area = :area"),
    @NamedQuery(name = "SeguimientoProyectos.findByJornada", query = "SELECT s FROM SeguimientoProyectos s WHERE s.jornada = :jornada"),
    @NamedQuery(name = "SeguimientoProyectos.findByNomIns", query = "SELECT s FROM SeguimientoProyectos s WHERE s.nomIns = :nomIns")})
public class SeguimientoProyectos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_seg")
    private String codSeg;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_seg")
    @Temporal(TemporalType.DATE)
    private Date fecSeg;
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
    @Column(name = "tot_hor")
    @Temporal(TemporalType.TIME)
    private Date totHor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_pro")
    private String codPro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "area")
    private String area;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "jornada")
    private String jornada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nom_ins")
    private String nomIns;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seguimientoProyectos")
    private List<CriteriosSeguimientoProyectos> criteriosSeguimientoProyectosList;
    @JoinColumn(name = "id_usu", referencedColumnName = "id_usu")
    @ManyToOne(optional = false)
    private Usuarios idUsu;
    @JoinColumn(name = "cod_tit_cri", referencedColumnName = "cod_tit_cri")
    @ManyToOne(optional = false)
    private TituloCriterios codTitCri;
    @JoinColumn(name = "cod_cen", referencedColumnName = "cod_cen")
    @ManyToOne(optional = false)
    private CentrosFormacion codCen;
    @JoinColumn(name = "cod_com", referencedColumnName = "cod_com")
    @ManyToOne(optional = false)
    private Competencias codCom;
    @JoinColumn(name = "cod_est_apr", referencedColumnName = "cod_est_apr")
    @ManyToOne(optional = false)
    private EstadosAprendiz codEstApr;
    @JoinColumn(name = "cod_est_jui", referencedColumnName = "cod_est_jui")
    @ManyToOne(optional = false)
    private EstadosJuicio codEstJui;
    @JoinColumn(name = "cod_fas_pro", referencedColumnName = "cod_fas_pro")
    @ManyToOne(optional = false)
    private FasesProyecto codFasPro;
    @JoinColumn(name = "cod_fic", referencedColumnName = "cod_fic")
    @ManyToOne(optional = false)
    private FichasCaracterizacion codFic;
    @JoinColumn(name = "cod_gra_jui", referencedColumnName = "cod_gra_jui")
    @ManyToOne(optional = false)
    private GradosJuicio codGraJui;
    @JoinColumn(name = "cod_niv_for", referencedColumnName = "cod_niv_for")
    @ManyToOne(optional = false)
    private NivelesFormacion codNivFor;
    @JoinColumn(name = "cod_prg", referencedColumnName = "cod_prg")
    @ManyToOne(optional = false)
    private Programas codPrg;
    @JoinColumn(name = "cod_reg", referencedColumnName = "cod_reg")
    @ManyToOne(optional = false)
    private Regionales codReg;
    @JoinColumn(name = "cod_res_apr", referencedColumnName = "cod_res_apr")
    @ManyToOne(optional = false)
    private ResultadosAprendizaje codResApr;
    @JoinColumn(name = "cod_tip_jui", referencedColumnName = "cod_tip_jui")
    @ManyToOne(optional = false)
    private TiposJuicio codTipJui;

    public SeguimientoProyectos() {
    }

    public SeguimientoProyectos(String codSeg) {
        this.codSeg = codSeg;
    }

    public SeguimientoProyectos(String codSeg, Date fecSeg, Date horIni, Date horFin, Date totHor, String codPro, String area, String jornada, String nomIns) {
        this.codSeg = codSeg;
        this.fecSeg = fecSeg;
        this.horIni = horIni;
        this.horFin = horFin;
        this.totHor = totHor;
        this.codPro = codPro;
        this.area = area;
        this.jornada = jornada;
        this.nomIns = nomIns;
    }

    public String getCodSeg() {
        return codSeg;
    }

    public void setCodSeg(String codSeg) {
        this.codSeg = codSeg;
    }

    public Date getFecSeg() {
        return fecSeg;
    }

    public void setFecSeg(Date fecSeg) {
        this.fecSeg = fecSeg;
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

    public Date getTotHor() {
        return totHor;
    }

    public void setTotHor(Date totHor) {
        this.totHor = totHor;
    }

    public String getCodPro() {
        return codPro;
    }

    public void setCodPro(String codPro) {
        this.codPro = codPro;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    public String getNomIns() {
        return nomIns;
    }

    public void setNomIns(String nomIns) {
        this.nomIns = nomIns;
    }

    @XmlTransient
    public List<CriteriosSeguimientoProyectos> getCriteriosSeguimientoProyectosList() {
        return criteriosSeguimientoProyectosList;
    }

    public void setCriteriosSeguimientoProyectosList(List<CriteriosSeguimientoProyectos> criteriosSeguimientoProyectosList) {
        this.criteriosSeguimientoProyectosList = criteriosSeguimientoProyectosList;
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

    public CentrosFormacion getCodCen() {
        return codCen;
    }

    public void setCodCen(CentrosFormacion codCen) {
        this.codCen = codCen;
    }

    public Competencias getCodCom() {
        return codCom;
    }

    public void setCodCom(Competencias codCom) {
        this.codCom = codCom;
    }

    public EstadosAprendiz getCodEstApr() {
        return codEstApr;
    }

    public void setCodEstApr(EstadosAprendiz codEstApr) {
        this.codEstApr = codEstApr;
    }

    public EstadosJuicio getCodEstJui() {
        return codEstJui;
    }

    public void setCodEstJui(EstadosJuicio codEstJui) {
        this.codEstJui = codEstJui;
    }

    public FasesProyecto getCodFasPro() {
        return codFasPro;
    }

    public void setCodFasPro(FasesProyecto codFasPro) {
        this.codFasPro = codFasPro;
    }

    public FichasCaracterizacion getCodFic() {
        return codFic;
    }

    public void setCodFic(FichasCaracterizacion codFic) {
        this.codFic = codFic;
    }

    public GradosJuicio getCodGraJui() {
        return codGraJui;
    }

    public void setCodGraJui(GradosJuicio codGraJui) {
        this.codGraJui = codGraJui;
    }

    public NivelesFormacion getCodNivFor() {
        return codNivFor;
    }

    public void setCodNivFor(NivelesFormacion codNivFor) {
        this.codNivFor = codNivFor;
    }

    public Programas getCodPrg() {
        return codPrg;
    }

    public void setCodPrg(Programas codPrg) {
        this.codPrg = codPrg;
    }

    public Regionales getCodReg() {
        return codReg;
    }

    public void setCodReg(Regionales codReg) {
        this.codReg = codReg;
    }

    public ResultadosAprendizaje getCodResApr() {
        return codResApr;
    }

    public void setCodResApr(ResultadosAprendizaje codResApr) {
        this.codResApr = codResApr;
    }

    public TiposJuicio getCodTipJui() {
        return codTipJui;
    }

    public void setCodTipJui(TiposJuicio codTipJui) {
        this.codTipJui = codTipJui;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codSeg != null ? codSeg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeguimientoProyectos)) {
            return false;
        }
        SeguimientoProyectos other = (SeguimientoProyectos) object;
        if ((this.codSeg == null && other.codSeg != null) || (this.codSeg != null && !this.codSeg.equals(other.codSeg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.SeguimientoProyectos[ codSeg=" + codSeg + " ]";
    }
    
}
