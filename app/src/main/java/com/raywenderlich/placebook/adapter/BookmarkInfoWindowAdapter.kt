package com.raywenderlich.placebook.adapter

import android.app.Activity
import android.graphics.Bitmap
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker
import com.raywenderlich.placebook.R

class BookmarkInfoWindowAdapter(context: Activity) : GoogleMap.InfoWindowAdapter { // Takes parameter representing host activity

    private val contents: View

    init{
        contents = context.layoutInflater.inflate(R.layout.content_bookmark_info,null)
    }

    override fun getInfoWindow(marker: Marker): View? {
        //This function is required, but can return null if not replacing the entire info window
        return null
    }

    override fun getInfoContents(marker: Marker): View? {
        val titleView = contents.findViewById<TextView>(R.id.title)
        titleView.text = marker.title ?: ""
            //Applies snippet text to phone id in content_bookmark_info.xml
        val phoneView = contents.findViewById<TextView>(R.id.phone)
        phoneView.text = marker.snippet ?: ""
            //Applies retrieved image to photo id in content_bookmark_info.xml
        val imageView = contents.findViewById<ImageView>(R.id.photo)
        imageView.setImageBitmap(marker.tag as Bitmap?)

        return contents
    }
}