package com.example.aircraft

import com.example.aircraft.jpa.AircraftJpaRepository
import org.springframework.stereotype.Component
import org.springframework.web.socket.CloseStatus
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.handler.TextWebSocketHandler
import java.time.Instant

@Component
class WebSocketHandler(
    val sessionList: MutableList<WebSocketSession>,
    val repository: AircraftJpaRepository): TextWebSocketHandler() {

    override fun afterConnectionEstablished(session: WebSocketSession) {
        sessionList.add(session)
        println("Connection established from $session @ ${Instant.now()}")
    }


    override fun handleTextMessage(session: WebSocketSession, message: TextMessage) {
        println("Message received: $message, from $session")
        sessionList.forEach {
            if (it != session) {
                it.sendMessage(message)
                println("--> Sending message $message to $it")
            }
        }
    }

    override fun afterConnectionClosed(session: WebSocketSession, status: CloseStatus) {
        sessionList.remove(session)
        println("Connection closed by $session @ ${Instant.now()}")
    }
}