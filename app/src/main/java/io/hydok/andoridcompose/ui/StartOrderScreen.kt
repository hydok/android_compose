package io.hydok.andoridcompose.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.hydok.andoridcompose.data.DataSource.quantityOptions

@Composable
fun StartOrderScreen(
    quantityOptions: List<Pair<Int, Int>>,
    onNextButtonClicked: (Int) -> Unit, //다음 화면 클릭
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        /*Image(
            painter = painterResource(R.drawable.cupcake),
            contentDescription = null,
            modifier = Modifier.width(300.dp)
        )*/
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Order", style = MaterialTheme.typography.h4)
        Spacer(modifier = Modifier.height(8.dp))
        quantityOptions.forEach { item ->
            SelectQuantityButton(
                labelRes = item.first,
                onClick = { onNextButtonClicked(item.second) }
            )
        }
    }


}

@Composable
fun SelectQuantityButton(
    @StringRes labelRes: Int,
    onClick:() -> Unit,
    modifier: Modifier = Modifier
) {
    Button(onClick = onClick,
        modifier = modifier.widthIn(min = 250.dp)
    ) {
        Text(text = stringResource(id = labelRes))
    }

}

@Preview
@Composable
fun StartOrderPreview(){
    StartOrderScreen(quantityOptions = quantityOptions, onNextButtonClicked = {})
}





