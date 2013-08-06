/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "planes_mejoramiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlanesMejoramiento.findAll", query = "SELECT p FROM PlanesMejoramiento p"),
    @NamedQuery(name = "PlanesMejoramiento.findByCodPlaMej", query = "SELECT p FROM PlanesMejoramiento p WHERE p.codPlaMej = :codPlaMej"),
    @NamedQuery(name = "PlanesMejoramiento.findByEncargado", query = "SELECT p FROM PlanesMejoramiento p WHERE p.encargado = :encargado"),
    @NamedQuery(name = "PlanesMejoramiento.findByFecIni", query = "SELECT p FROM PlanesMejoramiento p WHERE p.fecIni = :fecIni"),
    @NamedQuery(name = "PlanesMejoramiento.findByFecFin", query = "SELECT p FROM PlanesMejoramiento p WHERE p.fecFin = :fecFin"),
    @NamedQuery(name = "PlanesMejoramiento.findByTipPlaMej", query = "SELECT p FROM PlanesMejoramiento p WHERE p.tipPlaMej = :tipPlaMej"),
    @NamedQuery(name = "PlanesMejoramiento.findByFecRev", query = "SELECT p FROM PlanesMejoramiento p WHERE p.fecRev = :fecRev")})
public class PlanesMejoramiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_pla_mej")
    private Integer codPlaMej;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "encargado")
    private String encargado;
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
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "actividades")
    private String actividades;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "tip_pla_mej")
    private String tipPlaMej;
    @Lob
    @Size(max = 65535)
    @Column(name = "evi_cam")
    private String eviCam;
    @Lob
    @Size(max = 65535)
    @Column(name = "recursos")
    private String recursos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_rev")
    @Temporal(TemporalType.DATE)
    private Date fecRev;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @ManyToMany(mappedBy = "planesMejoramientoList")
    private List<EstadosMedidasFormativas> estadosMedidasFormativasList;
    @JoinTable(name = "planes_resultados", joinColumns = {
        @JoinColumn(name = "cod_pla_mej", referencedColumnName = "cod_pla_mej")}, inverseJoinColumns = {
        @JoinColumn(name = "cod_res_apr", referencedColumnName = "cod_res_apr")})
    @ManyToMany
    private List<ResultadosAprendizaje> resultadosAprendizajeList;
    @JoinColumn(name = "id_usu", referencedColumnName = "id_usu")
    @ManyToOne(optional = false)
    private Usuarios idUsu;
    @JoinColumn(name = "cod_fal", referencedColumnName = "cod_fal")
    @ManyToOne
    private Faltas codFal;
    @JoinColumn(name = "cod_fic", referencedColumnName = "cod_fic")
    @ManyToOne(optional = false)
    private FichasCaracterizacion codFic;

    public PlanesMejoramiento() {
    }

    public PlanesMejoramiento(Integer codPlaMej) {
        this.codPlaMej = codPlaMej;
    }

    public PlanesMejoramiento(Integer codPlaMej, String encargado, Date fecIni, Date fecFin, String actividades, String tipPlaMej, Date fecRev, String descripcion) {
        this.codPlaMej = codPlaMej;
        this.encargado = encargado;
        this.fecIni = fecIni;
        this.fecFin = fecFin;
        this.actividades = actividades;
        this.tipPlaMej = tipPlaMej;
        this.fecRev = fecRev;
        this.descripcion = descripcion;
    }

    public Integer getCodPlaMej() {
        return codPlaMej;
    }

    public void setCodPlaMej(Integer codPlaMej) {
        this.codPlaMej = codPlaMej;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
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

    public String getActividades() {
        return actividades;
    }

    public void setActividades(String actividades) {
        this.actividades = actividades;
    }

    public String getTipPlaMej() {
        return tipPlaMej;
    }

    public void setTipPlaMej(String tipPlaMej) {
        this.tipPlaMej = tipPlaMej;
    }

    public String getEviCam() {
        return eviCam;
    }

    public void setEviCam(String eviCam) {
        this.eviCam = eviCam;
    }

    public String getRecursos() {
        return recursos;
    }

    public void setRecursos(String recursos) {
        this.recursos = recursos;
    }

    public Date getFecRev() {
        return fecRev;
    }

    public void setFecRev(Date fecRev) {
        this.fecRev = fecRev;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<EstadosMedidasFormativas> getEstadosMedidasFormativasList() {
        return estadosMedidasFormativasList;
    }

    public void setEstadosMedidasFormativasList(List<EstadosMedidasFormativas> estadosMedidasFormativasList) {
        this.estadosMedidasFormativasList = estadosMedidasFormativasList;
    }

    @XmlTransient
    public List<ResultadosAprendizaje> getResultadosAprendizajeList() {
        return resultadosAprendizajeList;
    }

    public void setResultadosAprendizajeList(List<ResultadosAprendizaje> resultadosAprendizajeList) {
        this.resultadosAprendizajeList = resultadosAprendizajeList;
    }

    public Usuarios getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(Usuarios idUsu) {
        this.idUsu = idUsu;
    }

    public Faltas getCodFal() {
        return codFal;
    }

    public void setCodFal(Faltas codFal) {
        this.codFal = codFal;
    }

    public FichasCaracterizacion getCodFic() {
        return codFic;
    }

    public void setCodFic(FichasCaracterizacion codFic) {
        this.codFic = codFic;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPlaMej != null ? codPlaMej.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanesMejoramiento)) {
            return false;
        }
        PlanesMejoramiento other = (PlanesMejoramiento) object;
        if ((this.codPlaMej == null && other.codPlaMej != null) || (this.codPlaMej != null && !this.codPlaMej.equals(other.codPlaMej))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.PlanesMejoramiento[ codPlaMej=" + codPlaMej + " ]";
    }
    
}
