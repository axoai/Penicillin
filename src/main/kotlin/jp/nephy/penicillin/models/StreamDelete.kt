@file:Suppress("UNUSED")

package jp.nephy.penicillin.models

import jp.nephy.jsonkt.JsonObject
import jp.nephy.jsonkt.delegation.byJsonObject
import jp.nephy.jsonkt.delegation.byLong
import jp.nephy.jsonkt.delegation.byString
import jp.nephy.jsonkt.delegation.jsonObject

data class StreamDelete(override val json: JsonObject): PenicillinModel {
    private val delete by jsonObject
    private val status by delete.byJsonObject
    val timestampMs by delete.byString("timestamp_ms")
    val statusId by status.byLong("id")
    val statusIdStr by status.byString("id_str")
    val userId by status.byLong("user_id")
    val userIdStr by status.byString("user_id_str")
}
