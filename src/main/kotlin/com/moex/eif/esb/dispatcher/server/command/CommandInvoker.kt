package com.moex.eif.esb.dispatcher.server.command

import com.moex.eif.esb.dispatcher.server.model.CommandResult
import com.moex.eif.esb.dispatcher.server.repository.CommandHistoryService
import org.springframework.stereotype.Component

/**
 * @author evgeny.demkin@moex.com
 */

@Component
class CommandInvoker {

  lateinit var historyService : CommandHistoryService

  fun execute(command: Command) : CommandResult {
    historyService.add(command)
    return command.execute()
  }

}
