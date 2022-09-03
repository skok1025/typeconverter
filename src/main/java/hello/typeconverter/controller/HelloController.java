package hello.typeconverter.controller;

import hello.typeconverter.type.IpPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HelloController {

    private Integer GlobalData;

    @Autowired
    private MallInfoDTO dto;

    @GetMapping("/hello-v1")
    public String helloV1(HttpServletRequest request) {
        String data = request.getParameter("data"); // 문자타입조회
        Integer intValue = Integer.valueOf(data); // 숫자 타입으로 변경
        System.out.println("intValue = " + intValue);

        return "ok";
    }

    @GetMapping("/hello-v2")
    public String helloV2(@RequestParam Integer data) {
        System.out.println("data = " + data);
        return "ok";
    }

    @GetMapping("/ip-port")
    public String ipPort(@RequestParam IpPort ipPort) {
        System.out.println("ipPort IP = " + ipPort.getIp());
        System.out.println("ipPort Port = " + ipPort.getPort());

        return "ok";
    }

    @GetMapping("/test")
    public String test(@RequestParam Integer data) throws InterruptedException {

        ThreadLocal<Integer> dataLocal = new ThreadLocal<>();
        Integer ThreadData = null;

        dataLocal.set(data);
        dto.setData(data);

        System.out.println("ThreadLocalData: " + ThreadData);
        System.out.println("GlobalData: " + GlobalData);
        System.out.println("dtoData: " + dto.getData());


        ThreadData = dataLocal.get();
        GlobalData = data;
        Thread.sleep(10000); // 10s 초 sleep

        System.out.println("ThreadLocalData: " + ThreadData);
        System.out.println("GlobalData: " + GlobalData);
        System.out.println("dtoData: " + dto.getData());

        return "ok";
    }
}
