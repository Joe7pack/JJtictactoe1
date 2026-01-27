package com.guzzardo.jjtictactoe1

/*
 * Copyright 2024 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteType
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.window.core.layout.WindowSizeClass.Companion.WIDTH_DP_EXPANDED_LOWER_BOUND
import jjtictactoe1.composeapp.generated.resources.Res
import jjtictactoe1.composeapp.generated.resources.homeicon
import jjtictactoe1.composeapp.generated.resources.shopping
import jjtictactoe1.composeapp.generated.resources.planets_array
import org.jetbrains.compose.resources.StringArrayResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

import androidx.compose.material3.Button
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.Saver
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import jjtictactoe1.composeapp.generated.resources.lib_circlecrossgreen
import org.jetbrains.compose.resources.InternalResourceApi
import org.jetbrains.compose.resources.getStringArray
import org.jetbrains.compose.ui.tooling.preview.Preview

//class SampleNavigationSuiteScaffold { }

/* enum class AppDestinations(
    @StringRes val label: String,
    val icon: ImageVector,
    @StringRes val contentDescription: Int
) {
    //HOME(R.string.home, Icons.Default.Home, R.string.home),
    HOME(stringResource(Res.string.home), Icons.Default.Home, R.string.home),
    FAVORITES(R.string.favorites, Icons.Default.Favorite, R.string.favorites),
    SHOPPING(R.string.shopping, Icons.Default.ShoppingCart, R.string.shopping),
    PROFILE(R.string.profile, Icons.Default.AccountBox, R.string.profile),
}
 */


//var planetList = Res.array.planets_array.key

@Composable
fun Icons() {
    Icon(
        painter = painterResource(Res.drawable.homeicon),
        contentDescription = stringResource( Res.string.shopping)
    )
}

// replace AppDestinations.entries.forEach with planetList.forEach
/*
@Composable
fun planets(): StringArrayResource /* stringArrayResource List<String> */ {
    planetList  = Res.array.planets_array
    return planetList
} */

// 1. Define a custom Saver for StringArrayResource
@OptIn(InternalResourceApi::class)
val StringArrayResourceSaver = Saver<StringArrayResource, String>(
    save = { it.toString() //resource ->
        // When saving, convert the resource object into its integer ID
        //Res. .id
        //Res.array.planets_array
        //planetList2.
    },
    restore = { id ->
        // When restoring, create a new StringArrayResource object from the saved ID
        StringArrayResource(
            TODO(),
            key = TODO(),
            items = TODO()
        )
    }
)

// 2. Use the saver with rememberSaveable()
//@OptIn(InternalResourceApi::class)
@Composable
fun MyScreen2() {
    val planetList = Res.array.planets_array
    // Example resource ID (replace with your actual R.array.my_array_name)
    //val defaultResourceId = Res.array.planets_array //R.array.my_array_name

    var selectedResource by remember() {
        //mutableStateOf(StringArrayResource(defaultResourceId))
        mutableStateOf(planetList)
    }

    // You can now use selectedResource safely across process deaths
    //val arrayValues = getStringArray(resource = selectedResource)
    // ... UI code using arrayValues ...
}

@Preview
@Composable
fun TestFun(menuString: String) {

    /*
    Row() {
        //Text(text = menuString)
        KmpCanvasExample()
    }
     */

    Row() {
        //SampleNavigationSuiteScaffoldParts()
        TestImage2(this)
        MyScreen()
    }
}

@Composable
fun ClickableRowExample(menuString: String) {
    // 1. Define a mutable state for the text
    var displayedText by remember { mutableStateOf(menuString) }

    // 2. Create the Row and apply the clickable modifier
    Row(
        modifier = Modifier
            .clickable(onClick = {

                // Inside the onClick lambda, update the state variable
                displayedText = "The text has been modified!"
                //KmpCanvasExample()
            })
    ) {
        // 3. Use the state variable in the Text composable
        Text(text = displayedText)
    }
}

@Composable
fun KmpCanvasExample() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        // Draw a red line from the top-left to the bottom-right corner
        drawLine(
            color = Color.Red,
            start = Offset(x = 0f, y = 0f),
            end = Offset(x = size.width, y = size.height),
            strokeWidth = 4f
        )

        // Draw a blue rectangle in the center of the canvas
        val rectSize = Size(200f, 100f)
        val topLeftOffset = Offset(
            x = (size.width - rectSize.width) / 2f,
            y = (size.height - rectSize.height) / 2f
        )
        drawRect(
            color = Color.Blue,
            topLeft = topLeftOffset,
            size = rectSize
        )
    }
}


@Composable
fun SampleNavigationSuiteScaffoldParts() {
    // [START android_compose_adaptivelayouts_sample_navigation_suite_scaffold_remember]
    //var currentDestination by rememberSaveable { mutableStateOf(AppDestinations.HOME) }
    //var currentDestination by rememberSaveable { mutableStateOf(planetList) }
    // [END android_compose_adaptivelayouts_sample_navigation_suite_scaffold_remember]

    // [START android_compose_adaptivelayouts_sample_navigation_suite_scaffold_items]

    /*
    NavigationSuiteScaffold(
        navigationSuiteItems = {
                //AppDestinations.entries.forEach {
                arrayOf(planetList).forEach { planet ->
                    item(
                        icon = {
                            Icon(
                                painter = painterResource(Res.drawable.homeicon),
                                contentDescription = stringResource(Res.string.shopping)
                            )
                        },
                        label = { Text(stringResource(Res.string.shopping)) },
                        selected = true, //currentDestination,
                        onClick = { currentDestination }
                    )
                }
            }
        ) {
            // TODO: Destination content.
        }

     */


    // [END android_compose_adaptivelayouts_sample_navigation_suite_scaffold_items]

    // [START android_compose_adaptivelayouts_sample_navigation_suite_scaffold_content]
    NavigationSuiteScaffold(
        navigationSuiteItems = { /*...*/ }
    ) {
        HomeDestination()
        // Destination content.
        /*
    when (currentDestination) {
        AppDestinations.HOME -> HomeDestination()
        AppDestinations.FAVORITES -> FavoritesDestination()
        AppDestinations.SHOPPING -> ShoppingDestination()
        AppDestinations.PROFILE -> ProfileDestination()
    } */
    }
    // [END android_compose_adaptivelayouts_sample_navigation_suite_scaffold_content]
}

@Composable
fun HomeDestinationX() {
    TODO("Not yet implemented")
}


@Composable
fun SampleNavigationSuiteScaffoldCustomType() {
    // [START android_compose_adaptivelayouts_sample_navigation_suite_scaffold_layout_type]
    val adaptiveInfo = currentWindowAdaptiveInfo()
    val customNavSuiteType = with(adaptiveInfo) {
        if (windowSizeClass.isWidthAtLeastBreakpoint(WIDTH_DP_EXPANDED_LOWER_BOUND)) {
            NavigationSuiteType.NavigationDrawer
        } else {
            NavigationSuiteScaffoldDefaults.calculateFromAdaptiveInfo(adaptiveInfo)
        }
    }

    NavigationSuiteScaffold(
        navigationSuiteItems = { /* ... */ },
        layoutType = customNavSuiteType,
    ) {
        // Content...
    }
    // [END android_compose_adaptivelayouts_sample_navigation_suite_scaffold_layout_type]
}

@Composable
fun HomeDestination() {
    Button(onClick = { /* Do something when clicked */ }) {
        Icon(
            painter = painterResource(Res.drawable.lib_circlecrossgreen),
            contentDescription = stringResource(Res.string.shopping)
        )


        // Add a space between the icon and the text

        Text("Add Item")
    }


}

@Composable
fun FavoritesDestination() {
}

@Composable
fun ShoppingDestination() {
}

@Composable
fun ProfileDestination() {
}