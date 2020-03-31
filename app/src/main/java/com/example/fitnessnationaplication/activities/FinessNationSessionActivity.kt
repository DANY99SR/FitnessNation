package com.example.fitnessnationaplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fitnessnationaplication.R
import fragments.fragment1
import fragments.fragment2
import kotlinx.android.synthetic.main.activity_finess_nation_session.*

class FinessNationSessionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finess_nation_session)
        btn_go_to_F2A2.setOnClickListener {
            changeFragment()

        }
    }

    companion object {
        enum class FragmentTags(val value: String) {
            TAG_FRAGMENT_F1A2("TAG_FRAGMENT_F1A2"),
            TAG_FRAGMENT_F2A2("TAG_FRAGMENT_F2A2")
        }
    }

    var currentFragmentTag: FragmentTags? = null

    fun changeFragment() {

        val currentFragmentTag = when (currentFragmentTag) {
            null -> FragmentTags.TAG_FRAGMENT_F1A2
            FragmentTags.TAG_FRAGMENT_F1A2 -> FragmentTags.TAG_FRAGMENT_F2A2
            FragmentTags.TAG_FRAGMENT_F2A2 -> FragmentTags.TAG_FRAGMENT_F1A2

        }
        replaceFragment(currentFragmentTag)
    }

    private fun replaceFragment(TAG: FragmentTags?) {
        TAG?.run {

            val fragment = when (this) {
                FragmentTags.TAG_FRAGMENT_F1A2 -> fragment1.newInstance()
                FragmentTags.TAG_FRAGMENT_F2A2 -> fragment2.newInstance()

            }

            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fly_android_session, fragment,this.value)
            transaction.addToBackStack(this.value)
            transaction.commit()



        }
    }

    fun setFirstFragment() {
        val fragment: fragment2= fragment2.newInstance()

        val transaction =supportFragmentManager.beginTransaction()
        transaction.add(R.id.fly_android_session, fragment)
        transaction.addToBackStack(fragment2.toString())
        transaction.commit()
    }

    override fun onDestroy() {
        super.onDestroy()
    }



}
