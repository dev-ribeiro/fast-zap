package br.com.semmensagem.views

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.semmensagem.R
import br.com.semmensagem.ui.theme.CONTAINER_GAP
import br.com.semmensagem.ui.theme.Green600
import br.com.semmensagem.ui.theme.ROW_GAP

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView() {
    val ctx = LocalContext.current

    val MAX_SIZE_DDD = 2
    val MAX_SIZE_PHONE = 9
    val MAX_SIZE_BODY = 200

    var ddd by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var body by remember { mutableStateOf("") }

    val sheetState = rememberModalBottomSheetState()
    var isOpeningBottomSheetModal by remember { mutableStateOf(false) }

    fun handlerOpenBottomSheetModal() {
        if (ddd.length != 2) {
            Toast.makeText(ctx, "DDD Inválido", Toast.LENGTH_SHORT).show()
            return
        }

        if (phoneNumber.length != 9) {
            Toast.makeText(ctx, "Celular Inválido", Toast.LENGTH_SHORT).show()
            return
        }

        isOpeningBottomSheetModal = true
    }

    Scaffold(topBar = {
        TopAppBar(
            title = {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "FAST ZAP",
                        fontSize = 18.sp,
                        color = Color.White,
                    )
                }
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

            OutlinedTextField(
                label = {
                    Text(
                        text = "Texto (opcional)", color = Color.Black
                    )
                },
                value = body,
                onValueChange = { if (it.length <= MAX_SIZE_BODY) body = it },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.Black, focusedBorderColor = Color.Black
                ),
                modifier = Modifier.fillMaxWidth().height(200.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
            )

            Button(
                onClick = { handlerOpenBottomSheetModal() },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Green600
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("ENVIAR MENSAGEM")
            }

            if (isOpeningBottomSheetModal) {
                ModalBottomSheet(
                    sheetState = sheetState,
                    onDismissRequest = { isOpeningBottomSheetModal = false },
                ) {
                    Row(
                        modifier = Modifier.padding(bottom = 100.dp, start = 12.dp).fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(36.dp)
                    ) {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(4.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.whatsapp),
                                contentDescription = "Créditos: Freepick",
                                modifier = Modifier.width(50.dp)
                            )

                            Text("WhatsApp")
                        }

                        Column(
                            verticalArrangement = Arrangement.spacedBy(4.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.whatsapp_business),
                                contentDescription = "Créditos: Freepick",
                                modifier = Modifier.width(50.dp)
                            )

                            Text("Business")
                        }
                    }
                }
            }
        }
    }
}