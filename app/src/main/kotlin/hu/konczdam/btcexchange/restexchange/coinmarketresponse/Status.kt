package hu.konczdam.btcexchange.restexchange.coinmarketresponse

import com.fasterxml.jackson.annotation.JsonProperty

data class Status(
    @JsonProperty("credit_count")
    val creditCount: Int?,
    @JsonProperty("elapsed")
    val elapsed: Int?,
    @JsonProperty("error_code")
    val errorCode: Int?,
    @JsonProperty("error_message")
    val errorMessage: Any?,
    @JsonProperty("notice")
    val notice: Any?,
    @JsonProperty("timestamp")
    val timestamp: String?
)
