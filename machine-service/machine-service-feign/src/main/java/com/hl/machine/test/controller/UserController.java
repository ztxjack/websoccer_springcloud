package com.hl.machine.test.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hl.common.entity.User;
import com.hl.common.rest.Result;
import com.hl.common.rest.ResultGenerator;
import com.hl.machine.test.client.UserClient;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "基准测试")
@RestController
public class UserController {
	
	@Autowired
	private UserClient userClient;
	
	@ApiOperation("调用数据库进行批次量测试数据!")
	@RequestMapping(value = "/test2",method = RequestMethod.GET)
	public Result test (String id) {
		List<String> list = new ArrayList<>();
		list.add("测试服务器性能开始>>>>>");
		List<Date> start = new ArrayList<>();
		int a = 0;
		int b = 0;
		System.out.println("统计开始时间:"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		start.add(new Date());
		for (int i = 0;i<10000;i++) {
			try {
			    Thread th = new Thread(new Runnable(){
			        public void run(){
			        	User user = new User();
			        	user.setAge(1);
			        	user.setCreateBy("磊哥");
			        	user.setCreateDate(new Date());
			        	user.setMark("测试一下服务器压力!");
			        	user.setPassword("123456");
			        	user.setSex(1);
			        	user.setUsername("希望服务器别崩!");
						Result result = userClient.save(user);
						start.add(new Date());
						if (start.size() == 10000){//new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
							System.out.println("开始时间:"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(start.get(0))
									+",结束时间："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(start.get(9999)));
							System.out.println("总计耗时(秒)："+(start.get(9999).getTime() - start.get(0).getTime())/1000);
							System.out.println("总计耗时(分)："+(start.get(9999).getTime() - start.get(0).getTime())/1000/60);
						}						
						//System.out.println("当前进行时间:"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
						//System.out.println("正在进行接口测试,访问是否成功:"+result.getMessage()+"更新数据是否成功:"+result.getData());
			        } 
			      });
			    //System.out.println("第"+i+"次访问!");
			    th.start();
			    b = b+1;
			} catch (Exception e) {
				//System.out.println("当前异常:"+e.getMessage());
				if (start.size() == 10000){//new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					System.out.println("开始时间:"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(start.get(0))
							+",结束时间："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(start.get(9999)));
					System.out.println("总计耗时(秒)："+(start.get(9999).getTime() - start.get(0).getTime())/1000);
					System.out.println("总计耗时(分)："+(start.get(9999).getTime() - start.get(0).getTime())/1000/60);
				}	
				a = a+1;
				System.err.println("测试失败:"+a);				
				continue;
			}
		}
		System.err.println("访问结果统计,异常:"+a+",成功:"+(10000-a));
		list.add(">>>>>测试服务器性能结束");
		return ResultGenerator.genSuccessResult(list);
	}

}
