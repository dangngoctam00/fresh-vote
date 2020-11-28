package dnt.freshvote.domain;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class Votes {
	
	@EmbeddedId
	private VoteId pk;
	private Boolean upvote;
}
