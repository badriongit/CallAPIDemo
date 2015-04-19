package demo;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;


@Configuration
@ComponentScan("demo")
@PropertySource(value = "classpath:application.properties")
public class CallAPIConfig {
	private static final Charset UTF8 = Charset.forName("UTF-8");
	
	@Bean
	public RestTemplate restTemplate(){
		RestTemplate template = new RestTemplate();
		
		 List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		    MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();        
		    mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(new MediaType("application", "json", UTF8)));
		    messageConverters.add(mappingJackson2HttpMessageConverter);
		return template;
	}
	

}
