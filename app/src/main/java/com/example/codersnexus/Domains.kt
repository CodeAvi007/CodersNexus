package com.example.codersnexus

import android.util.EventLogTags
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun DomainsPage(navController: NavController){
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
                    }, selected = true, onClick = { navController.navigate("SecondScreen") })
                BottomNavigationItem(icon = {
                    Icon(imageVector = Icons.Default.Person,
                        contentDescription = "About us")
                }
                    , label = {
                        Text("About Us")
                    },selected = false, onClick = { navController.navigate("AboutUs")})
                BottomNavigationItem(icon = {
                    Icon(imageVector = Icons.Default.Call,
                        contentDescription = "Contact Us")
                }, label = {
                    Text(text ="Contact", color = Color.White)
                }, selected = false, onClick = { navController.navigate("ContactUs") })
            }
        },
        topBar = {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ){
                TopAppBar(
                    title = {
                        Text(text = stringResource(id = R.string.domains), color = Color.White, textAlign = TextAlign.Center)
                    },
                    backgroundColor = Color.Blue
                )
            }
        }
    ) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(domains) {
                    DomainItem(it)
                }
            }
        Spacer(modifier = Modifier.height(20.dp))
        Text(text ="Hello")

        }
    }
@Composable
fun DomainItem(a:Domain){
    var expanded by remember { mutableStateOf(false) }
    Card(elevation = 5.dp,
        modifier = Modifier
            .padding(10.dp)
            .background(color = Color.Magenta)
    ) {
        Column(
            modifier =Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .size(150.dp)
                        .padding(8.dp),
                    painter = painterResource(a.imageId),
                    contentDescription = null
                )
                Text(text = stringResource(id = a.name))
                Spacer(modifier=Modifier.weight(1f))
                IconButton(onClick = {expanded = !expanded}) {
                    if(expanded){
                        Image(painter = painterResource(id = R.drawable.expandmore), contentDescription =null)
                    }
                    else{
                        Image(painter = painterResource(id = R.drawable.expandless), contentDescription =null)
                    }
                }
            }
            if (expanded) {
                Description(a)
            }
        }
    }
}
@Composable
fun Description(a:Domain){
    Column(
        modifier = Modifier.padding(
            start = 16.dp,
            top = 8.dp,
            bottom = 16.dp,
            end = 16.dp
        )
    ) {
        Text(
            text = stringResource(R.string.about), fontWeight = FontWeight.Bold
        )
        Text(
            text = a.desc,
            textAlign = TextAlign.Justify
        )
    }
}