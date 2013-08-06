/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Usuario
 */
@Embeddable
public class FichasUsuariosPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_fic")
    private int codFic;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usu")
    private int idUsu;

    public FichasUsuariosPK() {
    }

    public FichasUsuariosPK(int codFic, int idUsu) {
        this.codFic = codFic;
        this.idUsu = idUsu;
    }

    public int getCodFic() {
        return codFic;
    }

    public void setCodFic(int codFic) {
        this.codFic = codFic;
    }

    public int getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(int idUsu) {
        this.idUsu = idUsu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codFic;
        hash += (int) idUsu;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FichasUsuariosPK)) {
            return false;
        }
        FichasUsuariosPK other = (FichasUsuariosPK) object;
        if (this.codFic != other.codFic) {
            return false;
        }
        if (this.idUsu != other.idUsu) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.FichasUsuariosPK[ codFic=" + codFic + ", idUsu=" + idUsu + " ]";
    }
    
}
