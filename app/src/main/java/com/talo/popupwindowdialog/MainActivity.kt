package com.talo.popupwindowdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.talo.popupwindowdialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        popupItem()
        popupWindow()
    }

    private fun popupItem() {
        binding.btnShowPopupDialog.setOnClickListener {
            var popup = PopupMenu(this, binding.btnShowPopupDialog)
            popup.inflate(R.menu.menu)
            popup.setOnMenuItemClickListener {
                Toast.makeText(this, "Click " + it.title, Toast.LENGTH_SHORT).show()
                true
            }
            popup.show()
        }
    }
    private fun popupWindow(){
        binding.btnShowPopupWindow.setOnClickListener {
            val window = PopupWindow(this)
            val view = layoutInflater.inflate(R.layout.layout_popup, null)
            window.contentView = view
            val image = view.findViewById<ImageView>(R.id.imageView)
            image.setOnClickListener {
                window.dismiss()
            }
            window.showAsDropDown(binding.btnShowPopupWindow)
        }
    }
}