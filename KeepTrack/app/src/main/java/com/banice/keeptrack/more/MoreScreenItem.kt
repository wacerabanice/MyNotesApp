package com.banice.keeptrack.more

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun MoreScreenItem(title: String, description: String, onMoreItemClicked: (String) -> Unit) {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .clickable {
                onMoreItemClicked(title)
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                style = MaterialTheme.typography.body1
            )
            Text(
                text = description,
                style = MaterialTheme.typography.caption
            )
        }
        Icon(imageVector = Icons.Rounded.ArrowForwardIos, contentDescription = null)
    }
}