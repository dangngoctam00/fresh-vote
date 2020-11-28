package dnt.freshvote.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class Comment {
	@EmbeddedId
	private CommentId pk;
	
	@Column(length = 5000)
	private String text;
}
