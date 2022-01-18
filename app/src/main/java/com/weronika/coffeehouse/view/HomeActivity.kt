package com.weronika.coffeehouse.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.google.android.material.tabs.TabLayout
import com.weronika.coffeehouse.R
import com.weronika.coffeehouse.databinding.HomeActivityBinding

class HomeActivity : AppCompatActivity(), TabLayout.OnTabSelectedListener {

    private lateinit var binding: HomeActivityBinding

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = HomeActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupTabLayout()
        setupDefaultFragment()
    }

    private fun setupDefaultFragment() {

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<MenuFragment>(R.id.home_fragment_container)
        }
    }

    private fun setupTabLayout() {

        binding.tabLayout.addTab(
            binding.tabLayout.newTab()
                .setId(R.id.menu_tab_item)
                .setCustomView(R.layout.menu_tab_item_layout)
                .apply { select() }
        )

        binding.tabLayout.addTab(
            binding.tabLayout.newTab()
                .setId(R.id.profile_tab_item)
                .setCustomView(R.layout.profile_tab_item_layout)
        )

        binding.tabLayout.addOnTabSelectedListener(this)

    }

    override fun onTabSelected(tab: TabLayout.Tab?) {

        if(tab?.id == R.id.menu_tab_item ) {

            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace<MenuFragment>(R.id.home_fragment_container)
            }

        }
        else {

            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace<ProfileFragment>(R.id.home_fragment_container)
            }
        }
    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {

        if(tab?.id == R.id.menu_tab_item ) {

            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace<MenuFragment>(R.id.home_fragment_container)
            }
        }
        else {

            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace<ProfileFragment>(R.id.home_fragment_container)
            }

        }
    }

    override fun onTabReselected(tab: TabLayout.Tab?) {

        if(tab?.id == R.id.menu_tab_item ) {

            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace<MenuFragment>(R.id.home_fragment_container)
            }
        }
        else {

            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace<ProfileFragment>(R.id.home_fragment_container)
            }
        }
    }

}