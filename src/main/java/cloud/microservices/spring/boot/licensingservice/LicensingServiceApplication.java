package cloud.microservices.spring.boot.licensingservice;

import cloud.microservices.spring.boot.licensingservice.events.source.LicenseSourceBean;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.*;


@EnableEurekaClient
@RestController
@RequestMapping(value = "/v1/license")
@SpringBootApplication
@RefreshScope
@EnableResourceServer
@EnableBinding(Source.class)
public class LicensingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LicensingServiceApplication.class, args);
    }

    @Autowired
    private LicenseSourceBean sourceBean;

    @Value("${licensing-mode}")
    private String mode;

    @RequestMapping(value = "/mode", method = RequestMethod.GET)
    public String getMode() {
        /*final Random rand = new Random();
        //if(rand.nextInt(4) == 3) {
            try {
                Thread.sleep(1200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        //}*/
        return mode;
    }


    @RequestMapping(value = "/id/{licenseId}", method = RequestMethod.GET)
    public String id(@PathVariable("licenseId") String licenseId) {
        return "license-object";
    }

    @RequestMapping(value = "/id/{licenseId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("licenseId") String licenseId) {
        sourceBean.publishLicenseChange("DELETE", licenseId);
    }
}
