package com.google.codelabs.mdc.kotlin.shrine

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.shr_login_fragment.*
import kotlinx.android.synthetic.main.shr_login_fragment.view.*

/**
 * Fragment representing the login screen for Shrine.
 */
class LoginFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        // Snippet from "Navigate to the next Fragment" section goes here.

        val view = inflater.inflate(R.layout.shr_login_fragment, container, false)

        /// Set an error is password is less than 8 chars
        view.next_button.setOnClickListener {
            if (!isPasswordValid(password_edit_text.text!!))
                password_text_input.error = getString(R.string.shr_error_password)
            else
            {
                password_text_input.error = null

                // Navigate to next frag
                (activity as NavigationHost).navigateTo(ProductGridFragment(), false)
            }
        }

        // Clear error once more than 8 chars are typed
        view.password_edit_text.setOnKeyListener { view, i, keyEvent ->
            if (isPasswordValid(password_edit_text.text))
            {
                password_text_input.error = null
            }
            false
        }

        return view
    }

    // "isPasswordValid" from "Navigate to the next Fragment" section method goes here
    private fun isPasswordValid(text: Editable?) : Boolean = text != null && text.length >= 8


}
