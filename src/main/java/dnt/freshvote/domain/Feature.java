package dnt.freshvote.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
public class Feature {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String description;
	private String status;
	
	@ManyToOne
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@JsonIgnore
	private Product product;
	
	@ManyToOne
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@JsonIgnore
	private User user;
	
	@OneToMany
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@JsonIgnore
	private Set<Comment> comments = new HashSet<Comment>();
}
