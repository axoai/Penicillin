@file:Suppress("UNUSED")

package jp.nephy.penicillin.models.special

import java.util.*

data class StatusID(val value: Long) {
    val date: Date
        get() = Date(epochTimeMs)
    val epochTimeMs: Long
        get() = (value shr 22) + 1288834974657
}
