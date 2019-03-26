package com.smilehacker.image.resize

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream

/**
 * Created by quan.zhou on 2019/3/26.
 */
class Resizer {

    fun resizeImag(filePath: String, distPath: String) {
        val options = BitmapFactory.Options()
        options.inJustDecodeBounds = false
        options.inSampleSize = 4
        val bitmap = BitmapFactory.decodeFile(filePath, options)
        val distFile = File(distPath)

        val bos = ByteArrayOutputStream()
        var quality = 100
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos)

        val outputStream = FileOutputStream(distFile)
        bos.writeTo(outputStream)

        try {
            outputStream.close()
            bos.close()
        } catch (e: java.lang.Exception) {
            Log.e("", "", e)
        }

        bitmap.recycle()
    }
}