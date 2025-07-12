package com.vineesh.newsapp.presentation.common

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.vineesh.newsapp.R
import com.vineesh.newsapp.ui.theme.WhiteGray
import org.w3c.dom.Text
import javax.security.auth.callback.Callback

@Composable
fun NewsLabelButton(
    text: String,
    onClick: () -> Unit
) {
    TextButton(
        onClick = onClick, colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = colorResource(R.color.textColor),
        )
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold)
        )
    }
}