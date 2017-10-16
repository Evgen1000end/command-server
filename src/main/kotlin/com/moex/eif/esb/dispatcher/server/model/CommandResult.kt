package com.moex.eif.esb.dispatcher.server.model

/**
 * @author evgeny.demkin@moex.com
 */
class CommandResult(val status:Int, val description: String) {


  //TODO - структура должна быть обговорена отдельно - тут просто пример

  override fun toString(): String {
    return "Command Result $status $description"
  }
}
