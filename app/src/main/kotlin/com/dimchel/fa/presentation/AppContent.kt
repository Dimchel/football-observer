package com.dimchel.fa.presentation

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.CurrentScreen
import com.dimchel.fa.R
import com.dimchel.fa.core.theme.FaTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppContent() {
    FaTheme(dynamicColor = true) {
        Scaffold(
            contentWindowInsets = WindowInsets(0.dp),
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),
                    title = {
                        Text(stringResource(id = R.string.app_name))
                    }
                )
            }
        ) {
            Surface(
                Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {
                CurrentScreen()
            }
        }
    }
}