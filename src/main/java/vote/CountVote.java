package vote;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

import restaurant.Restaurant;
import restaurant.Restaurants;

public class CountVote {

	private Map<Restaurant,Integer> contagem;
	private Restaurant vencedorFinal;
	public CountVote()
	{
		contagem= new HashMap<Restaurant,Integer>();
		vencedorFinal = null;
	}

	public void computeVotes(List<Restaurant> restaurantsVotados) {

		
		for (Restaurant restaurant : restaurantsVotados) {
			if(contagem.containsKey(restaurant))
			{
				int cont = contagem.get(restaurant);
				cont++;
				contagem.put(restaurant, cont);
			}
			else
			{
				contagem.put(restaurant, 1);
			}
		}
		
	}

	public Map<Restaurant, Integer> getContagem() {
		return contagem;
	}

	public void setContagem(Map<Restaurant, Integer> contagem) {
		this.contagem = contagem;
	}

	public String retornaVencedor() {
		// TODO Auto-generated method stub
		Restaurant vencedor=null;
		int resultado =0;
		
		for (Restaurant key : contagem.keySet())
		{
			if(vencedor==null)
			{
				vencedor = key;
				resultado = contagem.get(key);
			}
			else if(vencedor!=null)
			{
				if(contagem.get(key)>resultado)
				{
					vencedor = key;
					resultado =contagem.get(key);
				}
			}
		}
		vencedorFinal = vencedor;
		return vencedor.getNome();
	}
	
	public Restaurants updateRestaurants(Restaurants restaurantes, LocalDate ld)
	{
		List<Restaurant> restaurantesUpdate = restaurantes.getRestaurants();

		int minus = ld.getDayOfWeek().getValue()-1;
		LocalDate nextDayToVote = ld.minusDays(minus);
		nextDayToVote = nextDayToVote.plusDays(7);
		
		for(int c=0; restaurantesUpdate.size()>c;c++)
		{
			System.out.println(restaurantesUpdate.get(c).toString());
			System.out.println(vencedorFinal.toString());
			
			if(restaurantesUpdate.get(c).getId() == vencedorFinal.getId())
			{
				restaurantesUpdate.get(c).setLiberado(nextDayToVote);
			}
		}
		
		
		return restaurantes;
		
	}
	
	
}
