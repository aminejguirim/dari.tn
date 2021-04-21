package com.spring.dev.home.AuthApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.dev.home.AuthApp.model.SubPaiementDetails;



@Repository
public interface SubPaiementDetailsRepository extends JpaRepository< SubPaiementDetails , Long>{

}
