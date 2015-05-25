package de.analyticom.intf;

import java.util.List;

import de.analyticom.entity.Club;

public interface ClubDao {
	
	public List<Club> getAllClubs();
	
	public Club getClubById(Long id);

}
