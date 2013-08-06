/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "fichas_usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FichasUsuarios.findAll", query = "SELECT f FROM FichasUsuarios f"),
    @NamedQuery(name = "FichasUsuarios.findByCodFic", query = "SELECT f FROM FichasUsuarios f WHERE f.fichasUsuariosPK.codFic = :codFic"),
    @NamedQuery(name = "FichasUsuarios.findByIdUsu", query = "SELECT f FROM FichasUsuarios f WHERE f.fichasUsuariosPK.idUsu = :idUsu")})
public class FichasUsuarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FichasUsuariosPK fichasUsuariosPK;
    @JoinColumn(name = "id_usu", referencedColumnName = "id_usu", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuarios usuarios;
    @JoinColumn(name = "cod_fic", referencedColumnName = "cod_fic", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private FichasCaracterizacion fichasCaracterizacion;
    @JoinColumn(name = "cod_est_apr", referencedColumnName = "cod_est_apr")
    @ManyToOne(optional = false)
    private EstadosAprendiz codEstApr;

    public FichasUsuarios() {
    }

    public FichasUsuarios(FichasUsuariosPK fichasUsuariosPK) {
        this.fichasUsuariosPK = fichasUsuariosPK;
    }

    public FichasUsuarios(int codFic, int idUsu) {
        this.fichasUsuariosPK = new FichasUsuariosPK(codFic, idUsu);
    }

    public FichasUsuariosPK getFichasUsuariosPK() {
        return fichasUsuariosPK;
    }

    public void setFichasUsuariosPK(FichasUsuariosPK fichasUsuariosPK) {
        this.fichasUsuariosPK = fichasUsuariosPK;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public FichasCaracterizacion getFichasCaracterizacion() {
        return fichasCaracterizacion;
    }

    public void setFichasCaracterizacion(FichasCaracterizacion fichasCaracterizacion) {
        this.fichasCaracterizacion = fichasCaracterizacion;
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
        hash += (fichasUsuariosPK != null ? fichasUsuariosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FichasUsuarios)) {
            return false;
        }
        FichasUsuarios other = (FichasUsuarios) object;
        if ((this.fichasUsuariosPK == null && other.fichasUsuariosPK != null) || (this.fichasUsuariosPK != null && !this.fichasUsuariosPK.equals(other.fichasUsuariosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.FichasUsuarios[ fichasUsuariosPK=" + fichasUsuariosPK + " ]";
    }
    
}
