package zira.ai

import jakarta.inject.Singleton


@Singleton //
@Suppress("unused")
class GreetingEndpoint(val greetingService : Grpc_pocServiceGrpc) : GreeterGrpcKt.GreeterCoroutineImplBase() { //
    override suspend fun sayHello(request: HelloRequest): HelloReply {
        //
        val message = greetingService.sayHello(request.name)
        val reply = HelloReply.newBuilder().setMessage(message).build()
        return reply
    }
}