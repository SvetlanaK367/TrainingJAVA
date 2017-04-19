package com.sviatlana.web.model;

import javax.servlet.http.HttpServletRequest;

public interface ActionCommand {
	String execute(HttpServletRequest request);
	}
