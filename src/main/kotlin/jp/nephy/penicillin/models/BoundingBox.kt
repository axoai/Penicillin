@file:Suppress("UNUSED")

package jp.nephy.penicillin.models

import jp.nephy.jsonkt.JsonObject
import jp.nephy.jsonkt.delegation.jsonArray
import jp.nephy.jsonkt.delegation.string

data class BoundingBox(override val json: JsonObject): PenicillinModel {
    val type by string
    val coordinates by jsonArray
    // [
    //   [
    //     [-77.119759, 38.791645],
    //     [-76.909393, 38.791645],
    //     [-76.909393, 38.995548],
    //     [-77.119759, 38.995548]
    //   ]
    // ]
}
