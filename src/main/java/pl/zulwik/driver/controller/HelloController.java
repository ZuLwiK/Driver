package pl.zulwik.driver.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @GetMapping
    public String get(){
        return "test";
    }

    @GetMapping("/admin")
    @ResponseBody
    public String admin2(@AuthenticationPrincipal UserDetails customUser){
        return "this is userEntity " + customUser;
    }
}
