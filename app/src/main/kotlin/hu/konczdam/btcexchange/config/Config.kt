package hu.konczdam.btcexchange.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.BufferingClientHttpRequestFactory
import org.springframework.http.client.ClientHttpRequestFactory
import org.springframework.http.client.SimpleClientHttpRequestFactory
import org.springframework.web.client.RestTemplate

@Configuration
class Config {

    @Bean
    fun restTemplate(): RestTemplate {
        val factory: ClientHttpRequestFactory = BufferingClientHttpRequestFactory(SimpleClientHttpRequestFactory())
        return RestTemplate(factory)
    }
}
