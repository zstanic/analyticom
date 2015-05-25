package de.analyticom.intf;

import java.util.List;

import de.analyticom.entity.Player;
import de.analyticom.entity.PlayerRegistration;

public interface PlayerRegistrationDao {
	
	public void savePR(PlayerRegistration pr);
	
	public void deletePR(Long id);
	
	public List<PlayerRegistration> getPRByPlayerId(Player ply);

}
