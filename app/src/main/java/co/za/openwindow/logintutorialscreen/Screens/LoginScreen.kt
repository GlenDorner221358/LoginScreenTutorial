package co.za.openwindow.logintutorialscreen.Screens

import android.view.RoundedCorner
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.za.openwindow.logintutorialscreen.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(
    navigateToRegister:() -> Unit = {},
    modifier: Modifier = Modifier
) {

    val bgWorkNow = painterResource(id = R.drawable.backgroundimage)
    val rocketship = painterResource(id = R.drawable.rocket)
    var emailText by remember { mutableStateOf("") }
    var passwordText by remember { mutableStateOf("") }
    val textColor = Color(0xFFF090011)
    val backgroundColor = Color(0xFF090011)
    val buttonColor = Color(0xFF7920C2)
    val rocketcolor = Color(0xFFF2994A)

    var checked by remember { mutableStateOf(false) }


    Box(

        modifier = modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .background(Color.Black)
                .fillMaxSize()
        ) {
            Image(
                painter = bgWorkNow, // Use the correct variable name
                contentDescription = "background Image",
                modifier = modifier
                    .fillMaxWidth()
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
        ) {

            Spacer(modifier = modifier.size(138.dp))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                    .clip(shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp))
                    .background(backgroundColor)
                    .padding(25.dp)
                    .fillMaxHeight()
            ) {

                Spacer(modifier = modifier.size(70.dp))

                Text(
                    text = "LOGIN",
                    fontSize = 45.sp,
                    color = Color.White
                )

                Spacer(modifier = modifier.size(8.dp))

                Text(
                    text = "Explore the galaxy",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Spacer(modifier = modifier.size(30.dp))

                Column {
                    Text(
                        text = "Your email",
                        fontSize = 15.sp,
                        color = Color.White,
                        modifier = modifier
                            .padding(8.dp)
                    )
                    TextField(
                        value = emailText,
                        onValueChange = { emailText = it },
                        label = { Text("John Doe @ teufort .com") },
                        colors = TextFieldDefaults.textFieldColors(
                            focusedTextColor = Color.White, // Set the text color to white
                            unfocusedTextColor = Color.White, // Set the text color to white
                            cursorColor = Color.White, // Set the cursor color to white
                            focusedIndicatorColor = Color.Transparent, // Remove the underline when focused
                            unfocusedIndicatorColor = Color.Transparent, // Remove the underline when not focused
                            containerColor = Color.Transparent, // Transparent background
                            focusedLabelColor = Color.White,
                            unfocusedLabelColor = Color.White
                        ),
                        modifier = modifier
                            .fillMaxWidth()
                            .border(
                                width = 2.dp,
                                color = Color.White,
                                shape = RoundedCornerShape(30.dp)
                            )
                            .height(45.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                    )
                }


                Spacer(modifier = modifier.size(30.dp))

                Column {
                    Text(
                        text = "Your Password",
                        fontSize = 15.sp,
                        color = Color.White,
                        modifier = modifier
                            .padding(8.dp)
                    )
                    TextField(
                        value = passwordText,
                        onValueChange = { passwordText = it },
                        label = { Text("Password") },
                        colors = TextFieldDefaults.textFieldColors(
                            focusedTextColor = Color.White, // Set the text color to white
                            unfocusedTextColor = Color.White, // Set the text color to white
                            cursorColor = Color.White, // Set the cursor color to white
                            focusedIndicatorColor = Color.Transparent, // Remove the underline when focused
                            unfocusedIndicatorColor = Color.Transparent, // Remove the underline when not focused
                            containerColor = Color.Transparent, // Transparent background
                            focusedLabelColor = Color.White,
                            unfocusedLabelColor = Color.White
                        ),
                        modifier = modifier
                            .fillMaxWidth()
                            .border(
                                width = 2.dp,
                                color = Color.White,
                                shape = RoundedCornerShape(30.dp)
                            )
                            .height(45.dp),
                        visualTransformation = PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                    )

                }

                Spacer(modifier = modifier.size(2.dp))

                Row (
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = modifier
                        .fillMaxWidth()
                ){
                    Checkbox(
                        checked = checked,
                        onCheckedChange = { checked = it }
                    )

                    Text(
                        "Remember Me",
                        fontSize = 12.sp,
                        color = Color.White
                    )

                    Spacer(modifier = modifier
                        .width(75.dp))

                    TextButton(
                        onClick = {
                        // Add your navigation here
                        }
                    ) {
                        Text(text = "Forgot password?", color = rocketcolor)
                    }


                }


                Spacer(modifier = modifier.size(45.dp))

                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = buttonColor
                    ),
                    modifier = modifier.padding(horizontal = 10.dp)
                ) {
                    Text(
                        "Login",
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center,
                        modifier = modifier
                            .padding(vertical = 7.dp)
                            .fillMaxWidth()
                    )
                }

                Spacer(modifier = modifier.size(55.dp))

                NavigateToRegisterSection(
                    question = "Don't have an Account?",
                    buttonText = "Register"
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                    Text(
                        text = "Don't have an account?",
                        color = Color.White
                    )
                    TextButton(
                        onClick = { navigateToRegister.invoke() }) {
                        Text(text = "Sign Up", color = rocketcolor)
                    }
                }

            }

        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
        ) {
            Spacer(modifier = modifier.size(90.dp))
            Box(
                contentAlignment = Alignment.Center,
                modifier = modifier
                    .size(100.dp) // Set the size of the circle
                    .background((rocketcolor), shape = CircleShape) // Set the color and shape
            ){
                Image(
                    painter = rocketship, // Use the correct variable name
                    contentDescription = "rocketship",
                    modifier = modifier
                        .size(80.dp)

                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    Login()
}

@Composable
fun  NavigateToRegisterSection(
    question: String,
    buttonText: String
){

}