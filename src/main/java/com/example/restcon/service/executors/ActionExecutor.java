package com.example.restcon.service.executors;

import com.example.restcon.service.models.CommandAction;

public abstract class ActionExecutor implements Executor {
	protected abstract boolean accept(CommandAction action);
}
