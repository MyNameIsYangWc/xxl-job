package com.xxl.job.executor.common.url;

public interface BaseUrl extends BaseHost {

     //延迟消息队列
     String DELAY_SEND_MQ=RABBITMQ_PRODUCER+"/rabbitmqDelayProducer/delaySendMQ";

}
