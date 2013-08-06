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
@Table(name = "matriz_caracterizacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MatrizCaracterizacion.findAll", query = "SELECT m FROM MatrizCaracterizacion m"),
    @NamedQuery(name = "MatrizCaracterizacion.findByCodMatCar", query = "SELECT m FROM MatrizCaracterizacion m WHERE m.codMatCar = :codMatCar"),
    @NamedQuery(name = "MatrizCaracterizacion.findByMedicamentos", query = "SELECT m FROM MatrizCaracterizacion m WHERE m.medicamentos = :medicamentos"),
    @NamedQuery(name = "MatrizCaracterizacion.findByAlergias", query = "SELECT m FROM MatrizCaracterizacion m WHERE m.alergias = :alergias"),
    @NamedQuery(name = "MatrizCaracterizacion.findByTipAle", query = "SELECT m FROM MatrizCaracterizacion m WHERE m.tipAle = :tipAle"),
    @NamedQuery(name = "MatrizCaracterizacion.findByGenero", query = "SELECT m FROM MatrizCaracterizacion m WHERE m.genero = :genero"),
    @NamedQuery(name = "MatrizCaracterizacion.findByEstCiv", query = "SELECT m FROM MatrizCaracterizacion m WHERE m.estCiv = :estCiv"),
    @NamedQuery(name = "MatrizCaracterizacion.findByFecNac", query = "SELECT m FROM MatrizCaracterizacion m WHERE m.fecNac = :fecNac")})
public class MatrizCaracterizacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "cod_mat_car")
    private String codMatCar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "medicamentos")
    private boolean medicamentos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "alergias")
    private boolean alergias;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tip_ale")
    private String tipAle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "genero")
    private String genero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "est_civ")
    private String estCiv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_nac")
    @Temporal(TemporalType.DATE)
    private Date fecNac;
    @JoinColumn(name = "id_usu", referencedColumnName = "id_usu")
    @ManyToOne(optional = false)
    private Usuarios idUsu;
    @JoinColumn(name = "cod_apo", referencedColumnName = "cod_apo")
    @ManyToOne(optional = false)
    private Aportantes codApo;
    @JoinColumn(name = "cod_car_pob", referencedColumnName = "cod_car_pob")
    @ManyToOne(optional = false)
    private CaracterizacionesPoblacion codCarPob;
    @JoinColumn(name = "cod_clu", referencedColumnName = "cod_clu")
    @ManyToOne(optional = false)
    private Clubes codClu;
    @JoinColumn(name = "cod_eps", referencedColumnName = "cod_eps")
    @ManyToOne(optional = false)
    private Eps codEps;
    @JoinColumn(name = "cod_esc", referencedColumnName = "cod_esc")
    @ManyToOne(optional = false)
    private Escolaridades codEsc;
    @JoinColumn(name = "cod_fic", referencedColumnName = "cod_fic")
    @ManyToOne(optional = false)
    private FichasCaracterizacion codFic;
    @JoinColumn(name = "cod_ips", referencedColumnName = "cod_ips")
    @ManyToOne(optional = false)
    private Ips codIps;
    @JoinColumn(name = "cod_nuc_fam", referencedColumnName = "cod_nuc_fam")
    @ManyToOne(optional = false)
    private NucleosFamiliares codNucFam;
    @JoinColumn(name = "cod_ocu", referencedColumnName = "cod_ocu")
    @ManyToOne(optional = false)
    private Ocupaciones codOcu;
    @JoinColumn(name = "cod_tip_fam", referencedColumnName = "cod_tip_fam")
    @ManyToOne(optional = false)
    private TiposFamilia codTipFam;
    @JoinColumn(name = "cod_tip_san", referencedColumnName = "cod_tip_san")
    @ManyToOne(optional = false)
    private TiposSangre codTipSan;
    @JoinColumn(name = "cod_tip_viv", referencedColumnName = "cod_tip_viv")
    @ManyToOne(optional = false)
    private TiposVivienda codTipViv;

    public MatrizCaracterizacion() {
    }

    public MatrizCaracterizacion(String codMatCar) {
        this.codMatCar = codMatCar;
    }

    public MatrizCaracterizacion(String codMatCar, boolean medicamentos, boolean alergias, String tipAle, String genero, String estCiv, Date fecNac) {
        this.codMatCar = codMatCar;
        this.medicamentos = medicamentos;
        this.alergias = alergias;
        this.tipAle = tipAle;
        this.genero = genero;
        this.estCiv = estCiv;
        this.fecNac = fecNac;
    }

    public String getCodMatCar() {
        return codMatCar;
    }

    public void setCodMatCar(String codMatCar) {
        this.codMatCar = codMatCar;
    }

    public boolean getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(boolean medicamentos) {
        this.medicamentos = medicamentos;
    }

    public boolean getAlergias() {
        return alergias;
    }

    public void setAlergias(boolean alergias) {
        this.alergias = alergias;
    }

    public String getTipAle() {
        return tipAle;
    }

    public void setTipAle(String tipAle) {
        this.tipAle = tipAle;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEstCiv() {
        return estCiv;
    }

    public void setEstCiv(String estCiv) {
        this.estCiv = estCiv;
    }

    public Date getFecNac() {
        return fecNac;
    }

    public void setFecNac(Date fecNac) {
        this.fecNac = fecNac;
    }

    public Usuarios getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(Usuarios idUsu) {
        this.idUsu = idUsu;
    }

    public Aportantes getCodApo() {
        return codApo;
    }

    public void setCodApo(Aportantes codApo) {
        this.codApo = codApo;
    }

    public CaracterizacionesPoblacion getCodCarPob() {
        return codCarPob;
    }

    public void setCodCarPob(CaracterizacionesPoblacion codCarPob) {
        this.codCarPob = codCarPob;
    }

    public Clubes getCodClu() {
        return codClu;
    }

    public void setCodClu(Clubes codClu) {
        this.codClu = codClu;
    }

    public Eps getCodEps() {
        return codEps;
    }

    public void setCodEps(Eps codEps) {
        this.codEps = codEps;
    }

    public Escolaridades getCodEsc() {
        return codEsc;
    }

    public void setCodEsc(Escolaridades codEsc) {
        this.codEsc = codEsc;
    }

    public FichasCaracterizacion getCodFic() {
        return codFic;
    }

    public void setCodFic(FichasCaracterizacion codFic) {
        this.codFic = codFic;
    }

    public Ips getCodIps() {
        return codIps;
    }

    public void setCodIps(Ips codIps) {
        this.codIps = codIps;
    }

    public NucleosFamiliares getCodNucFam() {
        return codNucFam;
    }

    public void setCodNucFam(NucleosFamiliares codNucFam) {
        this.codNucFam = codNucFam;
    }

    public Ocupaciones getCodOcu() {
        return codOcu;
    }

    public void setCodOcu(Ocupaciones codOcu) {
        this.codOcu = codOcu;
    }

    public TiposFamilia getCodTipFam() {
        return codTipFam;
    }

    public void setCodTipFam(TiposFamilia codTipFam) {
        this.codTipFam = codTipFam;
    }

    public TiposSangre getCodTipSan() {
        return codTipSan;
    }

    public void setCodTipSan(TiposSangre codTipSan) {
        this.codTipSan = codTipSan;
    }

    public TiposVivienda getCodTipViv() {
        return codTipViv;
    }

    public void setCodTipViv(TiposVivienda codTipViv) {
        this.codTipViv = codTipViv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codMatCar != null ? codMatCar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MatrizCaracterizacion)) {
            return false;
        }
        MatrizCaracterizacion other = (MatrizCaracterizacion) object;
        if ((this.codMatCar == null && other.codMatCar != null) || (this.codMatCar != null && !this.codMatCar.equals(other.codMatCar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.MatrizCaracterizacion[ codMatCar=" + codMatCar + " ]";
    }
    
}
