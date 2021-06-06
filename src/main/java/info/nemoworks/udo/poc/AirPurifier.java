package info.nemoworks.udo.poc;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AirPurifier {

    private String entityId;
    private String state;
    private String mode;
    private double temperature;
    private int humidity;
    private int aqi;
}
