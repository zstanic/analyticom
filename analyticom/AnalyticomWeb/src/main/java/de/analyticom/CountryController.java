package de.analyticom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import de.analyticom.entity.Country;

@Controller
public class CountryController {

	@Autowired
	private CountryService srv;
	
	@RequestMapping(value="/getAllCountries.json", method=RequestMethod.GET)
	public @ResponseBody String getAllCountries(){
		String str = "";
		
		List<Country> lst = srv.getAllCountries();
		
		StringBuilder sb = new StringBuilder();
		
		int x=0;
		
		sb.append("[");
		for(Country cl : lst){
			sb.append("{\"id\":"+" \""+cl.getId()+"\","+"\"name\":"+"\""+cl.getName()+"\"}");
			if (x<lst.size()-1)	sb.append(",");
			x++;
		}
		sb.append("]");
		
		System.out.println(sb.toString());
		
		str = sb.toString();
		
		return str;
	}
	
}
