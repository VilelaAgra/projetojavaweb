package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import factory.FabricaConexao;
import models.UsuarioBean;

public class UsuarioDao {

	private static FabricaConexao CONNECTION;
	private Connection conexao;
	private UsuarioBean user = null;

	public UsuarioDao() {
		this.CONNECTION = new FabricaConexao();

	}

	public String autenticarUsuario(UsuarioBean usuario) {
		String retorno = null;

		try {
			conexao = CONNECTION.getConnection();
			String sql = "select * from usuarios where nome = ? and senha = ?";
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, usuario.getUsuario());
			ps.setString(2, usuario.getSenha());
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				retorno = "sucessoLogin";

			} else {
				retorno = "falhaLogin";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			CONNECTION.closeConnection();
		}

		return retorno;

	}

	public String cadastrarUsuario(UsuarioBean usuario) {
		String retorno = null;

		try {
			conexao = CONNECTION.getConnection();
			String sql = "INSERT INTO usuarios (nome,senha,email) VALUES (?,?,?)";
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, usuario.getUsuario());
			ps.setString(2, usuario.getSenha());
			ps.setString(3, usuario.getEmail());
			ps.executeUpdate();

			retorno = "telaLogin";
		} catch (Exception e) {
			System.out.println("Erro ao tentar cadastrar usuário");
			e.printStackTrace();
		}

		finally {
			CONNECTION.closeConnection();
		}

		return retorno;

	}

}
