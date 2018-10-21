@file:Suppress("UNUSED")

package jp.nephy.penicillin.models

import jp.nephy.jsonkt.ImmutableJsonObject
import jp.nephy.jsonkt.delegation.*


data class UserSuggestion(override val json: ImmutableJsonObject): PenicillinModel {
    val name by string
    val size by int
    val slug by string
    val users by modelList<User>()
}
