package simon.robot.ev3web;

import org.springframework.stereotype.Component;

@Component
public class MQReceiver {

    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
    }

}
