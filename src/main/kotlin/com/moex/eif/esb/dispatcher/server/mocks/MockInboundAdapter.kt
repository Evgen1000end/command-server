package com.moex.eif.esb.dispatcher.server.mocks

import com.moex.eif.esb.dispatcher.server.command.CommandExecutor
import com.moex.eif.esb.dispatcher.server.io.InboundAdapter
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Async
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.BlockingQueue

/**
 * @author evgeny.demkin@moex.com
 */

@Component
class MockInboundAdapter : InboundAdapter {


  private val logger = LoggerFactory.getLogger(MockInboundAdapter::class.java)


  private val capacity = 1000

  private val queue: BlockingQueue<ByteArray> = ArrayBlockingQueue(capacity)

  override fun take(): ByteArray {
    return queue.take()
  }

  //В реальности в queue будет записываться результат чтения события из com порта
  @Scheduled(fixedRate = 5000)
 // @Async
  open fun generateInput() {
    val byteArray = ByteArray(2)
    byteArray[0] = 0b11
    byteArray[1] = 0b01
    logger.info("Command bytes received in inbound adapter")
    queue.put(byteArray)
  }

}
