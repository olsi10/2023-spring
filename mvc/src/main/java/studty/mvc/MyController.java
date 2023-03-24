package studty.mvc;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api") // 이게 붙으면 주소는 localhost:1234/api/hello
// @Controller 대신 Rest API를 만드는 데에 최적화 된 RestController 사용
public class MyController {

//    @GetMapping("/hello")
//    public String hello() {
//        return "hello";
//    }

    // /hello 주소로 들어온 GET 메소드
    // @GetMapping("/hello") 똑같은 것
    @RequestMapping(value = "/hello", method = RequestMethod.GET)

    // 메소드가 끝나면 reponse가 날아감. 조작만 잘해서 hello를 주면 됨
    public void hello(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {
        response.setStatus(200);
        response.setHeader("Content-Type", "text/plain; charset=utf-8");
        response.setHeader("Content-Length", "5");
        response.getWriter().write("hello");

    }

    @GetMapping("/echo")
    public void method(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {
        response.setHeader("Content-Type", "text/html; charset=utf-8");
        response.getWriter().write("<h1>에코</h1>");
        
        String method = request.getMethod();
        System.out.println("Method : " +  method);

        String uri = request.getRequestURI();
        System.out.println("URI : " + uri);

        // 메소드
        // 주소
        // 버전

        String q = request.getQueryString();
        System.out.println("Query String : " + q);

        String protocol = request.getProtocol();
        System.out.println(protocol);

        // 해시맵
        HashMap<String, String> m = new HashMap<>();
        String[] parts = q.split("&");
        for(String p : parts) {
            String[] pair = p.split("=");
            m.put(pair[0], pair[1]);
        }

        for(Map.Entry<String, String> entry : m.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
