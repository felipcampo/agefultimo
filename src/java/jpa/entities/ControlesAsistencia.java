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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "controles_asistencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ControlesAsistencia.findAll", query = "SELECT c FROM ControlesAsistencia c"),
    @NamedQuery(name = "ControlesAsistencia.findByFecAsi", query = "SELECT c FROM ControlesAsistencia c WHERE c.fecAsi = :fecAsi"),
    @NamedQuery(name = "ControlesAsistencia.findByAsistencia", query = "SELECT c FROM ControlesAsistencia c WHERE c.asistencia = :asistencia"),
    @NamedQuery(name = "ControlesAsistencia.findByIdConAsi", query = "SELECT c FROM ControlesAsistencia c WHERE c.idConAsi = :idConAsi")})
public class ControlesAsistencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_asi")
    @Temporal(TemporalType.DATE)
    private Date fecAsi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "asistencia")
    private boolean asistencia;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_con_asi")
    private Integer idConAsi;
    @JoinColumn(name = "id_usu2", referencedColumnName = "id_usu")
    @ManyToOne(optional = false)
    private Usuarios idUsu2;
    @JoinColumn(name = "id_usu1", referencedColumnName = "id_usu")
    @ManyToOne(optional = false)
    private Usuarios idUsu1;
    @JoinColumn(name = "id_usu", referencedColumnName = "id_usu")
    @ManyToOne(optional = false)
    private Usuarios idUsu;
    @JoinColumn(name = "cod_fic", referencedColumnName = "cod_fic")
    @ManyToOne(optional = false)
    private FichasCaracterizacion codFic;
    @JoinColumn(name = "cod_est_apr", referencedColumnName = "cod_est_apr")
    @ManyToOne(optional = false)
    private EstadosAprendiz codEstApr;

    public ControlesAsistencia() {
    }

    public ControlesAsistencia(Integer idConAsi) {
        this.idConAsi = idConAsi;
    }

    public ControlesAsistencia(Integer idConAsi, Date fecAsi, boolean asistencia) {
        this.idConAsi = idConAsi;
        this.fecAsi = fecAsi;
        this.asistencia = asistencia;
    }

    public Date getFecAsi() {
        return fecAsi;
    }

    public void setFecAsi(Date fecAsi) {
        this.fecAsi = fecAsi;
    }

    public boolean getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(boolean asistencia) {
        this.asistencia = asistencia;
    }

    public Integer getIdConAsi() {
        return idConAsi;
    }

    public void setIdConAsi(Integer idConAsi) {
        this.idConAsi = idConAsi;
    }

    public Usuarios getIdUsu2() {
        return idUsu2;
    }

    public void setIdUsu2(Usuarios idUsu2) {
        this.idUsu2 = idUsu2;
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

    public FichasCaracterizacion getCodFic() {
        return codFic;
    }

    public void setCodFic(FichasCaracterizacion codFic) {
        this.codFic = codFic;
    }

    public EstadosAprendiz getCodEstApr() {
        return codEstApr;
    }

    public void setCodEstApr(EstadosAprendiz codEstApr) {
        this.codEstApr = codEstApr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConAsi != null ? idConAsi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ControlesAsistencia)) {
            return false;
        }
        ControlesAsistencia other = (ControlesAsistencia) object;
        if ((this.idConAsi == null && other.idConAsi != null) || (this.idConAsi != null && !this.idConAsi.equals(other.idConAsi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.ControlesAsistencia[ idConAsi=" + idConAsi + " ]";
    }
    
}
