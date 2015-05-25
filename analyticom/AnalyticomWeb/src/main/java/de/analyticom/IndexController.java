package de.analyticom;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/index")
public class IndexController {
	
	private final static Logger logger = Logger.getLogger(IndexController.class);
	private final static boolean isDebugEnabled = logger.isDebugEnabled();
	
	private final static String HOME_VIEW = "index";
	
	@RequestMapping(method = RequestMethod.GET)
    public String displayHome() throws Exception {
		if(isDebugEnabled){
			logger.debug("in displayHome method");
		}
        return HOME_VIEW;
    }

}
