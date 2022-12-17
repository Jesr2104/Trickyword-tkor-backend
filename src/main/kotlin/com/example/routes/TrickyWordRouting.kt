package com.example.routes

import com.example.utilities.HttpClient
import com.example.utilities.getBookNumber
import io.ktor.client.call.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun Route.trickyWordRouting() = runBlocking {
    // function to get all the trickyWord from a specific book
    route("/trickyWords/{bookNumber?}") {
        get {
            val bookNumber =
                call.parameters["bookNumber"]?.getBookNumber()
                    ?: return@get call.respondText(
                        text = "",
                        status = HttpStatusCode.BadRequest
                    )

            launch{
                val request = HttpClient()
                println("------------------------------------------------------------------")
                println(request.getClient().body() as String)
                println("------------------------------------------------------------------")
            }

        }
    }
}