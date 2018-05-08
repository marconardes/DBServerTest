package dbserverTest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import restaurant.Restaurant;
import restaurant.Restaurants;
import users.ListOfUsers;
import users.User;
import vote.UserVote;

class UserVotting {

	@Test
	void OneVote() {
		ListOfUsers userList = new ListOfUsers();
		userList.populate();
		User user = userList.selectUser(1);
		Restaurants restaurantList = new Restaurants();
		restaurantList.populate();
		Restaurant restaurant = restaurantList.selectRestaurant(1);
		LocalDate cd = LocalDate.of(2018, 8, 05);
		UserVote votting = new UserVote(userList.getUsers());
		
		
		votting.vote(user,restaurant,cd);
		assertTrue(votting.isResposta());
	}
	
	
	@Test
	void TwoVoteInADay() {
		ListOfUsers userList = new ListOfUsers();
		userList.populate();
		User user = userList.selectUser(1);
		Restaurants restaurantList = new Restaurants();
		restaurantList.populate();
		Restaurant restaurant = restaurantList.selectRestaurant(1);
		LocalDate cd = LocalDate.of(2018, 8, 05);
		UserVote votting = new UserVote(userList.getUsers());
		
		userList.setUsers(votting.vote(user,restaurant,cd));
		assertTrue(votting.isResposta());

		user = userList.selectUser(1);
		userList.setUsers(votting.vote(user,restaurant,cd));
		assertFalse(votting.isResposta());
	}
	
	@Test
	void TwoVoteInDiferentDay() {
		ListOfUsers userList = new ListOfUsers();
		userList.populate();
		User user = userList.selectUser(1);
		Restaurants restaurantList = new Restaurants();
		restaurantList.populate();
		Restaurant restaurant = restaurantList.selectRestaurant(1);
		LocalDate cd = LocalDate.of(2018, 8, 05);
		UserVote votting = new UserVote(userList.getUsers());
		
		userList.setUsers(votting.vote(user,restaurant,cd));
		assertTrue(votting.isResposta());
		cd = LocalDate.of(2018, 8, 06);
		user = userList.selectUser(1);
		userList.setUsers(votting.vote(user,restaurant,cd));
		assertTrue(votting.isResposta());
	}
	
	@Test
	void TwoUsersVote() {
		ListOfUsers userList = new ListOfUsers();
		userList.populate();
		User user = userList.selectUser(1);
		Restaurants restaurantList = new Restaurants();
		restaurantList.populate();
		Restaurant restaurant = restaurantList.selectRestaurant(1);
		LocalDate cd = LocalDate.of(2018, 8, 05);
		UserVote votting = new UserVote(userList.getUsers());
		
		userList.setUsers(votting.vote(user,restaurant,cd));
		assertTrue(votting.isResposta());
		cd = LocalDate.of(2018, 8, 06);
		user = userList.selectUser(1);
		userList.setUsers(votting.vote(user,restaurant,cd));
		assertTrue(votting.isResposta());
	}


}
