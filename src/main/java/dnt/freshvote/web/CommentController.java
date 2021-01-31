package dnt.freshvote.web;

import java.util.Date;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dnt.freshvote.domain.Comment;
import dnt.freshvote.domain.Feature;
import dnt.freshvote.domain.User;
import dnt.freshvote.repositories.CommentRepository;
import dnt.freshvote.repositories.FeatureRepository;
import lombok.Data;

@Data
@Controller
@RequestMapping("/products/{productId}/features/{featureId}/comments")
public class CommentController {
	@Autowired
	private CommentRepository commentRepo;
	
	@Autowired FeatureRepository featureRepo;
	
	
	@GetMapping
	@ResponseBody
	public Set<Comment> getComments(@PathVariable Long featureId) {
		return commentRepo.findByFeatureId(featureId);
	}
	
	@PostMapping
	public String addComment(@AuthenticationPrincipal User user, @PathVariable Long productId, 
			@PathVariable Long featureId, Comment comment, @RequestParam(required = false) Long parentId,
														@RequestParam(required = false) String childCommentText) {
		if (parentId != null) {
			comment = new Comment();
			Optional<Comment> parentCommentOpt = commentRepo.findById(parentId);
			if (parentCommentOpt.isPresent()) {
				comment.setComment(parentCommentOpt.get());
				parentCommentOpt.get().getComments().add(comment);
			}
			comment.setText(childCommentText);
		}
		Optional<Feature> featureOpt = featureRepo.findById(featureId);
		if (featureOpt.isPresent()) {
			comment.setFeature(featureOpt.get());
		}
		comment.setCreatedDate(new Date());
		comment.setUser(user);
		commentRepo.save(comment);
		return "redirect:/products/" + productId + "/features/" + featureId;
	}
}
