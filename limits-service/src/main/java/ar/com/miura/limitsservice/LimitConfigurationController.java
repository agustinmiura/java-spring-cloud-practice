package ar.com.miura.limitsservice;

import ar.com.miura.limitsservice.bean.LimitConfiguration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitConfigurationController {

    @Autowired
    private Configuration configuration;

    @GetMapping("/limits")
    @ResponseBody
    public LimitConfiguration getLimitFromConfig() {
        return new LimitConfiguration(configuration.getMin(), configuration.getMax());
    }

    @GetMapping("/fault-tolerant-example")
    @HystrixCommand(fallbackMethod = "fallbackGetConfiguration")
    public LimitConfiguration getLimitFromConfigFallback() {
        throw new RuntimeException("Not Available");
    }

    public LimitConfiguration fallbackGetConfiguration() {
        return new LimitConfiguration(9,999);
    }

}
