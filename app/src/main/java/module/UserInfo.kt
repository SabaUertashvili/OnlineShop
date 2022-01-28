package module

import android.media.Image
import android.net.Uri

data class UserInfo(
    val username : String = "",
    val name : String = "",
    val surname : String = "",
    val age : String = "",
    val postcodes : String = "",
    val uid : String = "",
    val uri: Uri? = null


)
