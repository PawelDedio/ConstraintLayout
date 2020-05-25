package com.dedio.constraintlayout

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

const val LINEAR_VIEWS = false

class WallAdapter : RecyclerView.Adapter<WallViewHolder>() {

    var items: List<WallItem>? = null


    override fun getItemViewType(position: Int): Int {
        return position % 3 + 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WallViewHolder {
        return when(viewType) {
            TYPE_MULTIPLE_PHOTO -> WallViewHolder(createMultiplePhotoItemView(parent))
            TYPE_PHOTO -> WallViewHolder(createPhotoItemView(parent))
            TYPE_EVENT -> WallViewHolder(createEventItemView(parent))
            else -> throw IllegalStateException("wrong view type")
        }
    }

    override fun getItemCount() = items!!.size

    override fun onBindViewHolder(viewHolder: WallViewHolder, position: Int) = Unit

    private fun createMultiplePhotoItemView(parent: ViewGroup): View {
        val resId = if(LINEAR_VIEWS) {
            R.layout.cell_linear_multiple_photos
        } else {
            R.layout.cell_constraint_multiple_photos
        }

        return inflateLayout(parent, resId)
    }

    private fun createPhotoItemView(parent: ViewGroup): View {
        val resId = if(LINEAR_VIEWS) {
            R.layout.cell_linear_photo
        } else {
            R.layout.cell_constraint_photo
        }

        return inflateLayout(parent, resId)
    }

    private fun createEventItemView(parent: ViewGroup): View {
        val resId = if(LINEAR_VIEWS) {
            R.layout.cell_linear_event
        } else {
            R.layout.cell_constraint_event
        }

        return inflateLayout(parent, resId)
    }

    private fun inflateLayout(parent: ViewGroup, resId: Int): View {
        return LayoutInflater.from(parent.context).inflate(resId, parent, false)
    }
}