package dnt.freshvote.web;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dnt.freshvote.domain.Feature;
import dnt.freshvote.domain.User;
import dnt.freshvote.service.FeatureService;
import lombok.Data;


@Data
@Controller
@RequestMapping("/products/{productId}/features")
public class FeatureController {
	@Autowired
	private FeatureService featureService;
	@PostMapping("")
	public String createFeature(@AuthenticationPrincipal User user, @PathVariable Long productId) {
		Feature feature = featureService.createFeature(user ,productId);		
		return "redirect:/products/" + productId + "/features/" + feature.getId();
	}
	
	@GetMapping("{featureId}")
	public String getFeature(@AuthenticationPrincipal User user,ModelMap model ,@PathVariable Long productId, @PathVariable Long featureId) {
		Optional<Feature> featureOpt = featureService.findById(featureId);
		if (featureOpt.isPresent()) {
			model.put("feature", featureOpt.get());
			model.put("comments", featureOpt.get().getComments());
		}
		
		//TODO: handle situation cannot find Feature by id
		
		model.put("user", user);
		return "feature";
	}
	
	@PostMapping("{featureId}")
	public String updateFeature(@AuthenticationPrincipal User user, Feature feature, @PathVariable Long productId, @PathVariable Long featureId) throws UnsupportedEncodingException {		
		feature.setUser(user);
		Feature featureRes = featureService.save(feature);
		String productNameEncoded;
		productNameEncoded = URLEncoder.encode(featureRes.getProduct().getName(), StandardCharsets.UTF_8);
		return "redirect:/p/" + productNameEncoded;
	}
	
}
