package javaOfMyThink.JavaBaseEntityThink;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * @Author: fang
 * @Date: 2019/11/15 21:25
 * @Description:
 */
public abstract class BaseEntity implements Serializable {

    /**
     * 将当前对象转成json格式
     * @return
     */
    public String toJsonString(){
        return JSON.toJSONString(this);
    }

}
