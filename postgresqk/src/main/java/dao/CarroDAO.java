package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Carro;

public class CarroDAO extends DAO {

	public CarroDAO() {
		super();
		conectar();
	}

	public void finalize() {
		close();
	}

	public boolean insert(Carro carro) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "INSERT INTO carro (id, marca, modelo, cor, kilometragem) "
				       + "VALUES ("+carro.getId()+ ", '" + carro.getMarca() + "', '"  
				       + carro.getModelo() + "', '" + carro.getCor() + "', '"+ carro.getKilometragem() + "');";
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}

	public Carro get(int id) {
		Carro carro = null;

		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM produto WHERE id=" + id;
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				carro = new Carro(rs.getInt("id"), rs.getString("marca"), rs.getString("modelo"),
						rs.getString("cor"), rs.getDouble("kilometragem"));
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return carro;
	}

	public List<Carro> get() {
		return get("");
	}

	public List<Carro> getOrderById() {
		return get("id");
	}

	public List<Carro> getOrderByMarca() {
		return get("marca");
	}

	public List<Carro> getOrderByModelo() {
		return get("modelo");
	}

	public List<Carro> getOrderByCor() {
		return get("modelo");
	}
	
	public List<Carro> getOrderByKilometragem() {
		return get("kilometragem");
	}
	
	private List<Carro> get(String orderBy) {

		List<Carro> carros = new ArrayList<Carro>();

		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM carro" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Carro c = new Carro(rs.getInt("id"), rs.getString("marca"), rs.getString("modelo"),
						rs.getString("cor"), rs.getDouble("kilometragem"));
				carros.add(c);
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return carros;
	}

	public boolean update(Carro carro) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			String sql = "UPDATE carro SET modelo = '" + carro.getModelo() + "', marca = '" + carro.getMarca()
					+ "', cor = '" + carro.getCor() + "'" + "', kilometragem = '" + carro.getKilometragem() + " WHERE id = " + carro.getId();
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}

	public boolean delete(int id) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			String sql = "DELETE FROM carro WHERE id = " + id;
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}

	public boolean autenticar(String modelo, String marca) {
		boolean resp = false;

		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM carro WHERE modeo LIKE '" + modelo + "' AND marca LIKE '" + marca + "'";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			resp = rs.next();
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return resp;
	}
}