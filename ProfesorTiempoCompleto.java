/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Profe;

/**
 *
 * @author Bryan Requenes
 */
public class ProfesorTiempoCompleto extends Profesor{
int HORAS_SEMANALES = 40;

    public ProfesorTiempoCompleto(String cedula, String nombres, String apellidos, int horasClase, String carrera, String tipo) {
        super(cedula, nombres, apellidos, horasClase, carrera, tipo);
    }

    
    public int horasComplementarias() {
        int hc =HORAS_SEMANALES-ProfesorTiempoCompleto.super.getHorasClase();
        return hc;
    }

    
}