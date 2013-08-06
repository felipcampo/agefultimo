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
@Table(name = "llamados_atencion_verbal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LlamadosAtencionVerbal.findAll", query = "SELECT l FROM LlamadosAtencionVerbal l"),
    @NamedQuery(name = "LlamadosAtencionVerbal.findByNumAcc", query = "SELECT l FROM LlamadosAtencionVerbal l WHERE l.numAcc = :numAcc"),
    @NamedQuery(name = "LlamadosAtencionVerbal.findByFecha", query = "SELECT l FROM LlamadosAtencionVerbal l WHERE l.fecha = :fecha")})
public class LlamadosAtencionVerbal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "num_acc")
    private Integer numAcc;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "situacion")
    private String situacion;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "impacto")
    private String impacto;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "compromiso")
    private String compromiso;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "efecto")
    private String efecto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @ManyToMany(mappedBy = "llamadosAtencionVerbalList")
    private List<EstadosMedidasFormativas> estadosMedidasFormativasList;
    @JoinColumn(name = "id_usu", referencedColumnName = "id_usu")
    @ManyToOne(optional = false)
    private Usuarios idUsu;
    @JoinColumn(name = "cod_fic", referencedColumnName = "cod_fic")
    @ManyToOne(optional = false)
    private FichasCaracterizacion codFic;

    public LlamadosAtencionVerbal() {
    }

    public LlamadosAtencionVerbal(Integer numAcc) {
        this.numAcc = numAcc;
    }

    public LlamadosAtencionVerbal(Integer numAcc, String situacion, String descripcion, String impacto, String compromiso, String efecto, Date fecha) {
        this.numAcc = numAcc;
        this.situacion = situacion;
        this.descripcion = descripcion;
        this.impacto = impacto;
        this.compromiso = compromiso;
        this.efecto = efecto;
        this.fecha = fecha;
    }

    public Integer getNumAcc() {
        return numAcc;
    }

    public void setNumAcc(Integer numAcc) {
        this.numAcc = numAcc;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImpacto() {
        return impacto;
    }

    public void setImpacto(String impacto) {
        this.impacto = impacto;
    }

    public String getCompromiso() {
        return compromiso;
    }

    public void setCompromiso(String compromiso) {
        this.compromiso = compromiso;
    }

    public String getEfecto() {
        return efecto;
    }

    public void setEfecto(String efecto) {
        this.efecto = efecto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @XmlTransient
    public List<EstadosMedidasFormativas> getEstadosMedidasFormativasList() {
        return estadosMedidasFormativasList;
    }

    public void setEstadosMedidasFormativasList(List<EstadosMedidasFormativas> estadosMedidasFormativasList) {
        this.estadosMedidasFormativasList = estadosMedidasFormativasList;
    }

    public Usuarios getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(Usuarios idUsu) {
        this.idUsu = idUsu;
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
        hash += (numAcc != null ? numAcc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LlamadosAtencionVerbal)) {
            return false;
        }
        LlamadosAtencionVerbal other = (LlamadosAtencionVerbal) object;
        if ((this.numAcc == null && other.numAcc != null) || (this.numAcc != null && !this.numAcc.equals(other.numAcc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.LlamadosAtencionVerbal[ numAcc=" + numAcc + " ]";
    }
    
}
