package hu.konczdam.btcexchange.restexchange.coinmarketresponse

import com.fasterxml.jackson.annotation.JsonProperty

data class Data(
    @JsonProperty("BTC")
    val BTC: BTC?
)
