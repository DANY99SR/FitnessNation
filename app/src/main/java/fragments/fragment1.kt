package fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fitnessnationaplication.R
import com.example.fitnessnationaplication.activities.FinessNationSessionActivity
import kotlinx.android.synthetic.main.fragment1.*


class fragment1 : Fragment() {


    companion object {
        fun newInstance()=fragment1()
    }

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,  savedInstanceState: Bundle?)
            = inflater.inflate(R.layout.fragment1, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_goto_act2.setOnClickListener {
            goToNextActivity()
        }
    }
    fun goToNextActivity()
    {
        val intent = Intent(activity, FinessNationSessionActivity::class.java)
        startActivity(intent)
    }

}

