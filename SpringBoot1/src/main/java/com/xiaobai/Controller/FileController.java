package com.xiaobai.Controller;

import com.xiaobai.model.JsonData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 文件测试
 *
 * @author 余修文
 * @date 2019/5/7 10:14
 */
@Controller
@PropertySource({"classpath:application.properties"})
public class FileController {

    @RequestMapping(value = "/api/v1/gopage")
    public Object index() {
        return "index";
    }

    @Value("${web.file.path}")
    private String filePath;

    @RequestMapping(value = "/print")
    @ResponseBody
    public JsonData printfResources() {
        return new JsonData(0, "成功", filePath);
    }

    @RequestMapping(value = "upload")
    @ResponseBody
    public JsonData upload(@RequestParam("head_img") MultipartFile file,
                           HttpServletRequest request) {
        if (file.isEmpty()) {
            return new JsonData(-1, "文件不能为空！", null);
        }
        if (file.getSize() > 1024 * 1024) {
            return new JsonData(-1, "文件太大！", null);
        }
        String name = request.getParameter("name");
        System.out.println("用户名：" + name);

        String fileName = file.getOriginalFilename();
        System.out.println("上传的文件名为：" + fileName);

        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        System.out.println("上传的后缀名为：" + suffixName);

        // 文件上传后的路径
        fileName = UUID.randomUUID() + suffixName;
        System.out.println("转换后的名称:" + fileName);

        File dest = new File(filePath + fileName);

        try {
            file.transferTo(dest);

            return new JsonData(0, fileName);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new JsonData(-1, "fail to save", null);
    }

}

