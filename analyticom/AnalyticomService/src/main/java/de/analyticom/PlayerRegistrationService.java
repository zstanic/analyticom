package de.analyticom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.analyticom.entity.Player;
import de.analyticom.entity.PlayerRegistration;
import de.analyticom.intf.PlayerRegistrationDao;

@Service
public class PlayerRegistrationService {
	
	@Autowired
	private PlayerRegistrationDao dao;
	
	public List<PlayerRegistration> getPRByPlayerId(Player ply) {
		return dao.getPRByPlayerId(ply);
	}

	@Transactional(value="analyticomTM")
	public void savePR(PlayerRegistration pr){
		dao.savePR(pr);
	}
	
	@Transactional(value="analyticomTM")
	public void deletePR(Long id){
		dao.deletePR(id);
	}
}
