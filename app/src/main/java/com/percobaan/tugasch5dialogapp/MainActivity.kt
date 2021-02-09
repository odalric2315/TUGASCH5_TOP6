package com.percobaan.tugasch5dialogapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.percobaan.tugasch5dialogapp.databinding.ActivityMainBinding
import com.percobaan.tugasch5dialogapp.databinding.CustomDialogBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonAlertDialog.setOnClickListener {
            showAlertDialog("TEST", "TESTING")
        }
        binding.buttonCustomDialog.setOnClickListener {
            showCustomDialog("TEST")
        }
        binding.buttonFragmentDialog.setOnClickListener {
            showFragmentDialog()
        }
    }

    private fun showAlertDialog(title: String, message: String) {
        val dialog = AlertDialog.Builder(this).setTitle(title).setMessage(message)
        dialog.setPositiveButton("CORRECT") { dialog, _ ->
            Toast.makeText(this, "Ok", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        dialog.setNegativeButton("Cancel") { dialog, _ ->
            Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        dialog.setNeutralButton("CHECK") { dialog, _ ->
            Toast.makeText(this, "Cek", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        dialog.create().show()
    }

    private fun showCustomDialog(title: String){
        val builder = AlertDialog.Builder(this)
        val view = CustomDialogBinding.inflate(layoutInflater)
        builder.setView(view.root)
        val dialog = builder.create()
        view.tvTitle.text = title
        view.buttonSubmit.setOnClickListener {
            val name = view.editName.text.toString()
            Toast.makeText(this, "Good Morning $name", Toast.LENGTH_LONG).show()
            dialog.dismiss()
        }
        dialog.show()
    }

    private fun showFragmentDialog(){
        val customDialogFragment = CustomDialogFragment.newInstance("Fragment Dialog Custom","")
        customDialogFragment.show(supportFragmentManager, "Custom")
    }
}