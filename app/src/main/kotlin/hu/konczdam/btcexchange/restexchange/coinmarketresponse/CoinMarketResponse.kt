package hu.konczdam.btcexchange.restexchange.coinmarketresponse

import com.fasterxml.jackson.annotation.JsonProperty

data class CoinMarketResponse(
    @JsonProperty("data")
    val `data`: Data?,
    @JsonProperty("status")
    val status: Status?
)
