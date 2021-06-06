package info.nemoworks.udo.poc;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

import java.util.UUID;

public class MQTTSubScriber {
    public static void main(String[] args) throws MqttException {
        String clientid = UUID.randomUUID().toString();
        MqttClient client = null;
        client = new MqttClient("tcp://test.mosquitto.org:1883", clientid);
        MqttConnectOptions options = new MqttConnectOptions();
        options.setAutomaticReconnect(true);
        options.setCleanSession(true);
        options.setConnectionTimeout(10);
        client.connect(options);

        client.subscribe("sub/app_demo/H4863HkBn1Poxb4D_FLG",((topic, payload) -> {
            System.out.println("subscriber=====" + new String(payload.getPayload()));
        }));
    }
}
