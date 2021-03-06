@file:Suppress("UNUSED")

package jp.nephy.penicillin.models

import jp.nephy.jsonkt.JsonObject
import jp.nephy.jsonkt.delegation.*

data class UserStreamWarning(override val json: JsonObject): PenicillinModel {
    private val warning by jsonObject
    val code by warning.byInt
    val message by warning.byString
    val percentFull by warning.byNullableInt("percent_full")
    val userId by warning.byNullableLong
}
