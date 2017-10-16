package com.moex.eif.esb.dispatcher.server.io

/**
 * @author evgeny.demkin@moex.com
 */
interface InboundAdapter {

  fun take() : ByteArray

}
