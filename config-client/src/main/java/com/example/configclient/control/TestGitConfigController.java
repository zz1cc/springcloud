package com.example.configclient.control;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * 以这种方式注释的Bean可以在运行时刷新，
 * 并且使用它们的任何组件将在下一个方法调用上获得一个新实例，
 * 完全初始化所有依赖项。
 */
@RestController
@RefreshScope// 这个注解声明了刷新配置的范围，如果使用config配置类的话，就声明到配置类上即可
public class TestGitConfigController {

    @Value("${a}")
    private String port;

    @RequestMapping("/getConfigs")
    public Map<String, Object> getConfigs(){
        Map<String, Object> map = new HashMap<>();
        map.put("port", port);
        return map;
    }

    @GetMapping(value = "/refresh")
    public String refresh(@RequestParam("url") String path){
        HttpURLConnection con = null;
        URL url = null;
        try {
            url = new URL(path);
            con = (HttpURLConnection)url.openConnection();
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("POST");
            con.setUseCaches(false);
            con.setInstanceFollowRedirects(true);
            con.connect();

            InputStream is;
            if (con.getResponseCode() >= 400) {
                is = con.getErrorStream();
            } else {
                is = con.getInputStream();
            }
            String response = "";
            byte buff[] = new byte[1024];
            int b = 0;
            while ((b = is.read(buff, 0, buff.length)) != -1) {
                response += new String(buff, 0, b);
            }
            is.close();
            return response;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }
}
