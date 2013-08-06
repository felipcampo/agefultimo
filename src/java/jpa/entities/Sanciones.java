/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "sanciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sanciones.findAll", query = "SELECT s FROM Sanciones s"),
    @NamedQuery(name = "Sanciones.findByCodSan", query = "SELECT s FROM Sanciones s WHERE s.codSan = :codSan"),
    @NamedQuery(name = "Sanciones.findByNomSan", query = "SELECT s FROM Sanciones s WHERE s.nomSan = :nomSan")})
public class Sanciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "cod_san")
    private String codSan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nom_san")
    @Temporal(TemporalType.DATE)
    private Date nomSan;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codSan")
    private List<Comites> comitesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codSan")
    private List<Faltas> faltasList;

    public Sanciones() {
    }

    public Sanciones(String codSan) {
        this.codSan = codSan;
    }

    public Sanciones(String codSan, Date nomSan) {
        this.codSan = codSan;
        this.nomSan = nomSan;
    }

    public String getCodSan() {
        return codSan;
    }

    public void setCodSan(String codSan) {
        this.codSan = codSan;
    }

    public Date getNomSan() {
        return nomSan;
    }

    public void setNomSan(Date nomSan) {
        this.nomSan = nomSan;
    }

    @XmlTransient
    public List<Comites> getComitesList() {
        return comitesList;
    }

    public void setComitesList(List<Comites> comitesList) {
        this.comitesList = comitesList;
    }

    @XmlTransient
    public List<Faltas> getFaltasList() {
        return faltasList;
    }

    public void setFaltasList(List<Faltas> faltasList) {
        this.faltasList = faltasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codSan != null ? codSan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sanciones)) {
            return false;
        }
        Sanciones other = (Sanciones) object;
        if ((this.codSan == null && other.codSan != null) || (this.codSan != null && !this.codSan.equals(other.codSan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Sanciones[ codSan=" + codSan + " ]";
    }
    
}
