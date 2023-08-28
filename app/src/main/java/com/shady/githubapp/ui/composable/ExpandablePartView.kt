package com.shady.githubapp.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.shady.githubapp.R
import com.shady.githubapp.ui.entities.TrendingViewItem


@Composable
fun ExpandablePartView(
    expanded: MutableState<Boolean>,
    state: TrendingViewItem,
) {
    if (expanded.value) {
        Column(
            modifier = Modifier.padding(
                bottom = 20.dp, start = 90.dp
            )
        ) {
            Text(
                text = state.description,
                modifier = Modifier.padding(top = 10.dp),
                color = MaterialTheme.colorScheme.tertiary
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            ) {
                Image(
                    painterResource(R.drawable.language_icon),
                    "language_icon",
                    modifier = Modifier
                        .size(16.dp)
                        .align(Alignment.CenterVertically),
                    colorFilter = ColorFilter.tint(color = Color(0xFF324299))
                )
                Text(
                    text = state.programmingLanguage,
                    modifier = Modifier
                        .padding(start = 6.dp)
                        .align(Alignment.CenterVertically),
                    color = MaterialTheme.colorScheme.tertiary
                )
                Image(
                    painterResource(R.drawable.stargazers_count_icon),
                    "stargazers_count_icon",
                    modifier = Modifier
                        .padding(start = 30.dp)
                        .size(16.dp)
                        .align(Alignment.CenterVertically),
                    colorFilter = ColorFilter.tint(color = Color(0xFFAC8D31))
                )
                Text(
                    text = state.stars,
                    modifier = Modifier
                        .padding(start = 6.dp)
                        .align(Alignment.CenterVertically),
                    color = MaterialTheme.colorScheme.tertiary
                )
            }
        }
    }
}
