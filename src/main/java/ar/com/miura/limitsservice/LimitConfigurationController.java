package ar.com.miura.limitsservice;

import ar.com.miura.limitsservice.bean.LimitConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitConfigurationController {

    @GetMapping("/limits")
    @ResponseBody
    public LimitConfiguration getLimitFromConfig() {
        return new LimitConfiguration(1,100);
    }

}
