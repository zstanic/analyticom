package de.analyticom;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.analyticom.entity.Club;
import de.analyticom.entity.Player;
import de.analyticom.entity.PlayerRegistration;

@Controller
public class PlayerRegistrationController {
	
	@Autowired
	private PlayerRegistrationService srv;
	
	@Autowired
	private PlayerService psrv;
	
	@Autowired
	private ClubService csrv;
	
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	
	@RequestMapping(value="/deletePR.json", method=RequestMethod.POST)
	public void deletePR(String id){
		srv.deletePR(Long.parseLong(id));
	}

	@RequestMapping(value="/savePR.json", method=RequestMethod.POST)
	public void savePR(String userid, String clubid, String df, String dt){
		
		try 
		{
			Date newdf = new Date();
			Date newdt = new Date();
			
			if (dt!=null)
			newdt = sdf.parse(dt);
			if (df!=null)
			newdf = sdf.parse(df);
			
			Club cb = csrv.getClubById(Long.parseLong(clubid));
			Player pl = psrv.getPlayerById(Long.parseLong(userid));
			
			PlayerRegistration pr = new PlayerRegistration();
			pr.setClub(cb);
			pr.setPlayer(pl);
			pr.setDateFrom(newdf);
			pr.setDateTo(newdt);
			
			srv.savePR(pr);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
