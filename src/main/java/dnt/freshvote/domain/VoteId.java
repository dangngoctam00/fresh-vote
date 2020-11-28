package dnt.freshvote.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Embeddable
public class VoteId implements Serializable {
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private User user;
	@ManyToOne
	private Feature feature;
}
