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

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Dog
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.vm.MainViewModel

class MainActivity : AppCompatActivity() {
    private val vm: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MainPage()
            }
        }
    }

    // Start building your app here!
    @Composable
    fun MainPage() {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "狗狗领养")
                    }
                )
            }
        ) {
            DogList(vm.dogs.value!!) {
                AdoptActivity.create(this, it)
            }
        }
    }

    @Composable
    fun DogList(dogList: List<Dog>, listener: (dog: Dog) -> Unit) {
        LazyColumn(
            contentPadding = PaddingValues(8.dp),
            content = {
                itemsIndexed(dogList) { i: Int, dog: Dog ->
                    Card(
                        elevation = 6.dp,
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .padding(bottom = 8.dp)
                            .fillMaxWidth()
                            .height(120.dp)
                            .clickable { listener.invoke(dog) }
                    ) {
                        Row {
                            Image(
                                painter = painterResource(id = dog.img),
                                modifier = Modifier.size(120.dp),
                                contentDescription = "",
                                contentScale = ContentScale.Crop
                            )
                            Column(
                                modifier = Modifier.padding(8.dp),
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = "Name: ${dog.name}",
                                    style = MaterialTheme.typography.subtitle1
                                )
                                Text(
                                    text = "Age: ${dog.age}岁",
                                    style = MaterialTheme.typography.body1
                                )
                                Text(
                                    text = "Breed: ${dog.breed}",
                                    style = MaterialTheme.typography.body1
                                )
                                Text(
                                    text = "Color: ${dog.color}",
                                    style = MaterialTheme.typography.body1
                                )
                            }
                        }
                    }
                }
            }
        )
    }
}
