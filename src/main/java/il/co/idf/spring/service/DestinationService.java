package il.co.idf.spring.service;

import il.co.idf.model.Destination;
import il.co.idf.spring.repo.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinationService extends GenericService<Destination> {

	@Autowired
	private DestinationRepository repository;

	public Destination save(Destination destination) {
		Destination byDestination = repository.findByName(destination.getName().trim());
		if (byDestination == null) {
			return repository.save(destination);
		} else {
			return byDestination;
		}
	}

	public List<Destination> findByQuery(String query) {
		return repository.findAllDestinationByNameContaining(query);
	}

}
