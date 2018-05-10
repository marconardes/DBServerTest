package users;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import common.CsvFile;

public class ListOfUsers {

	List<User> users;
	public ListOfUsers() {
		users = new ArrayList<User>();
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public void populate() {
		CsvFile csv = new CsvFile();
		try {
			CSVParser parser = csv.loadCsv("Users.csv");
			
			for (CSVRecord csvRecord : parser) {
				System.out.println(csvRecord.get(0));
				if(!csvRecord.get(0).equals("id"))
				{
					CharSequence cs = csvRecord.get(3);
					LocalDate ld = null;
					if(!cs.equals("null") )
					{
						ld = LocalDate.parse(cs);
					}
					
					User tuser = new User(Integer.parseInt(csvRecord.get(0)), csvRecord.get(1), csvRecord.get(2), ld);
					
					users.add(tuser);
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
		header.add("senha");
		header.add("votouHoje");

		for (User user : users) {
			List<String> save = new ArrayList<>();
			
			save.add(String.valueOf(user.getId()));
			save.add(String.valueOf(user.getNome()));
			save.add(String.valueOf(user.getSenha()));
			save.add(String.valueOf(user.getDataDaVotacao()));
			
			toFile.add(save);
			
			
		}
		CsvFile csv = new CsvFile();
		try {
			csv.CSVSave("Users.csv", toFile, header);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public User selectUser(int id) {
		for (User user : users) {
			if(user.getId() ==id)
			{
				return user;
			}
		}
		return null;
	}
	
	
	public boolean allVote(LocalDate data)
	{
		
		for (User user : users) {
			if(!user.isVotingToday(data))
			{
				return false;
			}
		}
		return true;
	}
}
