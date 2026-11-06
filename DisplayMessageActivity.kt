package ao.co.isptec.aplm.helloandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.style.TextAlign
import ao.co.isptec.aplm.helloandroid.ui.theme.HelloAndroidTheme

class DisplayMessageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val message = this.intent.getStringExtra("EXTRA_MESSAGE")

        // Divide, filtra espaços vazios e cria o bundle
        val palavras = message?.split(" ")?.filter { it.isNotBlank() } ?: listOf()
        val bundle = PalavraBundle(palavras)

        // Chama a função de nível superior para gerar o resumo
        val resumo = gerarResumo(bundle)

        setContent {
            HelloAndroidTheme {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize().padding(16.dp)
                ) {
                    // Mostra o resumo no ecrã, com o texto centrado
                    Text(
                        text = resumo,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}