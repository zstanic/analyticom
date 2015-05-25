package de.analyticom.intf;

import java.util.List;

import de.analyticom.entity.Player;

public interface PlayerDao {
	
	public Player getPlayerById(Long id);
	
	public List<Player> getPlayerById(Player ply);
	
	public void savePlayer(Player ply);
	
	public void updatePlayer(Player ply);
	
	public void deletePlayer(Player ply);

}
