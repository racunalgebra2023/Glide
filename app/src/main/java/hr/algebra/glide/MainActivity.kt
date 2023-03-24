package hr.algebra.glide

import android.graphics.PointF
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import jp.wasabeef.glide.transformations.BlurTransformation
import jp.wasabeef.glide.transformations.gpu.ContrastFilterTransformation
import jp.wasabeef.glide.transformations.gpu.VignetteFilterTransformation
import hr.algebra.glide.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity( ) {

    private lateinit var binding : ActivityMainBinding

    private val photoProvider = PhotoProvider( )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate( layoutInflater )
        setContentView( binding.root )

        binding.bGenerate.setOnClickListener {
            val url = photoProvider.generateRandomPictureUrl()
            Glide.with(this )
                .load( url )
                .centerCrop( )
                .timeout(1000000000 )
                .placeholder( R.drawable.ic_image_place_holder )
                .error( R.drawable.ic_broken_image )
                .fallback( R.drawable.ic_no_image )
                .into( binding.imageView )
        }

        binding.bCircle.setOnClickListener {
            val url = photoProvider.generateRandomPictureUrl()
            Glide.with(this)
                .load(url)
                .placeholder( R.drawable.ic_image_place_holder )
                .error( R.drawable.ic_broken_image )
                .skipMemoryCache(true)
                .diskCacheStrategy( DiskCacheStrategy.NONE )
                .transform(CircleCrop())
                .into( binding.imageView )
        }

        binding.bTransform.setOnClickListener {
            val url = photoProvider.generateRandomPictureUrl()

            Glide.with(this)
                .load(url)
                .override(500, 500)
                .transform(
                    CenterCrop( ),
                    BlurTransformation(5),
                    ContrastFilterTransformation(2.0f),
                    VignetteFilterTransformation(
                        PointF(0.5f, 0.5f),
                        floatArrayOf(0f, 0f, 0f),
                        0f,
                        0.4f)
                )
                .diskCacheStrategy( DiskCacheStrategy.DATA )
                .placeholder( R.drawable.ic_image_place_holder )
                .into( binding.imageView )
        }
    }
}