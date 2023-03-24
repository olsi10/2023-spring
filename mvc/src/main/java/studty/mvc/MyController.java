package studty.mvc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @Controller 대신 Rest API를 만드는 데에 최적화 된 RestController 사용
public class MyController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
