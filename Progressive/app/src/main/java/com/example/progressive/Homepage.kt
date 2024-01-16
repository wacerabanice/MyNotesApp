package com.example.progressive

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.progressive.ui.theme.ProgressiveTheme
import org.w3c.dom.Text

class Homepage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Home()
        }
    }
}

@Preview
@Composable

fun Home(){

Column (
    modifier = Modifier
        .background(Color.Cyan)
        .fillMaxSize()
        .padding(20.dp)

) {

    LazyColumn {

        item {
            Row {
                Text(text = "Your Morning Routine Products")
            }


        Spacer(modifier = Modifier.height(10.dp))


        Row {

            Image(painter = painterResource(id = R.drawable.toner),
                contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .border(1.dp, Color.Gray)
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row {

            Image(painter = painterResource(id = R.drawable.sunscreen),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .border(1.dp, Color.Gray)
            )


        }

        Spacer(modifier = Modifier.height(10.dp))

        Row {

            Image(painter = painterResource(id = R.drawable.vitaminc),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .border(1.dp, Color.Gray)
            )


        }


    Spacer(modifier = Modifier.height(10.dp))

    Column(
        verticalArrangement = Arrangement.Top
    ) {


        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(text = "Your Night Routine Products")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row {

            Image(
                painter = painterResource(id = R.drawable.scrub),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .border(1.dp, Color.Gray)
            )


        }

        Spacer(modifier = Modifier.height(10.dp))

        Row {
            Image(
                painter = painterResource(id = R.drawable.koreantoner),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .border(1.dp, Color.Gray)
            )

        }

        Spacer(modifier = Modifier.height(10.dp))

        Row {
            Image(
                painter = painterResource(id = R.drawable.nightcream),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .border(1.dp, Color.Gray)
            )
        }
    }
    }
    }
}

}





