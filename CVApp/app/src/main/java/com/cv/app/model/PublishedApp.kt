package com.cv.app.model

class PublishedApp {
    var appName: String = ""
    var appLink: String = ""

    constructor(_appName: String, _appLink: String) {
        this.appName = _appName
        this.appLink = _appLink
    }
}