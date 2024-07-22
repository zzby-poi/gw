package com.gw.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.gw.base.resp.ApiResp;
import com.gw.base.resp.PageResp;
import com.gw.demo.entity.Demo;
import com.gw.demo.req.DemoAddReq;
import com.gw.demo.req.DemoEditReq;
import com.gw.demo.req.DemoPageReq;
import com.gw.demo.service.DemoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/** 
* @author yangxy
* @version 创建时间：2023年10月24日 下午4:25:47 
*/
@RestController
@RequestMapping("/demo")
@Api(tags = "示例代码")
public class DemoController {
	@Autowired
	private DemoService demoService;

	@GetMapping("/checkLogin")
	@ApiOperation(value = "校验用户登录示例")
	public ApiResp<String> checkLogin(){
		return ApiResp.sucess();
	}
	
	@GetMapping("/checkAuth")
	@ApiOperation(value = "校验用户是否拥有某个权限示例")
	public ApiResp<String> checkAuth() {
		return ApiResp.sucess();
	}
	
	@GetMapping("/checkRole")
	@ApiOperation(value = "校验用户是否拥有某个角色示例")
	public ApiResp<String> checkRole() {
		return ApiResp.sucess();
	}
	
	@GetMapping("/page")
	@ApiOperation(value = "分页查询示例")
	public ApiResp<PageResp<Demo>> page(DemoPageReq demoPageReq){
		return demoService.page(demoPageReq);
	}
	
	@PostMapping("/add")
	@ApiOperation(value = "新增并记录数据变化操作日志示例")
	public ApiResp<String> add(@RequestBody @Valid DemoAddReq demoAddReq) {
		return demoService.add(demoAddReq);
	}
	
	@PutMapping("/eidt")
	@ApiOperation(value = "修改并记录数据变化操作日志示例")
	public ApiResp<String> eidt(@RequestBody @Valid DemoEditReq demoEditReq) {
		return demoService.eidt(demoEditReq);
	}
	
	@DeleteMapping("/del/{id}")
	@ApiOperation(value = "删除并记录数据删除操作日志示例")
	@ApiImplicitParam(name = "id",value = "ID",required = true)
	public ApiResp<String> del(@PathVariable("id") Long id) {
		return demoService.del(id);
	}
	

}
