package com.web2.Spring_Veiculo.model.dao;

import com.web2.Spring_Veiculo.model.entity.Veiculo;

import java.util.List;

public interface VeiculoDaoInterface {

        public Void insertVeiculo(Veiculo veiculo) throws ErrorDao;
        public List<Veiculo> getAllVeiculos() throws ErrorDao;
        public List<Veiculo> getAllVeiculosByMarca(String marca) throws ErrorDao;
        public List<Veiculo> getAllVeiculosByModelo(String modelo)  throws ErrorDao;
        public Veiculo getVeiculo(int id) throws ErrorDao;
        public void updateVeiculo(Veiculo veiculo) throws ErrorDao;
        public void deleteById(int id) throws ErrorDao;
        public void sair() throws ErrorDao;


}
