package com.example.eurekaclient2.client.controll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TestGetDataController {

    @Autowired
    HttpServletRequest request;

    @RequestMapping("/list")
    public List list (){
        List list = new ArrayList();
        list.add(1);
        list.add(4);
        list.add(request.getServerPort());
        return list;
    }
}
