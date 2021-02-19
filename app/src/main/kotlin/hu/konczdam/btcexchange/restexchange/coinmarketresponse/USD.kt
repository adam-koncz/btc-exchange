package hu.konczdam.btcexchange.restexchange.coinmarketresponse

import com.fasterxml.jackson.annotation.JsonProperty

data class USD(
    @JsonProperty("last_updated")
    val lastUpdated: String?,
    @JsonProperty("market_cap")
    val marketCap: Double?,
    @JsonProperty("percent_change_1h")
    val percentChange1h: Double?,
    @JsonProperty("percent_change_24h")
    val percentChange24h: Double?,
    @JsonProperty("percent_change_30d")
    val percentChange30d: Double?,
    @JsonProperty("percent_change_7d")
    val percentChange7d: Double?,
    @JsonProperty("price")
    val price: Double?,
    @JsonProperty("volume_24h")
    val volume24h: Double?
)
