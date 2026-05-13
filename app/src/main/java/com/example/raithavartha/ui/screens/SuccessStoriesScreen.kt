package com.example.raithavartha.ui.screens

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.raithavartha.data.model.SuccessStory
import com.example.raithavartha.ui.theme.RaithaVarthaTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuccessStoriesScreen(onBackClick: () -> Unit) {
    val stories = remember {
        listOf(
            SuccessStory(1, "Basavaraj Patil", "Tomato", "Dharwad", 
                "I used organic fertilizer and improved tomato yield successfully.", 
                "ನಾನು ಸಸ್ಯಜ ಗೊಬ್ಬರ ಬಳಸಿ ಟೊಮೇಟೊ ಉತ್ಪಾದನೆಯನ್ನು ಹೆಚ್ಚಿಸಿಕೊಂಡೆ.", 
                "https://images.pexels.com/photos/533280/pexels-photo-533280.jpeg"),
            SuccessStory(2, "Savitramma", "Paddy", "Mandya", 
                "System of Rice Intensification (SRI) helped me save water and increase grain weight.", 
                "ಶ್ರೀ (SRI) ಪದ್ಧತಿಯಿಂದ ನೀರು ಉಳಿತಾಯವಾಯಿತು ಮತ್ತು ಭತ್ತದ ಇಳುವರಿ ಹೆಚ್ಚಿತು.", 
                "https://images.unsplash.com/photo-1500937386664-56d1dfef3854?w=500&q=80"),
            SuccessStory(3, "Ramesh", "Maize", "Koppal",
                "Plant maize in well-drained loamy soil and ensure proper irrigation during the flowering stage to get a high yield.",
                "ಮೆಕ್ಕೆಜೋಳವನ್ನು ಉತ್ತಮ ನೀರು ಹೊರಹೋಗುವ ಲೋಮಿ ಮಣ್ಣಿನಲ್ಲಿ ಬೆಳೆಸಿ ಮತ್ತು ಹೂ ಬರುವ ಹಂತದಲ್ಲಿ ಸರಿಯಾದ ನೀರಾವರಿ ನೀಡಿ ಉತ್ತಮ ಇಳುವರಿ ಪಡೆಯಿರಿ.",
                "https://images.pexels.com/photos/547263/pexels-photo-547263.jpeg"),
            SuccessStory(4, "Ningappa", "Cotton", "Raichur", 
                "Integrated pest management reduced my expenses by 40%.", 
                "ಸಮಗ್ರ ಕೀಟ ನಿರ್ವಹಣೆಯಿಂದ ನನ್ನ ಖರ್ಚು ಶೇ.40 ರಷ್ಟು ಕಡಿಮೆಯಾಯಿತು.", 
                "https://images.unsplash.com/photo-1502395809857-fd80069897d0?q=80&w=1200&auto=format&fit=crop"),
            SuccessStory(5, "Lakshmi Devi", "Mango", "Kolar", 
                "Drip irrigation ensured survival of my mango orchard during drought.", 
                "ಹನಿ ನೀರಾವರಿ ಪದ್ಧತಿಯಿಂದ ಬರಗಾಲದಲ್ಲೂ ನನ್ನ ಮಾವಿನ ತೋಟ ಹಸಿರಾಗಿ ಉಳಿಯಿತು.", 
                "https://images.unsplash.com/photo-1553279768-865429fa0078?w=500&q=80"),
            SuccessStory(6, "Ramesh Hegde", "Turmeric", "Chamarajanagar", 
                "Scientific curing method improved the curcumin content and market price.", 
                "ವೈಜ್ಞಾನಿಕ ಸಂಸ್ಕರಣಾ ವಿಧಾನದಿಂದ ಅರಿಶಿನದ ಗುಣಮಟ್ಟ ಮತ್ತು ಬೆಲೆ ಉತ್ತಮಗೊಂಡಿತು.", 
                "https://images.pexels.com/photos/8184492/pexels-photo-8184492.jpeg"),
            SuccessStory(7, "Channappa", "Grapes", "Vijayapura", 
                "Export-quality grapes production became possible through expert guidance.", 
                "ತಜ್ಞರ ಮಾರ್ಗದರ್ಶನದಿಂದ ರಫ್ತು ಗುಣಮಟ್ಟದ ದ್ರಾಕ್ಷಿ ಬೆಳೆಯಲು ಸಾಧ್ಯವಾಯಿತು.", 
                "https://images.pexels.com/photos/708777/pexels-photo-708777.jpeg"),
            SuccessStory(8, "Anasuya", "Floriculture", "Hassan", 
                "Polyhouse farming of Gerbera is giving me consistent monthly income.", 
                "ಪಲಿಹೌಸ್‌ನಲ್ಲಿ ಜೆರ್ಬೆರಾ ಹೂವು ಬೆಳೆಸುತ್ತಿರುವುದು ತಿಂಗಳ ಸ್ಥಿರ ಆದಾಯಕ್ಕೆ ದಾರಿಯಾಗಿದೆ.", 
                "https://images.pexels.com/photos/931162/pexels-photo-931162.jpeg"),
            SuccessStory(9, "Mallappa", "Watermelon", "Bagalkot",
                "Proper disease management saved my pomegranate farm from wilt.", 
                "ಸರಿಯಾದ ರೋಗ ನಿರ್ವಹಣೆಯಿಂದ ಒಣ ಬೇರು ರೋಗದಿಂದ ದಾಳಿಂಬೆ ತೋಟವನ್ನು ಉಳಿಸಿಕೊಂಡೆ.", 
                "https://images.pexels.com/photos/2894205/pexels-photo-2894205.jpeg"),
            SuccessStory(10, "Siddaiah", "Dairy & Farming", "Tumakuru", 
                "Natural farming along with dairy is a highly sustainable model for me.", 
                "ನೈಸರ್ಗಿಕ ಕೃಷಿಯೊಂದಿಗೆ ಹೈನುಗಾರಿಕೆ ಮಾಡುವುದು ಲಾಭದಾಯಕ ಮತ್ತು ಸುಸ್ಥಿರವಾಗಿದೆ.", 
                "https://images.unsplash.com/photo-1500595046743-cd271d694d30?w=500&q=80")
        )
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Success Stories", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color(0xFFF1F8F1)),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(stories) { story ->
                StoryCard(story)
            }
        }
    }
}

@Composable
fun StoryCard(story: SuccessStory) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(),
        shape = RoundedCornerShape(24.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column {
            AsyncImage(
                model = story.imageUrl,
                contentDescription = story.farmerName,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
                    .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)),
                contentScale = ContentScale.Crop
            )
            
            Column(modifier = Modifier.padding(20.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = story.farmerName,
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.Black
                        )
                    )
                    Surface(
                        color = MaterialTheme.colorScheme.primaryContainer,
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = story.cropType,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                            style = MaterialTheme.typography.labelMedium.copy(
                                color = MaterialTheme.colorScheme.onPrimaryContainer,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                }
                
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = 4.dp)
                ) {
                    Icon(
                        Icons.Default.LocationOn,
                        contentDescription = null,
                        tint = Color.Gray,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = story.location,
                        style = MaterialTheme.typography.bodySmall.copy(color = Color.Gray)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))
                
                Text(
                    text = story.storyEn,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = Color.Black,
                        lineHeight = 22.sp,
                        fontWeight = FontWeight.Medium
                    )
                )
                
                Spacer(modifier = Modifier.height(12.dp))
                
                Text(
                    text = story.storyKn,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = Color.Black,
                        fontWeight = FontWeight.SemiBold,
                        lineHeight = 24.sp
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SuccessStoriesScreenPreview() {
    RaithaVarthaTheme {
        SuccessStoriesScreen(onBackClick = {})
    }
}
