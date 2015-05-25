package de.analyticom.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import de.analyticom.entity.Player;
import de.analyticom.entity.PlayerRegistration;
import de.analyticom.intf.PlayerRegistrationDao;

@Repository
public class PlayerRegistrationDaoImpl extends BaseDao<PlayerRegistration> implements PlayerRegistrationDao {

	@Override
	public void savePR(PlayerRegistration pr) {
		save(pr);
	}

	@Override
	public void deletePR(Long id) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("prId", id);
		PlayerRegistration pr = find(PlayerRegistration.class, parameters).get(0);
		delete(pr);
	}

	@Override
	public List<PlayerRegistration> getPRByPlayerId(Player ply) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("player", ply);
		
		return find(PlayerRegistration.class,parameters);
	}

}
