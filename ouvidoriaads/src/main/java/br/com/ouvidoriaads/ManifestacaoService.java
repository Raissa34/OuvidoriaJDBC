// SISTEMA DE OUVIDORIA USANDO JDBC E JOPTIONPANE E MYSQL 
// FEITO PELAS AS ALUNAS :      MATRICULA:

package br.com.ouvidoriaads;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ManifestacaoService {
	ManifestacaoDAO dao= new ManifestacaoDAO();
	// ESSE METODO ELE INCLUI TANTO O LISTAR POR TIPO QUANTO O LISTAR TODAS AS MANIFESTACOES, SO 
	//ADICIONAR A OPCAO QUE DESEJA.
	
	public void listar() {
	    while (true) {
	        String tipo;
	        ArrayList<Manifestacao> listaManifestacao = new ArrayList<>();

	        String textoRetorno = "Lista de manifestações: \n";

	        String opcao = JOptionPane.showInputDialog("Selecione o tipo da manifestação:\n" +
	                "1 - Reclamação\n" +
	                "2 - Elogio\n" +
	                "3 - Sugestão\n" +
	                "4 - Todas");

	        if (opcao == null) {
	            JOptionPane.showMessageDialog(null, "Retornando ao menu!");
	            break;
	        } else if (opcao.isBlank()) {
	            JOptionPane.showMessageDialog(null, "Digite uma opção!");
	            continue;
	        }

	        int opcaoInt = Integer.parseInt(opcao);

	        if (opcaoInt == 1) {
	            tipo = "Reclamação";
	            listaManifestacao = dao.listarPorTipo(tipo);
	        } else if (opcaoInt == 2) {
	            tipo = "Elogio";
	            listaManifestacao = dao.listarPorTipo(tipo);
	        } else if (opcaoInt == 3) {
	            tipo = "Sugestão";
	            listaManifestacao = dao.listarPorTipo(tipo);
	        } else if (opcaoInt == 4) {
	            listaManifestacao = dao.listarManifestacao();
	        } else {
	            JOptionPane.showMessageDialog(null, "Digite uma opção válida!");
	            continue;
	        }

	        if (!listaManifestacao.isEmpty()) {
	            for (Manifestacao manifestacaoTemp : listaManifestacao) {
	                textoRetorno += manifestacaoTemp.toString() + "\n";
	            }
	            JOptionPane.showMessageDialog(null, textoRetorno);
	        } else {
	            JOptionPane.showMessageDialog(null, "Não existem manifestações do tipo selecionado");
	        }
	    }
	}


	
// METODO PARA CRIAR UMA MANIFESTACAO SEJA ELA (ELOIGIO, RECLAMACAO OU SUGESTAO).
	
	public void criar() {
		String tipo = "";

		String autor = JOptionPane.showInputDialog("Digite seu nome: ");

		while (true) {
			String opcao = JOptionPane.showInputDialog(
					"Selecione o tipo da manifestação: \n" + "1 - Reclamação \n" + "2 - Elogio\n" + "3 - Sugestão\n");
			if (opcao.isBlank()) {
				JOptionPane.showMessageDialog(null, "Digite uma opção!");
			} else if (Integer.parseInt(opcao) == 1) {
				tipo = "Reclamação";
				break;
			} else if (Integer.parseInt(opcao) == 2) {
				tipo = "Elogio";
				break;
			} else if (Integer.parseInt(opcao) == 3) {
				tipo = "Sugestão";
				break;
			}
		}

		String descricao = JOptionPane.showInputDialog("Descreva sua manifestação: ");

		Manifestacao manifestacao = new Manifestacao(autor, tipo, descricao);

		dao.criarManifestacao(manifestacao);
		JOptionPane.showMessageDialog(null,"Manifestaçao Criada com Sucesso!");

	}
// METODO PARA PESQUISAR A MANIFESTACAO POR CODIGO.
	
	public void pesquisar() {
		
		ArrayList<Manifestacao> listaManifestacao = new ArrayList<Manifestacao>();

		String textoRetorno = "Lista de manifestações: \n";
		
		
		int codigo = Integer.parseInt(JOptionPane.showInputDialog("Insira o código da manifestação: "));
		
		listaManifestacao = dao.PesquisarPorCodigo(codigo);
		
		
		for (Manifestacao manifestacaoTemp : listaManifestacao) {
			textoRetorno += manifestacaoTemp.toString();
		}

		if (textoRetorno != "Lista de manifestações: \n") {
			JOptionPane.showMessageDialog(null, textoRetorno);
		} else {
			JOptionPane.showMessageDialog(null, "Não existem manifestações com este código");
		}

	}
// METODO DE MOSTRAR A QUANTIDADE MANIFESTACOES FEITAS PELO USUARIO.
	
	public void quantidade() {
		int quantidade = dao.exibirQuantidade();
		JOptionPane.showInternalMessageDialog(null,
				"Existem " +  quantidade
				+ " manifestações no banco de dados");

	}

}