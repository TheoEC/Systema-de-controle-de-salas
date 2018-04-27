/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serial;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;


public class Salva_Le_dados{
    static int linha;
    
    public void Le_dados(){
    try {
      FileReader arq = new FileReader("Relatorios.txt");
      BufferedReader lerArq = new BufferedReader(arq);
 
      String linha = lerArq.readLine(); // lê a primeira linha
                                        // a variável "linha" recebe o valor "null" quando o processo
                                        // de repetição atingir o final do arquivo texto
      while (linha != null) {
        System.out.printf(linha + "\n");
 
        linha = lerArq.readLine(); // lê da segunda até a última linha
      }
 
      arq.close();
    } catch (IOException e) {
        System.err.printf("Erro na abertura do arquivo", e.getMessage());
    }
    }
    
    
    
    
    
    public void Salva_Dados(String data) throws FileNotFoundException, IOException{
    ArrayList<String> dados = new ArrayList<>();
    try {
      FileReader arq = new FileReader("Relatorios.txt");
      BufferedReader lerArq = new BufferedReader(arq);
 
      String linha = lerArq.readLine(); // lê a primeira linha
                                        // a variável "linha" recebe o valor "null" quando o processo
                                        // de repetição atingir o final do arquivo texto
      while (linha != null) {
        dados.add(linha);
 
        linha = lerArq.readLine(); // lê da segunda até a última linha
      }
      arq.close();
    } catch (IOException e) {
        System.err.printf("Erro na abertura do arquivo", e.getMessage());
    }
    
        FileWriter arq = new FileWriter("Relatorios.txt");
        PrintWriter gravarArq = new PrintWriter(arq);
        for(int i = 0; i < dados.size(); i++) {
            gravarArq.printf(dados.get(i) + "\n");
        }
        gravarArq.printf(data + "\n");
        arq.close();
    }
}