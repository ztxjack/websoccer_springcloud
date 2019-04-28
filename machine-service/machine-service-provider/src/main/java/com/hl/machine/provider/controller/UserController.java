package com.hl.machine.provider.controller;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hl.common.entity.User;
import com.hl.common.rest.Result;
import com.hl.common.rest.ResultGenerator;
import com.hl.machine.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mr.磊
 * @since 2018-05-12
 */
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public Result save (@RequestBody User user) {
		return ResultGenerator.genSuccessResult(userService.insert(user));
	}

}

