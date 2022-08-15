package com.arech.uicomponents.component

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.arech.uicomponents.R

/**
 * Created by Pili Arancibia on 15-08-22.
 */

@Composable
fun AvatarSelector(modifier: Modifier = Modifier, attrs: AttrsAvatarSelector) {
    var imageUri by rememberSaveable {
        mutableStateOf<Uri?>(null)
    }

    val launcher = rememberLauncherForActivityResult(
        contract =
        ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        imageUri = uri
    }

    Box(modifier) {
        AvatarSelectorContent(imageUri, attrs)
        FloatingActionButton(
            modifier = Modifier.align(Alignment.BottomEnd),
            onClick = { launcher.launch("image/*") },
        ) {
            Icon(imageVector = Icons.Default.Add, contentDescription = null)
        }
    }
}

@Composable
fun AvatarSelectorContent(imageUri: Uri?, attrs: AttrsAvatarSelector) {
    Image(
        modifier = Modifier
            .height(131.dp)
            .width(131.dp)
            .clip(CircleShape),
        painter = if (imageUri == null) painterResource(id = attrs.placeHolderImage) else rememberAsyncImagePainter(
            ImageRequest
                .Builder(LocalContext.current)
                .data(data = imageUri)
                .build()
        ),
        contentScale = ContentScale.Crop,
        contentDescription = null,
    )
}

data class AttrsAvatarSelector(
    @DrawableRes val placeHolderImage: Int = R.drawable.cat_example
)