package com.sviatlana.web.model;

import com.sviatlana.web.command.ValidateSAX;
import com.sviatlana.web.inout.Login;
import com.sviatlana.web.inout.Logout;

public enum CommandEnum {
	LOGIN {
		{
			this.command = new Login();
		}
	},
	LOGOUT {
		{
			this.command = new Logout();
		}
	},
	VALIDATESAX {
		{
			this.command = new ValidateSAX();
		}
	},
	FILEUPLOAD2 {
		{
			this.command = new ValidateSAX();
		}
	};

	ActionCommand command;
		public ActionCommand getCurrentCommand() {
			System.out.println("CommandEnum, command=" + command);
		return command;
	}
}
