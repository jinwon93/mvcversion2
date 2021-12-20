package hello.thymeleaf.basic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/basic")
public class BasicController {

    @GetMapping("/text-basic")
    public String textBasic(Model model){
        model.addAttribute("data" , "Hello <b>Spring</b>");
        return "basic/text-basic";
    }


    @GetMapping("/text-unescapted")
    public String textUnescaped(Model model){
        model.addAttribute("data" , "Hello <b>Spring</b>");
        return "basic/text-unescapted";
    }

    @GetMapping("/variable")
    public String variable(Model model){

        User userA = new User("userA" , 10);
        User userB = new User("userB" , 20);

        List<User> list = new ArrayList<>();
        list.add(userA);
        list.add(userB);

        Map<String , User> map = new HashMap<>();
        map.put("userA" , userA);
        map.put("userB" , userB);

        model.addAttribute("user" , userA);
        model.addAttribute("users" , list);
        model.addAttribute("userMap" , map);

        return "basic/variable";
    }

    @GetMapping("/data")
    public  String date(Model model){
        model.addAttribute("localDateTime" , LocalDateTime.now());
        return "basic/date";
    }

    @GetMapping("/link")
    public String link(Model model){
        model.addAttribute("param1" , "data1");
        model.addAttribute("param2" , "data2");

        return "basic/link";

    }

    @GetMapping("/each")
    public String each(Model model){
        addUsers(model);
        return "basic/each";
    }

    private void addUsers(Model model){
        List<User> list = new ArrayList<>();
        list.add(new User("userA" , 10));
        list.add(new User("userB" , 20));
        list.add(new User("userC" , 30));

        model.addAttribute("users" , list);
    }


    @GetMapping("/literal")
    public String literal(Model model){
        model.addAttribute("data", "Spring");
        return "basic/literal";
    }

    @GetMapping("operation")
    public String operation(Model model){
        model.addAttribute("nullData" , null);
        model.addAttribute("data",  "Spring");
        return "basic/operation";
    }


}
