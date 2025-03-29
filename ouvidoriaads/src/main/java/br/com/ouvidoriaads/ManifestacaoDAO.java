package br.com.ouvidoriaads;
// NESSA CLASSE DAO USAMOS ELA PARA CONECTAR AS SERVICE E A APPLICATION PARA ENVIAR AS INFORMAÇOES PARA O DAO
// E ELE ENVIAR OS DADOS PARA O MYSQL.
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ManifestacaoDAO {

	private String sql;
	private PreparedStatement ps;
	private ResultSet rs;
	private Connection conn;

	public ArrayList<Manifestacao> listarManifestacao() {
		ArrayList<Manifestacao> listarManifestacao = new ArrayList<Manifestacao>();

		try {
			sql = "SELECT * FROM manifestacoes";
			conn = ConnectionDatabase.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Manifestacao manifestacao = new Manifestacao(rs.getInt("codigo"), rs.getString("autor"),
						rs.getString("tipo"), rs.getString("descricao"));
				listarManifestacao.add(manifestacao);

			}

			ps.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);

		}
		return listarManifestacao;

	}

	public ArrayList<Manifestacao> listarPorTipo(String tipo) {
		ArrayList<Manifestacao> listaOpcao = new ArrayList<Manifestacao>();

		try {
			sql = "SELECT * FROM manifestacoes WHERE tipo = ?";
			conn = ConnectionDatabase.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, tipo);
			rs = ps.executeQuery();

			while (rs.next()) {
				Manifestacao manifestacao = new Manifestacao(rs.getInt("codigo"), rs.getString("autor"),
						rs.getString("tipo"), rs.getString("descricao"));
				listaOpcao.add(manifestacao);

			}

			ps.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);

		}

		return listaOpcao;
	}

	public ArrayList<Manifestacao> PesquisarPorCodigo(int codigo) {
		ArrayList<Manifestacao> listagemManifestacao = new ArrayList<Manifestacao>();

		try {
			sql = "SELECT * FROM manifestacoes WHERE codigo = ?";
			conn = ConnectionDatabase.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, codigo);
			rs = ps.executeQuery();

			while (rs.next()) {
				Manifestacao manifestacao = new Manifestacao(rs.getInt("codigo"), rs.getString("autor"),
						rs.getString("tipo"), rs.getString("descricao"));
				listagemManifestacao.add(manifestacao);

			}

			ps.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);

		}

		return listagemManifestacao;
	}

	public void criarManifestacao(Manifestacao manifestacao) {

		try {

			sql = "INSERT INTO manifestacoes (autor, tipo, descricao) values (?,?,?)";
			conn = ConnectionDatabase.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, manifestacao.getAutor());
			ps.setString(2, manifestacao.getTipo());
			ps.setString(3, manifestacao.getDescricao());
			ps.execute();
			ps.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}

	}

	public int exibirQuantidade() {
		int quantidade = 0;
		try {
			sql = "SELECT COUNT(*) AS total from manifestacoes ";
			conn = ConnectionDatabase.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
		if (rs.next()){
			quantidade = rs.getInt("total");
		}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return quantidade;
	}
}
