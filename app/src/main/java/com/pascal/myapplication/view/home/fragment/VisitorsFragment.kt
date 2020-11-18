package com.pascal.myapplication.view.home.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.pascal.myapplication.R
import com.pascal.myapplication.adapter.AdapterVisitors
import com.pascal.myapplication.model.visitors.DataItem
import com.pascal.myapplication.model.visitors.ResponseAction
import com.pascal.myapplication.model.visitors.ResponseVisitors
import com.pascal.myapplication.viewModel.ViewModelHome
import kotlinx.android.synthetic.main.fragment_visitors.*


class VisitorsFragment : Fragment() {

    private lateinit var viewModel: ViewModelHome
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_visitors, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(ViewModelHome::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        initView()
        attachObserve()
        viewModel.getDataView()
    }

    private fun initView() {
        btn_visitorAdd.setOnClickListener {
            navController.navigate(R.id.action_visitorsFragment_to_inputActivity3)
        }

        recycler_visitors.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy < 0 && !btn_visitorAdd.isShown()) {
                    btn_visitorAdd.show()
                }
                else if (dy > 0 && btn_visitorAdd.isShown()) {
                    btn_visitorAdd.hide()
                }
            }

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
            }
        })
    }

    private fun attachObserve() {
        viewModel.responseData.observe(viewLifecycleOwner, Observer {showSiswaView(it)})
        viewModel.isError.observe(viewLifecycleOwner, Observer { showError(it) })
        viewModel.isLoading.observe(viewLifecycleOwner, Observer { showLoading(it) })
        viewModel.responseDelete.observe(viewLifecycleOwner, Observer { showDeleteSiswa(it) })
    }

    private fun showSiswaView(it: ResponseVisitors?) {
        val adapter = AdapterVisitors(it?.data, object : AdapterVisitors.OnClickListener {

            override fun detail(item: DataItem?) {
                val bundle = bundleOf("data" to item)
                navController.navigate(R.id.action_visitorsFragment2_to_detailActivity, bundle)
            }

            override fun update(item: DataItem?) {
                val bundle = bundleOf("data" to item)
                navController.navigate(R.id.action_visitorsFragment_to_inputActivity3, bundle)
            }

            override fun delete(item: DataItem?) {
                context?.let { it1 ->
                    AlertDialog.Builder(it1).apply {
                        setTitle(R.string.titleDelete)
                        setMessage(R.string.yakin)
                        setPositiveButton(R.string.yes) { dialogInterface, i ->

                            viewModel.deleteDataView(item?.id ?: "")
                            dialogInterface.dismiss()
                        }
                        setNegativeButton(R.string.cancel) { dialogInterface, i ->
                            dialogInterface.dismiss()
                        }
                    }.show()
                }
            }
        })
        recycler_visitors.adapter = adapter
    }

    private fun showDeleteSiswa(it: ResponseAction) {
        showToast("Delete Completed")
    }

    private fun showError(it: Throwable?) {
        showToast(it.toString())
    }

    private fun showLoading(it: Boolean?) {
        if (it == true) {
            progress_visitors.visibility = View.VISIBLE
        } else {
            progress_visitors.visibility = View.GONE
        }
    }

    private fun showToast(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        viewModel.getDataView()
    }
}