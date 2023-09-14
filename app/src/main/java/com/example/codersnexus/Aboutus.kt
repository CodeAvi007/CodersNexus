package com.example.codersnexus

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.launch


@Composable
fun AboutUs(navController: NavController) {
    val uriHandler = LocalUriHandler.current
    var coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current
    Scaffold(

//        Adding Bottom bar to the app
                bottomBar = {
            BottomAppBar (
                backgroundColor = Color.Blue
            ){
                BottomNavigationItem(
                    icon = {
                        Icon(imageVector = Icons.Default.Home, contentDescription = null)
                    },
                    label ={
                        Text(text ="Home", color = Color.White)
                    },
                    selected = false,
                    onClick ={
                        navController.navigate("FirstScreen")
                    }
                )
                BottomNavigationItem(
                    icon = {
                        Icon(imageVector = Icons.Default.Search, contentDescription = "Resourse" )
                    },
                    label = {
                        Text(text ="Domains",color = Color.White)
                    }, selected = false, onClick = { navController.navigate("SecondScreen") })
                BottomNavigationItem(icon = {
                    Icon(imageVector = Icons.Default.Person,
                        contentDescription = "About us")
                }
                    , label = {
                        Text("About Us")
                    },selected = true, onClick = { navController.navigate("AboutUs")})
                BottomNavigationItem(icon = {
                                            Icon(imageVector = Icons.Default.Call, contentDescription = "Contact Us")
                }, label = {
                           Text(text ="Contact", color = Color.White)
                }, selected = false
                    , onClick = { navController.navigate("ContactUs") })
            }
        },
        topBar= {
            TopAppBar(
                title = {
                    Text(text =" About Us", color = Color.White,textAlign = TextAlign.Center)
                },
                backgroundColor = Color.Blue
            )
        }
    ) {it->
        Column(
            modifier = Modifier
                .background(Color.LightGray)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.coders),
                contentDescription = "Image",
                Modifier
                    .width(200.dp)
                    .padding(20.dp)
                    .clip(RoundedCornerShape(30.dp))
            )
            Text(
                text = stringResource(id = R.string.descp),
                color = Color.Black,
                fontSize = 15.sp,
                textAlign = TextAlign.Justify,
                fontWeight = FontWeight(10),
                modifier = Modifier
                    .padding( 10.dp)
            )
            Text(
                text = "Android Developers",
                color = Color.Black,
                fontSize = 25.sp,
                fontWeight = FontWeight(50),
                modifier = Modifier
                    .padding(top = 30.dp)
            )
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Card(
                        modifier = Modifier
                            .padding(top = 30.dp)
                            .size(90.dp)
                            .testTag("circle"),
                        shape = CircleShape,
                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.sudha),
                            contentDescription = "aviimage",
                            modifier = Modifier.clickable {
                                Toast.makeText(context,"Sudha 's Profile",Toast.LENGTH_SHORT).show()
                                coroutineScope.launch {
                                    uriHandler.openUri("https://www.linkedin.com/in/sudha-balu-3a8556256/")
                                }
                            }
                        )
                    }
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = "Lakhsmi Sudha B",
                        color = Color.Black,
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center
                    )
                }
                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Card(
                        modifier = Modifier
                            .padding(top = 30.dp, start = 30.dp)
                            .size(90.dp)
                            .testTag("circle"),
                        shape = CircleShape,
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.dp),
                            contentDescription = "Avineshwar",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.clickable {
                                Toast.makeText(context,"Avineshwar 's Profile",Toast.LENGTH_SHORT).show()
                                coroutineScope.launch {
                                    uriHandler.openUri("https://www.linkedin.com/in/g-avineshwar-81a5ba217/"
                                        )
                                }
                            }
                        )
                    }
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = "  G Avneshwar",
                        color = Color.Black,
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center
                    )
                }
                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Card(
                        modifier = Modifier
                            .padding(top = 30.dp, start = 30.dp)
                            .size(90.dp)
                            .testTag("circle"),
                        shape = CircleShape,
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.basha),
                            contentDescription = "malikimg",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.clickable {
                                Toast.makeText(context,"Malik Basha's Profile",Toast.LENGTH_SHORT).show()
                                coroutineScope.launch {
                                    uriHandler.openUri("https://www.linkedin.com/in/malik-basha-s-957560256/")
                                }
                            }
                        )
                    }
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = "    Malik Basha.S",
                        color = Color.Black,
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "To know more about us click on our's profiles",
                fontSize = 15.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 20.dp)
                    .clickable {
                        Toast
                            .makeText(context, "View our's profile", Toast.LENGTH_SHORT)
                            .show()
                    }
            )
            Spacer(modifier = Modifier.height(100.dp))
            Text(text ="")
        }

    }
}