package il.co.idf.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Color implements GenericEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "NAME", unique = true)
	private String name;

	public Color(String name) {
		this.name = name;
	}

}
