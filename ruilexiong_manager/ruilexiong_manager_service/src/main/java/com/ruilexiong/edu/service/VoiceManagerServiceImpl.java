/**
 * FileName: VoiceManagerService
 * Author:   asus
 * Date:     2018/10/15 15:29
 * Description: 音频文件管理业务类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruilexiong.edu.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ruilexiong.edu.entity.VoiceFile;
import com.ruilexiong.edu.mapping.VoiceFileMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉<br>
 * 〈音频文件管理业务类〉
 *
 * @author asus
 * @create 2018/10/15
 * @since 1.0.0
 */
@Component
@Service
public class VoiceManagerServiceImpl implements VoiceManagerService {

    @Autowired
    private VoiceFileMapping voiceFileMapping;

    @Override
    public void insertVoiceFile(VoiceFile voiceFile) {
        voiceFileMapping.save(voiceFile);
    }
}