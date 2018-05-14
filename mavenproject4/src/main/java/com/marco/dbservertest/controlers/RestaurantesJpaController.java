/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marco.dbservertest.controlers;

import com.marco.dbservertest.beans.Restaurantes;
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
public class RestaurantesJpaController implements Serializable {

    public RestaurantesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Restaurantes restaurantes) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(restaurantes);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Restaurantes restaurantes) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            restaurantes = em.merge(restaurantes);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = restaurantes.getIdRestaurantes();
                if (findRestaurantes(id) == null) {
                    throw new NonexistentEntityException("The restaurantes with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Restaurantes restaurantes;
            try {
                restaurantes = em.getReference(Restaurantes.class, id);
                restaurantes.getIdRestaurantes();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The restaurantes with id " + id + " no longer exists.", enfe);
            }
            em.remove(restaurantes);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Restaurantes> findRestaurantesEntities() {
        return findRestaurantesEntities(true, -1, -1);
    }

    public List<Restaurantes> findRestaurantesEntities(int maxResults, int firstResult) {
        return findRestaurantesEntities(false, maxResults, firstResult);
    }

    private List<Restaurantes> findRestaurantesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Restaurantes.class));
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

    public Restaurantes findRestaurantes(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Restaurantes.class, id);
        } finally {
            em.close();
        }
    }

    public int getRestaurantesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Restaurantes> rt = cq.from(Restaurantes.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

	public List<Restaurantes> findRestaurantesEntitiesNotVotedTheWeek(LocalDate ld) {
		// TODO Auto-generated method stub
		List<Restaurantes> restaurantes =  new ArrayList<>();
		
		for (Restaurantes tRestaurante : findRestaurantesEntities()) {
			if(tRestaurante.getLiberado()==null)
			{
				restaurantes.add(tRestaurante);
			}
			else if (ld.isAfter(tRestaurante.getLiberado())) {
				restaurantes.add(tRestaurante);
			}
		}
		return restaurantes;
	}


    
}
