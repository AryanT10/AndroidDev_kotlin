package com.example.newsapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentTwo.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentTwo : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var thankYouMessage: TextView
    private lateinit var userDetails: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_two, container, false)

//        thankYouMessage = view.findViewById(R.id.thankYouMessage)
//        userDetails = view.findViewById(R.id.userDetails)

        // Retrieve data from the bundle
        val name = arguments?.getString("name") ?: "N/A"
        val email = arguments?.getString("email") ?: "N/A"
        val gender = arguments?.getString("gender") ?: "N/A"
        val termsAccepted = arguments?.getBoolean("termsAccepted") ?: false
        val familyEventOptIn = arguments?.getBoolean("familyEventOptIn") ?: false

        // Set data into individual TextViews using string resources
        view.findViewById<TextView>(R.id.thankYouMessage).text = getString(R.string.thank_you_message, name)
        view.findViewById<TextView>(R.id.userName).text = getString(R.string.user_name, name)
        view.findViewById<TextView>(R.id.userEmail).text = getString(R.string.user_email, email)
        view.findViewById<TextView>(R.id.userGender).text = getString(R.string.user_gender, gender)
        view.findViewById<TextView>(R.id.termsAccepted).text = getString(
            R.string.terms_accepted, if (termsAccepted) "Yes" else "No"
        )
        view.findViewById<TextView>(R.id.familyEventOptIn).text = getString(
            R.string.family_event_opt_in, if (familyEventOptIn) "Yes" else "No"
        )

        // Set up button click to navigate to ActivityTwo
        val goToActivityButton = view.findViewById<Button>(R.id.goToActivityTwoButton)
        goToActivityButton.setOnClickListener {
            val intent = Intent(requireContext(), ActivityTwo::class.java)
            intent.putExtra("userName", name)  // Pass user name via Intent
            startActivity(intent)
        }

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment fragmentTwo.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentTwo().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}