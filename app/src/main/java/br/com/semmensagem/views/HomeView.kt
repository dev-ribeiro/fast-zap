package br.com.semmensagem.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.semmensagem.ui.theme.CONTAINER_GAP
import br.com.semmensagem.ui.theme.Gray100
import br.com.semmensagem.ui.theme.Green600
import br.com.semmensagem.ui.theme.ROW_GAP

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView() {
    val MAX_SIZE_DDD = 2
    val MAX_SIZE_PHONE = 9

    var ddd by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }

    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(
                    text = "SEM CONTATO", fontSize = 16.sp, color = Color.White
                )
            }, colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Green600
            )
        )
    }) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding).padding(12.dp, 0.dp),
            verticalArrangement = Arrangement.spacedBy(CONTAINER_GAP)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(ROW_GAP)
            ) {
                OutlinedTextField(
                    label = {
                        Text(
                            text = "DDD", color = Color.Black
                        )
                    },
                    value = ddd,
                    onValueChange = { if (it.length <= MAX_SIZE_DDD) ddd = it },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = Color.Black, focusedBorderColor = Color.Black
                    ),
                    modifier = Modifier.width(100.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
                )

                OutlinedTextField(
                    label = {
                        Text(
                            text = "WhatsApp", color = Color.Black
                        )
                    },
                    value = phoneNumber,
                    onValueChange = { if (it.length <= MAX_SIZE_PHONE) phoneNumber = it },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = Color.Black, focusedBorderColor = Color.Black
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
                )
            }

            Button(
                onClick = {}, colors = ButtonDefaults.buttonColors(
                    containerColor = Green600
                ), modifier = Modifier.fillMaxWidth()
            ) {
                Text("ENVIAR MENSAGEM")
            }

        }
    }
}