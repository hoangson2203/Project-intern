package com.example.poemslesson1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.poemslesson1.databinding.FragmentStockScreenBinding

class stockScreen : Fragment() {
    private var _binding: FragmentStockScreenBinding? = null
    private var loserTodoList = arrayListOf<TopMarketModel>()
    private var gainersTodoList = arrayListOf<TopMarketModel>()
    private var topperformTodoList = arrayListOf<TopPerformModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        for (item in 0..5) {
            loserTodoList.add(TopMarketModel("Shanghai Turbo","SG: AWM", "0.6",-27.65))
        }
        for (item in 0..5) {
            gainersTodoList.add(TopMarketModel("Shanghai Turbo","SG: AWM", "0.6",27.65))
        }
        for (item in 0..2) {
            topperformTodoList.add(TopPerformModel("Property","+4.18%", "Ho Bee Land", "2.770  +1.09%"))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStockScreenBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding?.apply {
            rvTopLoser.adapter = TopMarketAdapter(loserTodoList)
            rvTopGainers.adapter = TopMarketAdapter(gainersTodoList)
            rvTopPerforming.adapter = TopPerformAdapter(topperformTodoList)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() = stockScreen()
    }
}