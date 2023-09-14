package com.example.codersnexus

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.launch


@Composable
fun contactus(navController: NavController) {

    Scaffold(
//      Adding Bottom navigation
        bottomBar = {
            BottomAppBar(
                backgroundColor = Color.Blue
            ) {
                BottomNavigationItem(
                    icon = {
                        Icon(imageVector = Icons.Default.Home, contentDescription = null)
                    },
                    label = {
                        Text(text = "Home", color = Color.White)
                    },
                    selected = false,
                    onClick = {
                        navController.navigate("FirstScreen")
                    }
                )
                BottomNavigationItem(
                    icon = {
                        Icon(imageVector = Icons.Default.Search, contentDescription = "Resourse")
                    },
                    label = {
                        Text(text = "Domains", color = Color.White)
                    }, selected = false, onClick = { navController.navigate("SecondScreen") })
                BottomNavigationItem(icon = {
                    Icon(imageVector = Icons.Default.Person,
                        contentDescription = "About us")
                }, label = {
                    Text("About Us", color = Color.White)
                }, selected = false, onClick = { navController.navigate("AboutUs") })
                BottomNavigationItem(icon = {
                    Icon(imageVector = Icons.Default.Call,
                        contentDescription = "Contact Us")
                }, label = {
                    Text(text = "Contact", color = Color.White)
                }, selected = true, onClick = { navController.navigate("ContactUs") })
            }
        },
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Contact Us", color = Color.White)
                },
                backgroundColor = Color.Blue
            )
        }
    ) {
        var text by remember { mutableStateOf("") }
        var text1 by remember { mutableStateOf("") }
        val context = LocalContext.current
        val uriHandler = LocalUriHandler.current
        var coroutineScope = rememberCoroutineScope()
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = "Contact Us",
                color = Color.Black,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 30.dp))
            Box(
                modifier = Modifier
                    .background(Color.DarkGray)
                    .padding(20.dp)
            ) {
                Column() {
                    OutlinedTextField(
                        value = text,
                        onValueChange = { text = it },
                        label = { Text("Enter Email Subject", color = Color.Magenta) },
                        textStyle = TextStyle(
                            color = Color.Black,
                            fontSize = 13.sp,
                            fontWeight = FontWeight(20)
                        ),
                        modifier = Modifier.padding(top = 50.dp)
                    )

                    OutlinedTextField(
                        value = text1,
                        onValueChange = { text1 = it },
                        label = { Text("Enter Email Body", color = Color.Magenta) },
                        textStyle = TextStyle(
                            color = Color.Black,
                            fontSize = 13.sp,
                            fontWeight = FontWeight(20)
                        ),
                        modifier = Modifier.padding(top = 50.dp)
                    )
                    Spacer(modifier = Modifier.padding(15.dp))
                    Button(onClick = {
                        val i = Intent(Intent.ACTION_SEND)
                        val emailid = arrayOf("codersnexusjntua@gmail.com")
                        i.putExtra(Intent.EXTRA_EMAIL, emailid)
                        i.putExtra(Intent.EXTRA_SUBJECT, text)
                        i.putExtra(Intent.EXTRA_TEXT, text1)
                        i.setType("Message/rfc822")
                        context.startActivity(Intent.createChooser(i, "chooseanemailclient"))
                        Toast.makeText(context, "Sending Email", Toast.LENGTH_SHORT).show()
                    }) {
                        Text(
                            text = "Send Email",
                            fontSize = 15.sp,
//                    modifier = Modifier.padding(10.dp)
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.padding(15.dp))
            Text(
                text = "OR",
                fontSize = 20.sp,
                color = Color.Black,
                modifier = Modifier
                    .background(Color.Unspecified)
                    .padding(10.dp)
            )
            Spacer(modifier = Modifier.padding(20.dp))
            Button(onClick = {
                Toast.makeText(context, "Fill The Form", Toast.LENGTH_SHORT).show()
            }) {
                Text(
                    text = "Fill Form",
                    fontSize = 15.sp,
                    modifier = Modifier
                        .padding(10.dp)
                        .clickable {
                            coroutineScope.launch {
                                uriHandler.openUri("https://forms.gle/9wx366UV5KQXRKdL8/")
                            }
                        }
                )
            }
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "")
        }
    }
}