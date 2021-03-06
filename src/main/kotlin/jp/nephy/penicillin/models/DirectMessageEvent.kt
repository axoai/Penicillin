@file:Suppress("UNUSED")

package jp.nephy.penicillin.models

import jp.nephy.jsonkt.JsonObject
import jp.nephy.jsonkt.delegation.*

data class DirectMessageEventList(override val json: JsonObject): PenicillinModel {
    val apps by model<App>()
    val events by modelList<Event>()
    val nextCursor by nullableString("next_cursor")

    data class App(override val json: JsonObject): PenicillinModel {
        val id by lazy { json.keys.first() }
        val name by json[id].jsonObject.byString
        val url by json[id].jsonObject.byString
    }

    data class Event(override val json: JsonObject): PenicillinModel {
        val createdTimestamp by string("created_timestamp")
        val id by string
        val messageCreate by model<MessageCreate>(key = "message_create")
        val type by string

        data class MessageCreate(override val json: JsonObject): PenicillinModel {
            val messageData by model<MessageData>(key = "message_data")
            val senderId by string("sender_id")
            val sourceAppId by nullableString("source_app_id")
            val target by model<Target>()

            data class MessageData(override val json: JsonObject): PenicillinModel {
                val entities by model<Entities>()
                val text by string

                data class Entities(override val json: JsonObject): PenicillinModel {
                    val hashtags by modelList<Hashtag>()
                    val symbols by jsonArray
                    val urls by modelList<Url>()
                    val userMentions by jsonArray("user_mentions")

                    data class Hashtag(override val json: JsonObject): PenicillinModel {
                        val indices by intList
                        val text by string
                    }

                    data class Url(override val json: JsonObject): PenicillinModel {
                        val displayUrl by string("display_url")
                        val expandedUrl by string("expanded_url")
                        val indices by intList
                        val url by string
                    }
                }
            }

            data class Target(override val json: JsonObject): PenicillinModel {
                val recipientId by string("recipient_id")
            }
        }
    }
}

data class DirectMessageEventShow(override val json: JsonObject): PenicillinModel {
    val event by model<DirectMessageEventList.Event>()
}
