package zira.ai

import jakarta.inject.Singleton


@Singleton //
@Suppress("unused")
class GreetingEndpoint : GreeterGrpcKt.GreeterCoroutineImplBase() { //
    override suspend fun sayHello(request: HelloRequest): HelloReply {
        val message = "message from stub: ${request.name}"
        return HelloReply.newBuilder().setMessage(message).build()
    }
}