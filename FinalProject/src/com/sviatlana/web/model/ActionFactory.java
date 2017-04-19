package com.sviatlana.web.model;

import javax.servlet.http.HttpServletRequest;

import com.sviatlana.web.command.EmptyCommand;
import com.sviatlana.web.services.MessageManager;

public class ActionFactory {
	
	public ActionCommand defineCommand(HttpServletRequest request) {
		ActionCommand current = new EmptyCommand();

		String action = request.getParameter("command");
		System.out.println("action=" + action);
		if (action == null || action.isEmpty()) {
			return current;
		}

		try {
			CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
			System.out.println("currentEnum=" + currentEnum);
			current = currentEnum.getCurrentCommand();
		} catch (IllegalArgumentException e) {
			request.setAttribute("wrongAction", action + MessageManager.getProperty("message.wrongaction"));
		}
		return current;
	}
}
