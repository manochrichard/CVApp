package com.cv.app.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.cv.app.model.PublishedApp
import com.cv.app.repository.AppListRepo

class MyProfileExtraViewModel(private val repo: AppListRepo) : ViewModel() {

    val mutableLiveData = MutableLiveData<List<PublishedApp>>()
    val errorLiveData = MutableLiveData<Throwable>()
    val showEmptyLiveData: LiveData<Boolean> = Transformations.map(mutableLiveData) {

        it.isEmpty()
    }

    fun getPublishedAppList() {
        try {
            val applist = repo.getAppList()
            mutableLiveData.postValue(applist)

        } catch (e: Exception) {
            errorLiveData.postValue(e)
        }

    }


}