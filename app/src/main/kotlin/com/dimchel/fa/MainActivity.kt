package com.dimchel.fa

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.dimchel.fa.league.LeagueNavigation

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.container_view, LeagueNavigation.getScreen())
            .commit()
    }
}