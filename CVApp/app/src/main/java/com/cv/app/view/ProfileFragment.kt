package com.cv.app.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.cv.app.R
import com.cv.app.viewmodel.MyProfileViewModel

class ProfileFragment : Fragment() {
    internal lateinit var textView_mobno: TextView
    internal lateinit var textView_name: TextView
    internal lateinit var textView_email: TextView
    internal lateinit var textView_jobtitle: TextView
    internal lateinit var textView_location: TextView
    internal lateinit var textView_summary: TextView
    internal lateinit var textView_skills: TextView
    internal lateinit var textView_cname: TextView
    internal lateinit var textView_workduration: TextView
    internal lateinit var textView_achievements: TextView
    internal lateinit var textView_responsibilities: TextView
    internal lateinit var textView_JobTitle: TextView
    internal lateinit var img_companyLogo: ImageView
    internal lateinit var progress_circle: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view =
            LayoutInflater.from(activity).inflate(R.layout.fragment_profile, container, false)
        textView_name = view.findViewById(R.id.txt_profileName)
        textView_mobno = view.findViewById(R.id.txt_profileContactNumber)
        textView_email = view.findViewById(R.id.txt_profileEmail)
        textView_jobtitle = view.findViewById(R.id.txt_profileTitle)
        textView_location = view.findViewById(R.id.txt_profileLocation)
        textView_summary = view.findViewById(R.id.txt_summary)
        textView_skills = view.findViewById(R.id.txt_skills)
        textView_cname = view.findViewById(R.id.txt_comapnyName)
        textView_workduration = view.findViewById(R.id.txt_workDuration)
        textView_achievements = view.findViewById(R.id.txt_Achievements)
        textView_responsibilities = view.findViewById(R.id.txt_Responsibilities)
        textView_JobTitle = view.findViewById(R.id.txt_JobTitle)
        img_companyLogo = view.findViewById(R.id.img_companyLogo)
        progress_circle = view.findViewById(R.id.progress_profile)


        return view;
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val model = ViewModelProviders.of(this.activity!!)
            .get<MyProfileViewModel>(MyProfileViewModel::class.java!!)
        model.getProfileData()
        model.mutableLiveData.observe(this, Observer { users ->
            if (users != null && users.size >= 1) {
                textView_name.text = users.get(0).name
                textView_mobno.text = users.get(0).mobileno
                textView_email.text = users.get(0).email
                textView_jobtitle.text = users.get(0).title
                textView_location.text = users.get(0).location
                textView_summary.text = users.get(0).profile_summary
                textView_skills.text = users.get(0).skills
                textView_cname.text = users.get(0).cname
                textView_workduration.text = users.get(0).duration
                textView_achievements.text = users.get(0).achievements
                textView_responsibilities.text = users.get(0).responsibilities
                textView_JobTitle.text = users.get(0).title
                Glide.with(activity!!).load(users.get(0).clogo).override(100, 100)
                    .placeholder(R.drawable.icons_user_profile_48).into(img_companyLogo)
                progress_circle.visibility = View.GONE

            } else {
                Toast.makeText(activity, "Please Try again", Toast.LENGTH_LONG).show()
            }

        })

        model.errorLiveData.observe(this, Observer {


            Toast.makeText(activity, " Error Loading data ", Toast.LENGTH_LONG).show()
        })


    }
}