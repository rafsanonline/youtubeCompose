package com.sslwireless.composeplayground

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.ClipboardManager
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.MotionScene
import androidx.constraintlayout.widget.ConstraintSet
import com.sslwireless.composeplayground.ui.theme.ComposePlaygroundTheme
import org.intellij.lang.annotations.JdkConstants

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePlaygroundTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                     VideoListView()
                }
            }
        }
    }

    @Composable
    private fun VideoListView() {

        var playVideo by remember {
            mutableStateOf(false)
        }
        
        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn {

                itemsIndexed(arrayListOf("Item 1", "Item 2")) { index, item ->
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                            .padding(5.dp)
                            .background(color = Color.Green),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(modifier = Modifier
                            .padding(start = 10.dp)
                            .clickable {
                                playVideo = !playVideo
                            }, text = item, style = TextStyle(textAlign = TextAlign.Center)
                        )
                    }
                }

            }

            AnimatedVisibility(visible = playVideo) {
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .clickable { playVideo = !playVideo }
                    .height(200.dp)
                    .background(color = Color.Red)) {

                }
            }

        }
        
      
    }
}

