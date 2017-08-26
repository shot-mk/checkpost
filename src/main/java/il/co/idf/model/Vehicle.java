package il.co.idf.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Vehicle implements GenericEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "COLOR_ID")
	private Color color;

	@Column(name = "PLATE_NUMBER")
	private String plateNumber;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "MANUFACTURER_ID")
	private Manufacturer manufacturer;

	public Vehicle(String plateNumber, Color color) {
		this.plateNumber = plateNumber;
		this.color = color;
	}

}
