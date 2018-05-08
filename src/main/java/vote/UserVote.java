package vote;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import restaurant.Restaurant;
import restaurant.Restaurants;
import users.User;

public class UserVote {

	private List<User> users;
	private List<Restaurant> restaurantsVotados;
	boolean resposta;
	
	public UserVote(List<User> users) {
		// TODO Auto-generated constructor stub
		this.users = users;
		this.restaurantsVotados = new ArrayList<>();
	}

	public List<User> vote(User user, Restaurant restaurant,LocalDate currentDate) {
		
		if(user.getDataDaVotacao()!=currentDate)
		{
			restaurantsVotados.add(restaurant);
			for(int c= 0; c<users.size() ; c++)
			{
				if(users.get(c).getId() ==user.getId()){

					resposta=true;
					user.setDataDaVotacao(currentDate);
					users.set(c, user);
				}
			}
		}
		else
		{
			resposta = false;
		}
		return users;
	}

	public boolean isResposta() {
		return resposta;
	}

	public void setResposta(boolean resposta) {
		this.resposta = resposta;
	}
	
	

}
