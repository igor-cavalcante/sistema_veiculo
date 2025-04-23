package com.web2.Spring_Veiculo.model.repository;


import com.web2.Spring_Veiculo.model.entity.Veiculo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.reactive.TransactionalOperator;

import java.util.List;

@Repository
public class VeiculoRepository {

    @PersistenceContext
    private EntityManager em;

    // Buscar todos os veículos
    public List<Veiculo> getAllVeiculos() {
        TypedQuery<Veiculo> query = em.createQuery("SELECT v FROM Veiculo v", Veiculo.class);
        return query.getResultList();
    }

    // Buscar veículo por ID (alterado para Long)
    public Veiculo getVeiculo(Long id) {
        return em.find(Veiculo.class, id);
    }

    // Salvar veículo (inserir ou atualizar)
    @Transactional
    public Veiculo salvar(Veiculo veiculo) {
        if (veiculo.getId() == null) {
            em.persist(veiculo);
            return veiculo;
        } else {
            return em.merge(veiculo);
        }
    }

    // Excluir veículo (alterado para Long)
    @Transactional
    public void excluir(Long id) {
        Veiculo veiculo = em.find(Veiculo.class, id);
        if (veiculo != null) {
            em.remove(veiculo);
        }
    }

}
