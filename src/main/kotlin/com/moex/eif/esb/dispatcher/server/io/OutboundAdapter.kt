package com.moex.eif.esb.dispatcher.server.io

/**
 * @author evgeny.demkin@moex.com
 */
interface OutboundAdapter {

  fun send(raw: ByteArray)

}
