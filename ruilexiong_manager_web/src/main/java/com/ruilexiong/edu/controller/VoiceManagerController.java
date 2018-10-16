/**
 * FileName: VoiceManagerController
 * Author:   asus
 * Date:     2018/10/15 15:26
 * Description: 后台音频文件管理
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruilexiong.edu.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ruilexiong.edu.service.VoiceManagerService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;

/**
 * 〈一句话功能简述〉<br>
 * 〈后台音频文件管理〉
 *
 * @author asus
 * @create 2018/10/15
 * @since 1.0.0
 */
@Controller
public class VoiceManagerController {

    @Value("${web.upload-path}")//获取上传音频文件目的路径
    private String uploadPath;
    @Reference
    private VoiceManagerService voiceManagerService;

    //跳转至音频文件上传页面
    @RequestMapping("/manager/toUploadVoice")
    public String toUploadPage() {
        return "templates/voice/voiceUpload";
    }

    //将音频文件上传至指定目录
    @PostMapping(value = "/manager/uploadVoice")
    @ResponseBody
    public String index(HttpServletRequest request, @RequestParam("voiceFiles") MultipartFile[] files) {

        if (files != null && files.length >= 1) {
            //创建根目录路径
            File rootPath = new File(uploadPath);
            if (!rootPath.exists()) {
                rootPath.mkdirs();
            }
            BufferedOutputStream bw = null;
            for (int i = 0; i < files.length; i++) {
                try {
                    String fileName = files[i].getOriginalFilename();
                    //判断是否有文件且是否为音频文件
                    if (fileName != null && !"".equalsIgnoreCase(fileName.trim()) && isVoiceFile(fileName)) {
                        //创建输出文件对象
                        File outFile = new File(uploadPath + "/" + fileName);
                        //拷贝文件到输出文件对象
                        FileUtils.copyInputStreamToFile(files[0].getInputStream(), outFile);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (bw != null) {
                            bw.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return "0";
    }

    //判断后缀是否符合音频文件
    private boolean isVoiceFile(String fileName) {
        String[] img_type = new String[]{".mp3", ".wav", "jpg"};
        if (fileName == null) {
            return false;
        }
        fileName = fileName.toLowerCase();
        for (String type : img_type) {
            if (fileName.endsWith(type)) {
                return true;
            }
        }
        return false;

    }

    //获取上传文件后缀名
    private String getFileType(String fileName) {
        if (fileName != null && fileName.indexOf(".") >= 0) {
            return fileName.substring(fileName.lastIndexOf("."), fileName.length());
        }
        return "";
    }

}