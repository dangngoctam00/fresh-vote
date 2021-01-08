package dnt.freshvote.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dnt.freshvote.domain.Feature;

public interface FeatureRepository extends JpaRepository<Feature, Long> {

}
