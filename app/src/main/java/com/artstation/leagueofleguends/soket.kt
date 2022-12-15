package com.artstation.leagueofleguends

import io.socket.client.IO
import io.socket.client.On.on
import io.socket.client.Socket
import java.net.URISyntaxException

object SocketHandler {

    lateinit var mSocket: Socket

    @Synchronized
    fun setSocket() {
        try {
            mSocket = IO.socket("http://192.168.0.9:3000")
            mSocket.on("connection") {
                println(it)
            }
        } catch (e: URISyntaxException) {
            println(e)
        }
    }

    @Synchronized
    fun getSocket(): Socket {
        return mSocket
    }

    @Synchronized
    fun establishConnection() {
        mSocket.on("///"){
            println("prueba")
        }
        mSocket.connect()
        println(mSocket)
    }

    @Synchronized
    fun closeConnection() {
        mSocket.disconnect()
    }
}