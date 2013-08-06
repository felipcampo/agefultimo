/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "remisiones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Remisiones.findAll", query = "SELECT r FROM Remisiones r"),
    @NamedQuery(name = "Remisiones.findByCodRem", query = "SELECT r FROM Remisiones r WHERE r.codRem = :codRem"),
    @NamedQuery(name = "Remisiones.findByNomRem", query = "SELECT r FROM Remisiones r WHERE r.nomRem = :nomRem")})
public class Remisiones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_rem")
    private Integer codRem;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nom_rem")
    private String nomRem;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "des_rem")
    private String desRem;
    @JoinTable(name = "usuarios_remisiones", joinColumns = {
        @JoinColumn(name = "cod_rem", referencedColumnName = "cod_rem")}, inverseJoinColumns = {
        @JoinColumn(name = "id_usu", referencedColumnName = "id_usu")})
    @ManyToMany
    private List<Usuarios> usuariosList;
    @JoinColumn(name = "cod_tip_bie", referencedColumnName = "cod_tip_bie")
    @ManyToOne(optional = false)
    private TiposCasosBienestar codTipBie;

    public Remisiones() {
    }

    public Remisiones(Integer codRem) {
        this.codRem = codRem;
    }

    public Remisiones(Integer codRem, String nomRem, String desRem) {
        this.codRem = codRem;
        this.nomRem = nomRem;
        this.desRem = desRem;
    }

    public Integer getCodRem() {
        return codRem;
    }

    public void setCodRem(Integer codRem) {
        this.codRem = codRem;
    }

    public String getNomRem() {
        return nomRem;
    }

    public void setNomRem(String nomRem) {
        this.nomRem = nomRem;
    }

    public String getDesRem() {
        return desRem;
    }

    public void setDesRem(String desRem) {
        this.desRem = desRem;
    }

    @XmlTransient
    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    public TiposCasosBienestar getCodTipBie() {
        return codTipBie;
    }

    public void setCodTipBie(TiposCasosBienestar codTipBie) {
        this.codTipBie = codTipBie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codRem != null ? codRem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Remisiones)) {
            return false;
        }
        Remisiones other = (Remisiones) object;
        if ((this.codRem == null && other.codRem != null) || (this.codRem != null && !this.codRem.equals(other.codRem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Remisiones[ codRem=" + codRem + " ]";
    }
    
}
