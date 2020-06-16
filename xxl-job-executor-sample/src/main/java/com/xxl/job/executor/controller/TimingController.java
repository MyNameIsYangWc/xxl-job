package com.xxl.job.executor.controller;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import com.xxl.job.executor.service.TimingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;

/**
 * 定时Controller
 * @author 杨文超
 * @date 2020-06-16
 */
@RestController
@RequestMapping("/Timing")
@Api(value = "TimingController",description = "定时任务Controller")
public class TimingController {

    @Autowired
    private TimingService timingService;

    /**
     *  定时触发-延时发送消息
     * @param param
     * @author 杨文超
     * @date 2020-06-16
     */
    @ApiOperation(value = "定时触发-延时发送消息",notes = "定时触发-延时发送消息")
    @ApiImplicitParams({

            @ApiImplicitParam(name = "Accept",value = "",required = false,dataType = "String",paramType = "header",defaultValue = "application/json")
    })
    @XxlJob("delaySendMQHandler")
    @PostMapping("/delaySendMQ")
    public ReturnT<String> delaySendMQHandler(String param) throws Exception{

        XxlJobLogger.log(String.format("delaySendMQ开始执行，时间：%s",new Date()));
        ReturnT<String> stringReturnT = timingService.delaySendMQ(param);
        return stringReturnT;
    }

}