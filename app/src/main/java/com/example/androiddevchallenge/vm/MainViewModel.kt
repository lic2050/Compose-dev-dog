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
package com.example.androiddevchallenge.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Dog

class MainViewModel : ViewModel() {

    val dogs: LiveData<MutableList<Dog>> by lazy {
        val dogList = mutableListOf<Dog>()
        dogList.add(Dog(R.mipmap.img_god_1, "花花", 3, "白色", "贵宾"))
        dogList.add(Dog(R.mipmap.img_god_2, "阿黄", 2, "黄色", "田园"))
        dogList.add(Dog(R.mipmap.img_god_3, "RT", 1, "棕色", "泰迪"))
        dogList.add(Dog(R.mipmap.img_god_4, "小美", 1, "白色", "贵宾"))
        dogList.add(Dog(R.mipmap.img_god_5, "西瓜", 1, "炫彩黑", "傻狗"))
        dogList.add(Dog(R.mipmap.img_god_6, "二哈", 1, "炫彩黑", "傻狗"))
        dogList.add(Dog(R.mipmap.img_god_7, "汤圆", 1, "炫彩黑", "傻狗"))
        dogList.add(Dog(R.mipmap.img_god_8, "饺子", 1, "炫彩黑", "傻狗"))
        dogList.add(Dog(R.mipmap.img_god_9, "云吞", 1, "炫彩黑", "傻狗"))
        dogList.add(Dog(R.mipmap.img_god_10, "馄饨", 1, "炫彩黑", "傻狗"))
        dogList.add(Dog(R.mipmap.img_god_11, "粽子", 1, "炫彩黑", "傻狗"))
        dogList.add(Dog(R.mipmap.img_god_12, "麻花", 1, "炫彩黑", "傻狗"))
        dogList.add(Dog(R.mipmap.img_god_13, "切糕", 1, "炫彩黑", "傻狗"))
        dogList.add(Dog(R.mipmap.img_god_14, "猪蹄", 1, "炫彩黑", "傻狗"))
        dogList.add(Dog(R.mipmap.img_god_15, "鸡爪", 1, "炫彩黑", "傻狗"))
        dogList.add(Dog(R.mipmap.img_god_16, "鸭脖", 1, "炫彩黑", "傻狗"))
        dogList.add(Dog(R.mipmap.img_god_17, "地龙", 1, "炫彩黑", "傻狗"))
        dogList.add(Dog(R.mipmap.img_god_18, "膏药", 1, "炫彩黑", "傻狗"))
        dogList.add(Dog(R.mipmap.img_god_19, "黄仔", 1, "炫彩黑", "傻狗"))
        MutableLiveData(dogList)
    }

    val showingDog = MutableLiveData<Dog?>()
}
