package dnt.freshvote.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private Boolean published;
	
	@ManyToOne
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private User user;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY ,mappedBy = "product")
	private Set<Feature> features = new HashSet<Feature>();
}
