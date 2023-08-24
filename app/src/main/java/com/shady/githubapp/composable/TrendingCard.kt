package com.shady.githubapp.composable

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.shady.domain.entity.Item
import com.shady.githubapp.R

@Composable
fun TrendingCard(state: Item) {
    val expanded = remember { mutableStateOf(false) }

    val extraPadding by animateDpAsState(
        if (expanded.value) 24.dp else 0.dp, animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessLow
        ), label = ""
    )

    Surface(color = Color.White,
        modifier = Modifier.clickable { expanded.value = !expanded.value }) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(modifier = Modifier.padding(top = 20.dp, start = 30.dp)) {
                Image(
                    painter = rememberAsyncImagePainter(model = state.owner.imageProfile),
                    contentDescription = stringResource(R.string.owner_profile_image_content_des),
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .padding(start = 0.dp, end = 10.dp)
                )
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = state.owner.userName, fontSize = 16.sp
                    )
                    Text(
                        text = state.fullName, style = MaterialTheme.typography.body1.copy(
                            fontWeight = FontWeight.ExtraBold
                        ), fontSize = 18.sp
                    )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            ExpandablePartView(expanded, extraPadding, state)
            Divider(color = Color.LightGray, thickness = 1.dp)
        }
    }
}

@Composable
private fun ExpandablePartView(
    expanded: MutableState<Boolean>,
    extraPadding: Dp,
    state: Item,
) {
    if (expanded.value) {
        Column(
            modifier = Modifier.padding(
                bottom = extraPadding.coerceAtLeast(0.dp), start = 30.dp
            )
        ) {
            Text(
                text = state.description,
                modifier = Modifier.padding(top = 10.dp, start = 40.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            ) {
                Image(
                    painterResource(R.drawable.language_icon), "language_icon",
                    modifier = Modifier
                        .padding(start = 40.dp)
                        .size(16.dp)
                        .align(CenterVertically),
                    colorFilter = ColorFilter.tint(color = Color(0xFF324299))
                )
                Text(
                    text = state.language,
                    modifier = Modifier
                        .padding(start = 3.dp)
                        .align(CenterVertically)
                )
                Image(
                    painterResource(R.drawable.stargazers_count_icon),
                    "stargazers_count_icon",
                    modifier = Modifier
                        .padding(start = 40.dp)
                        .size(16.dp)
                        .align(CenterVertically),
                    colorFilter = ColorFilter.tint(color = Color(0xFFAC8D31))
                )
                Text(
                    text = state.stargazersCount,
                    modifier = Modifier
                        .padding(start = 3.dp)
                        .align(CenterVertically)
                )
            }
        }
    }
}
