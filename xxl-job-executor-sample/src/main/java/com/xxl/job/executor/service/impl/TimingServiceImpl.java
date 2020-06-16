package com.xxl.job.executor.service.impl;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.executor.common.header.GetHeader;
import com.xxl.job.executor.restTemplate.CommonRestTemplate;
import com.xxl.job.executor.service.TimingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.xxl.job.executor.common.url.BaseUrl.DELAY_SEND_MQ;

@Service
public class TimingServiceImpl implements TimingService {

    @Autowired
    private CommonRestTemplate commonRestTemplate;

    /**
     *  定时触发-延时发送消息
     * @param param
     * @author 杨文超
     * @date 2020-06-16
     */
    @Override
    public ReturnT<String> delaySendMQ(String param) {

        Map<Object, Object> msg = new HashMap<>();
        msg.put("name","定时执行器");
        msg.put("执行时间",new Date());
        commonRestTemplate.post(DELAY_SEND_MQ, msg, GetHeader.getHeader());
        return ReturnT.SUCCESS;
    }

}
