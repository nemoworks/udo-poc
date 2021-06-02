package info.nemoworks.udo.poc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PocController {
    @GetMapping(value = "/")
    public String hello() {
        return "{name: testName}";
    }

}
