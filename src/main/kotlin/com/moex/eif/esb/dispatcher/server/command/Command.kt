package com.moex.eif.esb.dispatcher.server.command

import com.moex.eif.esb.dispatcher.server.model.CommandResult

/**
 * @author evgeny.demkin@moex.com
 */
interface Command {

  fun execute() : CommandResult



}
