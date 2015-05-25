package de.analyticom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.analyticom.entity.Player;
import de.analyticom.intf.PlayerDao;

@Service
public class PlayerService {
	
	@Autowired
	private PlayerDao dao;
	
	public Player getPlayerById(Long id){
		return dao.getPlayerById(id);
	}
	
	public List<Player> getPlayerById(Player ply){
		return dao.getPlayerById(ply);
	}

	@Transactional(value="analyticomTM")
	public void savePlayer(Player ply){
		dao.savePlayer(ply);
	}
	
	@Transactional(value="analyticomTM")
	public void updatePlayer(Player ply){
		dao.updatePlayer(ply);
	}
	
	@Transactional(value="analyticomTM")
	public void deletePlayer(Player ply){
		dao.deletePlayer(ply);
	}

}
