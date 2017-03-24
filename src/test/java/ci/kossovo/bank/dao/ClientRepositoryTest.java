package ci.kossovo.bank.dao;



import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import ci.kossovo.bank.entites.Client;


@RunWith(SpringRunner.class)
@DataJpaTest
public class ClientRepositoryTest {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Test
	    public void saveClient() {
		clientRepository.save(new Client("Traore"));
		clientRepository.save(new Client("Diarra"));
		
		List<Client> clients = clientRepository.findAll();
		assertThat(clients.size()).isEqualTo(2);
		

	}
	
	
}
