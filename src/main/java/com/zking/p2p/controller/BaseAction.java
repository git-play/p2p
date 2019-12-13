package com.zking.p2p.controller;

import java.io.PrintWriter;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zking.p2p.util.PageBean;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.fasterxml.jackson.databind.ObjectMapper;


public abstract class BaseAction implements Serializable {

	private static final long serialVersionUID = -3293898039715580711L;

	protected static final Logger log = LogManager.getLogger(BaseAction.class);

	public BaseAction() {
		super();
	}

	public String writeJson(Object object) {
		try {
			// 1. Java对象=>json字符串
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(object);

			// 2. 向客户端输出json字符串
			HttpServletResponse response = ServletActionContext.getResponse();
			// 如果json打印时出现乱码，设置响应的字符集和内容类型即可
			response.setCharacterEncoding("utf-8"); // 设置编码格式即可
			response.setContentType("application/json;charset=utf-8"); // 设置内容类型
			PrintWriter out = response.getWriter();
			out.println(json);
			// try {
			// out.flush();
			// } finally {
			// out.close();
			// }
			return null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public PageBean createPageBean() {
		HttpServletRequest request = ServletActionContext.getRequest();
		PageBean pageBean = new PageBean();
		pageBean.setRequest(request);
		return pageBean;
	}
}
