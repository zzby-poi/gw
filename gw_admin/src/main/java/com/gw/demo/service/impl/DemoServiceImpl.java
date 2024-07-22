package com.gw.demo.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gw.base.resp.ApiResp;
import com.gw.base.resp.PageResp;
import com.gw.demo.entity.Demo;
import com.gw.demo.mapper.DemoMapper;
import com.gw.demo.req.DemoAddReq;
import com.gw.demo.req.DemoEditReq;
import com.gw.demo.req.DemoPageReq;
import com.gw.demo.service.DemoService;
import com.gw.exception.ApiBussException;

/** 
* @author yangxy
* @version 创建时间：2023年10月24日 下午4:49:57 
*/
@Service
public class DemoServiceImpl extends ServiceImpl<DemoMapper, Demo> implements DemoService {

	@Override
	@SuppressWarnings("unchecked")
	public ApiResp<PageResp<Demo>> page(DemoPageReq demoPageReq) {
		// TODO Auto-generated method stub
		LambdaQueryWrapper<Demo> lambdaQuery = new QueryWrapper<Demo>().lambda();
		
		if(!StringUtils.isEmpty(demoPageReq.getUserName())) {
			lambdaQuery.like(Demo::getUserName, demoPageReq.getUserName());
		}
		if(!ObjectUtils.isEmpty(demoPageReq.getType())) {
			lambdaQuery.eq(Demo::getType, demoPageReq.getType());
		}
		
		PageHelper.startPage(demoPageReq.getPageNo(), demoPageReq.getPageSize());
		Page<Demo> page = (Page<Demo>) list(lambdaQuery);
		return ApiResp.page(page);
	}

	@Override
	public ApiResp<String> add(DemoAddReq demoAddReq) {
		// TODO Auto-generated method stub
		Demo demo = new Demo();
		BeanUtils.copyProperties(demoAddReq, demo);
		save(demo);
		return ApiResp.sucess();
	}

	@Override
	public ApiResp<String> eidt(DemoEditReq demoEditReq) {
		// TODO Auto-generated method stub
		Demo demo = getById(demoEditReq.getId());
		if(ObjectUtils.isEmpty(demo)) {
			throw new ApiBussException("数据不存在");
		}
		BeanUtils.copyProperties(demoEditReq, demo);
		updateById(demo);
		return ApiResp.sucess();
	}

	@Override
	public ApiResp<String> del(Long id) {
		// TODO Auto-generated method stub
		removeById(id);
		return ApiResp.sucess();
	}

	@Override
	public void sendAmqMsg() {
		// TODO Auto-generated method stub
		
	}

}
