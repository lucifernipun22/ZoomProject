package com.nhs.masaiconference.slider

import android.content.Context

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.nhs.masaiconference.R


class SlidePagerAdapter: PagerAdapter {


    var mContext: Context?=null
    var mList:List<slide>?=null

    constructor(context: Context, list:List<slide>)
    {
        mContext=context
        mList=list
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        var inflater:LayoutInflater= mContext!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        var slideLayout:View =inflater.inflate(R.layout.slide_item,null)

        var slideImage:ImageView =slideLayout.findViewById(R.id.slide_image)
        var slideText:TextView=slideLayout.findViewById(R.id.movie_title)
        slideImage.setImageResource(mList!!.get(position).image)
        slideText.setText(mList!!.get(position).title)
        container.addView(slideLayout)

        //return super.instantiateItem(container, position)
        return slideLayout

    }

    override fun isViewFromObject(p0: View, p1: Any): Boolean {
        return p0 == p1
    }

    override fun getCount(): Int {
    return mList!!.count()
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        //super.destroyItem(container, position, `object`)
        container.removeView(`object` as View)
    }
}