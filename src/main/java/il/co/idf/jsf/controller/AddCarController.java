package il.co.idf.jsf.controller;

import il.co.idf.model.*;
import il.co.idf.spring.repo.*;
import il.co.idf.spring.service.DestinationService;
import il.co.idf.spring.service.LocationService;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.*;

import static java.util.stream.Collectors.toList;

@ViewScoped
@Getter
@Setter
@ManagedBean
public class AddCarController implements Serializable {

	@ManagedProperty("#{carRepository}")
	VehicleRepository vehicleRepository;

	@ManagedProperty("#{directionService}")
	DestinationService destinationService;

	@ManagedProperty("#{locationService}")
	LocationService locationService;

	@ManagedProperty("#{checkPostRepository}")
	CheckPostRepository checkPostRepository;

	@ManagedProperty("#{colorRepository}")
	ColorRepository colorRepository;

	@ManagedProperty("#{factoryRepository}")
	ManufacturerRepository manufacturerRepository;

	@ManagedProperty("#{areaRepository}")
	DistrictRepository districtRepository;

	private boolean inCar = false;

	private List<Color> carColors = new ArrayList<>();

	private List<Manufacturer> carMakers = new ArrayList<>();

	private List<District> districts = new ArrayList<>();

	private Vehicle vehicle = new Vehicle();

	private Passenger passenger = new Passenger();

	private CheckPost checkPost = new CheckPost();

	private String direction = new String();

	private String location = new String();

	private boolean areaSelectDisabled = false;

	String areaId = null;

	@PostConstruct
	public void init() {

		Map<String,String> params =
				FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		areaId = params.get("htmr");
		Long id;
		try {
			id = Long.decode(areaId);
		} catch (Exception ex) {
			id = null;
		}
		if (id != null) {
			District resultDistrict = districtRepository.findOne(id);
			if (resultDistrict != null) {
				checkPost.setDistrict(resultDistrict);
				areaSelectDisabled = true;
			}
		}
		carColors = colorRepository.findAll();
		carMakers = manufacturerRepository.findAll();
		districts = districtRepository.findAll();
	}

	public List<Manufacturer> completeFactories(String query) {
		ArrayList<Manufacturer> filteredFactories = new ArrayList<>();
		for (Manufacturer manufacturer : carMakers) {
			if (manufacturer.getName().toLowerCase().contains(query.toLowerCase())) {
				filteredFactories.add(manufacturer);
			}
		}
		return filteredFactories;
	}

	public List<String> completeDirections(String query) {
		List<String> filteredDirections = destinationService.findByQuery(query).stream().map(a -> a.getName()).collect(toList());
		return filteredDirections;
	}

	public List<String> completeLocations(String query) {
		List<String> filteredLocations = locationService.findByQuery(query).stream().map(a -> a.getName()).collect(toList());
		return filteredLocations;
	}

	public String onSave() {
		if (!validate()) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Validation Error", "Not enough data. At least 2 of 3 values should be inserted (טלפון,ל.ז.,ת.ז)"));
			return null;
		}
		Destination destination = destinationService.save(new Destination(this.direction));
		Location location = locationService.save(new Location(this.location));
		checkPost.setPassengers(new HashSet<>(Arrays.asList(passenger)));
		checkPost.setVehicle(vehicle);
		checkPost.setLocation(location);
		checkPost.setDestination(destination);
		try {
			checkPostRepository.save(checkPost);
		} catch (Exception ex) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error while saving data", "Not enough data. Try refreshing the page."));
			return null;
		}
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Success!", "Data successfully added."));
		vehicle = new Vehicle();
		this.direction = "";
		this.location = "";
		passenger = new Passenger();
		checkPost = new CheckPost();
		return "addCheckPost.xhtml?htmr=" + areaId;
	}

	private boolean validate() {
		List<String> values = new ArrayList<>();
		if (passenger.getPassport() != null && !"".equals(passenger.getPassport())) {
			values.add(passenger.getPassport());
		}
		if (passenger.getTelephone() != null && !"".equals(passenger.getTelephone())) {
			values.add(passenger.getTelephone());
		}
		if (vehicle.getPlateNumber() != null && !"".equals(vehicle.getPlateNumber())) {
			values.add(vehicle.getPlateNumber());
		}
		if (values.size() >= 2) {
			return true;
		}
		return false;
	}

}
