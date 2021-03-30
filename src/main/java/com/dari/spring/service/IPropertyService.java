
	
package com.dari.spring.service;


import java.util.List;

import com.dari.spring.entity.Property;


public interface IPropertyService {
	
	
	List<Property> retrieveAllProp();
	Property addProp(Property p);
	void deleteProp(Long id);
	Property updateProp(Property p);
	Property retrieveProp(String id);

}
