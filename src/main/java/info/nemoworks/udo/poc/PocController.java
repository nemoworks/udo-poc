package info.nemoworks.udo.poc;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PocController {



    private AirPurifier airPurifier;

    @GetMapping(value = "/air")
    public String getAir() {
        this.airPurifier = new AirPurifier("fan.mypurifier2",
            "off",
            "idle",
            22.7,
            38,
            53);
        System.out.println(new Gson().toJson(this.airPurifier));
        return new Gson().toJson(this.airPurifier);
    }

    @PostMapping(value = "/air")
    public String createAir(String str) {
        this.airPurifier = new Gson().fromJson(str, AirPurifier.class);
        return new Gson().toJson(airPurifier);
    }

    @DeleteMapping(value = "/air")
    public String deleteAir() {
        this.airPurifier = null;
        return "Air purifier deleted.";
    }

    @PutMapping(value = "/air")
    public String putAir(@RequestParam String str) {
        this.airPurifier = new Gson().fromJson(str, AirPurifier.class);
        return new Gson().toJson(airPurifier);
    }

    @GetMapping(value = "/")
    public Map<String,Object> hello() {
        Map<String,Object> map = new HashMap<>();
        map.put("name","world");
        return map;
    }

    @PostMapping(value = "/")
    public Map<String,Object> postHello(@RequestBody String params){
        System.out.println(params);
        Map<String,Object> map = new HashMap<>();
        map.put("name","tc");
        return map;
    }
}
