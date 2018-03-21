/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Profe;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Bryan Requenes
 */
public class ListaProfesores {

private ArrayList <Profesor> lista = new ArrayList<Profesor>();


    public ArrayList<Profesor> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Profesor> lista) {
        this.lista = lista;
    }

  public void agregar (Profesor p){
      this.lista.add(p);
  }    
  
  public void grabar(){
      try {
          FileWriter fw = new FileWriter(new  File("C:\\Users\\Bryan Requenes\\Desktop\\Lista.txt"));
            PrintWriter pw = new PrintWriter(fw, true);
            for (Profesor prof : lista) {
                if (prof instanceof ProfesorTiempoParcial){
                     ProfesorTiempoParcial ptp = (ProfesorTiempoParcial)prof;
                     
                    pw.print( "Profesor Tiempo Parcial"+"  "+ ptp.toString() + "Horas complementarias"+"  "+ptp.horasComplementarias() + "horas" );
                }
                if (prof instanceof ProfesorMedioTiempo){
                    ProfesorMedioTiempo pmt = (ProfesorMedioTiempo)prof;
                    pw.print("Profesor Medio Tiempo "+"  "+ pmt.toString() + "Horas complementarias"+"  "+pmt.horasComplementarias() + "horas" );
                }
                if(prof instanceof ProfesorTiempoCompleto){
                    ProfesorTiempoCompleto ptc = (ProfesorTiempoCompleto)prof;
                    pw.print("Profesor Tiempo Completo"+"  "+ ptc.toString() + "Horas complementarias"+"  "+ptc.horasComplementarias() + "horas" );
                }
            
                    }
            pw.close(); 
      }catch(IOException e){
          
      }
  }

}