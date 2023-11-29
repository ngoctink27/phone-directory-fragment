package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFragment: Fragment() {
    lateinit var recyclerView: RecyclerView
    var listData: ArrayList<Contacts> = dataList()
    lateinit var myAdapter: ContactAdapter
    lateinit var addContact: ImageButton
    private lateinit var onClickItem: OnClickItem
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.content_main, container, false)

        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.onClickItem = activity as OnClickItem
        addContact = view.findViewById<ImageButton>(R.id.addContact)
        recyclerView = view.findViewById(R.id.recyclerView)
        //listData = dataList()
        myAdapter = ContactAdapter(listData, view.context)
        recyclerView.adapter = myAdapter
        recyclerView.layoutManager = LinearLayoutManager(
            view.context,
            LinearLayoutManager.VERTICAL,
            false
        )
        this.addContact.setOnClickListener{
            onClickItem.ButtonClicked()
        }
        this.myAdapter.setOnClickListener(
            object :
                ContactAdapter.OnClickListener {
                override fun onClick(position: Int, model: Contacts) {
                    onClickItem.ItemClicked(model)
                }
            }
        )
    }


    fun UpdateContent(item: Contacts) {
        this.listData.add(item)
        this.myAdapter.notifyItemInserted(listData.size -1 )
    }
    fun dataList() : ArrayList<Contacts>{
        var list: ArrayList<Contacts> = ArrayList<Contacts>()
        list.add(Contacts("The Ngoc", "0123456", "ntnk27@gmail.com", "091234678"))
        list.add(Contacts("Linh Linh", "9876543", "linh.nl@gmail.com", "098764321"))
        list.add(Contacts("Nhat Thien", "1122334", "thiennhat@gmail.com", "090909909"))
        list.add(Contacts("Tien Tung", "4455667", "tungnt@gmail.com", "087653210"))
        list.add(Contacts("Nam Duong", "7788990", "duongtn@gmail.com", "091234678"))
        list.add(Contacts("Quoc Khanh", "3344556", "khanhq@gmail.com", "092345789"))
        list.add(Contacts("Khanh Linh", "6677889", "khanhlinh@gmail.com", "091111111"))
        list.add(Contacts("Tuan Anh", "1122334", "anhtuann@gmail.com", "094444444"))
        list.add(Contacts("Duy", "5566778", "duydh@gmail.com", "096666666"))
        list.add(Contacts("Linh", "8899001", "linhhoang@gmail.com", "098888888"))
        return list
    }
}