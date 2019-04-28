package com.hl.machine.test.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hl.common.entity.User;
import com.hl.common.rest.Result;
import com.hl.common.rest.ResultGenerator;

@FeignClient(fallback = UserClient.Fallback.class,name = "machine-service-provider")
public interface UserClient {
	
	@RequestMapping(value="/user/save", method=RequestMethod.GET)  
	public Result save (@RequestBody User user);
	
	@Component
	static class Fallback implements UserClient {

		@Override
		public Result save(User user) {
			return ResultGenerator.genFailResult("当前服务好像崩溃了TxT...");
		}
		
	}

}
