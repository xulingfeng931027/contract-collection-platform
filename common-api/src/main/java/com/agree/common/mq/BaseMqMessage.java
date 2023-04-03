package com.agree.common.mq;

import com.alibaba.fastjson2.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.*;
import lombok.Builder.Default;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @className: RcnMqMessage
 * @Author: xulingfeng
 * @description: 事件消息基类
 * @date: 2023/3/2 16:47
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseMqMessage {

    /**
     * 消息唯一ID
     */
    @Default
    private String msgId = UUID.randomUUID().toString();

    /**
     * 消息主题
     */
    private String topic;

    /**
     * 消息类型
     */
    private String type;

    /**
     * 消息动作类型
     */
    private String action;

    /**
     * 消息发送方
     */
    private String src;

    /**
     * 消息数据
     */
    private String data;

    /**
     * 消息创建时间
     */
    @Default
    private long createTimeMillis = System.currentTimeMillis();

    /**
     * 消息其他属性
     */
    @Default
    private Map<String, String> properties = new HashMap<>();


    /**
     * 事件ID
     */
    private String eventId;

    /**
     * 设置数据对象
     *
     * @param dataObj 数据对象
     * @throws JsonProcessingException
     */
    public void setData(Object dataObj) throws Exception {
        if (dataObj != null) {
            if (dataObj instanceof String) {
                data = (String) dataObj;
            } else {
                data = JSONObject.toJSONString(dataObj);
            }
        } else {
            this.data = "";
        }
    }

    /**
     * 从消息体中获取消息对象
     *
     * @param clazz 消息对象类
     * @return 消息对象
     * @throws Exception
     */
    public <T extends Object> T getData(Class<T> clazz) {
        if (StringUtils.isEmpty(this.data)) {
            return null;
        }
        if (clazz.equals(String.class)) {
            return (T) this.data;
        } else {
            return JSONObject.parseObject(this.data, clazz);
        }
    }

    /**
     * 从消息体中获取消息Map对象
     *
     * @return 消息Map对象
     * @throws Exception
     */
    public Map<String, Object> getDataMap() throws Exception {
        return this.getData(HashMap.class);
    }

    /**
     * 从消息体中获取消息字符串
     *
     * @return 消息字符串
     * @throws Exception
     */
    public String getDataString() throws Exception {
        return this.getData(String.class);
    }

    /**
     * 添加消息属性
     *
     * @param key
     * @param value
     */
    public void addProperty(String key, String value) {
        properties.put(key, value);
    }

}
