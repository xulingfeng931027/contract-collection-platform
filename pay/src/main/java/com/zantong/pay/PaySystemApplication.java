package com.zantong.pay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
public class PaySystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaySystemApplication.class, args);
	}

}
