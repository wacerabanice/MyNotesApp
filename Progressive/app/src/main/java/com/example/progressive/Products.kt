package com.example.progressive

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.progressive.ui.theme.ProgressiveTheme

class Products : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            BrowseProducts()
        }
    }
}



@Preview(showBackground = true)
@Composable

fun BrowseProducts() {

    Column(
        modifier = Modifier
            .background(Color.Cyan)
            .fillMaxSize()
            .padding(20.dp)

    ) {
        Row{
            Text(text = "Your Morning Routine Products" )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row {

            Column {
                Text(text = "Toner")
                Image(
                    painter = painterResource(id = R.drawable.toner),
                    contentDescription = null,
                    modifier = Modifier
                        .size(150.dp)
                )
                Text(text = "Kes 2,300")
                Spacer(modifier = Modifier.height(10.dp))

                val cart = LocalContext.current
                TextButton(
                    onClick = {
                        cart.startActivity(Intent(cart, Cart::class.java))

                    },
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(Color.Gray),

                    modifier = Modifier
                        .size(100.dp, 50.dp)

                ) {
                    Text(text = "Drop in Cart")
                }
            }


                Spacer(modifier = Modifier.height(20.dp))

                Column {
                    Text(text = "Sunscreen")
                    Image(
                        painter = painterResource(id = R.drawable.sunscreen),
                        contentDescription = null,
                        modifier = Modifier
                            .size(150.dp)
                    )
                    Text(text = "Kes 2,500")
                    Spacer(modifier = Modifier.height(10.dp))

                    val cart = LocalContext.current
                    TextButton(
                        onClick = {
                            cart.startActivity(Intent(cart, Cart::class.java))

                        },
                        shape = RectangleShape,
                        colors = ButtonDefaults.buttonColors(Color.Gray),

                        modifier = Modifier
                            .size(100.dp, 50.dp)

                    ) {
                        Text(text = "Drop in Cart")
                    }
                }
            }

        Spacer(modifier = Modifier.height(10.dp))

        Row {
            Column {
                Text(text = "Korean Toner")
                Image(
                    painter = painterResource(id = R.drawable.koreantoner),
                    contentDescription = null,
                    modifier = Modifier
                        .size(150.dp)
                )
                Text(text = "Kes 3,300")
                Spacer(modifier = Modifier.height(10.dp))

                val cart = LocalContext.current
                TextButton(onClick = {
                    cart.startActivity(Intent(cart, Cart:: class.java))

                },
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(Color.Gray),

                    modifier = Modifier
                        .size(100.dp, 50.dp)

                ) {
                    Text(text = "Drop in Cart")
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Column {
                Text(text = "Vitamin C")

                Image(
                    painter = painterResource(id = R.drawable.vitaminc),
                    contentDescription = null,
                    modifier = Modifier
                        .size(150.dp)

                )
                Text(text = "Kes 3,200")
                Spacer(modifier = Modifier.height(10.dp))

                val cart = LocalContext.current
                TextButton(onClick = {
                    cart.startActivity(Intent(cart, Cart:: class.java))

                },
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(Color.Gray),

                    modifier = Modifier
                        .size( 100.dp,50.dp)

                ) {
                    Text(text = "Drop in Cart")
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
            Row {

                Column {
                    Text(text = "Night Cream")
                    Image(
                        painter = painterResource(id = R.drawable.nightcream),
                        contentDescription = null,
                        modifier = Modifier
                            .size(150.dp)
                    )
                    Text(text = "Kes 3,000")
                    Spacer(modifier = Modifier.height(10.dp))

                    val cart = LocalContext.current
                    TextButton(onClick = {
                        cart.startActivity(Intent(cart, Cart:: class.java))

                    },
                        shape = RectangleShape,
                        colors = ButtonDefaults.buttonColors(Color.Gray),

                        modifier = Modifier
                            .size(100.dp, 50.dp)

                    ) {
                        Text(text = "Drop in Cart")
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                Column {
                    Text(text = "Scrub")
                    Image(
                        painter = painterResource(id = R.drawable.scrub),
                        contentDescription = null,
                        modifier = Modifier
                            .size(150.dp)
                    )
                    Text(text = "Kes 2,000")
                    Spacer(modifier = Modifier.height(10.dp))

                    val cart = LocalContext.current
                    TextButton(onClick = {
                        cart.startActivity(Intent(cart, Cart:: class.java))

                    },
                        shape = RectangleShape,
                        colors = ButtonDefaults.buttonColors(Color.Gray),

                        modifier = Modifier
                            .size(100.dp, 50.dp)

                    ) {
                        Text(text = "Drop in Cart")
                    }
                }
            }









    }

    }























