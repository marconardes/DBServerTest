package com.marco.vottingSystem;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import com.marco.dbservertest.beans.Usuario;
import com.marco.install.Install;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class VottingSystemMecanicsTest {
	
	@Test
	public void vottingHoraInvalida() {
		Install.main();		
		VottingSystem vs = new VottingSystem();
		
		LocalTime lt = LocalTime.of(11, 40);
		assertFalse(vs.horaValida(lt));
		
	}
	
	@Test
	public void vottingHoraValida() {
		Install.main();		

		VottingSystem vs = new VottingSystem();
		
		LocalTime lt = LocalTime.of(11, 20);
		assertTrue(vs.horaValida(lt));

		
	}
	
	@Test
	public void passwordInvalid(){
		Install.main();		

		VottingSystem vs = new VottingSystem();
		LocalTime lt = LocalTime.of(11,00);
		LocalDate ld = LocalDate.of(2018, 05, 10);
		
		assertTrue(vs.prepare(ld, lt));
		Usuario user =vs.getListOfUsers().get(0);
                vs.setUser(user);
		assertFalse(user.validPassword("2"));
		assertFalse(vs.validaUsuario("2"));
		vs.close();
	}
	
	@Test
	public void prepareValid(){
		Install.main();		

		VottingSystem vs = new VottingSystem();
		LocalTime lt = LocalTime.of(11,00);
		LocalDate ld = LocalDate.of(2018, 05, 10);
		
		assertTrue(vs.prepare(ld, lt));
		assertFalse(vs.getListOfUsers().isEmpty());
		
		Usuario user =vs.getListOfUsers().get(0);
		vs.setUser(user);
                assertTrue(user.validPassword("1"));
		assertTrue(vs.validaUsuario("1"));
		vs.close();
	}
	
	
	
}
