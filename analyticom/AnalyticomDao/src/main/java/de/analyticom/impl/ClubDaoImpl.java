package de.analyticom.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import de.analyticom.entity.Club;
import de.analyticom.intf.ClubDao;

@Repository
public class ClubDaoImpl extends BaseDao<Club> implements ClubDao {

	@Override
	public List<Club> getAllClubs() {
		return findAll(Club.class);
	}
	
	
	@Override
	public Club getClubById(Long id) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("clubId", id);
		
		return find(Club.class, parameters).get(0);
	}

}
