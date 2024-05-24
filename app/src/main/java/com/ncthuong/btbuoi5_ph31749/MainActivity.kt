package com.ncthuong.btbuoi5_ph31749

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            previewMainActivity()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun previewMainActivity() {
    Box(
        modifier = Modifier
            .background(Color(0xFF252121))
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "Địa chỉ nhận hàng",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Start)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = rememberImagePainter(data = R.drawable.vitri),
                    contentDescription = null,
                    modifier = Modifier.size(50.dp)
                )

                Column(modifier = Modifier.weight(1f)) {
                    Text(text = "Tri | 2222222", color = Color.White)
                    Text(
                        text = "22/333 đường Trung Mỹ Tây 1",
                        color = Color.White
                    )
                    Text(
                        text = "phường Tân Thới Nhất",
                        color = Color.White
                    )
                    Text(
                        text = "quận 12, thành phố Hồ Chí Minh",
                        color = Color.White
                    )
                }
            }

            Text(
                text = "Vui lòng chọn 1 trong những phương thức sau:",
                color = Color.White,
                fontSize = 16.sp,
                modifier = Modifier.align(Alignment.Start)
            )

            val paymentMethods = listOf(
                Triple(Color.Blue, "Paypal", R.drawable.paypal),
                Triple(Color.Red, "Visa", R.drawable.visa_icon),
                Triple(Color.Magenta, "Momo", R.drawable.momo_icon),
                Triple(Color.Cyan, "ZaloPay", R.drawable.zalopay_icon),
                Triple(Color.Green, "COD", R.drawable.cod_icon)
            )

            paymentMethods.forEach { (color, text, image) ->
                PaymentOption(color = color, text = text, image = image)
            }

            Button(
                onClick = { /* Handle payment */ },
                modifier = Modifier
                    .background(Color(0xFFFF734C))
                    .fillMaxWidth()
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF734C)
                )
            ) {
                Text(
                    text = "Thanh toán",
                    color = Color.White,
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Composable
fun PaymentOption(color: Color, text: String, image: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(8.dp)
            .background(
                color = color,
                shape = RoundedCornerShape(10.dp)
            )
            .height(70.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = rememberImagePainter(data = image),
            contentDescription = null,
            modifier = Modifier.size(50.dp)
        )

        Text(
            text = text,
            color = Color.White,
            modifier = Modifier.weight(1f)
        )

        RadioButton(
            selected = false,
            onClick = { /* Handle selection */ }
        )
    }
}
