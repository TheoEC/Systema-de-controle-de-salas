package Serial;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Supervisorio {
    public static void main(String[] args) throws InterruptedException, IOException, FileNotFoundException {
        Salva_Le_dados IOinteration = new Salva_Le_dados();
        SerialRxTx serial = new SerialRxTx();
        Le_planilha leitor = new Le_planilha();
        
        Sistema_interno system = new Sistema_interno();
        system.setHorarios(leitor.pega_planilha());
        boolean anti_repeticao = false;
        
        if(serial.iniciaSerial()){
            while(true){
                Thread.sleep(100);
                if (system.Permissao(serial.getProtocolo().getSenha()) == true){ // acesso permitido
                    IOinteration.Salva_Dados(serial.getProtocolo().getSenha());
                    IOinteration.Salva_Dados("Acesso Liberado");
                    serial.sendData("1"); // Comando para destravar cofre
                    Thread.sleep(150);
                    serial.getProtocolo().setLuminosidade("Aberto");
                    int time = 0;
                    while(serial.getProtocolo().getLuminosidade().equals("Aberto") && time < 40){
                        Thread.sleep(500);
                        time += 1;
                    }
                    
                    serial.getProtocolo().setSenha("");
                    anti_repeticao = true;
                } 
                
                else{
                    if(serial.getProtocolo().getSenha().length() > 0){
                        IOinteration.Salva_Dados(serial.getProtocolo().getSenha());
                        IOinteration.Salva_Dados("Acesso Negado");
                        anti_repeticao = true;
                        serial.getProtocolo().setSenha("");
                    }
                }
                if(anti_repeticao == true){
                    IOinteration.Salva_Dados("");
                    anti_repeticao = false;
                }
            }
        }
        
        try {
            serial.close();
        } catch (Exception e){
            System.out.println("Erro ao liberar porta " + serial.getSerialportname());
        }
        
        
    }
}
/*
while(true){
      if (digitalRead(12) == 0){
        Serial.println("aberto");
        int Time = 0;
        while(true){
          if(digitalRead(12) == 1) {
            Serial.println("fechado");
            break;
          }
          Time += 1;
          delay(500);
          if (Time == 21) {
            Serial.println("MAL USO!!");
            break;
          }
        }
        break;
      }
      
      delay(500);
      time += 1
      if (time == 21){
        break
      }
    }
*/