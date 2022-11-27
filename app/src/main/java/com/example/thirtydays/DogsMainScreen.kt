package com.example.thirtydays

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.thirtydays.model.Dog


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun DogsBreedContent(modifier: Modifier = Modifier,visibleState: MutableTransitionState<Boolean>) {
    AnimatedVisibility(
        visibleState = visibleState,
        enter = fadeIn(
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioLowBouncy
            )
        ),
        exit = fadeOut(

        ),
    ) {
        LazyColumn(modifier = modifier.fillMaxSize()) {
            itemsIndexed(DataRepository.dogs) { index: Int, dog: Dog ->
                DogItem(dog = dog, modifier =         Modifier .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )  .padding(horizontal = 10.dp, vertical = 7.dp))

            }
        }
    }
}


    @Composable
    fun DogItem(modifier: Modifier = Modifier, dog: Dog){
        var isImgVisible by remember { mutableStateOf(false) }

        //card elevation 8dp

        Card(
            elevation = CardDefaults.cardElevation(4.dp),
            modifier = modifier,

        ) {

                /*  modifier= modifier
                  .animateContentSize(
                      animationSpec = spring(
                          dampingRatio = Spring.DampingRatioMediumBouncy,
                          stiffness = Spring.StiffnessLow
                      )
                  ),
            )
             {
                 */
             Column(modifier = Modifier.background(MaterialTheme.colorScheme.surface).padding(10.dp)) {
                    Text(
                        text = stringResource(id = dog.day),
                        style = MaterialTheme.typography.titleLarge
                    )
                    Text(
                        text = stringResource(id = dog.breed),
                        style = MaterialTheme.typography.titleSmall,
                        modifier = Modifier.padding(bottom = 7.dp)
                    )
                    Box(modifier = Modifier.clip(RoundedCornerShape(11.dp))) {
                        Image(modifier = Modifier
                            .clickable { isImgVisible = !isImgVisible }
                            .fillMaxWidth(),
                            painter = painterResource(id = dog.image),
                            contentDescription = null,
                            contentScale = ContentScale.Crop)
                    }
                    if (isImgVisible)
                        Text(
                            text = stringResource(id = dog.summary),
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(vertical = 7.dp)
                        )

                }
            }

    }

