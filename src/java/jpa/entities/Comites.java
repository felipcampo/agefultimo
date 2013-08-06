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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "comites")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comites.findAll", query = "SELECT c FROM Comites c"),
    @NamedQuery(name = "Comites.findByCodCom", query = "SELECT c FROM Comites c WHERE c.codCom = :codCom"),
    @NamedQuery(name = "Comites.findByFecCom", query = "SELECT c FROM Comites c WHERE c.fecCom = :fecCom"),
    @NamedQuery(name = "Comites.findByNumAct", query = "SELECT c FROM Comites c WHERE c.numAct = :numAct")})
public class Comites implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_com")
    private Integer codCom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_com")
    @Temporal(TemporalType.DATE)
    private Date fecCom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_act")
    private int numAct;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "comentarios")
    private String comentarios;
    @JoinColumn(name = "num_rep", referencedColumnName = "num_rep")
    @ManyToOne(optional = false)
    private ReportesNovedades numRep;
    @JoinColumn(name = "id_usu", referencedColumnName = "id_usu")
    @ManyToOne(optional = false)
    private Usuarios idUsu;
    @JoinColumn(name = "cod_san", referencedColumnName = "cod_san")
    @ManyToOne(optional = false)
    private Sanciones codSan;
    @JoinColumn(name = "cod_med_for", referencedColumnName = "cod_med_for")
    @ManyToOne(optional = false)
    private MedidasFormativas codMedFor;
    @JoinColumn(name = "cod_fal", referencedColumnName = "cod_fal")
    @ManyToOne(optional = false)
    private Faltas codFal;
    @JoinColumn(name = "cod_fic", referencedColumnName = "cod_fic")
    @ManyToOne(optional = false)
    private FichasCaracterizacion codFic;

    public Comites() {
    }

    public Comites(Integer codCom) {
        this.codCom = codCom;
    }

    public Comites(Integer codCom, Date fecCom, int numAct, String comentarios) {
        this.codCom = codCom;
        this.fecCom = fecCom;
        this.numAct = numAct;
        this.comentarios = comentarios;
    }

    public Integer getCodCom() {
        return codCom;
    }

    public void setCodCom(Integer codCom) {
        this.codCom = codCom;
    }

    public Date getFecCom() {
        return fecCom;
    }

    public void setFecCom(Date fecCom) {
        this.fecCom = fecCom;
    }

    public int getNumAct() {
        return numAct;
    }

    public void setNumAct(int numAct) {
        this.numAct = numAct;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public ReportesNovedades getNumRep() {
        return numRep;
    }

    public void setNumRep(ReportesNovedades numRep) {
        this.numRep = numRep;
    }

    public Usuarios getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(Usuarios idUsu) {
        this.idUsu = idUsu;
    }

    public Sanciones getCodSan() {
        return codSan;
    }

    public void setCodSan(Sanciones codSan) {
        this.codSan = codSan;
    }

    public MedidasFormativas getCodMedFor() {
        return codMedFor;
    }

    public void setCodMedFor(MedidasFormativas codMedFor) {
        this.codMedFor = codMedFor;
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
        hash += (codCom != null ? codCom.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comites)) {
            return false;
        }
        Comites other = (Comites) object;
        if ((this.codCom == null && other.codCom != null) || (this.codCom != null && !this.codCom.equals(other.codCom))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Comites[ codCom=" + codCom + " ]";
    }
    
}
