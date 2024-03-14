package com.nagma.myrecipeapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.appbar.AppBarLayout
import com.nagma.myrecipeapplication.databinding.FragmentHomeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

    private var _homeBinding: FragmentHomeBinding? = null
    private val homeBinding get() = _homeBinding!!

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home, container, false)
        _homeBinding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = _homeBinding!!.root
        val toolbar = view.findViewById<Toolbar>(R.id.toolbar);
//        toolbar.title = "My Recipe Application"
        (activity as AppCompatActivity).setSupportActionBar(toolbar)

//        val appBarLayout = view.findViewById<AppBarLayout>(R.id.appbar)
//        appBarLayout.addOnOffsetChangedListener(
//            AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
//                val scrollRange = appBarLayout.totalScrollRange
//                Log.i("CTB", "${scrollRange + verticalOffset}")
//                if (scrollRange + verticalOffset == 0) {
//                    toolbar.title = "Collapsed Title"
//                    Log.i("CTB", toolbar.title as String)
////                    (activity as AppCompatActivity).supportActionBar?.title = "Collapsed Title"
//                } else {
//                    toolbar.title = "Expanded Title"
//                    Log.i("CTB", toolbar.title as String)
//                }
//            },
//        )
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _homeBinding = null
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}