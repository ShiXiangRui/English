/**
 * FileName: UserMapping
 * Author:   asus
 * Date:     2018/7/25 16:12
 * Description: 用户dao层
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruilexiong.edu.mapping;

import com.ruilexiong.edu.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 〈一句话功能简述〉<br> 
 * 〈用户dao层〉
 *
 * @author asus
 * @create 2018/7/25
 * @since 1.0.0
 */
public interface UserMapping  extends JpaRepository<User,Integer> {

}

