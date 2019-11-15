package javaOfMyThink.JavaBaseEntityThink;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: fang
 * @Date: 2019/11/15 21:35
 * @Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends BaseEntity {

    private int id;
    private String name;
    private String gender;

}
