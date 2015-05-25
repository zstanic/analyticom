package de.analyticom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.analyticom.entity.Club;
import de.analyticom.intf.ClubDao;

@Service
public class ClubService {
	
	@Autowired
	private ClubDao clubDao;
	
	public List<Club> getAllClubs(){
		return clubDao.getAllClubs();
	}

	public Club getClubById(Long id){
		return clubDao.getClubById(id);
	}
}
