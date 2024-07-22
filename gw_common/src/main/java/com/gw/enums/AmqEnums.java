package com.gw.enums;

import lombok.Getter;

/** 
 * 消息队列枚举
* @author yangxy
* @version 创建时间：2023年10月24日 下午7:59:57 
*/
public enum AmqEnums {
	/**
	 * 操作日志队列
	 */
	OPERATE_LOG_AMQ("operate_log_queue","operate_log_routing","operate_log_exchange", 1),
	/**
	 * 示例普通队列
	 */
	DEMO_PT("demo_queue","demoRoute","demo_exchange",1),
	/**
	 * 示例死信队列
	 */
	DEMO_DEAL("demo_deal_queue","demoDealRoute","demo_deal_exchange",4);
	
	/**
	 * 队列名称
	 */
	public String queueName;
	
	/**
	 * 路由key
	 */
	public String routeKey;
	
	/**
	 * 交换机名称
	 */
	public String exchangeName;
	
	/**
	 * 队列类型（1 普通队列，2广播队列，3延迟队列,4死信队列）
	 */
	private int type;

	private AmqEnums(String queueName, String routeKey, String exchangeName, int type) {
		this.queueName = queueName;
		this.routeKey = routeKey;
		this.exchangeName = exchangeName;
		this.type = type;
	}

}
