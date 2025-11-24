package com.example.e_commerce.presentation.register

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
import androidx.compose.foundation.text.ClickableText
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
import com.example.e_commerce.ui.theme.ECommerceTheme
import com.example.e_commerce.utils.isValidEmail


@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
    onLoginClick: () -> Unit
) {
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .systemBarsPadding()
            .padding(horizontal = 24.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Create an account",
            color = Color(0xFF1A1A1A),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "Let's get you started.",
            color = Color(0xFF808080),
            fontSize = 15.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Full Name",
            color = Color(0xFF1A1A1A),
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = fullName,
            onValueChange = { fullName = it },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            placeholder = {
                Text(
                    "Enter your full name",
                    color = Color(0xFFAAAAAA),
                    fontSize = 15.sp
                )
            },
            trailingIcon = {
                if (fullName.length >= 3) {
                    Icon(
                        Icons.Default.CheckCircle,
                        null,
                        tint = Color(0xFF4CAF50),
                        modifier = Modifier.size(20.dp)
                    )
                }
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = if (fullName.length >= 3) Color(0xFF4CAF50) else Color(0xFFE0E0E0),
                unfocusedBorderColor = if (fullName.length >= 3) Color(0xFF4CAF50) else Color(0xFFE0E0E0),
            ),
            shape = RoundedCornerShape(12.dp),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Email Field
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
                    "Enter your email address",
                    color = Color(0xFFAAAAAA),
                    fontSize = 15.sp
                )
            },
            trailingIcon = {
                if (isValidEmail(email)) {
                    Icon(
                        Icons.Default.CheckCircle,
                        null,
                        tint = Color(0xFF4CAF50),
                        modifier = Modifier.size(20.dp)
                    )
                }
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = if (isValidEmail(email)) Color(0xFF4CAF50) else Color(0xFFE0E0E0),
                unfocusedBorderColor = if (email.isNotEmpty() && !isValidEmail(email)) Color(0xFFE53935) else if (isValidEmail(
                        email
                    )
                ) Color(0xFF4CAF50) else Color(0xFFE0E0E0)
            ),
            shape = RoundedCornerShape(12.dp),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

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
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Next
            ),
            placeholder = {
                Text(
                    "Enter your password",
                    color = Color(0xFFAAAAAA),
                    fontSize = 15.sp
                )
            },
            trailingIcon = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    if (password.length >= 8) {
                        Icon(
                            Icons.Default.CheckCircle,
                            null,
                            tint = Color(0xFF4CAF50),
                            modifier = Modifier.size(20.dp)
                        )
                    }
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            painter = painterResource(if (passwordVisible) R.drawable.ic_eye_off else R.drawable.ic_eye),
                            contentDescription = null,
                            tint = Color(0xFF1A1A1A),
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = if (password.length >= 8) Color(0xFF4CAF50) else Color(0xFFE0E0E0),
                unfocusedBorderColor = if (password.isNotEmpty() && password.length < 8) Color(0xFFE53935) else if (password.length >= 8) Color(
                    0xFF4CAF50
                ) else Color(0xFFE0E0E0)
            ),
            shape = RoundedCornerShape(12.dp),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Confirm Password",
            color = Color(0xFF1A1A1A),
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.height(8.dp))
        var confirmPasswordVisible by remember { mutableStateOf(false) }
        val passwordsMatch = confirmPassword.isNotEmpty() && confirmPassword == password

        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = if (confirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            placeholder = {
                Text(
                    "Re-enter your password",
                    color = Color(0xFFAAAAAA),
                    fontSize = 15.sp
                )
            },
            trailingIcon = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    if (passwordsMatch) {
                        Icon(
                            Icons.Default.CheckCircle,
                            null,
                            tint = Color(0xFF4CAF50),
                            modifier = Modifier.size(20.dp)
                        )
                    }
                    IconButton(onClick = { confirmPasswordVisible = !confirmPasswordVisible }) {
                        Icon(
                            painter = painterResource(if (confirmPasswordVisible) R.drawable.ic_eye_off else R.drawable.ic_eye),
                            contentDescription = null,
                            tint = Color(0xFF1A1A1A),
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = if (passwordsMatch) Color(0xFF4CAF50) else Color(0xFFE0E0E0),
                unfocusedBorderColor = if (confirmPassword.isNotEmpty() && !passwordsMatch) Color(
                    0xFFE53935
                ) else if (passwordsMatch) Color(0xFF4CAF50) else Color(0xFFE0E0E0)
            ),
            shape = RoundedCornerShape(12.dp),
            singleLine = true
        )

        val termsAnnotatedString = buildAnnotatedString {
            append("By signing up you agree to our ")
            pushStyle(
                style = SpanStyle(
                    textDecoration = TextDecoration.Underline,
                    color = Color(0xFF1A1A1A),
                    fontWeight = FontWeight.SemiBold
                ),
            )
            append("Terms, Privacy Policy, and Cookie Use ")
        }

        Text(
            text = termsAnnotatedString,
            modifier = Modifier.padding(top = 12.dp),
            color = Color(0xFF6B6B6B),
            fontSize = 13.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1A1A1A))
        ) {
            Text("Create Account", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            HorizontalDivider(
                Modifier.weight(1f),
                color = Color(0xFFE0E0E0),
                thickness = 1.dp
            )
            Text(
                "Or",
                modifier = Modifier.padding(horizontal = 16.dp),
                color = Color(0xFF9E9E9E),
                fontSize = 14.sp
            )
            HorizontalDivider(
                Modifier.weight(1f),
                color = Color(0xFFE0E0E0),
                thickness = 1.dp
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedButton(
            onClick = { /* Google signup */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(1.5.dp, Color(0xFFE0E0E0))
        ) {
            Icon(
                painterResource(R.drawable.ic_google),
                null,
                tint = Color.Unspecified,
                modifier = Modifier.size(20.dp)
            )
            Spacer(Modifier.width(12.dp))
            Text("Sign up with Google", fontSize = 16.sp, fontWeight = FontWeight.Medium, color = Color(0xFF1A1A1A))
        }

        Spacer(Modifier.height(12.dp))

        Button(
            onClick = { /* Facebook signup */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1877F2))
        ) {
            Icon(
                painterResource(R.drawable.ic_facebook),
                null,
                tint = Color.Unspecified,
                modifier = Modifier.size(20.dp)
            )
            Spacer(Modifier.width(12.dp))
            Text("Sign up with Facebook", fontSize = 16.sp, fontWeight = FontWeight.Medium)
        }


        Spacer(modifier = Modifier.weight(1f))
        Spacer(modifier = Modifier.height(32.dp))

        val loginAnnotatedString = buildAnnotatedString {
            append("Already have an account? ")
            pushStyle(
                style = SpanStyle(
                    textDecoration = TextDecoration.Underline,
                    color = Color(0xFF1A1A1A),
                    fontWeight = FontWeight.SemiBold
                )
            )
            append("Login")
            pop()
        }

        Text(
            text = loginAnnotatedString,
            color = Color(0xFF6B6B6B),
            fontSize = 14.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
                .clickable { onLoginClick() },
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegisterScreenPreview() {
    RegisterScreen(
        onLoginClick = {}
    )
}