package com.cv.app.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.cv.app.R
import com.cv.app.repository.AppListRepoImp
import com.cv.app.viewmodel.MyProfileExtraViewModel

class ProfileExtraFragment : Fragment() {
    internal lateinit var container_publishAppList: LinearLayout
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view =
            LayoutInflater.from(this.activity)
                .inflate(R.layout.fragment_profileextra, container, false)
        container_publishAppList = view.findViewById(R.id.container_applist)


        return view
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val model = MyProfileExtraViewModel(AppListRepoImp())
        model.getPublishedAppList()

        model.mutableLiveData.observe(this, Observer {
            container_publishAppList.removeAllViews()
            for (item in it) {
                val chileView: View =
                    LayoutInflater.from(activity).inflate(R.layout.row_applist, null, false)
                val txt_appname: TextView = chileView.findViewById(R.id.txt_appName)
                val txt_appLink: TextView = chileView.findViewById(R.id.txt_appLink)
                txt_appname.text = item.appName
                txt_appLink.text = item.appLink
                container_publishAppList.addView(chileView)
            }

        })

        model.errorLiveData.observe(this, Observer {

            Toast.makeText(activity, " Error Loading data", Toast.LENGTH_LONG).show()
        })




    }

}