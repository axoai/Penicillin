@file:Suppress("UNUSED")

package jp.nephy.penicillin.models

import jp.nephy.jsonkt.JsonObject
import jp.nephy.jsonkt.delegation.*
import jp.nephy.jsonkt.string
import jp.nephy.penicillin.models.special.CreatedAt
import jp.nephy.penicillin.models.special.Language

data class User(val parentJson: JsonObject): CommonUser(parentJson)

abstract class CommonUser(final override val json: JsonObject): PenicillinModel {
    val advertiserAccountServiceLevels by stringList("advertiser_account_service_levels")
    val advertiserAccountType by nullableString("advertiser_account_type")
    val analyticsType by nullableString("analytics_type")
    val businessProfileState by nullableString("business_profile_state")
    val canMediaTag by nullableBoolean("can_media_tag")
    val contributorsEnabled by boolean("contributors_enabled")
    val createdAt by lambda("created_at") { CreatedAt(it.string) }
    val defaultProfile by boolean("default_profile")
    val defaultProfileImage by boolean("default_profile_image")
    val description by nullableString
    val entities by model<UserEntity?>()
    val fastFollowersCount by nullableInt("fast_followers_count")
    val favouritesCount by int("favourites_count")
    val followRequestSent by nullableBoolean("follow_request_sent")
    val followedBy by nullableBoolean("followed_by")
    val followersCount by int("followers_count")
    val following by nullableBoolean
    val friendsCount by int("friends_count")
    val geoEnabled by boolean("geo_enabled")
    val hasCustomTimelines by nullableBoolean("has_custom_timelines")
    val hasExtendedProfile by nullableBoolean("has_extended_profile")
    val id by long
    val idStr by string("id_str")
    val isTranslationEnabled by nullableBoolean("is_translation_enabled")
    val isTranslator by boolean("is_translator")
    val lang by lambda { Language(it.string) }
    val listedCount by int("listed_count")
    val location by nullableString
    val mediaCount by nullableInt("media_count")
    val name by string
    val needsPhoneVerification by nullableBoolean("needs_phone_verification")
    val normalFollowersCount by nullableInt("normal_followers_count")
    val notifications by nullableBoolean
    val pinnedTweetIds by longList("pinned_tweet_ids")
    val pinnedTweetIdsStr by stringList("pinned_tweet_ids_str")
    val profileBackgroundColor by string("profile_background_color")
    val profileBackgroundImageUrl by string("profile_background_image_url")
    val profileBackgroundImageUrlHttps by string("profile_background_image_url_https")
    val profileBackgroundTile by boolean("profile_background_tile")
    val profileBannerExtension by model<ProfileImageExtension?>(key = "profile_banner_extensions")
    val profileBannerUrl by string("profile_banner_url")
    val profileImageExtensions by model<ProfileImageExtension?>(key = "profile_image_extensions")
    val profileImageUrl by string("profile_image_url")
    val profileImageUrlHttps by string("profile_image_url_https")
    val profileInterstitialType by nullableString("profile_interstitial_type")
    val profileLinkColor by string("profile_link_color")
    val profileSidebarBorderColor by string("profile_sidebar_border_color")
    val profileSidebarFillColor by string("profile_sidebar_fill_color")
    val profileTextColor by string("profile_text_color")
    val profileUseBackgroundImage by boolean("profile_use_background_image")
    val protected by boolean
    val screenName by string("screen_name")
    val status by model<Status?>()
    val statusesCount by int("statuses_count")
    val suspended by nullableBoolean
    val timeZone by nullableString("time_zone")
    val translatorType by string("translator_type")
    val url by nullableString
    val utcOffset by nullableInt("utc_offset")
    val verified by boolean
    val withheldInCountries by stringList("withheld_in_countries")
    val withheldScope by nullableString("withheld_scope")
    val isLockedAccount by lazy { profileInterstitialType == "fake_account" }

    fun profileImageUrlWithVariantSize(size: ProfileImageSize) = profileImageUrl.run {
        if (size == ProfileImageSize.Original) this
        else dropLast(4) + "_" + when (size) {
            ProfileImageSize.Normal -> "normal"
            ProfileImageSize.Bigger -> "bigger"
            else -> "mini"
        } + ".png"
    }

    fun profileImageUrlHttpsWithVariantSize(size: ProfileImageSize): String = profileImageUrl.let { url ->
        if (size == ProfileImageSize.Original) url
        else url.dropLast(4) + "_" + size.suffix + ".png"
    }

    fun profileBannerUrlWithVariantSize(size: ProfileBannersSize): String = profileBannerUrl + "/" + size.suffix

    enum class ProfileImageSize(val suffix: String){
        Normal("normal"),
        Bigger("bigger"),
        Mini("mini"),
        Original("")
    }

    enum class ProfileBannersSize(val suffix: String){
        Normal("600x200"),
        Bigger("1500x500"),
        Mini("300x100"),
        Web("web"),
        WebRetina("web_retina"),
        IPad("ipad"),
        IPadRetina("ipad_retina"),
        Mobile("mobile"),
        MobileRetina("mobile_retina")
    }
}
