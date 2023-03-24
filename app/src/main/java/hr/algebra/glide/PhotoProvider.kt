package hr.algebra.glide

import android.util.Log
import java.util.Random

class PhotoProvider {

    val TAG = "PhotoProvider"

    val photos: List< String? > = listOf(
        // Load null url
        null,

        // Load error url
        "https://non-existing-url",

        // Load normal url
        "https://github.com/bumptech/glide/blob/master/static/glide_logo.png?raw=true",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRJKVAJLmjkg-O5M1lmJgzjpz-us7WbIpFEgWrSmKjXElh2_W9V",
        "https://cdn.gobankingrates.com/wp-content/uploads/2019/01/Maldives-beach-resort-panoramic-landscape-shutterstock_1051887026-848x477.jpg",
        "https://themysteriousworld.com/wp-content/uploads/2015/08/maldives.jpg",
        "https://loveincorporated.blob.core.windows.net/contentimages/gallery/95e0431c-b232-4481-a5ac-f6d09fd31c57-Manali-structuresxx.jpg"
    )

    fun generateRandomPictureUrl( ): String? {
        val x = Random( ).nextInt( 7 )
        Log.i( TAG, "Getting ${x+1}. picture from list: ${ photos[x] }" )
        return photos[x]
    }
}