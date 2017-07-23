package simon.robot.ev3web;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class MQSender {

    private final RabbitTemplate rabbitTemplate;

    public MQSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(String payload) {
        rabbitTemplate.convertAndSend(Ev3WebApplication.commandQueueName, payload);
    }

}
