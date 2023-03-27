package com.zantong.collection;

import com.billing.system.domain.entity.handler.BillHandleContext;
import org.junit.jupiter.api.Test;

//@SpringBootTest
class ContractSystemApplicationTests {

	@Test
	void contextLoads() {
		BillHandleContext build = BillHandleContext.builder().build();
//		BillHandleContext build = new BillHandleContext();
//		System.out.println(build.getLastTimeCalledCost());
	}

}
