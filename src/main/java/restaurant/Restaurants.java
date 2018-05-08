package restaurant;

import java.util.ArrayList;
import java.util.List;

import users.User;

public class Restaurants {

	public List<Restaurant> restaurants;

	
	
	public Restaurants() {
		
		this.restaurants = new ArrayList<Restaurant>();
	}

	public List<Restaurant> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}

	public void populate() {
		restaurants.add(new Restaurant(1,"Churascaria"));
		restaurants.add(new Restaurant(2,"Japones"));
		restaurants.add(new Restaurant(3,"Mineira"));
		restaurants.add(new Restaurant(4,"Baiana"));
		restaurants.add(new Restaurant(5,"McDonalds"));
		restaurants.add(new Restaurant(6,"Pizzaria"));
		restaurants.add(new Restaurant(7,"Prato Feito"));
		restaurants.add(new Restaurant(8,"Buffet/SelfService"));
		
	}

	public Restaurant selectRestaurant(int id) {
		
		for (Restaurant restaurant : restaurants) {
			if(restaurant.id == id)
			{
				return restaurant;
			}
		}
		
		return null;
	}
	
	
	
}
