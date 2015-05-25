package de.analyticom;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/{path}")
public class DummyController {

	@RequestMapping(method = RequestMethod.GET)
    public String displayPath(@PathVariable("path") String path) throws Exception {
		
        return path;
    }
	
	@RequestMapping(value="/{path2}", method = RequestMethod.GET)
    public String displaySecondPath(@PathVariable("path") String path, @PathVariable("path2") String path2) throws Exception {
		
        return path+"/"+path2;
    }
}
