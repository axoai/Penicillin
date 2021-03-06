@file:Suppress("UNUSED")

package jp.nephy.penicillin.models

import jp.nephy.jsonkt.JsonObject
import jp.nephy.jsonkt.delegation.*

data class UserProfileBanner(override val json: JsonObject): PenicillinModel {
    val resolution1080x360 by model<Banner?>(key = "1080x360")
    val resolution1500x500 by model<Banner?>(key = "1500x500")
    val resolution300x100 by model<Banner?>(key = "300x100")
    val resolution600x200 by model<Banner?>(key = "600x200")
    val ipad by model<Banner?>()
    val ipadRetina by model<Banner?>(key = "ipad_retina")
    val mobile by model<Banner?>()
    val mobileRetina by model<Banner?>(key = "mobile_retina")
    val web by model<Banner?>()
    val webRetina by model<Banner?>(key = "web_retina")
}
