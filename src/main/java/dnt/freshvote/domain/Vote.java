package dnt.freshvote.domain;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class Vote {
	
	@EmbeddedId
	private VoteId pk;
	private Boolean upvote;
}
