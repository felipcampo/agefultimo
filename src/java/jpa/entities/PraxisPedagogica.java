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
@Table(name = "praxis_pedagogica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PraxisPedagogica.findAll", query = "SELECT p FROM PraxisPedagogica p"),
    @NamedQuery(name = "PraxisPedagogica.findByCodPrx", query = "SELECT p FROM PraxisPedagogica p WHERE p.codPrx = :codPrx"),
    @NamedQuery(name = "PraxisPedagogica.findByCumple", query = "SELECT p FROM PraxisPedagogica p WHERE p.cumple = :cumple"),
    @NamedQuery(name = "PraxisPedagogica.findByRevisor", query = "SELECT p FROM PraxisPedagogica p WHERE p.revisor = :revisor"),
    @NamedQuery(name = "PraxisPedagogica.findByFecha", query = "SELECT p FROM PraxisPedagogica p WHERE p.fecha = :fecha")})
public class PraxisPedagogica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_prx")
    private Integer codPrx;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "des_pra")
    private String desPra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cumple")
    private boolean cumple;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "observaciones")
    private String observaciones;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "revisor")
    private String revisor;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "recomendacion")
    private String recomendacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "id_usu", referencedColumnName = "id_usu")
    @ManyToOne(optional = false)
    private Usuarios idUsu;
    @JoinColumn(name = "cod_pro", referencedColumnName = "cod_pro")
    @ManyToOne(optional = false)
    private Proyectos codPro;
    @JoinColumn(name = "cod_cen", referencedColumnName = "cod_cen")
    @ManyToOne(optional = false)
    private CentrosFormacion codCen;

    public PraxisPedagogica() {
    }

    public PraxisPedagogica(Integer codPrx) {
        this.codPrx = codPrx;
    }

    public PraxisPedagogica(Integer codPrx, String desPra, boolean cumple, String observaciones, String revisor, String recomendacion, Date fecha) {
        this.codPrx = codPrx;
        this.desPra = desPra;
        this.cumple = cumple;
        this.observaciones = observaciones;
        this.revisor = revisor;
        this.recomendacion = recomendacion;
        this.fecha = fecha;
    }

    public Integer getCodPrx() {
        return codPrx;
    }

    public void setCodPrx(Integer codPrx) {
        this.codPrx = codPrx;
    }

    public String getDesPra() {
        return desPra;
    }

    public void setDesPra(String desPra) {
        this.desPra = desPra;
    }

    public boolean getCumple() {
        return cumple;
    }

    public void setCumple(boolean cumple) {
        this.cumple = cumple;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }

    public String getRecomendacion() {
        return recomendacion;
    }

    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Usuarios getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(Usuarios idUsu) {
        this.idUsu = idUsu;
    }

    public Proyectos getCodPro() {
        return codPro;
    }

    public void setCodPro(Proyectos codPro) {
        this.codPro = codPro;
    }

    public CentrosFormacion getCodCen() {
        return codCen;
    }

    public void setCodCen(CentrosFormacion codCen) {
        this.codCen = codCen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPrx != null ? codPrx.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PraxisPedagogica)) {
            return false;
        }
        PraxisPedagogica other = (PraxisPedagogica) object;
        if ((this.codPrx == null && other.codPrx != null) || (this.codPrx != null && !this.codPrx.equals(other.codPrx))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.PraxisPedagogica[ codPrx=" + codPrx + " ]";
    }
    
}
