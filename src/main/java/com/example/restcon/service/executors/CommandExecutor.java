package com.example.restcon.service.executors;

import java.util.Optional;

import com.example.restcon.service.models.Command;
import com.example.restcon.service.models.CommandResult;
import com.example.restcon.service.models.CommandType;

public interface CommandExecutor {
	boolean accept(CommandType type);

	Optional<CommandResult> execute (Command command);
}
