package tn.amir.projet.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.amir.projet.entity.Favorite;
import tn.amir.projet.entity.Property;
import tn.amir.projet.entity.User;

@Repository
public interface FavoriteRepository extends CrudRepository<Favorite, Integer>  {
	
	@Query(value = "SELECT f FROM Favorite f WHERE f.user=:user" + " AND f.property=:property")
	Optional<Favorite> findfavoritenotbyid(@Param("user") User user, @Param("property") Property property);
	
	@Query(value = "SELECT f FROM Favorite f WHERE f.property=:property")
	Iterable<Favorite> findfavsbyproperty(@Param("property") Property property);
}


