package javaOfMyThink.JavaBaseEntityThink;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

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


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }


    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }


}
