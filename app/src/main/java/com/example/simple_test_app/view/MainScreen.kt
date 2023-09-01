package com.example.simple_test_app.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.simple_test_app.model.AmiiboResponse

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    amiiboData: List<AmiiboResponse>
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                        Text(text = "Amiibo App")
                },

            )
        },
        content = { padding ->
            MainContent(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize(),
                amiiboData = amiiboData
            )
        }
    )
}

@Composable
private fun MainContent(
    modifier: Modifier = Modifier,
    amiiboData: List<AmiiboResponse>
) {
    LazyColumn {
        items(amiiboData) { itemData ->
            AmiiboListItem(itemData)
        }
    }
}

@Composable
private fun AmiiboListItem(
    itemData: AmiiboResponse,

) {
    Row(
        horizontalArrangement = Arrangement.Center
    ) {
        Text(text = itemData.name)
    }
}