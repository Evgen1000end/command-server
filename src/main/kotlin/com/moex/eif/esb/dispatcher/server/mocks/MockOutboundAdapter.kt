package com.moex.eif.esb.dispatcher.server.mocks

import com.moex.eif.esb.dispatcher.server.command.CommandExecutor
import com.moex.eif.esb.dispatcher.server.io.OutboundAdapter
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

/**
 * @author evgeny.demkin@moex.com
 */

@Component
class MockOutboundAdapter : OutboundAdapter {

  private val logger = LoggerFactory.getLogger(MockOutboundAdapter::class.java)

  override fun send(raw: ByteArray) {
    logger.info(" Send result '{}'", raw)
  }
}
