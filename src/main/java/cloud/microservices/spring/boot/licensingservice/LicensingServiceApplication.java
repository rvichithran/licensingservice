package cloud.microservices.spring.boot.licensingservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;


@EnableEurekaClient
@RestController
@RequestMapping(value = "/v1/licenses")
@SpringBootApplication
@RefreshScope
@EnableResourceServer
public class LicensingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LicensingServiceApplication.class, args);
    }

    @Value("${licensing-mode}")
    private String mode;

    @RequestMapping(value = "/mode", method = RequestMethod.GET)
    public String getMode() {
        final Random rand = new Random();
        //if(rand.nextInt(4) == 3) {
            /*try {
                Thread.sleep(1200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        //}
        return mode;
    }
}
