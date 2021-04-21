package com.spring.dev.home.AuthApp.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.dev.home.AuthApp.model.Subscription;




@Repository
public interface SubscriptionRepository extends JpaRepository < Subscription , Long> {
	
	/*@Query("Select s from Subscription s WHERE s.startingDate = CURRENT_DATE")
    public List<Subscription> findTodaysSubs(); */
	
	/*@Query(value="SELECT sum(s.price) FROM Subscription s WHERE s.startingDate BETWEEN :startingDate AND :expirationDate")
	float getTotalMoneyEarned(@Param("beginDate") LocalDate startingDate, @Param("expirationDate") Date expirationDate) ;*/

}
