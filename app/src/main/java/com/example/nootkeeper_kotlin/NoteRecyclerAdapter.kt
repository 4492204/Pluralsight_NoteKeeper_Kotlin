package com.example.nootkeeper_kotlin

import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.app.ActivityOptionsCompat
import androidx.transition.Scene

class NoteRecyclerAdapter(private val context: Context, private val notes: List<NoteInfo>) :
    androidx.recyclerview.widget.RecyclerView.Adapter<NoteRecyclerAdapter.ViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.item_note_list, p0, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val note = notes[p1]
        p0.textCourse?.text = note.course?.title
        p0.textTitle?.text = note.title
        p0.notePosition = p1
    }

    inner class ViewHolder(itemView: View?) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView!!) {
        val textCourse = itemView?.findViewById<TextView?>(R.id.textCourse)
        val textTitle = itemView?.findViewById<TextView?>(R.id.textTitle)

        var notePosition = 0
        init{
            itemView?.setOnClickListener{
                val intent = Intent(context, NoteActivity::class.java)
                intent.putExtra(NOTE_POSITION, notePosition)
                context.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(context as Activity).toBundle())
            }
        }
    }

}