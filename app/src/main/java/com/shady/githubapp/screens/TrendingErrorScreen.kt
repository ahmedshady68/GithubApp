package com.shady.githubapp.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.shady.githubapp.R


@Composable
fun TrendingErrorScreen(retry: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        LottieView(
            modifier = Modifier
                .fillMaxWidth()
                .align(TopCenter)
                .padding(top = 50.dp)
        )
        OutlinedButton(
            modifier = Modifier
                .fillMaxWidth()
                .align(alignment = BottomCenter)
                .padding(bottom = 50.dp, start = 20.dp, end = 20.dp),
            onClick = {
                retry.invoke()
            },
            border = BorderStroke(1.dp, Color.Green)
        ) {
            Text(text = stringResource(R.string.retry_button_text), color = Color.Green)
        }
    }
}

@Composable
fun LottieView(modifier: Modifier) {
    Surface(modifier = modifier) {
        val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.error_screen_animation))
        LottieAnimation(composition = composition, iterations = LottieConstants.IterateForever)
    }
}