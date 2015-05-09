/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.escalafon.AsignacionArea;
import entidades.escalafon.Empleado;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Administrador
 */
public class AsignacionAreaControlador extends Controlador<AsignacionArea>{
    
    public AsignacionAreaControlador() {
        super(AsignacionArea.class);
    }
    
    
    public List<AsignacionArea> buscarXEmpleado(Empleado empleado) {
        String jpql = "SELECT e FROM AsignacionArea e WHERE empleado = :empleado AND vigente = true";
        Map<String, Object> mapa = new HashMap<>();
        mapa.put("empleado", empleado);
        return this.getDao().buscar(jpql, mapa);
    }
}
