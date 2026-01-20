package com.example.myfirstgithub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myfirstgithub.ui.theme.MyFirstGithubTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyFirstGithubTheme {
                val navController = rememberNavController()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "home",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("home") { HomeScreen(navController) }
                        composable("student1") {
                             AljoScreen("Student 1", "Aljo, Stephanie", navController)
                        }
                        composable("student2") {
                            AmandyScreen("Student 2", "Maybe I know... maybe I don’t", navController)
                        }
                        composable("student3") {
                            AlmajedaScreen("Student 3", "Almajeda, Wesly R.", navController)
                        }
                        composable("student4") {
                            AlmonteScreen("Student 4", "Almonte, REnz Policarp", navController)
                        }
                        composable("student5") {
                            AmbatScreen("Student 5", "Ambat, Anthony", navController)
                        }
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

        val students = listOf("student1", "student2", "student3", "student4", "student5")

        students.forEachIndexed { index, route ->
            Button(
                onClick = { navController.navigate(route) },
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .padding(vertical = 5.dp)
            ) {
                Text("View Student ${index + 1}")
            }
        }
    }
}

@Composable
fun AljoScreen(
    name: String,
    bio: String,
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Back Button
        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.align(Alignment.Start)
        ) {
            Text("Back")
        }

        Spacer(modifier = Modifier.height(24.dp))

        Surface(
            modifier = Modifier.size(120.dp),
            shape = CircleShape,
            color = MaterialTheme.colorScheme.primaryContainer
        ) {
            Image(
                painter = painterResource(id = R.drawable.aljo),
                contentDescription = "Student Photo",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = name,
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = bio,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}


@Composable
fun AlmajedaScreen(
    name: String,
    bio: String,
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Back Button
        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.align(Alignment.Start)
        ) {
            Text("Back")
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Circular Image using Clip
        Surface(
            modifier = Modifier
                .size(150.dp) // Slightly larger for better visibility
                .clip(androidx.compose.foundation.shape.CircleShape),
            color = MaterialTheme.colorScheme.primaryContainer
        ) {
            Image(
                painter = painterResource(id = R.drawable.wesly),
                contentDescription = "Student Photo",
                contentScale = androidx.compose.ui.layout.ContentScale.Crop, // Ensures image fills the circle
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape) // Makes the image round
                    .border(3.dp, Color.LightGray, CircleShape) // Adds the green border
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Wesly Almajeda",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.primary
        )

        HorizontalDivider(modifier = Modifier.padding(vertical = 20.dp))

        // Organized Bio Section
        Column(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            BioRow(label = "Name:", value = bio) // Using the bio parameter for the full name
            BioRow(label = "Student no.:", value = "2300370")
            BioRow(label = "Program:", value = "BSIT")
            BioRow(label = "Year & section:", value = "3IT - A")
            BioRow(label = "Status:", value = "Irregular")
        }
    }
}

// Helper Composable to keep the alignment organized
@Composable
fun BioRow(label: String, value: String) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = label,
            modifier = Modifier.width(120.dp),
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun AmandyScreen(
    name: String,
    bio: String,
    navController: NavController
) {
    Box(modifier = Modifier.fillMaxSize()) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.king_bg),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alignment = Alignment.TopCenter,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            alpha = 0.7f
        )
        // Content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Back Button
            Button(
                onClick = { navController.popBackStack() }
            ) {
                Text("Back")
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Profile Header
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Surface(
                    modifier = Modifier.size(120.dp),
                    shape = CircleShape,
                    color = MaterialTheme.colorScheme.primaryContainer
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.king),
                        contentDescription = "Profile Photo",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "King Amandy",
                    color = Color(0xFFFFFFFF),
                    style = MaterialTheme.typography.headlineMedium
                )

                Text(
                    text = "Information Technology Student",
                    color = Color(0xFFFFFFFF),
                    style = MaterialTheme.typography.bodyMedium,

                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Action Buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick = { /* Message */ }) {
                    Text("Message")
                }
                OutlinedButton(onClick = { /* Follow */ }) {
                    Text("Follow")
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // About Section
            Text(
                text = "About",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = bio,
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Details Section
            Text(
                text = "Details",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Details rows
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Year", color = MaterialTheme.colorScheme.onSurfaceVariant)
                    Text("3rd Year")
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Interests", color = MaterialTheme.colorScheme.onSurfaceVariant)
                    Text("Android, Gaming, AI")
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Location", color = MaterialTheme.colorScheme.onSurfaceVariant)
                    Text("Probably indoors")
                }
            }
        }
    }
}


@Composable
fun AlmonteScreen(
    name: String,
    bio: String,
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Back Button
        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.align(Alignment.Start)
        ) {
            Text("Back")
        }

        Spacer(modifier = Modifier.height(24.dp))

        Surface(
            modifier = Modifier.size(120.dp),
            color = MaterialTheme.colorScheme.primaryContainer,
            shape = MaterialTheme.shapes.medium
        ) {
            Box(contentAlignment = Alignment.Center) {
                // Image
                Image(
                    painter = painterResource(id = R.drawable.renz),
                    contentDescription = "Student Photo",
                    modifier = Modifier.size(120.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text(text = name, style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = bio, style = MaterialTheme.typography.bodyLarge)
    }
}

@Composable
fun AmbatScreen(
    name: String,
    bio: String,
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Back Button
        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.align(Alignment.Start)
        ) {
            Text("Back")
        }

        Spacer(modifier = Modifier.height(24.dp))

        Surface(
            modifier = Modifier.size(120.dp),
            color = MaterialTheme.colorScheme.primaryContainer,
            shape = MaterialTheme.shapes.medium
        ) {
            Box(contentAlignment = Alignment.Center) {
                // Image
                Image(
                    painter = painterResource(id = R.drawable.ambat),
                    contentDescription = "Student Photo",
                    modifier = Modifier.size(120.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text(text = name, style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = bio, style = MaterialTheme.typography.bodyLarge)
    }
}

@Composable
fun StudentProfile5(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Back Button
        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.align(Alignment.Start)
        ) {
            Text("Back")
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Profile Image
        Surface(
            modifier = Modifier.size(120.dp),
            color = MaterialTheme.colorScheme.primaryContainer,
            shape = MaterialTheme.shapes.medium
        ) {
            Box(contentAlignment = Alignment.Center) {
                Image(
                    painter = painterResource(id = R.drawable.ambat),
                    contentDescription = "Student Photo",
                    modifier = Modifier.size(120.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Student Information
        Text(
            text = "Anthony C. Ambat",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Student No: 2300375",
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = "Program: BSIT",
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = "Year & Section: 3IT-A",
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = "Status: Irregular",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
