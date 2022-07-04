package zira.ai

import io.grpc.Channel
import io.grpc.ManagedChannel
import io.micronaut.context.annotation.Bean
import io.micronaut.context.annotation.Factory
import io.micronaut.grpc.annotation.GrpcChannel
import io.micronaut.grpc.server.GrpcServerChannel
import zira.ai.GreeterGrpc.GreeterBlockingStub


@Factory
internal class Clients {
    @Bean
    fun blockingStub(
        @GrpcChannel(GrpcServerChannel.NAME) channel: ManagedChannel
    ): GreeterGrpcKt.GreeterCoroutineStub {
        return GreeterGrpcKt.GreeterCoroutineStub(
            channel
        )
    }
}