package com.tc.web01.controller;

import java.util.HashMap;
import java.util.Map;

import com.tc.web01.controller.impl.AuthorizationCommand;
import com.tc.web01.controller.impl.DeleteUserCommand;
import com.tc.web01.controller.impl.GoToAuthorizationPageCommand;
import com.tc.web01.controller.impl.GoToHelloPageCommand;
import com.tc.web01.controller.impl.GoToLocTestCommand;
import com.tc.web01.controller.impl.GoToMainPageCommand;
import com.tc.web01.controller.impl.GoToRegistrationPageCommand;
import com.tc.web01.controller.impl.GoToUsersPageCommand;
import com.tc.web01.controller.impl.RegistrationCommand;
import com.tc.web01.controller.impl.RestartCommand;
import com.tc.web01.controller.impl.SwitchLocale;

public final class CommandProvider {
	private final Map<String, Command> commands = new HashMap<>();

	public CommandProvider() {
		commands.put("authorisation", new AuthorizationCommand());
		commands.put("switchLocale", new SwitchLocale());
		commands.put("registration", new RegistrationCommand());
		commands.put("restart", new RestartCommand());
		commands.put("delete_user", new DeleteUserCommand());
		commands.put("GO_TO_REGISTRATION_PAGE", new GoToRegistrationPageCommand());
		commands.put("GO_TO_AUTHORIZATION_PAGE", new GoToAuthorizationPageCommand());
		commands.put("GO_TO_HELLO_PAGE", new GoToHelloPageCommand());
		commands.put("GO_TO_MAIN_PAGE", new GoToMainPageCommand());
		commands.put("GO_TO_LOCTEST_PAGE", new GoToLocTestCommand());
		commands.put("GO_TO_USERS_PAGE", new GoToUsersPageCommand());
	}

	public final Command getCommand(String commandName) {
		Command command = commands.get(commandName);
		return command;
	}
}
