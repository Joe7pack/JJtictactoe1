package com.guzzardo.jjtictactoe1

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.jetbrains.compose.resources.StringArrayResource
import jjtictactoe1.composeapp.generated.resources.Res // Generated resource class
import jjtictactoe1.composeapp.generated.resources.planets_array

//class MyViewModel { }

open class MyViewModel : ViewModel() {
    // Initial state points to a specific generated StringArrayResource
    private val _currentArray = MutableStateFlow<StringArrayResource>(Res.array.planets_array)
    val currentArray = _currentArray.asStateFlow()

    /* fun updateArray(useSecondArray: Boolean) {
        _currentArray.value =
            if (useSecondArray) Res.array.my_array_two else Res.array.planets_array
    } */
}

// ViewModelFactory that retrieves the data repository for your app.
// per Android official website - If the ViewModel takes no dependencies or just the SavedStateHandle type as a dependency,
// you don't need to provide a factory for the framework to instantiate instances of that ViewModel type.

