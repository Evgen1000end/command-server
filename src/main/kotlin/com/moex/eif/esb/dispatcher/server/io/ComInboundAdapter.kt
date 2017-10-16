package com.moex.eif.esb.dispatcher.server.io

import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.BlockingQueue

/**
 * @author evgeny.demkin@moex.com
 */
class ComInboundAdapter : InboundAdapter {

  private val capacity = 1000

  private val queue: BlockingQueue<ByteArray> = ArrayBlockingQueue(capacity)

  override fun take(): ByteArray {
    return queue.take()
  }

}
