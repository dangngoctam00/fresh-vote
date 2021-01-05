package dnt.freshvote.security;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.security.core.GrantedAuthority;

import dnt.freshvote.domain.User;
import lombok.Data;

@Data
@Entity
public class Authority implements GrantedAuthority {
	
	private static final long serialVersionUID = 1272548942962614584L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String authority;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
}
