package dbserverTest;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.time.LocalDate;

import org.apache.derby.impl.sql.catalog.SYSFOREIGNKEYSRowFactory;
import org.junit.Before;
import org.junit.Test;

import exeptions.VoteExeption;
import restaurant.Restaurant;
import restaurant.Restaurants;
import users.ListOfUsers;
import users.User;
import vote.CountVote;
import vote.UserVote;

public class CountingVotesTest {

	private ListOfUsers lusers;
	
	private Restaurants restaurantes;
	private UserVote votting;
	
	@Before
	public void initialize()
	{
		System.out.println("INICIALIZANDO VARIAVEIS");
		
		lusers = new ListOfUsers();
		lusers.populate();
		
		restaurantes = new Restaurants();
		restaurantes.populate();
		votting = new UserVote(lusers.getUsers());
		
		
	}
	
	private void dayOneVotting(LocalDate ld) throws VoteExeption {
		System.out.println("Inicializando dia 1");
		
		 
		User user = lusers.selectUser(1);
		Restaurant restaurant = restaurantes.selectRestaurant(1);
		lusers.setUsers(votting.vote(user,restaurant,ld));
		
		
		user = lusers.selectUser(2);
		restaurant = restaurantes.selectRestaurant(2);
		lusers.setUsers(votting.vote(user,restaurant,ld));
		
		user = lusers.selectUser(3);
		restaurant = restaurantes.selectRestaurant(1);
		lusers.setUsers(votting.vote(user,restaurant,ld));

		user = lusers.selectUser(4);
		restaurant = restaurantes.selectRestaurant(3);
		lusers.setUsers(votting.vote(user,restaurant,ld));
		
		user = lusers.selectUser(5);
		restaurant = restaurantes.selectRestaurant(1);
		lusers.setUsers(votting.vote(user,restaurant,ld));

		user = lusers.selectUser(6);
		restaurant = restaurantes.selectRestaurant(1);
		lusers.setUsers(votting.vote(user,restaurant,ld));
		
		user = lusers.selectUser(7);
		restaurant = restaurantes.selectRestaurant(1);
		lusers.setUsers(votting.vote(user,restaurant,ld));
		
		user = lusers.selectUser(8);
		restaurant = restaurantes.selectRestaurant(1);
		lusers.setUsers(votting.vote(user,restaurant,ld));
		
		user = lusers.selectUser(9);
		restaurant = restaurantes.selectRestaurant(1);
		lusers.setUsers(votting.vote(user,restaurant,ld));
		
		user = lusers.selectUser(10);
		restaurant = restaurantes.selectRestaurant(1);
		lusers.setUsers(votting.vote(user,restaurant,ld));

		}
	
	@Test
	public void countVottingsOneDayTest() throws VoteExeption
	{
		LocalDate ld = LocalDate.of(2018, 05, 7);
		dayOneVotting(ld);
		CountVote cv =new CountVote();
		assertTrue(lusers.allVote(ld));
		cv.computeVotes(votting.getRestaurantsVotados());

		
		
		assertEquals("Churascaria",cv.retornaVencedor());
	}
	
	
	
	@Test(expected=VoteExeption.class)
	public void countVottingsExeptionVottingTest() throws VoteExeption
	{
	    
		LocalDate ld = LocalDate.of(2018, 05, 7);
		dayOneVotting(ld);
		CountVote cv =new CountVote();
		
		
		cv.computeVotes(votting.getRestaurantsVotados());
		
		cv.retornaVencedor();
		
		restaurantes = cv.updateRestaurants(restaurantes,ld);
		
		
		ld = LocalDate.of(2018, 05, 8);
		dayOneVotting(ld);
		
	}
	
}
