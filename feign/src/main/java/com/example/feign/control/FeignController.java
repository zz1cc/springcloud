package com.example.feign.control;

import com.example.feign.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeignController {

    @Autowired
    FeignService feignService;

    /**
     * 请求路径与生产者请求一致
     * @return
     */
    @RequestMapping("/getList")
    public List getList(){
        return  feignService.getList();
    }
}
