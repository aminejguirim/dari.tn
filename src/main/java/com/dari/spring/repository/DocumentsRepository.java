package com.dari.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dari.spring.entity.GuaranteeDocument;

@Repository

public interface DocumentsRepository  extends CrudRepository< GuaranteeDocument, Integer> {

}
