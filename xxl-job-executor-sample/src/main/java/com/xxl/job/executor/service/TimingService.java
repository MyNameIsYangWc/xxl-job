package com.xxl.job.executor.service;

import com.xxl.job.core.biz.model.ReturnT;

public interface TimingService {

    ReturnT<String> delaySendMQ(String param);
}
