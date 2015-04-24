/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import Entidad.ClsEntidadCuenta;
import java.util.List;

/**
 *
 * @author Alan
 */
public interface CuentaDao {
    
    public List<ClsEntidadCuenta> getAllCuentas();
    public void saveCuenta(ClsEntidadCuenta cuenta);
    public void saveCuentas(List<ClsEntidadCuenta> cuentas);
    
}
