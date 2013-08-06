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
import javax.persistence.Lob;
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
@Table(name = "alistamientos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alistamientos.findAll", query = "SELECT a FROM Alistamientos a"),
    @NamedQuery(name = "Alistamientos.findByCodAli", query = "SELECT a FROM Alistamientos a WHERE a.codAli = :codAli"),
    @NamedQuery(name = "Alistamientos.findByNomAli", query = "SELECT a FROM Alistamientos a WHERE a.nomAli = :nomAli"),
    @NamedQuery(name = "Alistamientos.findByBibliografia", query = "SELECT a FROM Alistamientos a WHERE a.bibliografia = :bibliografia")})
public class Alistamientos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_ali")
    private String codAli;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "nom_ali")
    private String nomAli;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "bibliografia")
    private String bibliografia;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "rec_did")
    private String recDid;
    @JoinColumn(name = "id_usu", referencedColumnName = "id_usu")
    @ManyToOne(optional = false)
    private Usuarios idUsu;
    @JoinColumn(name = "cod_tip_ali", referencedColumnName = "cod_tip_ali")
    @ManyToOne(optional = false)
    private TiposAlistamiento codTipAli;
    @JoinColumn(name = "cod_fas_pro", referencedColumnName = "cod_fas_pro")
    @ManyToOne(optional = false)
    private FasesProyecto codFasPro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codAli")
    private List<ControlesOperativos> controlesOperativosList;

    public Alistamientos() {
    }

    public Alistamientos(String codAli) {
        this.codAli = codAli;
    }

    public Alistamientos(String codAli, String nomAli, String bibliografia, String recDid) {
        this.codAli = codAli;
        this.nomAli = nomAli;
        this.bibliografia = bibliografia;
        this.recDid = recDid;
    }

    public String getCodAli() {
        return codAli;
    }

    public void setCodAli(String codAli) {
        this.codAli = codAli;
    }

    public String getNomAli() {
        return nomAli;
    }

    public void setNomAli(String nomAli) {
        this.nomAli = nomAli;
    }

    public String getBibliografia() {
        return bibliografia;
    }

    public void setBibliografia(String bibliografia) {
        this.bibliografia = bibliografia;
    }

    public String getRecDid() {
        return recDid;
    }

    public void setRecDid(String recDid) {
        this.recDid = recDid;
    }

    public Usuarios getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(Usuarios idUsu) {
        this.idUsu = idUsu;
    }

    public TiposAlistamiento getCodTipAli() {
        return codTipAli;
    }

    public void setCodTipAli(TiposAlistamiento codTipAli) {
        this.codTipAli = codTipAli;
    }

    public FasesProyecto getCodFasPro() {
        return codFasPro;
    }

    public void setCodFasPro(FasesProyecto codFasPro) {
        this.codFasPro = codFasPro;
    }

    @XmlTransient
    public List<ControlesOperativos> getControlesOperativosList() {
        return controlesOperativosList;
    }

    public void setControlesOperativosList(List<ControlesOperativos> controlesOperativosList) {
        this.controlesOperativosList = controlesOperativosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codAli != null ? codAli.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alistamientos)) {
            return false;
        }
        Alistamientos other = (Alistamientos) object;
        if ((this.codAli == null && other.codAli != null) || (this.codAli != null && !this.codAli.equals(other.codAli))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Alistamientos[ codAli=" + codAli + " ]";
    }
    
}
