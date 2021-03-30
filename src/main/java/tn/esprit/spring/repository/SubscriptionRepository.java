package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Subscription;
@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription , Long> {

}