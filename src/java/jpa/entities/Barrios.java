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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "barrios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Barrios.findAll", query = "SELECT b FROM Barrios b"),
    @NamedQuery(name = "Barrios.findByCodBar", query = "SELECT b FROM Barrios b WHERE b.codBar = :codBar"),
    @NamedQuery(name = "Barrios.findByNomBar", query = "SELECT b FROM Barrios b WHERE b.nomBar = :nomBar")})
public class Barrios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_bar")
    private Integer codBar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nom_bar")
    private String nomBar;
    @JoinColumn(name = "num_com", referencedColumnName = "num_com")
    @ManyToOne(optional = false)
    private Comunas numCom;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codBar")
    private List<Usuarios> usuariosList;

    public Barrios() {
    }

    public Barrios(Integer codBar) {
        this.codBar = codBar;
    }

    public Barrios(Integer codBar, String nomBar) {
        this.codBar = codBar;
        this.nomBar = nomBar;
    }

    public Integer getCodBar() {
        return codBar;
    }

    public void setCodBar(Integer codBar) {
        this.codBar = codBar;
    }

    public String getNomBar() {
        return nomBar;
    }

    public void setNomBar(String nomBar) {
        this.nomBar = nomBar;
    }

    public Comunas getNumCom() {
        return numCom;
    }

    public void setNumCom(Comunas numCom) {
        this.numCom = numCom;
    }

    @XmlTransient
    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codBar != null ? codBar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Barrios)) {
            return false;
        }
        Barrios other = (Barrios) object;
        if ((this.codBar == null && other.codBar != null) || (this.codBar != null && !this.codBar.equals(other.codBar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Barrios[ codBar=" + codBar + " ]";
    }
    
}
