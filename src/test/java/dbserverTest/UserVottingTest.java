package dbserverTest;


import java.time.LocalDate;

import org.junit.Test;

import exeptions.VoteExeption;
import restaurant.Restaurant;
import restaurant.Restaurants;
import users.ListOfUsers;
import users.User;
import vote.UserVote;

public class UserVottingTest {

	@Test
	public void OneVote() throws VoteExeption {
		ListOfUsers userList = new ListOfUsers();
		userList.populate();
		User user = userList.selectUser(1);
		Restaurants restaurantList = new Restaurants();
		restaurantList.populate();
		Restaurant restaurant = restaurantList.selectRestaurant(1);
		LocalDate cd = LocalDate.of(2018, 8, 05);
		UserVote votting = new UserVote(userList.getUsers());
		
		
		votting.vote(user,restaurant,cd);
	}
	
	
	@Test
	public void TwoVoteInDay() throws VoteExeption {
		ListOfUsers userList = new ListOfUsers();
		userList.populate();
		User user = userList.selectUser(1);
		Restaurants restaurantList = new Restaurants();
		restaurantList.populate();
		
		Restaurant restaurant = restaurantList.selectRestaurant(1);
		LocalDate cd = LocalDate.of(2018, 8, 05);
		
		UserVote votting = new UserVote(userList.getUsers());
		userList.setUsers(votting.vote(user,restaurant,cd));

		user = userList.selectUser(1);
		userList.setUsers(votting.vote(user,restaurant,cd));
	}
	
	@Test
	public void TwoVoteInDiferentDay() throws VoteExeption {
		ListOfUsers userList = new ListOfUsers();
		userList.populate();
		User user = userList.selectUser(1);
		Restaurants restaurantList = new Restaurants();
		restaurantList.populate();
		Restaurant restaurant = restaurantList.selectRestaurant(1);
		LocalDate cd = LocalDate.of(2018, 8, 05);
		UserVote votting = new UserVote(userList.getUsers());
		
		userList.setUsers(votting.vote(user,restaurant,cd));
		cd = LocalDate.of(2018, 8, 06);
		user = userList.selectUser(1);
		userList.setUsers(votting.vote(user,restaurant,cd));
	
	}
	
	@Test
	public void TwoUsersVote() throws VoteExeption {
		ListOfUsers userList = new ListOfUsers();
		userList.populate();
		User user = userList.selectUser(1);
		Restaurants restaurantList = new Restaurants();
		restaurantList.populate();
		Restaurant restaurant = restaurantList.selectRestaurant(1);
		LocalDate cd = LocalDate.of(2018, 8, 05);
		UserVote votting = new UserVote(userList.getUsers());
		
		userList.setUsers(votting.vote(user,restaurant,cd));
	
		user = userList.selectUser(2);
		userList.setUsers(votting.vote(user,restaurant,cd));
	}

	
}
