package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.SubPaiementDetails;
@Repository
public interface SubPaiementDetailsRepository extends JpaRepository<SubPaiementDetails, Long>{

}
