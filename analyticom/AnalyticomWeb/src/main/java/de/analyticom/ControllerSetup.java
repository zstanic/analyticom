package de.analyticom;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ControllerSetup {
	
	private final static Logger logger = Logger.getLogger(ControllerSetup.class);
	private final static boolean isDebugEnabled = logger.isDebugEnabled();
	
	private final static String ERROR_VIEW = "/error/error";
	private final static String EXCEPTION_MSG = "exceptionMsg";
	private final static String STACK_TRACE = "stackTrace";
	private final static String DEFAULT_ERROR_MSG = "An unexpected error occured while processing your request.....";
	
    @InitBinder
    public void initBinder (WebDataBinder binder)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        binder.registerCustomEditor(java.sql.Date.class, new CustomDateEditor(dateFormat, true));
        StringTrimmerEditor stringtrimmer = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, stringtrimmer);
    }
    
    /**
     * Intercepts all Exceptions  
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ModelAndView handleIOException(Exception ex) {
    	ModelAndView modelAndView = new ModelAndView(ERROR_VIEW);
	    if(isDebugEnabled){
	    	logger.error("HandleException - Catching: " + ex.getClass().getSimpleName(), ex);
	    }
	    modelAndView.addObject(EXCEPTION_MSG, DEFAULT_ERROR_MSG);
	    modelAndView.addObject(STACK_TRACE, Arrays.toString(ex.getStackTrace()));
	    return modelAndView;
    }

}
