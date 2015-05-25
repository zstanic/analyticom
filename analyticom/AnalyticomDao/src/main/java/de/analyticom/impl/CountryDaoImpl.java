package de.analyticom.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import de.analyticom.entity.Country;
import de.analyticom.intf.CountryDao;

@Repository
public class CountryDaoImpl extends BaseDao<Country> implements CountryDao {

	@Override
	public List<Country> getAllCountries() {
		return findAll(Country.class);
	}
	
	@Override
	public Country getCountryById(Long id) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("countryId", id);
		return find(Country.class, parameters).get(0);
	}
	
	@Override
	public Country getCountryByName(String name) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("name", name);
		return find(Country.class, parameters).get(0);
	}

}
