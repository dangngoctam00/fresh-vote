package dnt.freshvote.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dnt.freshvote.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
}
