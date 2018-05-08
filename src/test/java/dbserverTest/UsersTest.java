package dbserverTest;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import restaurant.Restaurants;
import users.ListOfUsers;
import users.User;

class UsersTest {

	
	@Test
	void nomeNaLista() {
		ListOfUsers userList = new ListOfUsers();
		userList.populate();
		User user = (User)userList.selectUser(1);
		assertNotNull(user);
		assertEquals(1, user.getId());
		assertEquals("Pessoa1", user.getNome());

	}
	
	@Test
	void nomeForaDaLista() {
		ListOfUsers userList = new ListOfUsers();
		userList.populate();
		User user = userList.selectUser(15);
		assertNull(user);
	}
	
	
	@Test
	void UsuarioQueNaoVotou()
	{
		User user = new User(1,"Usuario1","1", false );
		assertFalse(user.isVotouHoje());
	}
	
	@Test
	void UsuarioQueVotou()
	{
		User user = new User(1,"Usuario1","1", true );
				
		assertTrue(user.isVotouHoje());
	}
	
}	
