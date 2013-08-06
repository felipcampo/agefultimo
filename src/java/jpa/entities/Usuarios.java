/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findByIdUsu", query = "SELECT u FROM Usuarios u WHERE u.idUsu = :idUsu"),
    @NamedQuery(name = "Usuarios.findByTipDoc", query = "SELECT u FROM Usuarios u WHERE u.tipDoc = :tipDoc"),
    @NamedQuery(name = "Usuarios.findByNomUsu", query = "SELECT u FROM Usuarios u WHERE u.nomUsu = :nomUsu"),
    @NamedQuery(name = "Usuarios.findByTelUsu", query = "SELECT u FROM Usuarios u WHERE u.telUsu = :telUsu"),
    @NamedQuery(name = "Usuarios.findByDirUsu", query = "SELECT u FROM Usuarios u WHERE u.dirUsu = :dirUsu"),
    @NamedQuery(name = "Usuarios.findByMailUsu", query = "SELECT u FROM Usuarios u WHERE u.mailUsu = :mailUsu"),
    @NamedQuery(name = "Usuarios.findByTipCon", query = "SELECT u FROM Usuarios u WHERE u.tipCon = :tipCon"),
    @NamedQuery(name = "Usuarios.findByApeUsu", query = "SELECT u FROM Usuarios u WHERE u.apeUsu = :apeUsu"),
    @NamedQuery(name = "Usuarios.findByFirUsu", query = "SELECT u FROM Usuarios u WHERE u.firUsu = :firUsu"),
    @NamedQuery(name = "Usuarios.findByIniUsu", query = "SELECT u FROM Usuarios u WHERE u.iniUsu = :iniUsu")})
public class Usuarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usu")
    private Integer idUsu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "tip_doc")
    private String tipDoc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nom_usu")
    private String nomUsu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tel_usu")
    private long telUsu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "dir_usu")
    private String dirUsu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "mail_usu")
    private String mailUsu;
    @Size(max = 20)
    @Column(name = "tip_con")
    private String tipCon;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ape_usu")
    private String apeUsu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "fir_usu")
    private String firUsu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "ini_usu")
    private String iniUsu;
    @ManyToMany(mappedBy = "usuariosList")
    private List<Remisiones> remisionesList;
    @ManyToMany(mappedBy = "usuariosList")
    private List<Roles> rolesList;
    @JoinTable(name = "usuarios_controles", joinColumns = {
        @JoinColumn(name = "id_usu", referencedColumnName = "id_usu")}, inverseJoinColumns = {
        @JoinColumn(name = "num_con_ope", referencedColumnName = "num_con_ope")})
    @ManyToMany
    private List<ControlesOperativos> controlesOperativosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsu1")
    private List<EvaluacionesSeguimientos> evaluacionesSeguimientosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsu")
    private List<EvaluacionesSeguimientos> evaluacionesSeguimientosList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsu")
    private List<MedidasFormativas> medidasFormativasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsu")
    private List<ContratosProyectos> contratosProyectosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsu")
    private List<MatrizCaracterizacion> matrizCaracterizacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsu")
    private List<LlamadosAtencionVerbal> llamadosAtencionVerbalList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarios")
    private List<FichasUsuarios> fichasUsuariosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsu")
    private List<Comites> comitesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsu")
    private List<ReportesNovedades> reportesNovedadesList;
    @JoinColumn(name = "cod_bar", referencedColumnName = "cod_bar")
    @ManyToOne(optional = false)
    private Barrios codBar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsu")
    private List<PraxisPedagogica> praxisPedagogicaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsu")
    private List<PlanesMejoramiento> planesMejoramientoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsu")
    private List<SeguimientoInstructores> seguimientoInstructoresList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsu")
    private List<Alistamientos> alistamientosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsu")
    private List<SeguimientoProyectos> seguimientoProyectosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsu")
    private List<EstadosAspirantes> estadosAspirantesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsu")
    private List<SeguimientosProductiva> seguimientosProductivaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsu")
    private List<ControlAprendiz> controlAprendizList;

    public Usuarios() {
    }

    public Usuarios(Integer idUsu) {
        this.idUsu = idUsu;
    }

    public Usuarios(Integer idUsu, String tipDoc, String nomUsu, long telUsu, String dirUsu, String mailUsu, String apeUsu, String firUsu, String iniUsu) {
        this.idUsu = idUsu;
        this.tipDoc = tipDoc;
        this.nomUsu = nomUsu;
        this.telUsu = telUsu;
        this.dirUsu = dirUsu;
        this.mailUsu = mailUsu;
        this.apeUsu = apeUsu;
        this.firUsu = firUsu;
        this.iniUsu = iniUsu;
    }

    public Integer getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(Integer idUsu) {
        this.idUsu = idUsu;
    }

    public String getTipDoc() {
        return tipDoc;
    }

    public void setTipDoc(String tipDoc) {
        this.tipDoc = tipDoc;
    }

    public String getNomUsu() {
        return nomUsu;
    }

    public void setNomUsu(String nomUsu) {
        this.nomUsu = nomUsu;
    }

    public long getTelUsu() {
        return telUsu;
    }

    public void setTelUsu(long telUsu) {
        this.telUsu = telUsu;
    }

    public String getDirUsu() {
        return dirUsu;
    }

    public void setDirUsu(String dirUsu) {
        this.dirUsu = dirUsu;
    }

    public String getMailUsu() {
        return mailUsu;
    }

    public void setMailUsu(String mailUsu) {
        this.mailUsu = mailUsu;
    }

    public String getTipCon() {
        return tipCon;
    }

    public void setTipCon(String tipCon) {
        this.tipCon = tipCon;
    }

    public String getApeUsu() {
        return apeUsu;
    }

    public void setApeUsu(String apeUsu) {
        this.apeUsu = apeUsu;
    }

    public String getFirUsu() {
        return firUsu;
    }

    public void setFirUsu(String firUsu) {
        this.firUsu = firUsu;
    }

    public String getIniUsu() {
        return iniUsu;
    }

    public void setIniUsu(String iniUsu) {
        this.iniUsu = iniUsu;
    }

    @XmlTransient
    public List<Remisiones> getRemisionesList() {
        return remisionesList;
    }

    public void setRemisionesList(List<Remisiones> remisionesList) {
        this.remisionesList = remisionesList;
    }

    @XmlTransient
    public List<Roles> getRolesList() {
        return rolesList;
    }

    public void setRolesList(List<Roles> rolesList) {
        this.rolesList = rolesList;
    }

    @XmlTransient
    public List<ControlesOperativos> getControlesOperativosList() {
        return controlesOperativosList;
    }

    public void setControlesOperativosList(List<ControlesOperativos> controlesOperativosList) {
        this.controlesOperativosList = controlesOperativosList;
    }

    @XmlTransient
    public List<EvaluacionesSeguimientos> getEvaluacionesSeguimientosList() {
        return evaluacionesSeguimientosList;
    }

    public void setEvaluacionesSeguimientosList(List<EvaluacionesSeguimientos> evaluacionesSeguimientosList) {
        this.evaluacionesSeguimientosList = evaluacionesSeguimientosList;
    }

    @XmlTransient
    public List<EvaluacionesSeguimientos> getEvaluacionesSeguimientosList1() {
        return evaluacionesSeguimientosList1;
    }

    public void setEvaluacionesSeguimientosList1(List<EvaluacionesSeguimientos> evaluacionesSeguimientosList1) {
        this.evaluacionesSeguimientosList1 = evaluacionesSeguimientosList1;
    }

    @XmlTransient
    public List<MedidasFormativas> getMedidasFormativasList() {
        return medidasFormativasList;
    }

    public void setMedidasFormativasList(List<MedidasFormativas> medidasFormativasList) {
        this.medidasFormativasList = medidasFormativasList;
    }

    @XmlTransient
    public List<ContratosProyectos> getContratosProyectosList() {
        return contratosProyectosList;
    }

    public void setContratosProyectosList(List<ContratosProyectos> contratosProyectosList) {
        this.contratosProyectosList = contratosProyectosList;
    }

    @XmlTransient
    public List<MatrizCaracterizacion> getMatrizCaracterizacionList() {
        return matrizCaracterizacionList;
    }

    public void setMatrizCaracterizacionList(List<MatrizCaracterizacion> matrizCaracterizacionList) {
        this.matrizCaracterizacionList = matrizCaracterizacionList;
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

    public Barrios getCodBar() {
        return codBar;
    }

    public void setCodBar(Barrios codBar) {
        this.codBar = codBar;
    }

    @XmlTransient
    public List<PraxisPedagogica> getPraxisPedagogicaList() {
        return praxisPedagogicaList;
    }

    public void setPraxisPedagogicaList(List<PraxisPedagogica> praxisPedagogicaList) {
        this.praxisPedagogicaList = praxisPedagogicaList;
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
    public List<Alistamientos> getAlistamientosList() {
        return alistamientosList;
    }

    public void setAlistamientosList(List<Alistamientos> alistamientosList) {
        this.alistamientosList = alistamientosList;
    }

    @XmlTransient
    public List<SeguimientoProyectos> getSeguimientoProyectosList() {
        return seguimientoProyectosList;
    }

    public void setSeguimientoProyectosList(List<SeguimientoProyectos> seguimientoProyectosList) {
        this.seguimientoProyectosList = seguimientoProyectosList;
    }

    @XmlTransient
    public List<EstadosAspirantes> getEstadosAspirantesList() {
        return estadosAspirantesList;
    }

    public void setEstadosAspirantesList(List<EstadosAspirantes> estadosAspirantesList) {
        this.estadosAspirantesList = estadosAspirantesList;
    }

    @XmlTransient
    public List<SeguimientosProductiva> getSeguimientosProductivaList() {
        return seguimientosProductivaList;
    }

    public void setSeguimientosProductivaList(List<SeguimientosProductiva> seguimientosProductivaList) {
        this.seguimientosProductivaList = seguimientosProductivaList;
    }

    @XmlTransient
    public List<ControlAprendiz> getControlAprendizList() {
        return controlAprendizList;
    }

    public void setControlAprendizList(List<ControlAprendiz> controlAprendizList) {
        this.controlAprendizList = controlAprendizList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsu != null ? idUsu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.idUsu == null && other.idUsu != null) || (this.idUsu != null && !this.idUsu.equals(other.idUsu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Usuarios[ idUsu=" + idUsu + " ]";
    }
    
}
