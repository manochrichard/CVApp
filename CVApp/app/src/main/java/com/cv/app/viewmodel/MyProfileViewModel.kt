package com.cv.app.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.cv.app.model.User
import com.cv.app.repository.NetworkRequest

class MyProfileViewModel : ViewModel {

    constructor() : super()

    var mutableLiveData = MutableLiveData<ArrayList<User>>()
    var arrayList = ArrayList<User>()

    fun getProfileData(): MutableLiveData<ArrayList<User>> {
        fetchServerData()
        return mutableLiveData;
    }

    fun fetchServerData() {
        val jsonObjectRequest =
            JsonObjectRequest(Request.Method.GET, BASE_URL, null, Response.Listener { response ->
                if (response != null) {
                    val user = User(
                        response.optString("ename"),
                        response.optString("emobno"),
                        response.optString("email"),
                        response.optString("location"),
                        response.optString("ctitle"),
                        response.optString("profile_summary"),
                        response.optString("profile_skills"),
                        response.optString("cname"),
                        response.optString("cduration"),
                        response.optString("cresponsibilities"),
                        response.optString("cachievements"),
                        response.optString("clogo")
                    )
                    arrayList.add(user)
                    mutableLiveData.value = arrayList
                }
            }, Response.ErrorListener {
                val e = it.toString()

            })
        NetworkRequest.instance?.addToRequestQueue(jsonObjectRequest, REQUEST_TAG)

    }


    companion object {
        val BASE_URL =
            "https://gist.githubusercontent.com/manochrichard/7d288f5beec0893a6ed51175fc3b1df4/raw/c1e60c2941aa3135b7884a4bfc182dc9e5002397/cv.json"
        val REQUEST_TAG = "CVProfileData"
    }


}