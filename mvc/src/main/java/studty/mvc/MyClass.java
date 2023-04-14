package studty.mvc;

import jakarta.websocket.OnClose;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import java.util.Objects;

class Result {

    public String result;
    public Integer code;
}

@RestController
@RequestMapping("/test")
public class MyClass {

    @GetMapping(value = "/result-test", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result r() {
        return new Result();
    }

    @GetMapping(value = "/result-test2", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result rr() {
        Result r = new Result();
        r.result = "success";
        r.code = 10101;

        return r;
    }

//    @GetMapping(value = "/result-test3", produces = MediaType.APPLICATION_JSON_VALUE)
//    public Map<String, Object> rrr3() {
//        Map<String, Object> = new HashMap<>();
//        rrr3().put("result", "success");
//        rrr3().put("code", 3333);
//    }

    @GetMapping(value = "/date-json", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> json() {
        LocalDate now1 = LocalDate.now();
        LocalTime now2 = LocalTime.now();
        System.out.println(now1);
        System.out.println(now2);
        String date = String.valueOf(now1);
        String time = String.valueOf(now2);
        Map<String, Object> map = new HashMap<>();

        map.put("date", date);
        map.put("time", time);

        return map;
    }
}
