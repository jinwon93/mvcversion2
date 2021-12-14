package hello.thymeleaf.basic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

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

//    @GetMapping("/variable")
//    public String variable(Model model){
//
//    }

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


}
