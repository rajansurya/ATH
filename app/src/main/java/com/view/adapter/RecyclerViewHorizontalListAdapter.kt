package com.view.adapter

import android.content.Context
import android.widget.TextView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import fieldx.mobile.com.atiyaherb.R

import kotlinx.android.synthetic.main.count_view.*
import kotlinx.android.synthetic.main.count_view.view.*
import android.view.LayoutInflater


/**
 * Created by Rajan on 01-03-2019.
 */
class RecyclerViewHorizontalListAdapter : RecyclerView.Adapter<RecyclerViewHorizontalListAdapter.ViewHolder> {
    lateinit var arrayl: ArrayList<String>
    lateinit var context: Context

    constructor(contextl: Context) {
        context = contextl
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val listItem = layoutInflater.inflate(R.layout.count_view, p0, false)
        val viewHolder = ViewHolder(listItem)
        return viewHolder
    }

    override fun getItemCount(): Int {
        return arrayl.size
    }

    fun update(array: ArrayList<String>) {
        arrayl = array
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.itemView.count.text = arrayl.get(p1)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        init {
            itemView.count.text = ""
        }
    }
}