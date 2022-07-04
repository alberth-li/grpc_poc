package zira.ai

import io.micronaut.http.HttpResponse
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/test")
class TestController(private val greeterStub: GreeterGrpcKt.GreeterCoroutineStub) {

    @Get()
    suspend fun test(): MutableHttpResponse<String> {
        val request = HelloRequest.newBuilder().setName("Test Message").build()
        val resp = greeterStub.sayHello(request)
        return HttpResponse.ok(resp.message)
    }
}