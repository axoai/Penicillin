@file:Suppress("UNUSED")

package jp.nephy.penicillin.models

import jp.nephy.jsonkt.JsonObject
import jp.nephy.jsonkt.delegation.*

data class CoverMedia(val parentJson: JsonObject): CommonCoverMedia(parentJson)

abstract class CommonCoverMedia(final override val json: JsonObject): PenicillinModel {
    val tweetId by string("tweet_id")
    val type by string
    private val media by jsonObject
    val mediaId by media.byString("media_id")
    val mediaUrl by media.byString("url")
    private val size by media.byJsonObject
    val mediaWidth by size.byInt("w")
    val mediaHeight by size.byInt("h")
    private val render by jsonObject
    private val crops by render.byJsonObject
    val renderCropSquare by crops.byModel<FaceCoordinate>(key = "square")
    val renderCropPortrait9to16 by crops.byModel<FaceCoordinate>(key = "portrait_9_16")
    val renderCropPortrait3to4 by crops.byModel<FaceCoordinate>(key = "portrait_3_4")
    val renderCropPortrait16to9 by crops.byModel<FaceCoordinate>(key = "portrait_16_9")
}
