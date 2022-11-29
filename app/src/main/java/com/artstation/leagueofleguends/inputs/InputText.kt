package com.artstation.leagueofleguends.inputs

import android.content.Context
import android.util.AttributeSet
import android.widget.EditText
import android.widget.RelativeLayout
import com.artstation.leagueofleguends.R

class InputText(context: Context, attrRes: AttributeSet) : RelativeLayout(context, attrRes) {
    var editText: EditText
    init {
        inflate(context, R.layout.input_text, this)
        editText = findViewById(R.id.input)
        val attributes = context.obtainStyledAttributes(attrRes, R.styleable.InputText)
        editText.hint = attributes.getText(R.styleable.InputText_hint)
        editText.setText(attributes.getString(R.styleable.InputText_text))
        attributes.recycle()
    }
    fun edit(): EditText = editText
}