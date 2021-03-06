@file:Suppress("UNUSED")

package jp.nephy.penicillin.endpoints

enum class EndpointHost(val value: String) {
    Default("api.twitter.com"), Card("caps.twitter.com"), MediaUpload("upload.twitter.com"), Publish("publish.twitter.com"),

    UserStream("userstream.twitter.com"), SiteStream("sitestream.twitter.com"), Stream("stream.twitter.com")
}
