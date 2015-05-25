package de.analyticom;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import de.analyticom.entity.Club;
import de.analyticom.entity.Country;
import de.analyticom.entity.Player;
import de.analyticom.entity.PlayerRegistration;

@Controller
public class PlayerController {
	
	@Autowired
	private PlayerService srv;
	
	@Autowired
	private CountryService csrv;
	
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	
	@RequestMapping(value="/getPlayerPRs.json", method=RequestMethod.POST)
	public @ResponseBody String getPlayerPRs(String id){
		String str = "";
		Player pl = srv.getPlayerById(Long.parseLong(id));
		
		StringBuilder sb = new StringBuilder();
		
		int x=0;
		
		sb.append("[");
		for(PlayerRegistration pr : pl.getPlyRegs()){
			sb.append("{\"id\":"+"\""+pr.getId()+"\","+"\"club\":"+"\""+pr.getClub().getName()+"\","+"\"df\":"+"\""+sdf.format(pr.getDateFrom())+"\","+
					"\"dt\":"+"\""+sdf.format(pr.getDateTo())+"\"}");
			if (x<pl.getPlyRegs().size()-1)	sb.append(",");
			x++;
		}
		sb.append("]");
		
		System.out.println(sb.toString());
		
		str = sb.toString();
				
		return str;
	}
	
	@RequestMapping(value="/deletePlayer.json", method=RequestMethod.POST)
	public void deletePlayer(String id){
		Player pl = srv.getPlayerById(Long.parseLong(id));
		
		srv.deletePlayer(pl);
	}
	
	@RequestMapping(value="/savePlayer.json", method=RequestMethod.POST)
	public void savePlayer(String id, String uniqueId, String firstName, String lastName, String dob, String pob, String country){
		try 
		{
			Date newDob = sdf.parse(dob);
			Country cntr = csrv.getCountryByName(country);
			
			if(id!=null){
				Player pl = srv.getPlayerById(Long.parseLong(id));
				pl.setCountry(cntr);
				pl.setFirstName(firstName);
				pl.setLastName(lastName);
				pl.setUniqueID(uniqueId);
				pl.setDateOfBirth(newDob);
				pl.setPlaceOfBirth(pob);
				srv.updatePlayer(pl);
			}else{
				Player pl = new Player();
				pl.setFirstName(firstName);
				pl.setLastName(lastName);
				pl.setUniqueID(uniqueId);
				pl.setDateOfBirth(newDob);
				pl.setPlaceOfBirth(pob);
				pl.setCountry(cntr);
				srv.savePlayer(pl);
			}
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/searchPlayer.json", method=RequestMethod.POST)
	public @ResponseBody String searchPlayer(String id, String uniqueId, String firstName, String lastName, String dob, String pob, String country){
		String str = "";
		try 
		{
			Date newDob = new Date();
			if(dob!=null){
				newDob = sdf.parse(dob);
			}
			Player pl = new Player();
			pl.setFirstName(firstName);
			pl.setLastName(lastName);
			pl.setUniqueID(uniqueId);
			pl.setDateOfBirth(newDob);
			pl.setPlaceOfBirth(pob);
			
			if(country!=null){
				Country cntr = csrv.getCountryByName(country);
				pl.setCountry(cntr);
			}
			
			List<Player> lst = srv.getPlayerById(pl);
			
			StringBuilder sb = new StringBuilder();
			
			int x=0;
			
			sb.append("[");
			for(Player ply : lst){
				sb.append("{\"id\":"+"\""+ply.getId()+"\","+"\"uid\":"+"\""+ply.getUniqueID()+"\","+"\"fn\":"+"\""+ply.getFirstName()+"\","+
						"\"ln\":"+"\""+ply.getLastName()+"\","+"\"dob\":"+"\""+sdf.format(ply.getDateOfBirth())+"\","+"\"pob\":"+"\""+ply.getPlaceOfBirth()+"\","+"\"country\":"+"\""+ply.getCountry().getName()+"\"}");
				if (x<lst.size()-1)	sb.append(",");
				x++;
			}
			sb.append("]");
			
			System.out.println(sb.toString());
			
			str = sb.toString();
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return str;
	}

}
