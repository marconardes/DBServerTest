package common;

import java.util.ArrayList;
import java.util.List;

import restaurant.Restaurant;
import restaurant.Restaurants;
import users.ListOfUsers;
import users.User;

public class Install {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		installRestaurants();
		installUsers();
	}

	public static void installRestaurants()
	{
		Restaurants restaurantInstall = new Restaurants();
		List<Restaurant> restaurants = new ArrayList<Restaurant>();
		
		restaurants.add(new Restaurant(1,"Churascaria"));
		restaurants.add(new Restaurant(2,"Japones"));
		restaurants.add(new Restaurant(3,"Mineira"));
		restaurants.add(new Restaurant(4,"Vegana"));
		restaurants.add(new Restaurant(5,"McDonalds"));
		restaurants.add(new Restaurant(6,"Pizzaria"));
		restaurants.add(new Restaurant(7,"Prato Feito"));
		restaurants.add(new Restaurant(8,"Buffet/SelfService"));

		restaurantInstall.setRestaurants(restaurants);
		restaurantInstall.saveCSV();
	}
	
	public static void installUsers()
	{
		
		ListOfUsers userInstall = new ListOfUsers();
		List<User> users = new ArrayList<User>();
		
		users.add(new User(1,"Pessoa1", "1", null));
		users.add(new User(2,"Pessoa2", "2", null));
		users.add(new User(3,"Pessoa3", "3", null));
		users.add(new User(4,"Pessoa4", "4", null));
		users.add(new User(5,"Pessoa5", "5", null));
		users.add(new User(6,"Pessoa6", "6", null));
		users.add(new User(7,"Pessoa7", "7", null));
		users.add(new User(8,"Pessoa8", "8", null));
		users.add(new User(9,"Pessoa9", "9", null));
		users.add(new User(10,"Pessoa10", "10", null));
		
		userInstall.setUsers(users);
		userInstall.saveCSV();
	}
	
}
