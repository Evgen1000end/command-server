package com.moex.eif.esb.dispatcher.server.command

import com.moex.eif.esb.dispatcher.server.io.ComInboundAdapter
import com.moex.eif.esb.dispatcher.server.io.ComOutboundAdapter
import com.moex.eif.esb.dispatcher.server.io.InboundAdapter
import com.moex.eif.esb.dispatcher.server.io.OutboundAdapter
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

/**
 * @author evgeny.demkin@moex.com
 */

@Component
class CommandExecutor {

  private val logger = LoggerFactory.getLogger(CommandExecutor::class.java)

  @Autowired
  lateinit var inboundAdapter: InboundAdapter

  @Autowired
  lateinit var commandBuilder: CommandBuilder

  @Autowired
  lateinit var commandInvoker : CommandInvoker

  @Autowired
  lateinit var outboundAdapter: OutboundAdapter

  fun start() {
    logger.info("Start server lifecycle")
    while(true) {
      val rawCommand = inboundAdapter.take()
      logger.info("Got raw command")
      val command = commandBuilder.build(rawCommand)
      logger.info("Find command '{}' ", command.toString())
      val commandResult = commandInvoker.execute(command)
      logger.info("Result of command execute '{}'", commandResult.toString())
      val rawResult = commandBuilder.build(commandResult)
      logger.info("raw result '{}'", rawResult)
      outboundAdapter.send(rawResult)
    }
  }


  @PostConstruct
  fun init() {
    start()
  }

}
