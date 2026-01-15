package com.example.myfirstgithub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myfirstgithub.ui.theme.MyFirstGithubTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyFirstGithubTheme {
                // The NavController keeps track of which screen we are on
                val navController = rememberNavController()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // The NavHost defines all the "pages" in your app
                    NavHost(
                        navController = navController,
                        startDestination = "home",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("home") { HomeScreen(navController) }
                        composable("student1") { StudentProfile(name = "Student 1", bio = "Tep") }
                        composable("student2") { StudentProfile(name = "Student 2", bio = "King") }
                        composable("student3") { StudentProfile(name = "Student 3", bio = "Wes") }
                        composable("student4") { StudentProfile(name = "Student 4", bio = "Renz") }
                        composable("student4") { StudentProfile(name = "Student 5", bio = "Ambat") }
                    }
                }
            }
        }
    }
}

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "The Dream Team", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(24.dp))

        // Create a button for each student
        val students = listOf("student1", "student2", "student3", "student4", "student5")

        students.forEachIndexed { index, route ->
            Button(
                onClick = { navController.navigate(route) },
                modifier = Modifier.fillMaxWidth(0.7f).padding(vertical = 4.dp)
            ) {
                Text("View Student ${index + 1}")
            }
        }
    }
}

@Composable
fun StudentProfile(name: String, bio: String) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Placeholder for Photo
        Surface(
            modifier = Modifier.size(120.dp),
            color = MaterialTheme.colorScheme.primaryContainer,
            shape = MaterialTheme.shapes.medium
        ) {
            Box(contentAlignment = Alignment.Center) {
                Text("Photo")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text(text = name, style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = bio, style = MaterialTheme.typography.bodyLarge)
    }
}