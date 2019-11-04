package com.cv.app

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import com.cv.app.model.PublishedApp
import com.cv.app.repository.AppListRepoImp
import com.cv.app.viewmodel.MyProfileExtraViewModel
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class AppPublishListTest {
    @get: Rule
    val rule = InstantTaskExecutorRule()

    val respository=Mockito.mock(AppListRepoImp::class.java)
    val vm = MyProfileExtraViewModel(respository)


    @Test
    fun publishedAppList_test() {

        Mockito.`when`(respository.getAppList()).thenReturn(
            listOf(
                PublishedApp(
                        "SIP",
                "https://play.google.com/store/apps/details?id=com.amazon.mShop.android.shopping&hl=en_CA"
            ),
                        PublishedApp(
                        "Amazon",
                "https://play.google.com/store/apps/details?id=com.amazon.mShop.android.shopping&hl=en_CA"
            )
            )
        )
        vm.getPublishedAppList()
        assert(vm.mutableLiveData.value?.size == 2)
    }

    @Test
    fun emptyPublishedAppList_test() {

        Mockito.`when`(respository.getAppList()).thenReturn(
            listOf()
        )

        vm.getPublishedAppList()
        vm.showEmptyLiveData.observeForever {}
        assert(vm.mutableLiveData.value?.size == 0)
        assert(vm.showEmptyLiveData.value == true)
    }

    @Test
    fun publishedAppList_testFail() {

        Mockito.`when`(respository.getAppList()).then {
            throw Exception("Error")
        }

        vm.getPublishedAppList()
        assert(vm.errorLiveData.value != null)
    }

    fun <T> LiveData<T>.observedValue(): T? {
        observeForever { }
        return value
    }

}