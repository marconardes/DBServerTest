package restaurant;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import common.CsvFile;
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
		CsvFile csv = new CsvFile();
		try {
			CSVParser parser = csv.loadCsv("Restaurants.csv");
			
			for (CSVRecord csvRecord : parser) {
				System.out.println(csvRecord.get(0));
				if(!csvRecord.get(0).equals("id"))
				{
					CharSequence cs = csvRecord.get(2);
					LocalDate ld = null;
					if(!cs.equals("null") )
					{
						ld = LocalDate.parse(cs);
					}
					
					Restaurant tres = new Restaurant(Integer.parseInt(csvRecord.get(0)), csvRecord.get(1));
					tres.setLiberado(ld);
					
					restaurants.add(tres);
				}			
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("=-=====================");
	
	}
	
	public void saveCSV()
	{
		List<List<String>> toFile= new ArrayList<>();		
		List<String> header = new ArrayList<>();
		header.add("id");
		header.add("nome");
		header.add("liberado");

		for (Restaurant rest : restaurants) {
			List<String> save = new ArrayList<>();
			
			save.add(String.valueOf(rest.getId()));
			save.add(String.valueOf(rest.getNome()));
			save.add(String.valueOf(rest.getLiberado()));
			
			toFile.add(save);
			
			
		}
		CsvFile csv = new CsvFile();
		try {
			csv.CSVSave("Restaurants.csv", toFile, header);
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		
	}

	public Restaurant selectRestaurant(int id) {
		
		for (Restaurant restaurant : restaurants) {
			if(restaurant.getId() == id)
			{
				return restaurant;
			}
		}
		
		return null;
	}
	
	
	
}
