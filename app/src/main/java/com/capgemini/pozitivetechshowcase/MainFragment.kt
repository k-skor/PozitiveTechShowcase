package com.capgemini.pozitivetechshowcase

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.navigation.findNavController
import com.capgemini.pozitivetechshowcase.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

private const val ARG_PARAM1 = "fruit"

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class MainFragment : Fragment(), AdapterView.OnItemSelectedListener {

    private lateinit var binding: FragmentMainBinding

    private val fruits = arrayOf("Orange", "Apple", "Banana")
    private var fruit: String = ""

    @Inject
    lateinit var adapter: ArrayAdapter<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            fruit = it.getString(ARG_PARAM1) ?: ""
        }

        savedInstanceState?.let {
            fruit = it.getString(ARG_PARAM1) ?: ""
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(layoutInflater)
        fruits.forEach { adapter.add(it) }
        binding.spinner.adapter = adapter
        binding.spinner.onItemSelectedListener = this
        binding.action1.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_mainFragment_to_detailFragment)
        }
        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(ARG_PARAM1, fruit)
    }

    override fun onResume() {
        super.onResume()
        binding.spinner.setSelection(fruits.indexOf(fruit))
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        this.fruit = fruits[p2]
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        // do nothing
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param fruit Parameter fruit.
         * @return A new instance of fragment MainFragment.
         */
        @JvmStatic
        fun newInstance(fruit: String) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, fruit)
                }
            }
    }
}