package info.nemoworks.udo.poc;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
