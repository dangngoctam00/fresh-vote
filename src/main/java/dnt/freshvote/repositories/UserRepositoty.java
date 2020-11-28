package dnt.freshvote.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dnt.freshvote.domain.User;

@Repository
public interface UserRepositoty extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
