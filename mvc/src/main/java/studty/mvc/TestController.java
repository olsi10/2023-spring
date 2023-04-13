package studty.mvc;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/test")
public class TestController {

    // hello, world 출력하기
    @GetMapping(value = "/hello", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public String hello() {
        return "Hello, world";
    }

    // string 붙이기
    // Get "/reverse?words=hello,world,mirim"
    // 일반적인 텍스트로 "mirim,world,hello 출력하기
    // Get "/reverse?words=web,solution" -> "solution, web" 출력

    @GetMapping(value = "/reverse", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String reverse(@RequestParam(value = "word", required = true) String word) {
        String result = "";
        String[] words = word.split(",");
        for(int i = words.length - 1;  i >= 0; i--) {
            if(i != 0) {
                result += words[i] + ",";
            }
            if(i == 0) {
                result += words[i];
            }
        }
//        System.currentTimeMillis();
        return result;
    }

    // 3번
    @GetMapping(value = "/mul", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String mul1(@RequestParam("num1") int num1,
                            @RequestParam("num2") int num2) {

        int result = num1 * num2;

        return String.valueOf((result));

    }

    //4번
    @GetMapping(value = "/calc/{math}", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String mul2(@PathVariable(value = "math") String math,
                       @RequestParam("num1") int num1,
                       @RequestParam("num2") int num2) {

        int i = 0;

        switch (math) {
            case "mul":
                i = num1 * num2;
                break;
            case "add":
                i = num1 + num2;
                break;
            case "div":
                i = num1 / num2;
                break;
        }

        return String.valueOf(i);
    }

    int i = 1;
    
    //5번
    //호출횟수 구하기 전역변수로 i 가져오기
    @PostMapping(value = "count")
    @ResponseBody
    public Integer count() {
        i++;
        return i;
    }

}