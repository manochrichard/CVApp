package com.cv.app.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.cv.app.model.User
import com.cv.app.repository.NetworkRequest

import org.json.JSONObject

class MyProfileViewModel() : ViewModel() {
    var mutableLiveData = MutableLiveData<List<User>>()
    var errorLiveData = MutableLiveData<Throwable>()

    fun getProfileData() {
        fetchServerData()

    }

    fun fetchServerData() {
        val jsonObjectRequest =
            JsonObjectRequest(Request.Method.GET, BASE_URL, null, Response.Listener { response ->
                if (response != null) {
                    val list = addProfileDataToMutableList(response)
                    mutableLiveData.postValue(list)
                }

            }, Response.ErrorListener {
                errorLiveData.postValue(it)


            })
        NetworkRequest.instance?.addToRequestQueue(jsonObjectRequest, REQUEST_TAG)

    }

    fun addProfileDataToMutableList(response: JSONObject): List<User> {

        return listOf(
            User(
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
        )


    }


    companion object {
        val BASE_URL =
            "https://gist.githubusercontent.com/manochrichard/7d288f5beec0893a6ed51175fc3b1df4/raw/c1e60c2941aa3135b7884a4bfc182dc9e5002397/cv.json"
        val REQUEST_TAG = "CVProfileData"
    }


}