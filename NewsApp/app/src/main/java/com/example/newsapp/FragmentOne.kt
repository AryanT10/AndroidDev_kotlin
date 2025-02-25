package com.example.newsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.google.android.material.materialswitch.MaterialSwitch


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


/**
 * A simple [Fragment] subclass.
 * Use the [FragmentOne.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentOne : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var genderRadioGroup: RadioGroup
    private lateinit var familyEventSwitch: MaterialSwitch
    private lateinit var termsCheckBox: CheckBox
    private lateinit var registerButton: Button


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

        val view = inflater.inflate(R.layout.fragment_one, container, false)

        // Initialize views
        nameEditText = view.findViewById(R.id.nameEditText)
        emailEditText = view.findViewById(R.id.emailEditText)
        genderRadioGroup = view.findViewById(R.id.genderRadioGroup)
        familyEventSwitch = view.findViewById(R.id.familyEventSwitch)
        termsCheckBox = view.findViewById(R.id.termsCheckBox)
        registerButton = view.findViewById(R.id.registerButton)

        // Set click listener for the Register button
        registerButton.setOnClickListener {
            passDataToFragmentTwo()
        }

        // Inflate the layout for this fragment
        return view
    }

    private fun passDataToFragmentTwo() {
        val name = nameEditText.text.toString()
        val email = emailEditText.text.toString()
        val selectedGenderId = genderRadioGroup.checkedRadioButtonId
        val gender = view?.findViewById<RadioButton>(selectedGenderId)?.text.toString()
        val termsAccepted = termsCheckBox.isChecked
        val familyEventOptIn = familyEventSwitch.isChecked

        // Bundle to pass data
        val bundle = Bundle().apply {
            putString("name", name)
            putString("email", email)
            putString("gender", gender)
            putBoolean("termsAccepted", termsAccepted)
            putBoolean("familyEventOptIn", familyEventOptIn)
        }

        // Navigate to FragmentTwo
        val fragmentTwo = FragmentTwo()
        fragmentTwo.arguments = bundle

        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragmentTwo) // Replaces FragmentOne
            .addToBackStack(null) // Allows going back
            .commit()
    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment fragmentOne.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentOne().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}