package hu.konczdam.btcexchange.restexchange

import hu.konczdam.btcexchange.model.Currency
import hu.konczdam.btcexchange.restexchange.coinmarketresponse.CoinMarketResponse
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Service
import org.springframework.web.client.RestClientException
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder

@Service
class RestClient {
    @Autowired
    private lateinit var restTemplate: RestTemplate

    @Value("\${coinmarket-apikey}")
    private lateinit var apiKey: String

    companion object {
        private const val HEADER_NAME = "X-CMC_PRO_API_KEY"
        private const val URL = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/quotes/latest"
        private const val QUERY_PARAM = "symbol"
        private val logger = LoggerFactory.getLogger(RestClient::class.java)
    }

    fun getBitcoinExchangeRateFromServer(): Double? {
        logger.info("Retrieving BTC price from coinmarketcap.")
        val uriBuilder = UriComponentsBuilder
            .fromHttpUrl(URL)
            .queryParam(QUERY_PARAM, Currency.BTC.toString())
        val headers = HttpHeaders()
        headers.set(HEADER_NAME, apiKey)
        val httpEntity = HttpEntity<Any>(headers)

        val response: HttpEntity<CoinMarketResponse>? = try {
            restTemplate.exchange(
                uriBuilder.toUriString(),
                HttpMethod.GET,
                httpEntity,
                CoinMarketResponse::class.java

            )
        } catch (exception: RestClientException) {
            logger.warn("failed to get BTC price from coinmarket", exception)
            null
        }

        return response?.body?.data?.BTC?.quote?.USD?.price
        TODO("Some caching would be nice")
    }
}
