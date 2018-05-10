package dbserverTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Test;

import users.ListOfUsers;
import users.User;

public class UsersTest {

	
	@Test
	public void nomeNaLista() {
		ListOfUsers userList = new ListOfUsers();
		userList.populate();
		User user = (User)userList.selectUser(1);
		assertNotNull(user);
		assertEquals(1, user.getId());
		assertEquals("Pessoa1", user.getNome());

	}
	
	@Test
	public void nomeForaDaLista() {
		ListOfUsers userList = new ListOfUsers();
		userList.populate();
		User user = userList.selectUser(15);
		assertNull(user);
	}
	
	
	@Test
	public void UsuarioQueNaoVotou()
	{
		User user = new User(1,"Usuario1","1", null );
		assertFalse(user.isVotingToday(LocalDate.now()));
	}
	
	@Test
	public void UsuarioQueVotou()
	{
		User user = new User(1,"Usuario1","1", LocalDate.now() );
		assertTrue(user.isVotingToday(LocalDate.now()));
	}
	
}	
