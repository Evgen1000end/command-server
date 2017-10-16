package com.moex.eif.esb.dispatcher.server.repository

import com.moex.eif.esb.dispatcher.server.command.Command
import org.springframework.stereotype.Component
import java.util.ArrayList

/**
 * @author evgeny.demkin@moex.com
 */

@Component
class CommandHistoryService {

  private val history : ArrayList<Command> = ArrayList()

  fun add(command : Command) {
    history.add(command)
  }

}
