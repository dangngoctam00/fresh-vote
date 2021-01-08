package dnt.freshvote.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dnt.freshvote.domain.Comment;
import dnt.freshvote.repositories.CommentRepository;
import lombok.Data;

@Data
@Controller
@RequestMapping("/products/{productId}/features/{featureId}/comments")
public class CommentController {
	@Autowired
	private CommentRepository commentRepo;
	
	
	@GetMapping
	@ResponseBody
	public List<Comment> getComments(@PathVariable Long featureId) {
		return commentRepo.findByFeatureId(featureId);
	}
}
