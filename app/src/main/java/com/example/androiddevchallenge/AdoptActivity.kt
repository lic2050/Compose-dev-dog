/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.model.Dog
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.white40

class AdoptActivity : AppCompatActivity() {

    companion object {
        const val Key = "dog"
        fun create(context: Context, dog: Dog) {
            val intent = Intent(context, AdoptActivity::class.java)
            intent.putExtra(Key, dog)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dog = intent.getSerializableExtra(Key) as Dog
        setContent {
            MyTheme {
                AdoptPage(dog)
            }
        }
    }

    @Composable
    fun AdoptPage(dog: Dog) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "领养")
                    }
                )
            }
        ) {
            AdoptDog(dog) {
                Toast.makeText(this, "Adopt", Toast.LENGTH_SHORT).show()
            }
        }
    }

    @Composable
    fun AdoptDog(dog: Dog, adoptListener: () -> Unit) {
        Column(modifier = Modifier.padding(16.dp)) {
            Box(contentAlignment = Alignment.BottomStart) {
                Image(
                    painter = painterResource(id = dog.img),
                    modifier = Modifier
                        .size(328.dp),
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
                Box(
                    modifier = Modifier
                        .wrapContentSize()
                        .background(white40, shape = RoundedCornerShape(topEnd = 16.dp))
                ) {
                    Column(modifier = Modifier.padding(8.dp)) {
                        Text(text = "Name: ${dog.name}", style = MaterialTheme.typography.subtitle1)
                        Text(text = "Age: ${dog.age}岁", style = MaterialTheme.typography.body1)
                        Text(text = "Breed: ${dog.breed}", style = MaterialTheme.typography.body1)
                        Text(text = "Color: ${dog.color}", style = MaterialTheme.typography.body1)
                    }
                }
            }
            Spacer(modifier = Modifier.size(32.dp))
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()) {
                Button(
                    onClick = {
                        adoptListener.invoke()
                    },
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape)
                ) {
                    Text(text = "Adpot", fontSize = 24.sp)
                }
            }
        }
    }
}
