package com.example.dinvercalculos

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView


class CListAdapter(private val getContext: Context, private val customListItem : ArrayList<CList>):
    ArrayAdapter<CList>(getContext,0 , customListItem)
{
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var listLayout = convertView

        val holder : ViewHolder


        if(listLayout == null)
        {
            val inflateList = (getContext as Activity).layoutInflater

            listLayout = inflateList!!.inflate(R.layout.custom_list,parent,false)

            holder = ViewHolder()

            holder.mTextViewOne = listLayout!!.findViewById(R.id.text1)

            holder.mTextViewTwo = listLayout!!.findViewById(R.id.text2)

            holder.mImageListView = listLayout!!.findViewById(R.id.imageView7)

            listLayout.setTag(holder)
        }
        else
        {
            holder = listLayout.getTag() as ViewHolder
        }

        val listItem = customListItem[position]

        holder.mTextViewOne!!.setText(listItem.mCListTextOne)

        holder.mTextViewTwo!!.setText(listItem.mCListTextTwo)

        holder.mImageListView!!.setImageResource(listItem.mCListImage)

        return listLayout
    }

    class ViewHolder
    {
        internal var mTextViewOne : TextView? = null
        internal var mTextViewTwo : TextView? = null
        internal var mImageListView : ImageView? = null

    }
}