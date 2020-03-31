package fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.fitnessnationaplication.R
import kotlinx.android.synthetic.main.fragment2.*

class fragment2 : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment1, container, false)
        return view
    }

    companion object {
        fun newInstance() = fragment2()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toast = Toast.makeText(this.context, "This is F1A2", Toast.LENGTH_SHORT).show()
        btn_next.setOnClickListener {
            toTheSecondFragment()
            val toast = Toast.makeText(this.context, "This is F2A2", Toast.LENGTH_SHORT).show()
        }


    }

    fun toTheSecondFragment() {
        val transaction = fragmentManager!!.beginTransaction()
        transaction.replace(R.id.fly_android_session, fragment3.newInstance())
        transaction.addToBackStack(fragment3.toString())
        transaction.commit()
    }
}



