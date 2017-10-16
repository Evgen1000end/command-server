package com.moex.eif.esb.dispatcher.server.command

import com.moex.eif.esb.dispatcher.server.command.impl.HelloWorldCommand
import com.moex.eif.esb.dispatcher.server.model.CommandResult
import org.springframework.stereotype.Component

/**
 * @author evgeny.demkin@moex.com
 */

@Component
class CommandBuilder {

  fun build(raw: ByteArray) : Command {
    //Пока тупо возвращаю всегда одну команду - тут надо разбирать байты и искать команду
    return HelloWorldCommand()
  }

  fun build(result: CommandResult) : ByteArray {
    //пока тупо возвращаю какие-то байты
    val byteArray = ByteArray(2)
    byteArray[0] = 0b00
    byteArray[1] = 0b10
    return byteArray
  }

}
