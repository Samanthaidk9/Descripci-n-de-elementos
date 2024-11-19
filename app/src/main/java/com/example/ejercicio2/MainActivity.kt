package com.example.ejercicio2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ejemplos()
        }
    }
}

@Composable
fun Ejemplos() {
    var texto by remember { mutableStateOf("") }
    var isChecked by remember { mutableStateOf(false) }
    var switchChecked by remember { mutableStateOf(false) }
    var sliderPosition by remember { mutableStateOf(0f) }
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf(1) }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { // }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Añadir"
                )
            }
        }
    ) { paddingValues ->
        Surface(
            modifier = Modifier.padding(paddingValues)
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(17.dp)
            ) {
                item {
                    Text(text = "Ejemplo de texto")
                    Spacer(modifier = Modifier.height(8.dp))

                    Button(
                        onClick = {mostrarMensaje = true}
                    ) {
                        Text("Haga click")
                    }
                    if (mostrarMensaje){
                     Spacer(modifier = Modifier.height(8.dp))
                     Text("Has pulsado el boton.")

                    }                    }
                    Spacer(modifier = Modifier.height(8.dp))

                    TextField(
                        value = texto,
                        onValueChange = { texto = it },
                        label = { Text("Ejemplo del elemento TextField") }
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Image(
                        painter = painterResource(id = programacion.jpg),
                        contentDescription = "Ejemplo de Image",
                        modifier = Modifier.size(100.dp)
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Box {
                        Button(onClick = { expanded = true }) {
                            Text("Menu")
                        }
                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false }
                        ) {
                            DropdownMenuItem(
                                text = { Text("Primera Opcion") },
                                onClick = { expanded = false }
                            )
                            DropdownMenuItem(
                                text = { Text("Segunda Opcion") },
                                onClick = { expanded = false }
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(
                            checked = isChecked,
                            onCheckedChange = { isChecked = it }
                        )
                        Text("Ejemplo de Checkbox")
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Switch(
                            checked = switchChecked,
                            onCheckedChange = { switchChecked = it }
                        )
                        Text("Ejemplo de Switch")
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Column {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = selectedOption == 1,
                                onClick = { selectedOption = 1 }
                            )
                            Text("Primera opcion")
                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = selectedOption == 2,
                                onClick = { selectedOption = 2 }
                            )
                            Text("Segunda opcion")
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Slider(
                        value = sliderPosition,
                        onValueChange = { sliderPosition = it }
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text("Contenido")
                            Text("Contenido 2")
                        }
                    }
                }
            }
        }
    }
}