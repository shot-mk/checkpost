package il.co.idf.spring.service;

import il.co.idf.model.Location;
import il.co.idf.spring.repo.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService extends GenericService<Location> {

	@Autowired
	LocationRepository locationRepository;


	@Override
	public Location save(Location location) {
		Location loc = locationRepository.findByLocation(location.getLocation().trim());
		if (loc == null) {
			return locationRepository.save(location);
		} else {
			return loc;
		}
	}


	public List<Location> findByQuery(String query) {
		return locationRepository.findLocationsByLocationContaining(query);
	}


}
