package dnt.freshvote.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
public class Comment {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@JsonIgnore
	private User user;
	
	
	@ManyToOne
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@JsonIgnore
	private Feature feature;
	
	@OneToMany(mappedBy = "comment")
	private List<Comment> comments;
	
	@ManyToOne
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@JoinColumn(name="comment_id", nullable = true)
	@JsonIgnore
	private Comment comment;
	
	@Column(length = 5000)
	private String text;
	
	private Date createdDate;
}
