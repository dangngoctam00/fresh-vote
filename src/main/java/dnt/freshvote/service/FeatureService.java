package dnt.freshvote.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dnt.freshvote.domain.Feature;
import dnt.freshvote.domain.Product;
import dnt.freshvote.domain.User;
import dnt.freshvote.repositories.FeatureRepository;
import dnt.freshvote.repositories.ProductRepository;

@Service
public class FeatureService {
	@Autowired
	private FeatureRepository featureRepo;
	@Autowired
	private ProductRepository productRepo;
	public Feature createFeature(User user ,Long productId) {
		Feature feature = new Feature();
		Optional<Product> productOpt = productRepo.findById(productId);
		if (productOpt.isPresent()) {
			Product product = productOpt.get();
			feature.setProduct(product);
			product.getFeatures().add(feature);
			feature.setStatus("Pending review");
			feature.setUser(user);
			user.getFeatures().add(feature);
			return featureRepo.save(feature);
		}
		return feature;
	}
	public Feature save(Feature feature) {
		return featureRepo.save(feature);
	}
	public Optional<Feature> findById(Long featureId) {
		return featureRepo.findById(featureId);
	}
}
