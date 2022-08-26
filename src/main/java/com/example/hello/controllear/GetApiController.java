package com.example.hello.controllear;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {
    @GetMapping(path ="/hello")
    public  String getHello(){
        return "getHello";
    }
    //pathvarible
    @GetMapping("/path-Variable/{name}")
    public  String pathVariable(@PathVariable(name = "name") String pathname){
        System.out.println("pathVariable:" + pathname);
        return pathname;
    }

    //quary ?부터 검색할때 시작하는것
    // http://localhost:9090/api/get/quary-param?user=steve&emalil = stave
    @GetMapping("query-param")
    public String getParam(Map<String, String> queryParam){
        StringBuilder sb = new StringBuilder();
        queryParam.entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");
            sb.append(entry.getKey()+"="+entry.getValue()+ "\n");
        });

        return sb.toString();
    }
    @GetMapping("query-param02")
    public  String queryParam02(
        @RequestParam String name,
        @RequestParam String email,
        @RequestParam int age
        ){
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);
        return  name +" " +email +" " +age;
    }


}
