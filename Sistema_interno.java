package Serial;

import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
/*
Codigos para obtenção de informações por SimpleDateFormat:
y ano
M mes
dd dia do mes
EEE dia da semana abreviado em portugues
EEEE dia da semana completo em portugues
D dia
H hora do dia(0/24)
h Hora da manha ou da tarde(0/12)
m minuto
s segundo
S milisegundo
 */

public class Sistema_interno {
	Horarios horarios = new Horarios();
        
        
        
	public boolean Permissao(String senha) {
		Date momento = new Date();

		SimpleDateFormat minutos = new SimpleDateFormat("m");
		SimpleDateFormat hora = new SimpleDateFormat("H");
		SimpleDateFormat dia = new SimpleDateFormat("EEE");
		//System.out.println(momento);

		String Minuto = minutos.format(momento);
		String Hora = hora.format(momento);
		String Dia = dia.format(momento);
		//System.out.println(Dia + "   " + Hora + ":" + Minuto);

		int day = 0, aula = -1; // (aula = -1) = horarios adversos
		if (Dia.equals("dom") == true) { // voltado a capturar o dia para a verificação adiante
			day = 0;
                        System.out.println("deu pau");
		}

		else if (Dia.equals("seg") == true) {
			day = 1;
		}

		else if (Dia.equals("ter") == true) {
			day = 2;
			
		}

		else if (Dia.equals("qua") == true) {
			day = 3;
		}

		else if (Dia.equals("Qui") == true) {
			day = 4;
		}

		else if (Dia.equals("sex") == true) {
			day = 5;
                        
		}

		else if (Dia.equals("sáb") == true) {
			day = 6;
		}

		// VERIFICA AULA POR HORARIO ATUAL

		if (Hora.equals("7") == true && Integer.parseInt(Minuto) <= 50) { // Integer.parseInt(String) = convert string
																			// para inteiro
			aula = 0;
		}

		else if (Hora.equals("7") == true && Integer.parseInt(Minuto) > 50
				|| Hora.equals("8") == true && Integer.parseInt(Minuto) <= 40) { // se for mais de 7:50 ou se for 8
																					// horas e minutos menor ou igual a
																					// 40
			aula = 1;
		}

		else if (Hora.equals("8") == true && Integer.parseInt(Minuto) > 40
				|| Hora.equals("9") == true && Integer.parseInt(Minuto) <= 30) {
			aula = 2;
		}

		// Intervalo

		else if (Hora.equals("9") == true && Integer.parseInt(Minuto) > 50
				|| Hora.equals("10") == true && Integer.parseInt(Minuto) <= 40) {
			aula = 3;
			System.out.println("concerta bugs 2(hora ok)");
		}

		else if (Hora.equals("10") == true && Integer.parseInt(Minuto) > 40
				|| Hora.equals("11") == true && Integer.parseInt(Minuto) <= 30) {
			aula = 4;
		}

		else if (Hora.equals("11") == true && Integer.parseInt(Minuto) > 30
				|| Hora.equals("12") == true && Integer.parseInt(Minuto) <= 20) {
			aula = 5;
		}

		// FIM DOS HORARIOS DA MANHA

		else if (Hora.equals("13") == true && Integer.parseInt(Minuto) <= 50) {
			aula = 6;
		}

		else if (Hora.equals("13") == true && Integer.parseInt(Minuto) > 50
				|| Hora.equals("14") == true && Integer.parseInt(Minuto) <= 40) {
			aula = 7;
		}

		else if (Hora.equals("14") == true && Integer.parseInt(Minuto) > 40
				|| Hora.equals("15") == true && Integer.parseInt(Minuto) <= 30) {
			aula = 8;
		}

		// Intervalo.

		else if (Hora.equals("15") == true && Integer.parseInt(Minuto) > 50
				|| Hora.equals("16") == true && Integer.parseInt(Minuto) <= 40) {
			aula = 9;
		}

		else if (Hora.equals("16") == true && Integer.parseInt(Minuto) > 40
				|| Hora.equals("17") == true && Integer.parseInt(Minuto) <= 30) {
			aula = 10;
		}

		else if (Hora.equals("17") == true && Integer.parseInt(Minuto) > 30
				|| Hora.equals("18") == true && Integer.parseInt(Minuto) <= 20) {
			aula = 11;
		}

		// ------------PESQUISAR E COMPLETAR HORARIOS NOTURNOS----------------

		// TESTE:
		else if (Hora.equals("20") == true && Integer.parseInt(Minuto) > 30
				|| Hora.equals("21") == true && Integer.parseInt(Minuto) <= 60) {
			aula = 12;
		}
		//System.out.println(senha + "  " + this.horarios.getAula(day -1, aula));
		try {
			/*if (horarios.getAula(day, aula).getSenha().equals(senha) == true) {
				System.out.println("Acesso permitido");
				return true;
			}*/
                        
                        if (this.horarios.getAula(day - 1, aula).getSenha().equals(senha) == true) {
				System.out.println("Acesso permitido");
				return true;
                        }
		}
                
		catch (Exception e) {
			//System.out.println("Acesso negado pelo sistema");
		}
		/*
		 * necessario um try para os casos onde não há um professor no horario atual o
		 * getAula() não tera um objeto Professor instanciado para retornar.
		 */
		return false;
	}

	public Horarios getHorarios() {
		return horarios;
	}

	public void setHorarios(Horarios horarios) {
		this.horarios = horarios;
		System.out.println("Horario adquirido");
	}

}