package com.satc.aula06demopersistencia.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.satc.aula06demopersistencia.R

class UserAdapter(private val dataSet: ArrayList<User>) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {

        var tvName : TextView
        var tvEmail: TextView
        var btSave: Button

        init {
            tvName = view.findViewById(R.id.tv_name)
            tvEmail = view.findViewById(R.id.tv_email)
            btSave = view.findViewById(R.id.bt_delete)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.user_rv_item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        var user : User = dataSet.get(position)

        // Preencher as views com as infos do user
        viewHolder.tvName.setText(user.name)
        viewHolder.tvEmail.setText(user.email)
    }
}
