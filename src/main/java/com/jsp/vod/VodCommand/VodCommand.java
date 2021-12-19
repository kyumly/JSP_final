package com.jsp.vod.VodCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface VodCommand {
	void execute(HttpServletRequest request, HttpServletResponse response);
}
