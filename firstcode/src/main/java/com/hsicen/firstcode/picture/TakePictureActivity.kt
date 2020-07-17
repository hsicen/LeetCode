package com.hsicen.firstcode.picture

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.media.ExifInterface
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.core.content.FileProvider
import com.hsicen.firstcode.R
import kotlinx.android.synthetic.main.activity_take_picture.*
import java.io.File

/**
 * 作者：hsicen  2020/7/16 8:32
 * 邮箱：codinghuang@163.com
 * 功能：
 * 描述：调用系统相机拍照
 */
class TakePictureActivity : AppCompatActivity() {
    private val takePicture = 110110
    private val choosePicture = 110111

    private lateinit var imageUri: Uri
    lateinit var outputImage: File

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_take_picture)

        btn_take.setOnClickListener {
            takePicture()
        }
    }

    private fun choosePicture() {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
        intent.addCategory(Intent.CATEGORY_OPENABLE)
        intent.type = "image/*" //指定只显示图片
        startActivityForResult(intent, choosePicture)
    }

    private fun takePicture() {
        //创建文件  使用缓存目录，可跳过权限检测
        outputImage = File(externalCacheDir, "output_image.jpg")
        if (outputImage.exists()) outputImage.delete()
        outputImage.createNewFile()

        //获取文件路径
        imageUri = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            //通过FileProvider来进行文件路径映射，不是真实路径，类似于ContentProvider
            FileProvider.getUriForFile(this, "com.hsicen.camera.test", outputImage)
        } else Uri.fromFile(outputImage) //真实文件路径

        //启动相机
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri)
        startActivityForResult(intent, takePicture)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            takePicture -> {
                if (Activity.RESULT_OK == resultCode) {
                    val bitmap =
                        BitmapFactory.decodeStream(contentResolver.openInputStream(imageUri))
                    iv_take.setImageBitmap(rotateIfNeed(bitmap))
                }
            }

            choosePicture -> {
                if (Activity.RESULT_OK == resultCode && data != null) {
                    data.data?.let {
                        val bitmap = getBitmapFromUri(it)
                        iv_take.setImageBitmap(bitmap)
                    }
                }
            }
        }
    }

    private fun getBitmapFromUri(uri: Uri) =
        contentResolver.openAssetFileDescriptor(uri, "r")?.use {
            BitmapFactory.decodeFileDescriptor(it.fileDescriptor)
        }

    /*** 是否需要旋转图片*/
    private fun rotateIfNeed(bitmap: Bitmap): Bitmap {
        val exif = ExifInterface(outputImage.path)
        val orientation =
            exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL)
        return when (orientation) {
            ExifInterface.ORIENTATION_ROTATE_90 -> rotateBitmap(bitmap, 90)
            ExifInterface.ORIENTATION_ROTATE_180 -> rotateBitmap(bitmap, 180)
            ExifInterface.ORIENTATION_ROTATE_270 -> rotateBitmap(bitmap, 270)
            else -> bitmap
        }
    }

    /*** 旋转Bitmap*/
    private fun rotateBitmap(bitmap: Bitmap, degree: Int): Bitmap {
        val matrix = Matrix()
        matrix.postRotate(degree.toFloat())
        val rotateBitmap =
            Bitmap.createBitmap(bitmap, 0, 0, bitmap.width, bitmap.height, matrix, true)
        bitmap.recycle()

        return rotateBitmap
    }
}