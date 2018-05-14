package com.marco.vottingSystem;


import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.marco.dbservertest.beans.Restaurantes;
import com.marco.dbservertest.beans.Usuario;
import com.marco.dbservertest.beans.Votos;
import com.marco.dbservertest.controlers.UsuarioJpaController;
import com.marco.dbservertest.controlers.VotosJpaController;
import com.marco.dbservertest.controlers.exceptions.NonexistentEntityException;
import com.marco.install.Install;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VottingSystemMecanicsVotting {
	
	
	private Votos resultados;
	private VotosJpaController controlerRV;
	
	static VottingSystem vs;
	private LocalTime lt;
	private LocalDate ld;
	


	
	@Test
	public void votting8Days() throws NonexistentEntityException, Exception {
		Install.main();
		vs = new VottingSystem();
		
		
	    lt = LocalTime.of(11, 00);
	    ld = LocalDate.of(2018, 05, 07);
	    
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("commonPU");
		controlerRV =new VotosJpaController(emf);
		
		
		assertTrue(controlerRV.findVotesByDay(ld).isEmpty());
		assertTrue(vs.horaValida(lt));
		vs.prepare(ld, lt);
		assertEquals(8, vs.getRestaurantes().size());
		
		
		assertEquals(3,vs.getListOfUsers().size());
		Usuario usuario = vs.getListOfUsers().get(0);
		Restaurantes restaurante1 = vs.getRestaurantes().get(0);
		Restaurantes restaurante2 = vs.getRestaurantes().get(1);
		
		
		vs.setUser(usuario);
		assertTrue(vs.validaUsuario("1"));		
		assertTrue(vs.vote(restaurante1));
		
		vs.prepare(ld, lt);
		assertEquals(2,vs.getListOfUsers().size());
			
		usuario = vs.getListOfUsers().get(0);
		vs.setUser(usuario);
		assertTrue(vs.validaUsuario("2"));		
		assertTrue(vs.vote(restaurante2));

		vs.prepare(ld, lt);
		assertEquals(1,vs.getListOfUsers().size());
		
		usuario = vs.getListOfUsers().get(0);
		vs.setUser(usuario);
		assertTrue(vs.validaUsuario("3"));		
		assertTrue(vs.vote(restaurante1));

		vs.prepare(ld, lt);
		assertEquals(0,vs.getListOfUsers().size());
		
		assertTrue(vs.getListOfUsers().isEmpty());
		
		assertEquals("Churrascaria",vs.resultadosEleicao());
		vs.close();
		
		vottingDay2();
		vottingDay3();
		vottingDay4();
		vottingDay5();
		vottingDay6();
		vottingDay7();
		vottingDay8();
	}
	


	public void vottingDay2() throws NonexistentEntityException, Exception
	{
	

		vs = new VottingSystem();
		
		
	    lt = LocalTime.of(11, 00);
	    ld = ld.plusDays(1);
	    
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("commonPU");
		controlerRV =new VotosJpaController(emf);

		ld.plusDays(1);
		vs.prepare(ld, lt);
		assertEquals(7, vs.getRestaurantes().size());
		Restaurantes restaurante1 = vs.getRestaurantes().get(0);
		Restaurantes restaurante2 = vs.getRestaurantes().get(1);
		addUser("1",restaurante2);
		addUser("2",restaurante1);
		addUser("3",restaurante2);
		vs.prepare(ld, lt);
		assertEquals(0,vs.getListOfUsers().size());
		assertTrue(vs.getListOfUsers().isEmpty());
		assertEquals("Vegetariana",vs.resultadosEleicao());
		vs.close();
		
		
	}
	
	public void vottingDay3() throws NonexistentEntityException, Exception
	{
	

		vs = new VottingSystem();
		
		
	    lt = LocalTime.of(11, 00);
	    ld = ld.plusDays(1);
	    
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("commonPU");
		controlerRV =new VotosJpaController(emf);

		ld.plusDays(1);
		vs.prepare(ld, lt);
		assertEquals(6, vs.getRestaurantes().size());
		Restaurantes restaurante1 = vs.getRestaurantes().get(0);
		Restaurantes restaurante2 = vs.getRestaurantes().get(1);
		addUser("1",restaurante2);
		addUser("2",restaurante1);
		addUser("3",restaurante2);
		vs.prepare(ld, lt);
		assertEquals(0,vs.getListOfUsers().size());
		assertTrue(vs.getListOfUsers().isEmpty());
		assertEquals("Indiana",vs.resultadosEleicao());
		vs.close();
		
		
	}
	
	public void vottingDay4() throws NonexistentEntityException, Exception
	{
	

		vs = new VottingSystem();
		
		
	    lt = LocalTime.of(11, 00);
	    ld = ld.plusDays(1);
	    
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("commonPU");
		controlerRV =new VotosJpaController(emf);

		ld.plusDays(1);
		vs.prepare(ld, lt);
		assertEquals(5, vs.getRestaurantes().size());
		Restaurantes restaurante1 = vs.getRestaurantes().get(0);
		Restaurantes restaurante2 = vs.getRestaurantes().get(1);
		addUser("1",restaurante2);
		addUser("2",restaurante1);
		addUser("3",restaurante2);
		vs.prepare(ld, lt);
		assertEquals(0,vs.getListOfUsers().size());
		assertTrue(vs.getListOfUsers().isEmpty());
		assertEquals("McLanche",vs.resultadosEleicao());
		vs.close();
		
		
	}
	
	public void vottingDay5() throws NonexistentEntityException, Exception
	{
	

		vs = new VottingSystem();
		
		
	    lt = LocalTime.of(11, 00);
	    ld = ld.plusDays(1);
	    
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("commonPU");
		controlerRV =new VotosJpaController(emf);

		ld.plusDays(1);
		vs.prepare(ld, lt);
		assertEquals(4, vs.getRestaurantes().size());
		Restaurantes restaurante1 = vs.getRestaurantes().get(0);
		Restaurantes restaurante2 = vs.getRestaurantes().get(1);
		addUser("1",restaurante2);
		addUser("2",restaurante1);
		addUser("3",restaurante2);
		vs.prepare(ld, lt);
		assertEquals(0,vs.getListOfUsers().size());
		assertTrue(vs.getListOfUsers().isEmpty());
		assertEquals("X-TUDO",vs.resultadosEleicao());
		vs.close();
		
		
	}
	
	public void vottingDay6() throws NonexistentEntityException, Exception
	{
	

		vs = new VottingSystem();
		
		
	    lt = LocalTime.of(11, 00);
	    ld = ld.plusDays(1);
	    
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("commonPU");
		controlerRV =new VotosJpaController(emf);

		ld.plusDays(1);
		vs.prepare(ld, lt);
		assertEquals(3, vs.getRestaurantes().size());
		Restaurantes restaurante1 = vs.getRestaurantes().get(0);
		Restaurantes restaurante2 = vs.getRestaurantes().get(1);
		addUser("1",restaurante2);
		addUser("2",restaurante1);
		addUser("3",restaurante2);
		vs.prepare(ld, lt);
		assertEquals(0,vs.getListOfUsers().size());
		assertTrue(vs.getListOfUsers().isEmpty());
		assertEquals("SelfService",vs.resultadosEleicao());
		vs.close();
		
		
	}
	
	public void vottingDay7() throws NonexistentEntityException, Exception
	{
	

		vs = new VottingSystem();
		
		
	    lt = LocalTime.of(11, 00);
	    ld = ld.plusDays(1);
	    
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("commonPU");
		controlerRV =new VotosJpaController(emf);

		ld.plusDays(1);
		vs.prepare(ld, lt);
		assertEquals(2, vs.getRestaurantes().size());
		Restaurantes restaurante1 = vs.getRestaurantes().get(0);
		Restaurantes restaurante2 = vs.getRestaurantes().get(1);
		addUser("1",restaurante1);
		addUser("2",restaurante1);
		addUser("3",restaurante2);
		vs.prepare(ld, lt);
		assertEquals(0,vs.getListOfUsers().size());
		assertTrue(vs.getListOfUsers().isEmpty());
		assertEquals("Chinesa",vs.resultadosEleicao());
		vs.close();
		
		
	}
	
	public void vottingDay8() throws NonexistentEntityException, Exception
	{
	

		vs = new VottingSystem();
		
		
	    lt = LocalTime.of(11, 00);
	    ld = ld.plusDays(1);
	    
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("commonPU");
		controlerRV =new VotosJpaController(emf);

		ld.plusDays(1);
		vs.prepare(ld, lt);
		assertEquals(8, vs.getRestaurantes().size());
		Restaurantes restaurante1 = vs.getRestaurantes().get(0);
		Restaurantes restaurante2 = vs.getRestaurantes().get(1);
		addUser("1",restaurante1);
		addUser("2",restaurante1);
		addUser("3",restaurante2);
		vs.prepare(ld, lt);
		assertEquals(0,vs.getListOfUsers().size());
		assertTrue(vs.getListOfUsers().isEmpty());
		assertEquals("Churrascaria",vs.resultadosEleicao());
		vs.close();
		
		
	}
	
	
	void addUser(String senha,Restaurantes restaurante) throws NonexistentEntityException, Exception
	{
		vs.prepare(ld, lt);
		Usuario usuario;
		usuario = vs.getListOfUsers().get(0);
		vs.setUser(usuario);
		assertTrue(vs.validaUsuario(senha));		
		assertTrue(vs.vote(restaurante));
	}
	
	
	
}
