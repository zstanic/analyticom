package de.analyticom.intf;

import java.util.List;

import de.analyticom.entity.Country;

public interface CountryDao {
	
	public List<Country> getAllCountries();
	
	public Country getCountryById(Long id);
	
	public Country getCountryByName(String name);

}
