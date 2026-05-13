package com.example.raithavartha.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.raithavartha.data.model.Crop

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CropCategoryScreen(onBackClick: () -> Unit) {
    var searchQuery by remember { mutableStateOf("") }

    val crops = remember {
        listOf(
            Crop(1, "Tomato", "ಟೊಮ್ಯಾಟೊ", 
                listOf("Use drip irrigation.", "Add organic compost regularly."), 
                listOf("ಡ್ರಿಪ್ ನೀರಾವರಿ ಬಳಸಿ.", "ನಿಯಮಿತವಾಗಿ ಸಸ್ಯಜ ಗೊಬ್ಬರ ಹಾಕಿ."), ""),
            Crop(2, "Potato", "ಆಲೂಗಡ್ಡೆ", 
                listOf("Plant in well-drained soil.", "Check for blight diseases regularly."), 
                listOf("ಚೆನ್ನಾಗಿ ಬಸಿದು ಹೋಗುವ ಮಣ್ಣಿನಲ್ಲಿ ನೆಡಿ.", "ಮೋಡ ಕವಿದ ವಾತಾವರಣದಲ್ಲಿ ರೋಗಗಳ ಬಗ್ಗೆ ಎಚ್ಚರ."), ""),
            Crop(3, "Arecanut", "ಅಡಿಕೆ", 
                listOf("Maintain proper drainage system.", "Control root grubs effectively."), 
                listOf("ಸರಿಯಾದ ಬಸಿಕಾಲುವೆ ವ್ಯವಸ್ಥೆ ಮಾಡಿ.", "ಬೇರು ಹುಳುಗಳನ್ನು ನಿಯಂತ್ರಿಸಿ."), ""),
            Crop(4, "Coconut", "ತೆಂಗು", 
                listOf("Provide adequate potash fertilizers.", "Manage rhinoceros beetle infestation."), 
                listOf("ಪೊಟ್ಯಾಷ್ ಗೊಬ್ಬರವನ್ನು ಹೆಚ್ಚಾಗಿ ನೀಡಿ.", "ಕೆಂಪು ಮೂತಿ ಹುಳುಗಳನ್ನು ನಿಯಂತ್ರಿಸಿ."), ""),
            Crop(5, "Paddy", "ಭತ್ತ", 
                listOf("Maintain water level in the field.", "Use balanced nitrogen fertilizers."), 
                listOf("ಗದ್ದೆಯಲ್ಲಿ ನೀರಿನ ಮಟ್ಟವನ್ನು ಕಾಪಾಡಿ.", "ಸಾರಜನಕಯುಕ್ತ ಗೊಬ್ಬರಗಳನ್ನು ಬಳಸಿ."), ""),
            Crop(6, "Ragi", "ರಾಗಿ", 
                listOf("Ideal for dry land farming.", "Apply compost during sowing."), 
                listOf("ಖುಷ್ಕಿ ಜಮೀನು ಬೇಸಾಯಕ್ಕೆ ಉತ್ತಮ.", "ಬಿತ್ತನೆ ಸಮಯದಲ್ಲಿ ಕಂಪೋಸ್ಟ್ ಬಳಸಿ."), ""),
            Crop(7, "Maize", "ಮೆಕ್ಕೆಜೋಳ", 
                listOf("Ensure strict weed control.", "Provide timely irrigation."), 
                listOf("ಕಳೆ ನಿಯಂತ್ರಣ ಖಚಿತಪಡಿಸಿಕೊಳ್ಳಿ.", "ಸಮಯಕ್ಕೆ ಸರಿಯಾಗಿ ನೀರಾವರಿ ಒದಗಿಸಿ."), ""),
            Crop(8, "Onion", "ಈರುಳ್ಳಿ", 
                listOf("Use sulfur for better bulb quality.", "Avoid water logging in beds."), 
                listOf("ಉತ್ತಮ ಗುಣಮಟ್ಟಕ್ಕೆ ಗಂಧಕ ಬಳಸಿ.", "ನೀರು ನಿಲ್ಲದಂತೆ ಎಚ್ಚರವಹಿಸಿ."), ""),
            Crop(9, "Chilli", "ಮೆಣಸಿನಕಾಯಿ", 
                listOf("Control leaf curl virus through pests.", "Mulching is highly recommended."), 
                listOf("ಎಲೆ ಮುದುಡು ರೋಗ ನಿಯಂತ್ರಿಸಿ.", "ಹೊದಿಕೆ ಬೇಸಾಯ (Mulching) ಶಿಫಾರಸು ಮಾಡಲಾಗಿದೆ."), ""),
            Crop(10, "Sugarcane", "ಕಬ್ಬು", 
                listOf("Regular trash mulching for moisture.", "Efficient water management techniques."), 
                listOf("ಕಬ್ಬಿನ ರವದಿಯನ್ನು ಹೊದಿಕೆಯಾಗಿ ಬಳಸಿ.", "ದಕ್ಷ ನೀರಿನ ನಿರ್ವಹಣೆ ಮಾಡಿ."), ""),
            Crop(11, "Banana", "ಬಾಳೆ", 
                listOf("Provide wind protection for trees.", "De-suckering is essential for yield."), 
                listOf("ಗಾಳಿಯಿಂದ ರಕ್ಷಣೆ ನೀಡಿ.", "ಸಮಯಕ್ಕೆ ಸರಿಯಾಗಿ ಕಂದುಗಳನ್ನು ತೆಗೆಯಿರಿ."), ""),
            Crop(12, "Mango", "ಮಾವಿನ ಹಣ್ಣು", 
                listOf("Pruning for better canopy growth.", "Manage hopper pests during flowering."), 
                listOf("ಉತ್ತಮ ಇಳುವರಿಗೆ ಸವರುವಿಕೆ ಮಾಡಿ.", "ಜಿಗಿಹುಳುಗಳ ನಿಯಂತ್ರಣ ಮಾಡಿ."), ""),
            Crop(13, "Cotton", "ಹತ್ತಿ", 
                listOf("Integrated bollworm management.", "Maintain consistent soil moisture."), 
                listOf("ಕಾಯಿ ಕೊರಕದ ನಿಯಂತ್ರಣ ಮಾಡಿ.", "ಮಣ್ಣಿನ ತೇವಾಂಶ ಕಾಪಾಡಿಕೊಳ್ಳಿ."), ""),
            Crop(14, "Groundnut", "ನೆಲಗಡಲೆ", 
                listOf("Apply gypsum at pegging stage.", "Ensure loose soil for peg entry."), 
                listOf("ಕಾಯಿ ಕಟ್ಟುವ ಹಂತದಲ್ಲಿ ಜಿಪ್ಸಂ ಬಳಸಿ.", "ಮಣ್ಣು ಸಡಿಲವಾಗಿರುವಂತೆ ನೋಡಿಕೊಳ್ಳಿ."), ""),
            Crop(15, "Turmeric", "ಅರಿಶಿನ", 
                listOf("Use raised bed planting method.", "Timely earthing up for rhizomes."), 
                listOf("ಎತ್ತರಿಸಿದ ಪಾತಿಗಳನ್ನು ಬಳಸಿ.", "ಸಮಯಕ್ಕೆ ಸರಿಯಾಗಿ ಮಣ್ಣು ಏರಿಸುವಿಕೆ ಮಾಡಿ."), "")
        )
    }

    val filteredCrops = crops.filter {
        it.nameEn.contains(searchQuery, ignoreCase = true) || 
        it.nameKn.contains(searchQuery, ignoreCase = true)
    }

    Scaffold(
        topBar = {
            Column(modifier = Modifier.background(Color.White)) {
                TopAppBar(
                    title = { 
                        Text("Crop Categories", style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)) 
                    },
                    navigationIcon = {
                        IconButton(onClick = onBackClick) {
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.White,
                        titleContentColor = MaterialTheme.colorScheme.primary
                    )
                )
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    placeholder = { Text("Search Crops / ಬೆಳೆಗಳನ್ನು ಹುಡುಕಿ", color = Color.DarkGray) },
                    leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, tint = Color.Gray) },
                    shape = RoundedCornerShape(12.dp),
                    singleLine = true,
                    textStyle = TextStyle(color = Color.Black),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black,
                        focusedPlaceholderColor = Color.DarkGray,
                        unfocusedPlaceholderColor = Color.DarkGray,
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedBorderColor = MaterialTheme.colorScheme.primary,
                        unfocusedBorderColor = Color.LightGray
                    )
                )
            }
        }
    ) { paddingValues ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(1),
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color(0xFFF1F8F1)),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(filteredCrops) { crop ->
                CropDetailCard(crop)
            }
        }
    }
}

@Composable
fun CropDetailCard(crop: Crop) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text(
                text = crop.nameEn,
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold, color = Color.Black)
            )
            Text(
                text = crop.nameKn,
                style = MaterialTheme.typography.titleMedium.copy(color = MaterialTheme.colorScheme.primary)
            )
            
            Spacer(modifier = Modifier.height(12.dp))
            HorizontalDivider(color = Color.LightGray.copy(alpha = 0.5f))
            Spacer(modifier = Modifier.height(12.dp))
            
            Text(
                text = "English Suggestions:",
                style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold, color = Color.Black)
            )
            crop.suggestionsEn.forEach { suggestion ->
                Text(
                    text = "• $suggestion",
                    style = MaterialTheme.typography.bodyMedium.copy(color = Color.Black),
                    modifier = Modifier.padding(start = 8.dp, top = 2.dp)
                )
            }
            
            Spacer(modifier = Modifier.height(12.dp))
            
            Text(
                text = "Kannada Suggestions:",
                style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold, color = Color.Black)
            )
            crop.suggestionsKn.forEach { suggestion ->
                Text(
                    text = "• $suggestion",
                    style = MaterialTheme.typography.bodyMedium.copy(color = Color.Black),
                    modifier = Modifier.padding(start = 8.dp, top = 2.dp)
                )
            }
        }
    }
}
