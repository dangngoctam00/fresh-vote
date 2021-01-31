package dnt.freshvote.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import dnt.freshvote.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
	Set<Comment> findByFeatureId(Long featureId);
}
