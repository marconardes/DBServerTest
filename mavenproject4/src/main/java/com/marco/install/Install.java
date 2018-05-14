/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marco.install;

import com.marco.dbservertest.beans.Restaurantes;
import com.marco.dbservertest.beans.Usuario;
import com.marco.dbservertest.controlers.RestaurantesJpaController;
import com.marco.dbservertest.controlers.UsuarioJpaController;

import java.time.LocalDate;
import java.util.ResourceBundle.Control;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author marco
 */
public class Install {


    public static void main(String... args) {
    	System.out.println("INICIALIZANDO O BANCO DE DADOS");
    	
        System.out.println("ADICIONANDO RESTAURANTES");

        add();
        
    }
    
    
    
    private static void add()
    {
    	LocalDate ld = LocalDate.now().minusDays(10);
         EntityManagerFactory factory = Persistence.createEntityManagerFactory("installPU");

    	RestaurantesJpaController control;
    	control = new RestaurantesJpaController(factory);
    	
    	Restaurantes restaurantes =new Restaurantes();
    	restaurantes.setNome("Churrascaria");
    	restaurantes.setLiberado(ld);
    	control.create(restaurantes);
    	
    	restaurantes =new Restaurantes();
    	restaurantes.setNome("Chinesa");
    	restaurantes.setLiberado(ld);
    	control.create(restaurantes);
    	
    	
    	restaurantes =new Restaurantes();
    	restaurantes.setNome("Vegetariana");
    	restaurantes.setLiberado(ld);
    	control.create(restaurantes);
    	
    	
    	restaurantes =new Restaurantes();
    	restaurantes.setNome("Indiana");
    	restaurantes.setLiberado(ld);
    	control.create(restaurantes);
    	
    	
    	restaurantes =new Restaurantes();
    	restaurantes.setNome("McLanche");
    	restaurantes.setLiberado(ld);
    	control.create(restaurantes);
    	
    	
    	restaurantes =new Restaurantes();
    	restaurantes.setNome("X-TUDO");
    	restaurantes.setLiberado(ld);
    	control.create(restaurantes);
    	
    	
    	restaurantes =new Restaurantes();
    	restaurantes.setNome("SelfService");
    	restaurantes.setLiberado(ld);
    	control.create(restaurantes);
    	
    	
    	restaurantes =new Restaurantes();
    	restaurantes.setNome("Sopa");
    	restaurantes.setLiberado(ld);
        control.create(restaurantes);
    	
        System.out.println("ADICIONANDO USUARIOS");
		Usuario usuario;

        usuario = new Usuario();

        usuario.setNome("Usuario1");
        usuario.setSenha("1");
        
       
        UsuarioJpaController controlU = new UsuarioJpaController(factory);

        controlU.create(usuario);

        usuario = new Usuario();
        usuario.setNome("Usuario2");

        usuario.setSenha("2");
        controlU.create(usuario);

        usuario = new Usuario();
        usuario.setNome("Usuario3");

        usuario.setSenha("3");
        controlU.create(usuario);
        
        factory.close();
	}
    
}
