package com.example.codersnexus
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Domain(
    @DrawableRes val imageId:Int,
    @StringRes val name:Int,
     val desc:String
)

val domains = listOf(
    Domain(R.drawable.coders,R.string.web,"Web development is the process of creating and maintaining websites and web applications for the internet. It encompasses a wide range of tasks, including designing the user interface, coding the functionality, and ensuring the website's performance, security, and compatibility with various devices and browsers."),
    Domain(R.drawable.coders,R.string.android,"Android development is the process of creating mobile applications specifically designed to run on the Android operating system which powers the majority of smartphones and tablets worldwide."),
    Domain(R.drawable.coders,R.string.cloud,"Cloud computing is a revolutionary technology that has transformed the way businesses and individuals access, store, and manage data and applications."),
    Domain(R.drawable.coders,R.string.cyber,"Cyber-security is the practice of protecting computer systems, networks, data and digital assets from various forms of cyber threats and attacks. It is a critical field in our increasingly interconnected and digitized world."),
    Domain(R.drawable.coders,R.string.data,"Data science is an interdisciplinary field that combines techniques from statistics, computer science, and domain-specific expertise to extract meaningful insights and knowledge from data.")
)

