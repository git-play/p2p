package com.zking.p2p.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WriteJson {

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
	
	public static void write(Object obj, HttpServletResponse resp) {

		try {
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(obj);

			PrintWriter writer = resp.getWriter();
			writer.println(json);

		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

}
