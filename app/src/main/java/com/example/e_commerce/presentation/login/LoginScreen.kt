package com.example.e_commerce.presentation.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.e_commerce.R
import com.example.e_commerce.utils.isValidEmail
import androidx.compose.material3.LocalTextStyle
import androidx.compose.foundation.clickable

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onNavigateToRegister: () -> Unit = {}
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .systemBarsPadding()
            .padding(horizontal = 24.dp)
            .verticalScroll(rememberScrollState())) {
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Login to your account",
            color = Color(0xFF1A1A1A),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "It's great to see you again.",
            color = Color(0xFF808080),
            fontSize = 15.sp
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Email",
            color = Color(0xFF1A1A1A),
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            placeholder = {
                Text(
                    text = "Enter your email address",
                    color = Color(0xFFAAAAAA),
                    fontSize = 15.sp
                )
            },
            trailingIcon = {
                if (email.isNotEmpty()) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = null,
                        tint = Color(0xFF4CAF50),
                        modifier = Modifier.size(20.dp)
                    )
                }
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedBorderColor = if (isValidEmail(email)) Color(0xFF4CAF50) else Color(
                    0xFFE0E0E0
                ),
                unfocusedBorderColor = if (isValidEmail(email)) Color(0xFF4CAF50) else if (email.isNotEmpty() && !isValidEmail(
                        email
                    )
                ) Color(0xFFE53935) else Color(0xFFE0E0E0),
                errorBorderColor = Color(0xFFE53935)
            ),
            shape = RoundedCornerShape(12.dp),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Password",
            color = Color(0xFF1A1A1A),
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(8.dp))

        var passwordVisible by remember { mutableStateOf(false) }

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            isError = password.isNotEmpty() && password.length < 8,
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            placeholder = {
                Text(
                    text = "Enter your password",
                    color = Color(0xFFAAAAAA),
                    fontSize = 15.sp
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedBorderColor = if (password.length >= 8) Color(0xFF4CAF50) else Color(
                    0xFFE0E0E0
                ),
                unfocusedBorderColor = if (password.length >= 8) Color(0xFF4CAF50) else if (password.isNotEmpty() && password.length < 8) Color(
                    0xFFE53935
                ) else Color(0xFFE0E0E0),
                errorBorderColor = Color(0xFFE53935)
            ),
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.padding(end = 4.dp)
                ) {
                    if (password.isNotEmpty()) {
                        Icon(
                            imageVector = Icons.Default.CheckCircle,
                            contentDescription = null,
                            tint = Color(0xFF4CAF50),
                            modifier = Modifier.size(20.dp)
                        )
                    }
                    IconButton(
                        onClick = { passwordVisible = !passwordVisible },
                        modifier = Modifier.size(24.dp)
                    ) {
                        Icon(
                            painter = painterResource(
                                if (passwordVisible) R.drawable.ic_eye_off else R.drawable.ic_eye
                            ),
                            contentDescription = if (passwordVisible) "Hide password" else "Show password",
                            tint = Color(0xFF1A1A1A),
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            },
            shape = RoundedCornerShape(12.dp),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(12.dp))

        val annotatedString = buildAnnotatedString {
            append("Forgot your password? ")
            withStyle(
                style = SpanStyle(
                    textDecoration = TextDecoration.Underline,
                    color = Color(0xFF1A1A1A),
                    fontWeight = FontWeight.Medium
                )
            ) {
                append("Reset your password")
            }
        }

        Text(
            text = annotatedString,
            color = Color(0xFF6B6B6B),
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF1A1A1A),
                contentColor = Color.White
            ),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 0.dp,
                pressedElevation = 0.dp
            )
        ) {
            Text(
                text = "Login",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            HorizontalDivider(
                modifier = Modifier.weight(1f),
                color = Color(0xFFE0E0E0),
                thickness = 1.dp
            )

            Text(
                text = "Or",
                modifier = Modifier.padding(horizontal = 16.dp),
                color = Color(0xFF9E9E9E),
                fontSize = 14.sp
            )

            HorizontalDivider(
                modifier = Modifier.weight(1f),
                color = Color(0xFFE0E0E0),
                thickness = 1.dp
            )
        }

        OutlinedButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(1.5.dp, Color(0xFFE0E0E0)),
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color.White,
                contentColor = Color(0xFF1A1A1A)
            )
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_google),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier.size(20.dp)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = "Login with Google",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF1877F2),
                contentColor = Color.White
            ),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 0.dp,
                pressedElevation = 0.dp
            )
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_facebook),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier.size(20.dp)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = "Login with Facebook",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }

        Spacer(modifier = Modifier.weight(1f))
        Spacer(modifier = Modifier.height(32.dp))

        val annotatedString2 = buildAnnotatedString {
            append("Don't have an account? ")
            pushStyle(
                style = SpanStyle(
                    textDecoration = TextDecoration.Underline,
                    color = Color(0xFF1A1A1A),
                    fontWeight = FontWeight.SemiBold
                )
            )
            append("Join")
            pop()
        }

      Text(
            text = annotatedString2,
            color = Color(0xFF6B6B6B),
            fontSize = 14.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
                .clickable { onNavigateToRegister() },
            textAlign = TextAlign.Center
        )
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}