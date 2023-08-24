package com.shady.githubapp.composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.shady.githubapp.R


@Composable
fun AppBarTrending() {
    TopAppBar(
        title = {
            Text(
                stringResource(R.string.trending_screen_title),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(), fontWeight = FontWeight.Bold
            )
        },
        actions = {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = stringResource(R.string.menu_icon_content_des)
                )
            }
        },
        backgroundColor = Color.White,
        contentColor = Color.Black,
        elevation = 1.dp
    )
}