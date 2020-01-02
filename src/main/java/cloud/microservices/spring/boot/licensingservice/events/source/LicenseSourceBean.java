package cloud.microservices.spring.boot.licensingservice.events.source;

import cloud.microservices.spring.boot.licensingservice.events.models.LicenseChangeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class LicenseSourceBean {

    private Source source;

    @Autowired
    public LicenseSourceBean(Source source) {
        this.source = source;
    }

    public void publishLicenseChange(String action, String licenseId) {
        final LicenseChangeModel model = new LicenseChangeModel(action, licenseId);
        source.output().send(MessageBuilder.withPayload(model).build());
    }
}
