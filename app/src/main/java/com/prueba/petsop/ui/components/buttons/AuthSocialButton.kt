import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prueba.petsop.ui.theme.BlueLabel

@Composable
fun AuthSocialButtonWithImage(
    text: String?,
    iconResId: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier
            .height(50.dp),
        shape = RoundedCornerShape(12.dp),
        border = ButtonDefaults.outlinedButtonBorder,
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = MaterialTheme.colorScheme.onBackground
        )
    ) {
        Image(
            painter = painterResource(id = iconResId),
            contentDescription = text ?: "icon",
            modifier = Modifier
                .height(24.dp)
                .padding(end = if (text != null) 8.dp else 0.dp)
        )

        text?.let {
            Text(
                text = it,
                style = MaterialTheme.typography.labelSmall,
                color = BlueLabel,
                letterSpacing = 0.sp
            )
        }
    }
}



