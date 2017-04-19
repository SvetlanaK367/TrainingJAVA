package com.sviatlana.web.inout;

import javax.servlet.http.HttpServletRequest;

import com.sviatlana.web.model.ActionCommand;
import com.sviatlana.web.services.ConfigurationManager;
import com.sviatlana.web.services.MessageManager;

public class Logout implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		MessageManager.getProperty("message.logout");
		String page = ConfigurationManager.getProperty("path.page.logout");
		request.getSession().invalidate();
		return page;
	}

}
