package zira.ai

import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@MicronautTest
internal class GreetingEndpointTest {
    @Inject
    lateinit var stub: GreeterGrpcKt.GreeterCoroutineStub

    @Test
    suspend fun sayHello() {
        val request = HelloRequest.newBuilder().setName("Test Message").build()
        val resp = stub.sayHello(request)
        Assertions.assertEquals("message from stub: ${request.name}", resp)
    }
}