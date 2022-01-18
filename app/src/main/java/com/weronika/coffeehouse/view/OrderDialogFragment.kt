package com.weronika.coffeehouse.view

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.lifecycleScope
import com.weronika.coffeehouse.databinding.OrderDialogFragmentBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class OrderDialogFragment : DialogFragment() {

    private lateinit var binding: OrderDialogFragmentBinding

    companion object {
        const val DIALOG_TAG = "OrderDialog"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = OrderDialogFragmentBinding.inflate(inflater,
            container, false)
        setupOkButton()

        return binding.root
    }

    private fun setupOkButton() {
        binding.okButton.setOnClickListener {

            lifecycleScope.launch {

                val intent = Intent(context, HomeActivity::class.java)
                startActivity(intent)
                delay(5000)
                Toast.makeText(context, "Your order is ready",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun dismiss() {}
}