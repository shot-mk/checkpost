package il.co.idf.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "CHECKPOST")
public class CheckPost implements GenericEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DISTRICT_ID")
	private District district;

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name = "VEHICLE_ID")
	private Vehicle vehicle;

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinTable(name = "CHECKPOST_PASSENGER",
			joinColumns = {@JoinColumn(name = "checkpost_id")},
			inverseJoinColumns = {@JoinColumn(name="passenger_id")})
	private Set<Passenger> passengers = new HashSet<>();

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name = "LOCATION_ID")
	private Location location;

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name = "DESTINATION_ID")
	private Destination destination;

	@Temporal(TemporalType.DATE)
	private Date date;

	@Temporal(TemporalType.TIME)
	private Date time;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_created")
	private Date dateCreated;

	@PrePersist
	private void prePersist() {
		dateCreated = new Date();
	}


}
