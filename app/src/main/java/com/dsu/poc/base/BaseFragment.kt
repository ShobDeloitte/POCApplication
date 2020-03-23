package com.dsu.poc.base

import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment

/*
A base fragment to implement common functions to be used in other activities
*/
abstract class BaseFragment : Fragment() {

    /*
     * Displays the alert dialog with a particular message with one / two buttons
     */

    fun showAlertDialog(dialogBuilder: AlertDialog.Builder.() -> Unit) {
        val builder = activity?.let {
            AlertDialog.Builder(it)
        }
        builder?.dialogBuilder()
        val dialog = builder?.create()

        dialog?.show()
    }

    fun AlertDialog.Builder.positiveButton(
        text: String = "Okay",
        handleClick: (which: Int) -> Unit = {}
    ) {
        this.setPositiveButton(text, { dialogInterface, which -> handleClick(which) })
    }

    fun AlertDialog.Builder.negativeButton(
        text: String = "Cancel",
        handleClick: (which: Int) -> Unit = {}
    ) {
        this.setNegativeButton(text, { dialogInterface, which -> handleClick(which) })
    }
}