/**
 * FileName: VoiceFile
 * Author:   asus
 * Date:     2018/10/18 15:41
 * Description: 音频文件类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruilexiong.edu.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈音频文件类〉
 *
 * @author asus
 * @create 2018/10/18
 * @since 1.0.0
 */
@Entity
@Table(name = "voicefile")
public class VoiceFile implements Serializable {
    @Id //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增
    private Integer voiceId;
    private String fileName;
    private String picName;
    private Integer typeId;
    private String uploadTime;


    @Override
    public String toString() {
        return "VoiceFile{" +
                "voiceId=" + voiceId +
                ", fileName='" + fileName + '\'' +
                ", picName='" + picName + '\'' +
                ", typeId=" + typeId +
                ", uploadTime='" + uploadTime + '\'' +
                '}';
    }

    public Integer getVoiceId() {
        return voiceId;
    }

    public void setVoiceId(Integer voiceId) {
        this.voiceId = voiceId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }
}