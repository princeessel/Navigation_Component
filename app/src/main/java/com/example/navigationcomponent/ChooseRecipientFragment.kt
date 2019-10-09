package com.example.navigationcomponent


import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_choose_recipient.*

/**
 * A simple [Fragment] subclass.
 */
class ChooseRecipientFragment : Fragment(), View.OnClickListener {
    var navController: NavController? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_recipient, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.next_button).setOnClickListener(this)
        view.findViewById<Button>(R.id.cancel_button).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.next_button -> {
                if (!TextUtils.isEmpty(editTextRecipient.text.toString())) {
                    val bundle = bundleOf("recipient" to editTextRecipient.text.toString())
                    navController!!.navigate(
                        R.id.action_fragmentChooseRecipient_to_specifyAmountFragment,
                        bundle
                    )

                }
            }
            R.id.cancel_button -> activity!!.onBackPressed()
        }
    }
}
