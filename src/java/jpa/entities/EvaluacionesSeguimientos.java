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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "evaluaciones_seguimientos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EvaluacionesSeguimientos.findAll", query = "SELECT e FROM EvaluacionesSeguimientos e"),
    @NamedQuery(name = "EvaluacionesSeguimientos.findByMedio", query = "SELECT e FROM EvaluacionesSeguimientos e WHERE e.medio = :medio"),
    @NamedQuery(name = "EvaluacionesSeguimientos.findByTipo", query = "SELECT e FROM EvaluacionesSeguimientos e WHERE e.tipo = :tipo"),
    @NamedQuery(name = "EvaluacionesSeguimientos.findByFecIni", query = "SELECT e FROM EvaluacionesSeguimientos e WHERE e.fecIni = :fecIni"),
    @NamedQuery(name = "EvaluacionesSeguimientos.findByFecFin", query = "SELECT e FROM EvaluacionesSeguimientos e WHERE e.fecFin = :fecFin"),
    @NamedQuery(name = "EvaluacionesSeguimientos.findByFecRecEvi", query = "SELECT e FROM EvaluacionesSeguimientos e WHERE e.fecRecEvi = :fecRecEvi"),
    @NamedQuery(name = "EvaluacionesSeguimientos.findByAutenticidad", query = "SELECT e FROM EvaluacionesSeguimientos e WHERE e.autenticidad = :autenticidad"),
    @NamedQuery(name = "EvaluacionesSeguimientos.findByCalidad", query = "SELECT e FROM EvaluacionesSeguimientos e WHERE e.calidad = :calidad"),
    @NamedQuery(name = "EvaluacionesSeguimientos.findByPertinencia", query = "SELECT e FROM EvaluacionesSeguimientos e WHERE e.pertinencia = :pertinencia"),
    @NamedQuery(name = "EvaluacionesSeguimientos.findByVigencia", query = "SELECT e FROM EvaluacionesSeguimientos e WHERE e.vigencia = :vigencia"),
    @NamedQuery(name = "EvaluacionesSeguimientos.findByAprendizaje", query = "SELECT e FROM EvaluacionesSeguimientos e WHERE e.aprendizaje = :aprendizaje"),
    @NamedQuery(name = "EvaluacionesSeguimientos.findByFirApr", query = "SELECT e FROM EvaluacionesSeguimientos e WHERE e.firApr = :firApr"),
    @NamedQuery(name = "EvaluacionesSeguimientos.findByFirIns", query = "SELECT e FROM EvaluacionesSeguimientos e WHERE e.firIns = :firIns"),
    @NamedQuery(name = "EvaluacionesSeguimientos.findByCodEvaSeg", query = "SELECT e FROM EvaluacionesSeguimientos e WHERE e.codEvaSeg = :codEvaSeg")})
public class EvaluacionesSeguimientos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "observaciones")
    private String observaciones;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "car_apr")
    private String carApr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "medio")
    private String medio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tipo")
    private String tipo;
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
    @Column(name = "fec_rec_evi")
    @Temporal(TemporalType.DATE)
    private Date fecRecEvi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "autenticidad")
    private boolean autenticidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "calidad")
    private boolean calidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pertinencia")
    private boolean pertinencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vigencia")
    private boolean vigencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "aprendizaje")
    private boolean aprendizaje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "fir_apr")
    private String firApr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "fir_ins")
    private String firIns;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_eva_seg")
    private Integer codEvaSeg;
    @JoinColumn(name = "cod_act_pro", referencedColumnName = "cod_act_pro")
    @ManyToOne(optional = false)
    private ActividadesProyecto codActPro;
    @JoinColumn(name = "cod_res_apr", referencedColumnName = "cod_res_apr")
    @ManyToOne(optional = false)
    private ResultadosAprendizaje codResApr;
    @JoinColumn(name = "cod_fic", referencedColumnName = "cod_fic")
    @ManyToOne(optional = false)
    private FichasCaracterizacion codFic;
    @JoinColumn(name = "id_usu1", referencedColumnName = "id_usu")
    @ManyToOne(optional = false)
    private Usuarios idUsu1;
    @JoinColumn(name = "id_usu", referencedColumnName = "id_usu")
    @ManyToOne(optional = false)
    private Usuarios idUsu;
    @JoinColumn(name = "cod_evi_apr", referencedColumnName = "cod_evi_apr")
    @ManyToOne(optional = false)
    private EvidenciasAprendizaje codEviApr;

    public EvaluacionesSeguimientos() {
    }

    public EvaluacionesSeguimientos(Integer codEvaSeg) {
        this.codEvaSeg = codEvaSeg;
    }

    public EvaluacionesSeguimientos(Integer codEvaSeg, String observaciones, String carApr, String medio, String tipo, Date fecIni, Date fecFin, Date fecRecEvi, boolean autenticidad, boolean calidad, boolean pertinencia, boolean vigencia, boolean aprendizaje, String firApr, String firIns) {
        this.codEvaSeg = codEvaSeg;
        this.observaciones = observaciones;
        this.carApr = carApr;
        this.medio = medio;
        this.tipo = tipo;
        this.fecIni = fecIni;
        this.fecFin = fecFin;
        this.fecRecEvi = fecRecEvi;
        this.autenticidad = autenticidad;
        this.calidad = calidad;
        this.pertinencia = pertinencia;
        this.vigencia = vigencia;
        this.aprendizaje = aprendizaje;
        this.firApr = firApr;
        this.firIns = firIns;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getCarApr() {
        return carApr;
    }

    public void setCarApr(String carApr) {
        this.carApr = carApr;
    }

    public String getMedio() {
        return medio;
    }

    public void setMedio(String medio) {
        this.medio = medio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public Date getFecRecEvi() {
        return fecRecEvi;
    }

    public void setFecRecEvi(Date fecRecEvi) {
        this.fecRecEvi = fecRecEvi;
    }

    public boolean getAutenticidad() {
        return autenticidad;
    }

    public void setAutenticidad(boolean autenticidad) {
        this.autenticidad = autenticidad;
    }

    public boolean getCalidad() {
        return calidad;
    }

    public void setCalidad(boolean calidad) {
        this.calidad = calidad;
    }

    public boolean getPertinencia() {
        return pertinencia;
    }

    public void setPertinencia(boolean pertinencia) {
        this.pertinencia = pertinencia;
    }

    public boolean getVigencia() {
        return vigencia;
    }

    public void setVigencia(boolean vigencia) {
        this.vigencia = vigencia;
    }

    public boolean getAprendizaje() {
        return aprendizaje;
    }

    public void setAprendizaje(boolean aprendizaje) {
        this.aprendizaje = aprendizaje;
    }

    public String getFirApr() {
        return firApr;
    }

    public void setFirApr(String firApr) {
        this.firApr = firApr;
    }

    public String getFirIns() {
        return firIns;
    }

    public void setFirIns(String firIns) {
        this.firIns = firIns;
    }

    public Integer getCodEvaSeg() {
        return codEvaSeg;
    }

    public void setCodEvaSeg(Integer codEvaSeg) {
        this.codEvaSeg = codEvaSeg;
    }

    public ActividadesProyecto getCodActPro() {
        return codActPro;
    }

    public void setCodActPro(ActividadesProyecto codActPro) {
        this.codActPro = codActPro;
    }

    public ResultadosAprendizaje getCodResApr() {
        return codResApr;
    }

    public void setCodResApr(ResultadosAprendizaje codResApr) {
        this.codResApr = codResApr;
    }

    public FichasCaracterizacion getCodFic() {
        return codFic;
    }

    public void setCodFic(FichasCaracterizacion codFic) {
        this.codFic = codFic;
    }

    public Usuarios getIdUsu1() {
        return idUsu1;
    }

    public void setIdUsu1(Usuarios idUsu1) {
        this.idUsu1 = idUsu1;
    }

    public Usuarios getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(Usuarios idUsu) {
        this.idUsu = idUsu;
    }

    public EvidenciasAprendizaje getCodEviApr() {
        return codEviApr;
    }

    public void setCodEviApr(EvidenciasAprendizaje codEviApr) {
        this.codEviApr = codEviApr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEvaSeg != null ? codEvaSeg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaluacionesSeguimientos)) {
            return false;
        }
        EvaluacionesSeguimientos other = (EvaluacionesSeguimientos) object;
        if ((this.codEvaSeg == null && other.codEvaSeg != null) || (this.codEvaSeg != null && !this.codEvaSeg.equals(other.codEvaSeg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.EvaluacionesSeguimientos[ codEvaSeg=" + codEvaSeg + " ]";
    }
    
}
