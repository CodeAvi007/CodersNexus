package com.example.codersnexus

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import kotlinx.coroutines.delay

@Composable
fun Splash(navController:NavController){
    val scale = remember {
        Animatable(2f)
    }
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.8f,
            animationSpec = tween(
                durationMillis = 500,
                easing = {
                    OvershootInterpolator(5f).getInterpolation(it)
                }
            )
        )
        delay(2000L)
        navController.navigate(
            route = "FirstScreen",
            navOptions = NavOptions.Builder()
                .setPopUpTo("Splash", inclusive = true)
                .build()
        )
    }
        Box(modifier =
        Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Image(painter = painterResource(id = R.drawable.coders), contentDescription = "logo" , modifier = Modifier.scale(scale.value
            ))
        }
    }