package com.xxl.job.executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author xuxueli 2018-10-28 00:38:13
 */
@SpringBootApplication
@EnableEurekaClient
public class XxlJobExecutorApplication {

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){

		HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		httpRequestFactory.setConnectionRequestTimeout(3000);
		httpRequestFactory.setConnectTimeout(3000);
		httpRequestFactory.setReadTimeout(3000);

		RestTemplate restTemplate = new RestTemplate(httpRequestFactory);
		return restTemplate;
	}

	public static void main(String[] args) {
        SpringApplication.run(XxlJobExecutorApplication.class, args);
		System.out.println("定时管理启动成功!!!");
	}

}