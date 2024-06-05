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
fun LoginScreenTutorial(
    modifier: Modifier = Modifier
) {

//    For the email and text fields to work
    var emailText by remember { mutableStateOf("") }
    var passwordText by remember { mutableStateOf("") }

//    Images
    val bgWorkNow = painterResource(id = R.drawable.backgroundimage)
    val rocketship = painterResource(id = R.drawable.rocket)

//    Specific colors
    val backgroundColor = Color(0xFF090011)
    val buttonColor = Color(0xFF7920C2)
    val rocketcolor = Color(0xFFF2994A)

//    Checkbox var (use to toggle if checked or not)
    var checked by remember { mutableStateOf(false) }


//    Where the code starts
//    Main over all container box.
//    allows for the login panel to be in front of the background with no weird gaps where corners
//    are rounded
//    Also lets us add the rocket ship logo over the front of the login panel
    Box(
        modifier = modifier
            .background(Color.White)
            .fillMaxSize()
    ) {

//        Background image at the top behind the rocket ship icon
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
//        End of background

//        Start of middle layer (the login panel)
        Column(
//            This column lets us add a spacer between the login panel and the top of the
//            screen. Which lets us see the background we made earlier
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
        ) {

//            Adds space between top of page and top of login panel
            Spacer(modifier = modifier.size(138.dp))

//          The login panel itself
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
//                    use .clip to round the corners
                    .clip(shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp))
                    .background(backgroundColor)
                    .padding(25.dp)
                    .fillMaxHeight()
            ) {

//                More space
                Spacer(modifier = modifier.size(70.dp))

//                Heading
                Text(
                    text = "LOGIN",
                    fontSize = 45.sp,
                    color = Color.White
                )

//                Little space before flavor text
                Spacer(modifier = modifier.size(8.dp))

//                Flavor text
                Text(
                    text = "Explore the galaxy",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Spacer(modifier = modifier.size(30.dp))

//                Stay with me here, it gets wild
//                The text fields are columns with a label above and then the text field below


                Column {

//                    Label above the field
                    Text(
                        text = "Your email",
                        fontSize = 15.sp,
                        color = Color.White,
                        modifier = modifier
                            .padding(8.dp)
                    )

//                    Where you type stuff
                    TextField(
                        value = emailText,
                        onValueChange = { emailText = it },
                        label = { Text("JohnDoe@teufort.com") }, //this is the text displayed inside the field
//                        Think of this label like placeholder text

                        colors = TextFieldDefaults.textFieldColors(
                            focusedTextColor = Color.White, // Set the text color to white
                            unfocusedTextColor = Color.White, // Set the text color to white
                            cursorColor = Color.White, // Set the cursor color to white
                            focusedIndicatorColor = Color.Transparent, // Remove the underline when focused
                            unfocusedIndicatorColor = Color.Transparent, // Remove the underline when not focused
                            containerColor = Color.Transparent, // Transparent background
                            focusedLabelColor = Color.White, // Set the label in the field color to white
                            unfocusedLabelColor = Color.White // Set the label in the field color to white
                        ),
                        modifier = modifier
//                            Some styling
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

//                This is the exact same as the email text field
//                Copy + pasted
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

//                        Small change here, this is so that whatever you type is censored
//                        Like a real password input field
                        visualTransformation = PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                    )

                }

                Spacer(modifier = modifier.size(2.dp))

//                The row below the password field
                Row (
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = modifier
                        .fillMaxWidth()
                ){
//                    Checkbox
                    Checkbox(
                        checked = checked,
                        onCheckedChange = { checked = it }
                    )
//                    Text next to the checkbox
                    Text(
                        "Remember Me",
                        fontSize = 12.sp,
                        color = Color.White
                    )

//                    Spacer to add some distance inbetween
                    Spacer(modifier = modifier
                        .width(75.dp))

//                    Forgot password button
                    TextButton(
                        onClick = {
                        // Add your navigation here
                        }
                    ) {
                        Text(text = "Forgot password?", color = rocketcolor)
                    }


                }


                Spacer(modifier = modifier.size(45.dp))

//                The login button
                Button(
                    onClick = {
//                              Add your onclick function here
                              },
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

//                Adds space below the login button
                Spacer(modifier = modifier.size(55.dp))

//                Text below the login button
                Row(
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                    Text(
                        text = "Don't have an account?",
                        color = Color.White
                    )

//                    Clickable text button for navigation
                    TextButton(
                        onClick = {
//                            Add your navigation here
                        }) {
                        Text(text = "Sign Up", color = rocketcolor)
                    }
                }

            }

        }

//        Top layer (Rocketship icon/logo)
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
        ) {
            Spacer(modifier = modifier.size(90.dp))

//          The orange circle
            Box(
                contentAlignment = Alignment.Center,
                modifier = modifier
                    .size(100.dp) // Set the size of the circle
                    .background((rocketcolor), shape = CircleShape) // Set the color and shape
            ){

//              The actual logo image on the orange circle
                Image(
                    painter = rocketship, //Declared at the top
                    contentDescription = "rocketship",
                    modifier = modifier
                        .size(80.dp)

                )
            }
        }

    }
}

//This bit of code lets us see the preview in the split code window over there -->
@Preview(showBackground = true)
@Composable
fun LoginScreenTutorialPreview() {
    LoginScreenTutorial()
}