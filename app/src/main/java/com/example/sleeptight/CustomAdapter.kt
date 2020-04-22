package com.example.sleeptight

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class CustomAdapter constructor(var context: Context, var mangtime : ArrayList<Time>) : BaseAdapter(){
    class ViewHolder(row: View){
        var textviewtimingchoose : TextView
        var textviewtimingsleep : TextView

        init {
            textviewtimingchoose = row.findViewById(R.id.lstimechoose)
            textviewtimingsleep = row.findViewById(R.id.lstimesleep)
        }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view : View?
        var viewHolder : ViewHolder
        if (convertView == null){
            var layoutInflater : LayoutInflater = LayoutInflater.from(context)
            view = layoutInflater.inflate(R.layout.dong_listview_sleep,null)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = convertView.tag as ViewHolder
        }
        var time : Time = getItem(position) as Time
        viewHolder.textviewtimingchoose.text = time.timingchoose
        viewHolder.textviewtimingsleep.text = time.timingsleep
        return view as View
    }

    override fun getItem(position: Int): Any {
        return mangtime.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return mangtime.size
    }

}