/**
 * FileName: VoiceFileMapping
 * Author:   asus
 * Date:     2018/10/18 15:50
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruilexiong.edu.mapping;

import com.ruilexiong.edu.entity.VoiceFile;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author asus
 * @create 2018/10/18
 * @since 1.0.0
 */
public interface VoiceFileMapping extends JpaRepository<VoiceFile,Integer> {
}