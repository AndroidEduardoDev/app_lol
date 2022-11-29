package com.artstation.leagueofleguends.inputs

import android.content.Context
import android.util.AttributeSet
import android.widget.Button
import android.widget.EditText
import android.widget.RelativeLayout
import com.artstation.leagueofleguends.R

class InputButton(context: Context, attrRes: AttributeSet) : RelativeLayout(context, attrRes) {
    var button: Button

    init {
        inflate(context, R.layout.input_button, this)
        button = findViewById(R.id.input)
        val attributes = context.obtainStyledAttributes(attrRes, R.styleable.InputButton)
        button.text = attributes.getString(R.styleable.InputButton_textButton)
        attributes.recycle()
    }

    fun edit(): Button = button
    override fun setOnClickListener(l: OnClickListener?) {
        super.setOnClickListener(l)
        button.setOnClickListener(l)
    }
}