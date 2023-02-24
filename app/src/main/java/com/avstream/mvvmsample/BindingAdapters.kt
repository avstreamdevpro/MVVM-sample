package com.avstream.mvvmsample

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener

object BindingAdapters {

    @BindingAdapter("android:text")
    @JvmStatic fun setTitle(view: EditText, newTitle: String) {
        if (view.text.toString() != newTitle) {
            view.setText(newTitle)
        }
    }

    @InverseBindingAdapter(attribute = "android:text")
    @JvmStatic fun getTitle(view: EditText): String {
        return view.text.toString()
    }

    @BindingAdapter("android:textAttrChanged")
    @JvmStatic fun setListeners(view: EditText, attrChange: InverseBindingListener){
        view.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                attrChange.onChange()
            }

        })
    }
}