package org.com.testing.with.simpletest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import org.com.testing.with.simpletest.databinding.CardViewItemBinding

/**
 * TODO: Implement the Adapter that will populate a RecyclerView using the information generated in ViewModel
 * */

class RVCustomAdapter : ListAdapter<Article, RVCustomAdapter.ViewHolder>(Companion) {

    companion object : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            TODO("Not yet implemented")
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            TODO("Not yet implemented")
        }

    }

    inner class ViewHolder(private val binding: CardViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindView(article: Article) {
            binding.mTextViewTitle.text = article.title
            binding.mTextViewContent.text = article.content
            Picasso.get()
                .load(article.imageURL).into(binding.mImageViewCardViewItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            CardViewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(getItem(position))
    }
}