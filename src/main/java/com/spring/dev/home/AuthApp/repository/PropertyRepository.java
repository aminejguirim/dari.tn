package com.spring.dev.home.AuthApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.dev.home.AuthApp.model.Property;

@Repository
public interface PropertyRepository extends CrudRepository<Property, Integer>,JpaRepository<Property, Integer> {
	
	List<Property> findByStatusFalse();
	
	List<Property> findByPriceAndAvailabilityAndStatusTrue(float price, String availability);
	
	/////////////////// Surface //////////////////
	List<Property> findBySurfaceAndAvailabilityAndStatusTrue(float surface, String availability);
	List<Property> findBySurfaceAndAvailabilityAndStatusTrueOrderByPriceAsc(float surface, String availability);
	List<Property> findBySurfaceAndAvailabilityAndStatusTrueOrderByPriceDesc(float surface, String availability);
	
	///////////////// City /////////////////////
	List<Property> findByCityAndAvailabilityAndStatusTrue(String city, String availability);
	List<Property> findByCityAndAvailabilityAndStatusTrueOrderByPriceAsc(String city, String availability);
	List<Property> findByCityAndAvailabilityAndStatusTrueOrderByPriceDesc(String city, String availability);
	
	//////////////// State //////////////////
	List<Property> findByStateAndAvailabilityAndStatusTrue(String state, String availability);
	List<Property> findByStateAndAvailabilityAndStatusTrueOrderByPriceAsc(String state, String availability);
	List<Property> findByStateAndAvailabilityAndStatusTrueOrderByPriceDesc(String state , String availability);
    
	//////////////// Rooms //////////////////
	List<Property> findByNbrRoomsAndAvailabilityAndStatusTrue(int nbrRooms, String availability);
	List<Property> findByNbrRoomsAndAvailabilityAndStatusTrueOrderByPriceAsc(int nbrRooms, String availability);
	List<Property> findByNbrRoomsAndAvailabilityAndStatusTrueOrderByPriceDesc(int nbrRooms, String availability);
	
	List<Property> findByNbrRoomsAndNbrFloorAndNbrBathroomsAndAvailabilityAndStatusTrue(int nbrRooms,int nbrFloor,int nbrBathrooms, String availability);
	
	
	@Query("Select p from Property p WHERE p.price Between :pricemin and :pricemax AND p.availability LIKE :availability AND p.status=:status ORDER BY p.price ASC")
    public List<Property> findByPriceMinMaxPriceAsc(@Param("pricemin") float pricemin,@Param("pricemax") float pricemax, @Param("availability") String availability,@Param("status") boolean status);
	
	@Query("Select p from Property p WHERE p.price Between :pricemin and :pricemax AND p.availability LIKE :availability AND p.status=:status ORDER BY p.price DESC")
    public List<Property> findByPriceMinMaxPriceDesc(@Param("pricemin") float pricemin,@Param("pricemax") float pricemax, @Param("availability") String availability,@Param("status") boolean status);
	
	@Query("Select p from Property p WHERE p.price Between :pricemin and :pricemax AND p.availability LIKE :availability AND p.status=:status ORDER BY p.surface ASC")
    public List<Property> findByPriceMinMaxSurfaceAsc(@Param("pricemin") float pricemin,@Param("pricemax") float pricemax, @Param("availability") String availability,@Param("status") boolean status);
	
	@Query("Select p from Property p WHERE p.price Between :pricemin and :pricemax AND p.availability LIKE :availability AND p.status=:status ORDER BY p.surface DESC")
    public List<Property> findByPriceMinMaxSurfaceDesc(@Param("pricemin") float pricemin,@Param("pricemax") float pricemax, @Param("availability") String availability,@Param("status") boolean status);



}

