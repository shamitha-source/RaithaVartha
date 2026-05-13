package com.example.raithavartha.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Psychology
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.raithavartha.data.model.FarmingTip
import com.example.raithavartha.ui.components.TipCard
import com.example.raithavartha.ui.theme.RaithaVarthaTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onCropCategoryClick: () -> Unit,
    onSuccessStoriesClick: () -> Unit,
    onExpertAskClick: () -> Unit
) {
    val farmingTips = listOf(
        FarmingTip(1, "Spray neem water on leaves to prevent pests.", "ಕೀಟಗಳನ್ನು ತಡೆಯಲು ಎಲೆಗಳ ಮೇಲೆ ಬೇವು ನೀರನ್ನು ಸಿಂಪಡಿಸಿ.", "https://images.unsplash.com/photo-1515150144380-bca9f1650ed9?q=80&w=1200&auto=format&fit=crop&utm_source=chatgpt.com"),
        FarmingTip(2, "Water plants in the morning or evening.", "ಬೆಳಿಗ್ಗೆ ಅಥವಾ ಸಂಜೆ ಗಿಡಗಳಿಗೆ ನೀರು ಹಾಕಿ.", "https://images.pexels.com/photos/2132250/pexels-photo-2132250.jpeg?utm_source=chatgpt.com"),
        FarmingTip(3, "Avoid watering during afternoon heat.", "ಮಧ್ಯಾಹ್ನ ಬಿಸಿಲಿನಲ್ಲಿ ನೀರು ಹಾಕುವುದನ್ನು ತಪ್ಪಿಸಿ.", "https://images.pexels.com/photos/325944/pexels-photo-325944.jpeg"),
        FarmingTip(4, "Use organic fertilizers for better soil health.", "ಉತ್ತಮ ಮಣ್ಣಿನ ಆರೋಗ್ಯಕ್ಕಾಗಿ ಸಸ್ಯಜ ಗೊಬ್ಬರ ಬಳಸಿ.", "https://images.pexels.com/photos/1301856/pexels-photo-1301856.jpeg?utm_source=chatgpt.com"),
        FarmingTip(5, "Remove weeds regularly for healthy crop growth.", "ಬೆಳೆ ಉತ್ತಮವಾಗಿ ಬೆಳೆಯಲು ಕಳೆಗಳನ್ನು ತೆಗೆದುಹಾಕಿ.", "https://images.pexels.com/photos/4503261/pexels-photo-4503261.jpeg?utm_source=chatgpt.com"),
        FarmingTip(6, "Use drip irrigation to save water.", "ನೀರನ್ನು ಉಳಿಸಲು ಡ್ರಿಪ್ ನೀರಾವರಿ ಬಳಸಿ.", "https://live.staticflickr.com/3134/2552390830_ff35860aa0_o.jpg"),
        FarmingTip(7, "Rotate crops to maintain soil nutrients.", "ಮಣ್ಣಿನ ಪೋಷಕಾಂಶ ಕಾಪಾಡಲು ಬೆಳೆ ಪರಿವರ್ತನೆ ಮಾಡಿ.", "https://images.unsplash.com/photo-1500382017468-9049fed747ef?w=800&q=80"),
        FarmingTip(8, "Use healthy seeds for better yield.", "ಉತ್ತಮ ಉತ್ಪಾದನೆಗೆ ಉತ್ತಮ ಬೀಜ ಬಳಸಿ.", "https://images.unsplash.com/photo-1530507629858-e4977d30e9e0?w=800&q=80"),
        FarmingTip(9, "Check crops regularly for diseases.", "ರೋಗಗಳಿಗಾಗಿ ಬೆಳೆಗಳನ್ನು ನಿಯಮಿತವಾಗಿ ಪರಿಶೀಲಿಸಿ.", "https://images.unsplash.com/photo-1592924357228-91a4daadcfea?w=800&q=80"),
        FarmingTip(10, "Store harvested crops in dry places.", "ಕೊಯ್ಲಾದ ಬೆಳೆಗಳನ್ನು ಒಣ ಸ್ಥಳದಲ್ಲಿ ಸಂಗ್ರಹಿಸಿ.", "https://images.pexels.com/photos/2252584/pexels-photo-2252584.jpeg?utm_source=chatgpt.com")
    )

    val pagerState = rememberPagerState(pageCount = { farmingTips.size })
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "Raitha Vartha",
                            style = MaterialTheme.typography.headlineSmall.copy(
                                fontWeight = FontWeight.ExtraBold,
                                color = MaterialTheme.colorScheme.primary
                            )
                        )
                        Text(
                            text = "ರೈತ ವಾರ್ತೆ",
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.White
                )
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = onExpertAskClick,
                icon = { Icon(Icons.Default.Psychology, contentDescription = null) },
                text = { Text("Ask AI Expert") },
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = Color.White
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color(0xFFF8FBF8))
                .verticalScroll(rememberScrollState())
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                CategoryButton(
                    text = "Crop Category",
                    onClick = onCropCategoryClick,
                    modifier = Modifier.weight(1f)
                )
                CategoryButton(
                    text = "Success Stories",
                    onClick = onSuccessStoriesClick,
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Daily Farming Tips",
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                ),
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                HorizontalPager(
                    state = pagerState,
                    modifier = Modifier.fillMaxWidth(),
                    contentPadding = PaddingValues(horizontal = 32.dp),
                    pageSpacing = 16.dp
                ) { page ->
                    TipCard(tip = farmingTips[page])
                }

                if (pagerState.currentPage > 0) {
                    IconButton(
                        onClick = {
                            scope.launch {
                                pagerState.animateScrollToPage(pagerState.currentPage - 1)
                            }
                        },
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .padding(start = 4.dp)
                            .background(Color.White.copy(alpha = 0.8f), CircleShape)
                            .size(40.dp)
                    ) {
                        Icon(
                            Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                            contentDescription = "Previous",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }

                if (pagerState.currentPage < farmingTips.size - 1) {
                    IconButton(
                        onClick = {
                            scope.launch {
                                pagerState.animateScrollToPage(pagerState.currentPage + 1)
                            }
                        },
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .padding(end = 4.dp)
                            .background(Color.White.copy(alpha = 0.8f), CircleShape)
                            .size(40.dp)
                    ) {
                        Icon(
                            Icons.AutoMirrored.Filled.KeyboardArrowRight,
                            contentDescription = "Next",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(80.dp))
        }
    }
}

@Composable
fun CategoryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier.height(56.dp),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
        ),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp)
    ) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.labelLarge.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    RaithaVarthaTheme {
        HomeScreen(onCropCategoryClick = {}, onSuccessStoriesClick = {}, onExpertAskClick = {})
    }
}
