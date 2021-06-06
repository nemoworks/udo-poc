package info.nemoworks.udo.poc;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MQTTPublisher {

    public static void main(String[] args) throws MqttException {
        String clientid = UUID.randomUUID().toString();
        MqttClient client = null;
//        MqttClient client1 = null;
        client = new MqttClient("tcp://test.mosquitto.org:1883", clientid);
        MqttConnectOptions options = new MqttConnectOptions();
        options.setAutomaticReconnect(true);
        options.setCleanSession(true);
        options.setConnectionTimeout(10);
        client.connect(options);

//        client1 = new MqttClient("tcp://test.mosquitto.org:1883", clientid);
//        client1.connect(options);
//        client1.subscribe("sub/app_demo/H4863HkBn1Poxb4D_FLG",((topic, payload) -> {
//            System.out.println("subscriber=====" + new String(payload.getPayload()));
//        }));

        Map<String,Object> map = new HashMap<>();
        map.put("name","world");
        MqttMessage mqttMessage = new MqttMessage(map.toString().getBytes());
        client.publish("sub/app_demo/H4863HkBn1Poxb4D_FLG",mqttMessage);
        System.out.println("\tMessage '" + map + "' to 'udo'");
    }
}
