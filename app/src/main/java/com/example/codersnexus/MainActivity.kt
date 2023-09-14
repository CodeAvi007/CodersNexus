package com.example.codersnexus



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.codersnexus.ui.theme.CodersNexusTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CodersNexusTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    MainApp()
                }
            }
        }
    }
}
    //}
//@Composable
//fun Greeting() {
//    val context = LocalContext.current
////    val imageView = ImageView(context)
////    Glide.with(context)
////        .load(R.raw.your_gif_resource)
////        .into(imageView)
//    Scaffold(
//topBar = {
//    TopAppBar(
//        title = {
//            Text(text = "Web Development", fontSize = 30.sp,color  = Color.White)
//        },
//        backgroundColor = Color.Blue,
//    )
//}
//    ) {
//        Column(modifier = Modifier
//            .padding(6.dp)
//            .fillMaxSize()
//            .verticalScroll(rememberScrollState()),
//            verticalArrangement = Arrangement.Top,
//            horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//            Text("Web Development", fontSize = 30.sp, fontWeight = FontWeight.Bold,color= Color.Green)
//            Spacer(modifier = Modifier.height(15.dp))
//            Image(painter = painterResource(id = R.drawable.webdev), contentDescription = "Web Development",
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(250.dp))
//            Text(text =
//                    "Web development is the art and science of creating websites and web applications that are accessible and functional on the internet. It involves a blend of programming, design, and content creation to build interactive and user-friendly online experiences. Web developers utilize various technologies, including HTML, CSS, JavaScript, and server-side scripting languages like PHP, Python, or Ruby, to bring websites to life. Whether it's crafting visually appealing designs, ensuring seamless functionality, or optimizing for performance and security, web development is at the core of the digital landscape, shaping the way we interact and share information online. Explore the world of web development, and you'll discover endless opportunities to create and innovate on the web.",
//            fontSize = 15.sp,
//            textAlign = TextAlign.Justify)
//        }
//    }
//}

@Composable
fun MainApp()
{
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "Splash"){
            composable("Splash"){
            Splash(navController = navController)
            }
            composable("FirstScreen"){
            Home(navController = navController)
            }
            composable("SecondScreen"){
                DomainsPage(navController = navController)
            }
            composable("AboutUs"){
                AboutUs(navController  = navController)
            }
            composable("ContactUs"){
                contactus(navController = navController)
            }
        }
}
    @Composable
    fun Home(navController: NavController) {
        Scaffold(
//            Adding Bottom bar to the app
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
                                    selected = true,
                                    onClick ={
                                        navController.navigate("FirstScreen")
                                    }
                                )
                                    BottomNavigationItem(
                                        icon = {
                                               Icon(imageVector = Icons.Default.Search, contentDescription = "Resource" )
                                        },
                                        label = {
                                                Text(text ="Domains",color = Color.White)
                                        }, selected = false, onClick = { navController.navigate("SecondScreen") })
                                    BottomNavigationItem(icon = {
                                                                Icon(imageVector = Icons.Default.Person,
                                                                    contentDescription = "About us")
                                                                }
                                        , label = {
                                                  Text("About Us" , color = Color.White)
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
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.Center
                ){
                TopAppBar(
                    title = {
                        Text(text = stringResource(id = R.string.title),
                            fontStyle = FontStyle.Italic, color = Color.White,
                        textAlign = TextAlign.Center)
                    },
                    backgroundColor = Color.Blue
                )
                }
            }
        ) {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
                .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(painter = painterResource(id = R.drawable.coders),
                    contentDescription = null, modifier = Modifier.width(300.dp)
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = "About:",
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = stringResource(id = R.string.intro),
                    fontSize = 15.sp,
                    fontStyle = FontStyle.Normal,
                    textAlign = TextAlign.Justify
                )
            }
        }
    }