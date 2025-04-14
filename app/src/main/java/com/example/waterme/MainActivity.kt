package com.example.waterme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.waterme.ui.theme.WaterMeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WaterMeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    PlantListScreen(navController = navController)
                }
            }
        }
    }
}

@Composable
fun PlantListScreen(navController: NavController) {
    val plants = listOf("Cây Xương Rồng", "Cây Trầu Bà", "Cây Sen Đá")
    LazyColumn {
        items(plants) { plant ->
            Text(
                text = plant,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { navController.navigate("reminder/$plant") }
                    .padding(16.dp)
            )
        }
    }
}
