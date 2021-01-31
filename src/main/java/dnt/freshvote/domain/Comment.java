package dnt.freshvote.domain;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author scotlandyard
 *
 */
@Data
@Entity
public class Comment implements Comparable<Comment> {
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
	@OrderBy("createdDate, id")
	private Set<Comment> comments = new TreeSet<Comment>();
	
	@ManyToOne
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@JoinColumn(name="comment_id", nullable = true)
	@JsonIgnore
	private Comment comment;
	
	@Column(length = 5000)
	private String text;
	
	private Date createdDate;

	@Override
	public int compareTo(Comment other) {
		int comparedValue = this.getCreatedDate().compareTo(other.getCreatedDate());
		if (comparedValue == 0) {
			comparedValue = this.getId().compareTo(other.getId());			
		}
		return comparedValue;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id  + " text=" + text + "]";
	}
	
}
