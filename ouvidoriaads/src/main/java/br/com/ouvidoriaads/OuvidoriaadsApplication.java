package br.com.ouvidoriaads;

import javax.swing.JOptionPane;

	public class OuvidoriaadsApplication {
		
// ESSA CLASSE VAI RECEBER OS METODOS DA CLASSE MANIFESTACAODAO, E CRIAR O MENU ONDE FICARÁ VISIVEL PARA O USUARIO!
		
		public static void main(String[] args) {
			ManifestacaoService service = new ManifestacaoService();
			try {
	            do {
	            	String opcao = JOptionPane.showInputDialog("Sistema de Ouvidoria UNIFACISA\n"
	            			+ "Bem vindo Usuário! \n"
	            			+ "MENU:\n"
	            			+ "1 - Listar Manifestações\n"
	            			+ "2 - Criar nova Manifestação\n"
	            			+ "3 - Pesquisar Manifestação\n"
	            			+ "4 - Exibir quantidade de Manifestação\n"
	            			+ "5 - Sair\n"
	            			+ "\nSelecione sua opção: ");
	            	
// USEI O IF NO LUGAR DO SWITCH POIS SERIA MAIS FACIL PARA INCLUIR TANTO
//AS LISTAGENS POR TIPO QUANTO A TOTAL, EVITANDO BUGS.
	            	
	            	if (Integer.parseInt(opcao) == 1) {
	            		service.listar();
					} else if (Integer.parseInt(opcao) == 2) {
						service.criar();
					} else if (Integer.parseInt(opcao) == 3) {
						service.pesquisar();
					} else if (Integer.parseInt(opcao) == 4) {
						service.quantidade();
					} else if (Integer.parseInt(opcao) == 5 || opcao == null) {
						JOptionPane.showMessageDialog(null, "Saindo do Sistema");
						break;
					} else {
						JOptionPane.showMessageDialog(null, "Digite uma opção válida");
					}
	                

			} while (true);
		} catch (Exception e) {
					// TODO: handle exception
				}
			}
	}