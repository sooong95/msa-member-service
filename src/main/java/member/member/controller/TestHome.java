package member.member.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestHome {

    @GetMapping("/member/test")
    public String home() {
        return "ok";
    }
}
