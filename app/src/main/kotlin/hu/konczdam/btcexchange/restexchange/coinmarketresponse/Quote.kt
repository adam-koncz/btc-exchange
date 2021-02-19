package hu.konczdam.btcexchange.restexchange.coinmarketresponse

import com.fasterxml.jackson.annotation.JsonProperty

data class Quote(
    @JsonProperty("USD")
    val USD: USD?
)
