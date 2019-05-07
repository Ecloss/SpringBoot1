package com.xiaobai.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 余修文
 * @date 2019/5/6 22:33
 * ResponseBody + Controller
 */
@RestController
public class OtherHttpController {

    private Map<String, Object> params = new HashMap<>();

    @PostMapping("/v1/login")
    public Object login(String id, String pwd) {
        params.clear();
        params.put("id", id);
        params.put("pwd", pwd);

        return params;
    }

    @PutMapping(value = "/v1/put")
    public Object put(String id) {
        params.clear();
        params.put("id", id);

        return params;
    }

    @DeleteMapping(value = "/v1/del")
    public Object del(String id) {
        params.clear();

        params.put("id", id);
        return params;
    }

}
