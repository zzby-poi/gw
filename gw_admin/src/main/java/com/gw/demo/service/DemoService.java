package com.gw.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gw.base.resp.ApiResp;
import com.gw.base.resp.PageResp;
import com.gw.demo.entity.Demo;
import com.gw.demo.req.DemoAddReq;
import com.gw.demo.req.DemoEditReq;
import com.gw.demo.req.DemoPageReq;

/** 
* @author yangxy
* @version 创建时间：2023年10月24日 下午4:38:18 
*/
public interface DemoService extends IService<Demo>{
	/**
	 * 分页查询示例
	* @author yangxy
	* @version 创建时间：2023年10月24日 下午4:48:24 
	* @return
	 */
	public ApiResp<PageResp<Demo>> page(DemoPageReq demoPageReq);
	
	/**
	 * 新增并记录数据变化操作日志示例
	* @author yangxy
	* @version 创建时间：2023年10月24日 下午4:48:32
	 * @return 
	 */
	public ApiResp<String> add(DemoAddReq demoAddReq);
	
	/**
	 * 修改并记录数据变化操作日志示例
	* @author yangxy
	* @version 创建时间：2023年10月24日 下午4:48:40
	 * @return 
	 */
	public ApiResp<String> eidt(DemoEditReq demoEditReq);
	
	/**
	 * 删除并记录数据删除操作日志示例
	* @author yangxy
	* @version 创建时间：2023年10月24日 下午4:48:49 
	* @param id
	 * @return 
	 */
	public ApiResp<String> del(Long id);
	
	/**
	 * 向消息队列推送消息示例
	* @author yangxy
	* @version 创建时间：2023年10月24日 下午4:48:57
	 */
	public void sendAmqMsg();
}
