package com.sungho.product

import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpHeaders
import org.springframework.http.server.reactive.ServerHttpRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ServerWebExchange
import org.springframework.web.server.WebFilter
import org.springframework.web.server.WebFilterChain
import reactor.core.publisher.Mono


@RestController
@RequestMapping("")
class ProductController {
    @GetMapping
    suspend fun getProductList(): String {
        val a = RequestContextHolder.getRequest().awaitSingle()
        return a.id

    }
}


object RequestContextHolder {
    const val CONTEXT_KEY = "REQUEST_CONTEXT"
    fun getRequest(): Mono<ServerHttpRequest> =
        Mono.deferContextual { ctx -> Mono.just(ctx[CONTEXT_KEY]) }
}

@Configuration
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.REACTIVE)
class RequestContextInterceptor: WebFilter {
    override fun filter(exchange: ServerWebExchange, chain: WebFilterChain): Mono<Void> {
        val request = exchange.request
        return chain.filter(exchange)
            .contextWrite { ctx -> ctx.put(RequestContextHolder.CONTEXT_KEY, request) }
    }
}