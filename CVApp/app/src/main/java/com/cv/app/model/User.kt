package com.cv.app.model

class User {
    var name: String = ""
    var mobileno: String = ""
    var email: String = ""
    var location: String = ""
    var title: String = ""
    var profile_summary: String = ""
    var skills: String = ""
    var cname: String = ""
    var duration: String = ""
    var responsibilities: String = ""
    var achievements: String = ""
    var clogo: String = ""

    constructor(
        _name: String,
        _mobileno: String,
        _email: String,
        _location: String,
        _title: String,
        _profile_summary: String,
        _skills: String,
        _cname: String,
        _duration: String,
        _responsibilities: String,
        _achievements: String,
        _clogo: String
    ) {
        this.name = _name
        this.mobileno = _mobileno
        this.email = _email
        this.location = _location
        this.title = _title
        this.profile_summary = _profile_summary
        this.skills = _skills
        this.cname = _cname
        this.duration = _duration
        this.responsibilities = _responsibilities
        this.achievements = _achievements
        this.clogo = _clogo


    }
}


