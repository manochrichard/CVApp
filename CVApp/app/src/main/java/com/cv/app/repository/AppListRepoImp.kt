package com.cv.app.repository

import com.cv.app.model.PublishedApp

class AppListRepoImp : AppListRepo {
    override fun getAppList(): List<PublishedApp> {
        return listOf(
            PublishedApp(
                "WhatsApp",
                "https://play.google.com/store/apps/details?id=com.whatsapp"

            ),
            PublishedApp(
                "Youtube",
                "https://play.google.com/store/apps/details?id=com.google.android.youtube"

            )
        )
    }
}

interface AppListRepo {
    fun getAppList(): List<PublishedApp>
}