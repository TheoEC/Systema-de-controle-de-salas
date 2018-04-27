package Serial;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Protocolo {
    private String tipoDado;
    private String senha = "";
    private String acesso;
    private String Luminosidade = "1";
    private String LeituraComando;
    private Salva_Le_dados IOinteration = new Salva_Le_dados();
   
    //---------- metodos -------------------------------------------------------

    public String getTipoDado() {
        return tipoDado;
    }

    public void setTipoDado(String tipoDado) {
        this.tipoDado = tipoDado;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLuminosidade() {
        return Luminosidade;
    }

    public void setLuminosidade(String Luminosidade) {
        this.Luminosidade = Luminosidade;
    }

    public String getLeituraComando() {
        return LeituraComando;
    }

    public void setLeituraComando(String LeituraComando) throws FileNotFoundException, IOException {
        if (LeituraComando.length() == 4){
            this.senha = LeituraComando;
            this.LeituraComando = LeituraComando;
        }
        else {
            if (LeituraComando.equals("Cofre Fechado!")){
                this.Luminosidade = "Fechado";
                System.out.println(LeituraComando);
                this.IOinteration.Salva_Dados(LeituraComando);
                this.LeituraComando = LeituraComando;
            }
            else {
                if (LeituraComando.equals("Cofre aberto!")){
                    System.out.println(LeituraComando);
                    this.LeituraComando = LeituraComando;
                    this.IOinteration.Salva_Dados(LeituraComando);
                }
                else{
                    System.out.println("Erro em protocolo, dado recebido não identificado: " + LeituraComando);
                    this.IOinteration.Salva_Dados(LeituraComando);
                }
            } 
        }
    }
}    
