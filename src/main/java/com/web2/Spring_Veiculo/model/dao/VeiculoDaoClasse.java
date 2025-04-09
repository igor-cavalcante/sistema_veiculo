package com.web2.Spring_Veiculo.model.dao;

import com.web2.Spring_Veiculo.connect.ConnectDao;
import com.web2.Spring_Veiculo.model.entity.Veiculo;

import java.lang.reflect.WildcardType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.util.List;

public class VeiculoDaoClasse implements  VeiculoDaoInterface {

    Connection con;
    public  VeiculoDaoClasse() {
        try {
            con = ConnectDao.dataSource();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Void insertVeiculo(Veiculo veiculo) throws ErrorDao {
        return null;
    }

    @Override
    public List<Veiculo> getAllVeiculos() throws ErrorDao {
        List<Veiculo> veiculos = new ArrayList<>();

        try {
            PreparedStatement psmt = con.prepareStatement("SELECT  * from veiculos");
            psmt.executeQuery();
            ResultSet rs = psmt.getResultSet();
while (rs.next()) {
    Veiculo veiculo = new Veiculo();
    veiculo.setId(rs.getInt("id"));
    veiculo.setMarca(rs.getString("marca"));
    veiculo.setModelo(rs.getString("modelo"));
    veiculo.setPreco(rs.getBigDecimal("preco"));
    veiculo.setAno(rs.getInt("ano_fabricacao"));
    veiculos.add(veiculo);
}
        } catch (SQLException e) {
            throw new ErrorDao(e);
        }

        System.out.println(veiculos);
        return veiculos;
    }

    @Override
    public List<Veiculo> getAllVeiculosByMarca(String marca) throws ErrorDao {
        return List.of();
    }

    @Override
    public List<Veiculo> getAllVeiculosByModelo(String modelo) throws ErrorDao {
        return List.of();
    }

    @Override
    public Veiculo getVeiculo(int id) throws ErrorDao {
        return null;
    }

    @Override
    public void updateVeiculo(Veiculo veiculo) throws ErrorDao {

    }

    @Override
    public void deleteById(int id) throws ErrorDao {

    }
        @Override
        public void sair() throws ErrorDao {
            try {
                if (con != null && !con.isClosed()) {
                    con.close();
                }
            } catch (SQLException e) {
                throw new ErrorDao(e);
            }
        }
    }

