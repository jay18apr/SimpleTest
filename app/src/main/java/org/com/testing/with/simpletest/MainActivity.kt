
package org.com.testing.with.simpletest

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.com.testing.with.simpletest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: MainViewModel
    private var rvAdapter: RVCustomAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        rvAdapter = RVCustomAdapter()
        binding.mRecyclerView.adapter = rvAdapter

        //make reverseLayout true - If we want to reverse the recyclerview without reversing the list from fetch data
        binding.mRecyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        viewModel.apply {
            data.observe(this@MainActivity) {
                rvAdapter?.submitList(it)
                // If we want to reverse the recyclerview without reversing the list from fetch data
                //binding.mRecyclerView.smoothScrollToPosition(it.size-1)
            }
        }

        lifecycle.addObserver(viewModel)
    }
}