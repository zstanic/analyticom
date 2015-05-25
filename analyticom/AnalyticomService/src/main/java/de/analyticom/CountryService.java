package de.analyticom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.analyticom.entity.Country;
import de.analyticom.intf.CountryDao;

@Service
public class CountryService {
	
	@Autowired
	private CountryDao dao;
	
	public List<Country> getAllCountries(){
		return dao.getAllCountries();
	}
	
	
	public Country getCountryById(Long id) {
		return dao.getCountryById(id);
	}
	
	public Country getCountryByName(String name) {
		return dao.getCountryByName(name);
	}

}
