/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serial;

import java.io.IOException;

/**
 *
 * @author Windows
 */
public class testLeitor {
    public static void main(String[] args) throws IOException{
        Le_planilha le = new Le_planilha();
        Sistema_interno pe = new Sistema_interno();
        pe.setHorarios(le.pega_planilha());
        pe.getHorarios().getHorario(3);
        
    }
    
}
