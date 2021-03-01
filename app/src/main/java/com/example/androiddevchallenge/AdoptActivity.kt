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
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.model.Dog
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.vm.MainViewModel

class AdoptActivity : AppCompatActivity() {
    private val vm: MainViewModel by viewModels()

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
        val vm: MainViewModel = viewModel()
        Scaffold(
            topBar = {
                TopAppBar(title = {
                    Text(text = "领养")
                })
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
            Box(contentAlignment = Alignment.BottomEnd) {
                Image(
                    painter = painterResource(id = dog.img),
                    modifier = Modifier
                        .size(328.dp),
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
                Button(
                    onClick = {
                        adoptListener.invoke()
                    },
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text(text = "Adpot")
                }
            }
            Spacer(modifier = Modifier.size(16.dp))
            Text(text = "Name: ${dog.name}", style = MaterialTheme.typography.subtitle1)
            Text(text = "Age: ${dog.age}岁", style = MaterialTheme.typography.body1)
            Text(text = "Breed: ${dog.breed}", style = MaterialTheme.typography.body1)
            Text(text = "Color: ${dog.color}", style = MaterialTheme.typography.body1)

        }
    }
}

