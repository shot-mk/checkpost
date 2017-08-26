package il.co.idf.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "PASSENGER")
public class Passenger implements GenericEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "LICENSE_NUMBER")
	private String passport;

	@Column(name = "TELEPHONE_NUMBER")
	private String telephone;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "passengers")
	@JsonIgnore
	private Set<CheckPost> checkPosts;

}
