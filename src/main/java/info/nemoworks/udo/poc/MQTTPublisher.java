package info.nemoworks.udo.poc;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

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

        Map<String, Object> map = new HashMap<>();
        map.put("name", "world");
        MqttMessage mqttMessage = new MqttMessage(map.toString().getBytes());
        client.publish("sub/app_demo/rt2lOHoB6rEk5qw4LBPd", mqttMessage);
        System.out.println("\tMessage '" + map + "' to 'udo'");
//        String dumbStr = "ThisIsNotAJsonStr";
//        MqttMessage dumbStrMessage = new MqttMessage(dumbStr.getBytes());
//        client.publish("sub/app_demo/rt2lOHoB6rEk5qw4LBPd", dumbStrMessage);
        String illegalStrCreatedBy = "{CreatedBy: who}";
        String illegalStrCreatedOn = "{CreatedOn: 1202}";
        String correctStr = "{CreatedBy: nemoworks, CreatedOn: 2021}";
        MqttMessage illegalCreatedByMessage = new MqttMessage(illegalStrCreatedBy.getBytes());
        MqttMessage illegalCreatedOnMessage = new MqttMessage(illegalStrCreatedOn.getBytes());
        MqttMessage correctMessage = new MqttMessage(correctStr.getBytes());
        client.publish("sub/app_demo/rt2lOHoB6rEk5qw4LBPd", illegalCreatedByMessage);
        client.publish("sub/app_demo/rt2lOHoB6rEk5qw4LBPd", illegalCreatedOnMessage);
        client.publish("sub/app_demo/rt2lOHoB6rEk5qw4LBPd", correctMessage);
    }

//    public void publishFilteringMessage(String appId, String formatString, String udoId)
//        throws MqttException {
//        String clientid = UUID.randomUUID().toString();
//        MqttClient client = null;
////        MqttClient client1 = null;
//        client = new MqttClient("tcp://test.mosquitto.org:1883", clientid);
//        MqttConnectOptions options = new MqttConnectOptions();
//        options.setAutomaticReconnect(true);
//        options.setCleanSession(true);
//        options.setConnectionTimeout(10);
//        client.connect(options);
//        MqttMessage mqttMessage = new MqttMessage(formatString.getBytes());
//        client.publish("sub/" + appId + "/" + udoId, mqttMessage);
//        System.out.println("\tMessage '" + formatString + "' to 'udo'");
//    }
}
