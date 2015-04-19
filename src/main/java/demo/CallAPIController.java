package demo;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;


@Controller
public class CallAPIController {
	
	@Autowired
	RestTemplate operations;
	
    @RequestMapping(value="/restcall", method=RequestMethod.GET)
    public @ResponseBody PostModel getUser(HttpServletResponse response) {
    	PostModel jsonFeed = operations.getForObject("http://jsonplaceholder.typicode.com/posts/1", PostModel.class);
    	return jsonFeed;
        //model.addAttribute("jsonFeed", jsonFeed);
    }

}
