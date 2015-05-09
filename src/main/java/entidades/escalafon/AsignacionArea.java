/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades.escalafon;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Documentos
 */

@Entity
@Table(name="asignacion_area",schema = "institucional")
public class AsignacionArea implements Serializable{
    
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    @Basic
    private Date fechaInicio;
    
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    @Basic
    private Date fechaFin;
    
    @Column(name = "vigente")
    @Basic
    private Boolean vigente;
    
    @ManyToOne(targetEntity = Departamento.class)
    @JoinColumn(name="area_codigo",referencedColumnName="codigo",nullable=false)
    private Departamento area;
    
    @OneToOne(targetEntity = Empleado.class)
    @JoinColumn(name="persona_nro_documento",referencedColumnName="nro_documento",nullable=false)
    private Empleado empleado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Boolean getVigente() {
        return vigente;
    }

    public void setVigente(Boolean vigente) {
        this.vigente = vigente;
    }
    
    
    public Departamento getArea() {
        return area;
    }

    public void setArea(Departamento area) {
        this.area = area;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
    
}
