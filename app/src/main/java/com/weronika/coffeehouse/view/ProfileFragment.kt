package com.weronika.coffeehouse.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.weronika.coffeehouse.databinding.ProfileFragmentBinding
import com.weronika.coffeehouse.viewmodel.AccountViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProfileFragment : Fragment() {

    private lateinit var binding: ProfileFragmentBinding
    private var accountViewModel: AccountViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = ProfileFragmentBinding.inflate(inflater,
            container, false
        )
        lifecycleScope.launch {
            accountViewModel = AccountViewModel(context!!)
            accountViewModel?.updateProfile()
            binding.account = accountViewModel
        }
        return binding.root
    }
}