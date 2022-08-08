package br.com.przucato.businesscard.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.przucato.businesscard.data.BusinessCard
import br.com.przucato.businesscard.databinding.BusinessCardItemBinding

class BusinessCardAdapter: ListAdapter<BusinessCard, BusinessCardAdapter.ViewHolder>(DiffCallback()) {

    var listenerShare: (View) -> Unit = {}

    inner class ViewHolder(
        private val binding: BusinessCardItemBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: BusinessCard) {
            binding.textViewName.text = item.name
            binding.textViewPhone.text = item.phone
            binding.textViewEmail.text = item.email
            binding.textViewCompany.text = item.company
            binding.cardView.setBackgroundColor(Color.parseColor(item.backgroundColor))
            binding.cardView.setOnClickListener {
                listenerShare
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = BusinessCardItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class DiffCallback: DiffUtil.ItemCallback<BusinessCard>() {

    override fun areItemsTheSame(oldItem: BusinessCard, newItem: BusinessCard): Boolean = oldItem == newItem

    override fun areContentsTheSame(oldItem: BusinessCard, newItem: BusinessCard): Boolean = oldItem.id == newItem.id

}