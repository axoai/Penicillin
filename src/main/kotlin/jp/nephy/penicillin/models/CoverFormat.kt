@file:Suppress("UNUSED")

package jp.nephy.penicillin.models

import jp.nephy.jsonkt.JsonObject
import jp.nephy.jsonkt.delegation.boolean
import jp.nephy.jsonkt.delegation.byString
import jp.nephy.jsonkt.delegation.jsonObject
import jp.nephy.jsonkt.delegation.string

data class CoverFormat(val parentJson: JsonObject): CommonCoverMedia(parentJson) {
    val pageId by string("page_id")
    val isPromoted by boolean("is_promoted")
    private val linkTitleCard by jsonObject("link_title_card")
    val linkUrl by linkTitleCard.byString("url")
    val linkDisplayUrl by linkTitleCard.byString("display_url")
    val linkVanitySource by linkTitleCard.byString("vanity_source")
    val linkTitle by linkTitleCard.byString("title")
}
