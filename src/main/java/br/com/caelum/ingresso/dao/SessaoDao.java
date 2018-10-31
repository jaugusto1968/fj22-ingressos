package br.com.caelum.ingresso.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Sessao;

@Repository
public class SessaoDao {

	@PersistenceContext
	private EntityManager manager;
	
	
	public void save(Sessao sessao){
		manager.persist(sessao);
	}
	
	public List<Sessao> buscaSessoesDaSala(Integer salaId){
		return manager.createQuery("select s from Sessao s Where s.sala.id =:id", Sessao.class)
				.setParameter("id", salaId)
				.getResultList();
	}
	
	public List<Sessao> buscaSessoesDoFilme(Filme filme){
		return manager.createQuery("select s from Sessao s Where s.filme =:filme", Sessao.class)
				.setParameter("filme", filme)
				.getResultList();
	}	
	
	
}
