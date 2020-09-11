package club.ha5fun.easywork.dubbo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author chen
 * @Company ha5fun.club
 */
@Configuration
public class EasyWorkConfig {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
