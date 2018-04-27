/*
 Teste de escrita em arquivo txt
 */
package Serial;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

class Escrita {
public static void main(String[] args) throws IOException {
    try{
        OutputStream os = new FileOutputStream("saida.txt"); // Passo 1
        OutputStreamWriter osw = new OutputStreamWriter(os); // Passo 2
        BufferedWriter bw = new BufferedWriter(osw); // Passo 3
        
        bw.write("Disciplina de POO");
        
        bw.close();
        osw.close();   
        os.close();
        
        
        // Lembrar de fechar o arquivo!
        // Passo 3
    } // Passo 2
    // Passo 2
    catch(Exception e){
        e.printStackTrace();;
    }
  }
} 
