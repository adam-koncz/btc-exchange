package hu.konczdam.btcexchange.restexchange.coinmarketresponse

import com.fasterxml.jackson.annotation.JsonProperty

data class BTC(
    @JsonProperty("circulating_supply")
    val circulatingSupply: Int?,
    @JsonProperty("cmc_rank")
    val cmcRank: Int?,
    @JsonProperty("date_added")
    val dateAdded: String?,
    @JsonProperty("id")
    val id: Int?,
    @JsonProperty("is_active")
    val isActive: Int?,
    @JsonProperty("is_fiat")
    val isFiat: Int?,
    @JsonProperty("last_updated")
    val lastUpdated: String?,
    @JsonProperty("max_supply")
    val maxSupply: Int?,
    @JsonProperty("name")
    val name: String?,
    @JsonProperty("num_market_pairs")
    val numMarketPairs: Int?,
    @JsonProperty("platform")
    val platform: Any?,
    @JsonProperty("quote")
    val quote: Quote?,
    @JsonProperty("slug")
    val slug: String?,
    @JsonProperty("symbol")
    val symbol: String?,
    @JsonProperty("tags")
    val tags: List<String>?,
    @JsonProperty("total_supply")
    val totalSupply: Int?
)
