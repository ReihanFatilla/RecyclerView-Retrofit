package com.reift.recyclerview_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.reift.recyclerview_retrofit.api.data.UserItem
import com.reift.recyclerview_retrofit.api.network.ApiConfig
import com.reift.recyclerview_retrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var mAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mAdapter = UserAdapter()
        getUserList()
    }

    fun setUpRecyclerView(){
        binding.rvUser.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = mAdapter
        }
    }

    fun getUserList(){
        ApiConfig.getApiService().getListUser().enqueue(
            object : Callback<List<UserItem>> {
                override fun onResponse(
                    call: Call<List<UserItem>>,
                    response: Response<List<UserItem>>
                ) {
                    response.body()?.let {
                        mAdapter.setData(it)
                        setUpRecyclerView()
                    }
                }

                override fun onFailure(call: Call<List<UserItem>>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "Failed to Fecth Data", Toast.LENGTH_SHORT).show()
                }

            }
        )
    }
}