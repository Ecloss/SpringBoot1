package com.xiaobai.Controller;

import com.xiaobai.model.ServerSettings;
import com.xiaobai.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 测试Http协议的get请求
 *
 * @author 余修文
 * @date 2019/5/6 17:51
 */
@RestController
public class GetController {

    private Map<String, Object> params = new HashMap<>(16);

    /**
     * 测试resultFul协议，从路径中获取字段
     * 定义的协议链接：不要用驼峰，最好用下划线_
     *
     * @param cityId
     * @param userId
     * @return
     */
    @RequestMapping(value = "/v1/{city_id}/{user_id}", method = RequestMethod.GET)
    public Object findUser(@PathVariable("city_id") String cityId,
                           @PathVariable("user_id") String userId) {
        params.clear();

        params.put("cityId", cityId);
        params.put("userId", userId);

        return params;
    }

    /**
     * 测试GetMapping
     *
     * @param from
     * @param size
     * @return
     */
    @GetMapping(value = "/v1/page_user1")
    public Object pageUser(int from, int size) {
        params.clear();

        params.put("from", from);
        params.put("size", size);

        return params;
    }

    /**
     * 测试@RequestParam
     *
     * @param from
     * @param size
     * @return
     */
    @GetMapping(value = "/v1/page_user2")
    public Object pageUserV2(@RequestParam(defaultValue = "1", name = "page") int from,
                             @RequestParam(defaultValue = "10", name = "size") int size) {
        params.clear();

        params.put("from", from);
        params.put("size", size);
        params.put("num", 100);
        System.out.println("123");


        return params;
    }

    /**
     * 功能描述：bean对象传参
     * 注意：1、注意需要指定http头为 content-type为application/json
     * 2、使用body传输数据
     *
     * @param user
     * @return
     */
    @PostMapping(value = "/v2/save_user")
    public Object saveUser(@RequestBody User user) {
        params.clear();

        params.put("name", user.getName());
        params.put("user", user);

        return params;
    }

    /**
     * 功能描述：测试获取http头信息
     *
     * @param access_token
     * @param id
     * @return
     */
    @GetMapping("/v1/get_header")
    public Object getHeader(@RequestHeader("access_token") String access_token, String id) {
        params.clear();

        params.put("access_token", access_token);
        params.put("id", id);

        return params;
    }

    /**
     * 测试request请求
     *
     * @param request
     * @return
     */
    @GetMapping("/v1/test_request")
    public Object testRequest(HttpServletRequest request) {
        params.clear();

        String id = request.getParameter("id");
        params.put("id", id);

        return params;
    }

    @Autowired
    private ServerSettings serverSettings;

    @GetMapping(value = "/v1/test_properties")
    public Object testPeroperties() {


        return serverSettings;
    }

}
