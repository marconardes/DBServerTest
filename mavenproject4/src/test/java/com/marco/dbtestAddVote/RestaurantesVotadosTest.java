/**
 * 
 */
package com.marco.dbtestAddVote;

import com.marco.dbservertest.beans.Restaurantes;
import com.marco.dbservertest.beans.Votos;
import com.marco.dbservertest.controlers.RestaurantesJpaController;
import com.marco.dbservertest.controlers.VotosJpaController;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.marco.install.Install;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author marco
 *
 */
public class RestaurantesVotadosTest{

	private Votos rv;
	private VotosJpaController controlerRV;
	private RestaurantesJpaController controlRest;
	
	@BeforeEach
	public void limpaDb()
	{
		Install.main();
                        
		rv = new Votos();
		

	}
	
	
	@Test
	public void verificaLista()
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("commonPU");
    	        controlRest = new RestaurantesJpaController(emf);
                
		List<Restaurantes> rest =controlRest.findRestaurantesEntities();
		
		assertEquals(8, rest.size());
                emf.close();
	}
        
        
        
        @Test
	public void addVotos()
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("commonPU");
		controlerRV =  new VotosJpaController(emf);
    	        controlRest = new RestaurantesJpaController(emf);
                
		List<Restaurantes> rest =controlRest.findRestaurantesEntities();
		
                
                
                Votos votos = new Votos();
                votos.setLd(LocalDate.now());
                
                     
                votos.setRestaurant(rest.get(0));
                
                controlerRV.create(votos);
                
                votos = new Votos();
                votos.setLd(LocalDate.now());
                votos.setRestaurant(rest.get(0));
                
                controlerRV.create(votos);
                
                assertEquals(2, controlerRV.getVotosCount());
                assertEquals(8, rest.size());	
                emf.close();
	}
        
        
    @Test
	public void verificaData()
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("commonPU");
		controlerRV =  new VotosJpaController(emf);
    	        controlRest = new RestaurantesJpaController(emf);
                
		List<Restaurantes> rest =controlRest.findRestaurantesEntities();
		
                
                
                Votos votos = new Votos();
                votos.setLd(LocalDate.now());
                
                     
                votos.setRestaurant(rest.get(0));
                
                controlerRV.create(votos);
                
                votos = new Votos();
                votos.setLd(LocalDate.of(2018, 1, 5));
                votos.setRestaurant(rest.get(0));
                
                controlerRV.create(votos);
                
                assertEquals(1,controlerRV.findVotesByDay(LocalDate.now()).size());
                assertEquals(2, controlerRV.getVotosCount());
                assertEquals(8, rest.size());	
                emf.close();
	}
    
    @Test
  	public void verificaVotos()
  	{
  		EntityManagerFactory emf = Persistence.createEntityManagerFactory("commonPU");
  		controlerRV =  new VotosJpaController(emf);
      	        controlRest = new RestaurantesJpaController(emf);
                  
  		List<Restaurantes> rest =controlRest.findRestaurantesEntities();
  		
                  
                  
                  Votos votos = new Votos();
                  votos.setLd(LocalDate.now());
                  
                       
                  votos.setRestaurant(rest.get(0));
                  
                  controlerRV.create(votos);
                  
                  votos = new Votos();
                  votos.setLd(LocalDate.now());
                  votos.setRestaurant(rest.get(0));
                  
                  controlerRV.create(votos);
                  
                  assertEquals(2,controlerRV.findVotesByDay(LocalDate.now()).size());
                  assertEquals(2,controlerRV.findVotesOfSameRestaurantInDay(rest.get(0), LocalDate.now()));
                  assertEquals(2, controlerRV.getVotosCount());
                  assertEquals(8, rest.size());	
                  emf.close();
  	}
}
