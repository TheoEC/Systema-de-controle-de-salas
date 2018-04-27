package Serial;

import java.util.ArrayList;

public class Horarios {
	Professor[][] Semana = new Professor[5][12];
	/*
	 * Um array multidimensional onde existe 7 listas(uma para cada dia da semana),
	 * cada uma contando 15 objetos do tipo Professor, um para cada possivel
	 * horário(5 para cada turno).
	 */

	public void getHorario(int dia) {
		try { // serve para caso o usuario digite um...8?
			ArrayList<String> Dias_da_semana = new ArrayList<String>();

			Dias_da_semana.add("Segunda Feira");
			Dias_da_semana.add("Terca Feira");
			Dias_da_semana.add("Quarta");
			Dias_da_semana.add("Quinta");
			Dias_da_semana.add("Sexta");

			System.out.println(Dias_da_semana.get(dia) + ":");
			for (int i = 0; i < 15; i++) { // imprimirá todos os horarios do dia
				try { // necessario pois se não ouver ocupação no horario, o getNumero_de_matricula()
						// dara erro.
					System.out.println((i + 1) + "ª aula: Professor:" + Semana[dia][i].getNome());
				} catch (Exception e) {
					System.out.println("Horario vazio");
				}

			}

		} catch (RuntimeException erro) {
			System.out.println("Dia da semana não identificado");
		}

	}

	public void setAula(Professor professor, int dia, int aula) {
		this.Semana[dia][aula] = professor;
	}

	public Professor getAula(int dia, int aula) {
		return this.Semana[dia][aula];
	}

	public void p() {
		System.out.println(this.Semana);
	}

}