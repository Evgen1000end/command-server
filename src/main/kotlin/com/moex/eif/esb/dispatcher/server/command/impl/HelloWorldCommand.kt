package com.moex.eif.esb.dispatcher.server.command.impl

import com.moex.eif.esb.dispatcher.server.command.Command
import com.moex.eif.esb.dispatcher.server.model.CommandResult

/**
 * @author evgeny.demkin@moex.com
 */
class HelloWorldCommand : Command {

  override fun execute(): CommandResult {
    return CommandResult(0, "Hello, world!")
  }

  override fun toString(): String {
    return "Command - HelloWorldCommand"
  }
}
