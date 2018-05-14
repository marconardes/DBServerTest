package com.marco.vottingSystem;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import com.marco.dbservertest.beans.Restaurantes;
import com.marco.dbservertest.beans.Usuario;
import com.marco.dbservertest.beans.Votos;
import com.marco.dbservertest.controlers.RestaurantesJpaController;
import com.marco.dbservertest.controlers.UsuarioJpaController;
import com.marco.dbservertest.controlers.VotosJpaController;
import com.marco.dbservertest.controlers.exceptions.NonexistentEntityException;


public class VottingSystem {

        private Usuario user;
	private List<Usuario> listOfUsers;
	private LocalDate ld;
	private LocalTime lt, horaInicio, horaFinal;
	
	private EntityManagerFactory emf;
	private RestaurantesJpaController controlRest;
	
	private VotosJpaController votosController;
	private UsuarioJpaController usersControler;
	
	HashMap<Restaurantes,Integer> restauranteContagem;
	List<Restaurantes> restaurantes;

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

        
        
        
	public VottingSystem()
	{
		listOfUsers = null;
		ld = null;
		horaInicio = LocalTime.of(8,00);
		horaFinal = LocalTime.of(11, 30);
               
	}

	public boolean horaValida(LocalTime lt)
	{
		this.lt = lt;
		return lt.isAfter(horaInicio)&&lt.isBefore(horaFinal);
	}
	
        public boolean prepare()
        {
            lt = LocalTime.now();
            ld = LocalDate.now();
            return prepare(ld,lt);
        }
        
	public boolean prepare(LocalDate ld,LocalTime lt)
	{
		this.lt = lt;
		this.ld = ld;
		boolean initialize = horaValida(lt);
		emf = Persistence.createEntityManagerFactory("commonPU");
		controlRest = new RestaurantesJpaController(emf);
		usersControler = new UsuarioJpaController(emf);
		restaurantes =controlRest.findRestaurantesEntitiesNotVotedTheWeek(ld);
		
		listOfUsers = usersControler.findUsuarioEntitiesRestantes(ld);
                
		return initialize;
	}
	
	public boolean validaUsuario(String senha)
	{
		return user.validPassword(senha);	
	}
	
	public boolean vote(Restaurantes restaurante) throws NonexistentEntityException, Exception
	{
		votosController = new VotosJpaController(emf);
		Votos voto = new Votos();
		voto.setRestaurant(restaurante);
		voto.setLd(ld);
		user.setData(ld);
		
		usersControler.edit(user);
		votosController.create(voto);
		
		return true;	
	}
	
	public List<Usuario> getListOfUsers() {
		return listOfUsers;
	}

	public void setListOfUsers(List<Usuario> listOfUsers) {
		this.listOfUsers = listOfUsers;
	}

	public LocalDate getLd() {
		return ld;
	}

	public void setLd(LocalDate ld) {
		this.ld = ld;
	}

	public LocalTime getLt() {
		return lt;
	}

	public void setLt(LocalTime lt) {
		this.lt = lt;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalTime getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(LocalTime horaFinal) {
		this.horaFinal = horaFinal;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public RestaurantesJpaController getControlRest() {
		return controlRest;
	}

	public void setControlRest(RestaurantesJpaController controlRest) {
		this.controlRest = controlRest;
	}

	public VotosJpaController getVotosController() {
		return votosController;
	}

	public void setVotosController(VotosJpaController votosController) {
		this.votosController = votosController;
	}

	public UsuarioJpaController getUsersControler() {
		return usersControler;
	}

	public void setUsersControler(UsuarioJpaController usersControler) {
		this.usersControler = usersControler;
	}

	public List<Restaurantes> getRestaurantes() {
		return restaurantes;
	}

	public void setRestaurantes(List<Restaurantes> restaurantes) {
		this.restaurantes = restaurantes;
	}

	
        
	public void geraResultados()
	{
            votosController = new VotosJpaController(emf);
		restauranteContagem = new HashMap<>();
		for (Restaurantes restaurante : restaurantes) {
                    
                    int cont = votosController.findVotesOfSameRestaurantInDay(restaurante, ld);
			restauranteContagem.put(restaurante, cont);
		}
	}
	
	public String resultadosEleicao() throws IlegalClosingVotting {
		
                Restaurantes r = null;
		int i =0;
		
                
		if((lt.isAfter(horaFinal))||(listOfUsers.isEmpty()))
		{
			geraResultados();
			  for (Map.Entry<Restaurantes,Integer> entry : restauranteContagem.entrySet()) {
		            if(i == 0)
		            {
		            	r = entry.getKey();
		            	i =entry.getValue();
		            	
		            }
		            else if((int)entry.getValue()>i)
		            {
		              		r = entry.getKey();
			            	i =entry.getValue();
		           
		            }
		        }
			
		}
		else
		{
			throw new IlegalClosingVotting();
		}
		
                if(r!=null)
                {
                	LocalDate ldd = ld.minusDays(ld.getDayOfWeek().getValue());
                	ldd = ldd.plusDays(7);
                	r.setLiberado(ldd);
                	try {
						controlRest.edit(r);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                	
                    return r.getNome();
                }
		return "Falha";
	}

	public void close() {
		emf.close();
		
	}
	
	
	
}
