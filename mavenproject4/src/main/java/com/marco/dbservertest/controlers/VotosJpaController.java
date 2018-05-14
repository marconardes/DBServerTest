/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marco.dbservertest.controlers;

import com.marco.dbservertest.beans.Restaurantes;
import com.marco.dbservertest.beans.Votos;
import com.marco.dbservertest.controlers.exceptions.NonexistentEntityException;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author marco
 */
public class VotosJpaController implements Serializable {

    public VotosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Votos votos) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(votos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

 


    public List<Votos> findVotosEntities() {
        return findVotosEntities(true, -1, -1);
    }

    public List<Votos> findVotesByDay(LocalDate now)
    {
        List<Votos> votos = new ArrayList<>();
        
        findVotosEntities().stream().filter((findVotosEntity) -> (findVotosEntity.getLd().isEqual(now))).forEachOrdered((findVotosEntity) -> {
            votos.add(findVotosEntity);
        });
        
        return votos;
    }
    
    public int findVotesOfSameRestaurantInDay(Restaurantes restaurantes, LocalDate ld)
    {
        int votos =0;
        for (Votos findVotosEntity : findVotesByDay(ld)) {
            if(findVotosEntity.getRestaurant().getIdRestaurantes()==restaurantes.getIdRestaurantes())
            {
            	votos++;
            }
        }
        
        return votos;
    }
    
    public List<Votos> findVotosEntities(int maxResults, int firstResult) {
        return findVotosEntities(false, maxResults, firstResult);
    }

    private List<Votos> findVotosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Votos.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Votos findVotos(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Votos.class, id);
        } finally {
            em.close();
        }
    }

    public int getVotosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Votos> rt = cq.from(Votos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
