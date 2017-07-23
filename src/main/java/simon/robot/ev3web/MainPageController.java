package simon.robot.ev3web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.json.Json;
import javax.json.JsonValue;

@Controller
public class MainPageController {

    private final MQSender mqSender;

    public MainPageController(MQSender sender) {
        mqSender = sender;
    }

    @GetMapping("/control")
    public String control(Model model) {
        return "control";
    }

    @PostMapping(value="/control", params = {"forward"})
    public String forward() {
        System.out.println("forward");

        String commandJson = Json.createObjectBuilder()
                .add("command_name", "drive")
                .add("args", Json.createObjectBuilder())
                .build()
                .toString();

        mqSender.send(commandJson);

        return "control";
    }

    @PostMapping(value="/control", params = {"backward"})
    public String backward() {
        System.out.println("backward");

        String commandJson = Json.createObjectBuilder()
                .add("command_name", "drive")
                .add("args", Json.createObjectBuilder()
                        .add("reverse", JsonValue.TRUE)
                )
                .build()
                .toString();

        mqSender.send(commandJson);

        return "control";
    }

    @PostMapping(value="/control", params = {"turn left"})
    public String turnLeft() {
        System.out.println("turn left");

        String commandJson = Json.createObjectBuilder()
                .add("command_name", "turn")
                .add("args", Json.createObjectBuilder()
                        .add("degree", -100)
                )
                .build()
                .toString();

        mqSender.send(commandJson);

        return "control";
    }

    @PostMapping(value="/control", params = {"turn right"})
    public String turnRight() {
        System.out.println("turn right");

        String commandJson = Json.createObjectBuilder()
                .add("command_name", "turn")
                .add("args", Json.createObjectBuilder()
                        .add("degree", 100)
                )
                .build()
                .toString();

        mqSender.send(commandJson);

        return "control";
    }


}
