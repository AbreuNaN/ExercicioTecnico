package desafiojava;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class App {
	public static void main(String[] args) throws Exception {
		int op;

		do {
			op = Integer.parseInt(JOptionPane.showInputDialog("Digite uma op��o"));
			Metodos metodo = new Metodos();
			try {
				File arquivo = new File("src/desafiojava/bolsistas.csv");
				Scanner leitor = new Scanner(arquivo);

				List<Bolsista> listasBolsistas = new ArrayList<Bolsista>();

				while (leitor.hasNext()) {
					/* Pegando os atributos da linha do arquivo csv */
					String[] atributos = leitor.nextLine().split(";");
					
					Bolsista bolsista = new Bolsista(atributos[0], atributos[1], atributos[2], atributos[3],
							atributos[4], atributos[5], atributos[6], atributos[7], atributos[8], atributos[9],
							atributos[10]);
					
					listasBolsistas.add(bolsista);
				}

				/* Consulta do bolsista zero do ano requerido. */
				if (op == 1) {
					int anoConsulta = Integer.parseInt(JOptionPane.showInputDialog("Digite o Ano para a consulta: "));
					JOptionPane.showMessageDialog(null,
							"O bolsista zero �: " + metodo.mostrarBolsaZeroAno(anoConsulta, listasBolsistas));
				}
				
				/* Codifica��o nomes dos bolsistas */
				if (op == 2) {
					JOptionPane.showMessageDialog(null, metodo.retornarNomeEmbaralhado(listasBolsistas));
				}
				
				/* Consulta da m�dia anual requerida  */
				if (op == 3) {
					int anoConsulta = Integer.parseInt(JOptionPane.showInputDialog("Digite o Ano para a consulta: "));
					JOptionPane.showMessageDialog(null,
							"A m�dia do ano consultado �: " + metodo.consultarMediaAnual(anoConsulta, listasBolsistas));
				}
				
				/* Listar as tr�s bolsas mais altas e as tr�s mais baixas */
				if (op == 4) {
					metodo.ranquearAlunos(listasBolsistas);
					JOptionPane.showMessageDialog(null, metodo.ranquearAlunos(listasBolsistas));
					System.out.println(metodo.ranquearAlunos(listasBolsistas));
				}

				leitor.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} while (op == 5);

	}

}
