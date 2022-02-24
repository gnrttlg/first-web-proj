package com.tc.web01.controller;

import java.util.HashMap;
import java.util.Map;

import com.tc.web01.controller.impl.AddToCartCommand;
import com.tc.web01.controller.impl.AuthorizationCommand;
import com.tc.web01.controller.impl.BuyCommand;
import com.tc.web01.controller.impl.DeleteGoodCommand;
import com.tc.web01.controller.impl.DeleteUserCommand;
import com.tc.web01.controller.impl.GoToAuthorizationPageCommand;
import com.tc.web01.controller.impl.GoToCartPageCommand;
import com.tc.web01.controller.impl.GoToHelloPageCommand;
import com.tc.web01.controller.impl.GoToMainPageCommand;
import com.tc.web01.controller.impl.GoToRegistrationPageCommand;
import com.tc.web01.controller.impl.GoToStoragesPageCommand;
import com.tc.web01.controller.impl.GoToUsersPageCommand;
import com.tc.web01.controller.impl.RegistrationCommand;
import com.tc.web01.controller.impl.RemoveFromCartCommand;
import com.tc.web01.controller.impl.RestartCommand;
import com.tc.web01.controller.impl.SwitchLocale;

public final class CommandProvider {
	private final Map<String, Command> commands = new HashMap<>();

	public CommandProvider() {
		commands.put("authorisation", new AuthorizationCommand());
		commands.put("add_to_cart", new AddToCartCommand());
		commands.put("buy", new BuyCommand());
		commands.put("switchLocale", new SwitchLocale());
		commands.put("registration", new RegistrationCommand());
		commands.put("restart", new RestartCommand());
		commands.put("remove_from_cart", new RemoveFromCartCommand());
		commands.put("delete_user", new DeleteUserCommand());
		commands.put("delete_good", new DeleteGoodCommand());

		commands.put("GO_TO_CART_PAGE", new GoToCartPageCommand());
		commands.put("GO_TO_REGISTRATION_PAGE", new GoToRegistrationPageCommand());
		commands.put("GO_TO_AUTHORIZATION_PAGE", new GoToAuthorizationPageCommand());
		commands.put("GO_TO_HELLO_PAGE", new GoToHelloPageCommand());
		commands.put("GO_TO_MAIN_PAGE", new GoToMainPageCommand());
		commands.put("GO_TO_STORAGES_PAGE", new GoToStoragesPageCommand());
		commands.put("GO_TO_USERS_PAGE", new GoToUsersPageCommand());
	}

	public final Command getCommand(String commandName) {
		Command command = commands.get(commandName);
		return command;
	}
}
