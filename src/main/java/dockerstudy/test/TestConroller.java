package dockerstudy.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestConroller {

    @GetMapping("")
    public String getTest() {
        return "Test~!";
    }
}
