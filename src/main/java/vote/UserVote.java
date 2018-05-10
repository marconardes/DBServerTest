package vote;


//TODO Modificar para reduzir variação de codigos............
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import exeptions.VoteExeption;
import restaurant.Restaurant;
import restaurant.Restaurants;
import users.User;

public class UserVote {

	private List<User> users;
	private List<Restaurant> restaurantsVotados;
	
	public UserVote(List<User> users) {
		// TODO Auto-generated constructor stub
		this.users = users;
		this.restaurantsVotados = new ArrayList<>();
	}

	public List<User> vote(User user, Restaurant restaurant,LocalDate currentDate) throws VoteExeption {
		
		if(user.getDataDaVotacao()!=currentDate)
		{
			System.out.println(restaurant.verificaBloqueio(currentDate));
			
			if(restaurant.verificaBloqueio(currentDate))
			{
				restaurantsVotados.add(restaurant);
			}
			else
				throw new VoteExeption();
			for(int c= 0; c<users.size() ; c++)
			{
				if(users.get(c).getId() ==user.getId()){

					user.setDataDaVotacao(currentDate);
					users.set(c, user);
				}
			}
		}
		return users;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Restaurant> getRestaurantsVotados() {
		return restaurantsVotados;
	}

	public void setRestaurantsVotados(List<Restaurant> restaurantsVotados) {
		this.restaurantsVotados = restaurantsVotados;
	}
	
	

}
