package info.nemoworks.udo.poc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PocController {
    @GetMapping(value = "/")
    public Map<String,Object> hello() {
        Map<String,Object> map = new HashMap<>();
        map.put("name","world");
        return map;
    }

}
