package com.agree.collection;

import com.agree.contract.ContractSystemApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
public class BillingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContractSystemApplication.class, args);
	}

}
