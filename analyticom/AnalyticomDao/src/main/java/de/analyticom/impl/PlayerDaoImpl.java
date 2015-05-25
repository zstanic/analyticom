package de.analyticom.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import de.analyticom.entity.Player;
import de.analyticom.intf.PlayerDao;

@Repository
public class PlayerDaoImpl extends BaseDao<Player> implements PlayerDao {

	@Override
	public Player getPlayerById(Long id) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("playerId", id);
		
		return find(Player.class, parameters).get(0);
	}
	
	@Override
	public List<Player> getPlayerById(Player ply) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		if (ply.getId()!=null)
			parameters.put("playerId", ply.getId());
		if(ply.getUniqueID()!=null)
			parameters.put("uniqueID", ply.getUniqueID());
		if(ply.getFirstName()!=null)
			parameters.put("firstName", ply.getFirstName());
		if(ply.getLastName()!=null)
			parameters.put("lastName", ply.getLastName());
		if(ply.getDateOfBirth()!=null)
			parameters.put("dateOfBirth", ply.getDateOfBirth());
		if(ply.getPlaceOfBirth()!=null)
			parameters.put("placeOfBirth", ply.getPlaceOfBirth());
		if(ply.getCountry()!=null)
			parameters.put("country", ply.getCountry());
		
		return find(Player.class, parameters);
	}

	@Override
	public void savePlayer(Player ply) {
		save(ply);
	}

	@Override
	public void updatePlayer(Player ply) {
		update(ply);
	}

	@Override
	public void deletePlayer(Player ply) {
		delete(ply);
	}

}
