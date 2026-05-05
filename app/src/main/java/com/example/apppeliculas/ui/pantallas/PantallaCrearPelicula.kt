import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation3.runtime.NavKey
import com.example.apppeliculas.R
import com.example.apppeliculas.bbdd.datosApp
import com.example.apppeliculas.modelo.Pelicula
import com.example.apppeliculas.ui.componentes.LumTextField
import com.example.apppeliculas.ui.componentes.LumToolBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaCrearPelicula(backStack: MutableList<NavKey>, pelicula: Pelicula?) {
    val context = LocalContext.current

    var titulo by rememberSaveable(pelicula) { mutableStateOf(pelicula?.titulo ?: "") }
    var genero by rememberSaveable(pelicula) { mutableStateOf(pelicula?.genero ?: "") }
    var director by rememberSaveable(pelicula) { mutableStateOf(pelicula?.director ?: "") }
    var puntuacion by rememberSaveable(pelicula) { mutableStateOf(pelicula?.puntuacion ?: "") }

    val formularioValido = titulo.isNotEmpty() && genero.isNotEmpty() &&
            director.isNotEmpty() && puntuacion.isNotEmpty()

    Scaffold(

        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            LumToolBar(
                texto = stringResource(R.string.añadir_pelicula_),backStack = backStack,
                )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    if (formularioValido) {
                        val idNueva = pelicula?.id ?: (datosApp.listaPeliculas.size + 1).toString()
                        val nuevaPelicula = Pelicula(id = idNueva, titulo, genero, director, puntuacion)
                        val indiceExistente = datosApp.listaPeliculas.indexOfFirst { it.id == idNueva }

                        if (indiceExistente != -1) {
                            datosApp.listaPeliculas[indiceExistente] = nuevaPelicula
                        } else {
                            datosApp.listaPeliculas.add(nuevaPelicula)
                        }

                        Toast.makeText(context, "¡Película guardada!", Toast.LENGTH_SHORT).show()
                        if (backStack.size > 1) backStack.removeAt(backStack.size - 1)
                    } else {
                        Toast.makeText(context, "Rellena todos los campos", Toast.LENGTH_SHORT).show()
                    }
                },

                containerColor = if (formularioValido) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.background,
                contentColor = MaterialTheme.colorScheme.onPrimary,
                shape = RoundedCornerShape(percent = 35),
                modifier = Modifier
                    .padding(bottom = 16.dp, end = 8.dp)
                    .size(65.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.outline_add_24),
                    contentDescription = stringResource(R.string.guardar),
                    modifier = Modifier.size(30.dp)
                )
            }
        }
    ) { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(20.dp) ){


                LumTextField(
                    value = titulo,
                    onValueChange = { titulo = it },
                    vacio = titulo.isEmpty(),
                    etiqueta = stringResource(R.string.titulo),
                    textoErrorAbajo = stringResource(R.string.solicitar_titulo),
                    esContraseña = false
                )

                LumTextField(
                    value = genero,
                    onValueChange = { genero = it },
                    vacio = genero.isEmpty(),
                    etiqueta = stringResource(R.string.genero),
                    textoErrorAbajo = stringResource(R.string.solicitar_genero),
                    esContraseña = false
                )

                LumTextField(
                    value = director,
                    onValueChange = { director = it },
                    vacio = director.isEmpty(),
                    etiqueta = stringResource(R.string.director),
                    textoErrorAbajo = stringResource(R.string.solicitar_director),
                    esContraseña = false
                )

                LumTextField(
                    value = puntuacion,
                    onValueChange = { puntuacion = it },
                    vacio = puntuacion.isEmpty(),
                    etiqueta = stringResource(R.string.puntuacion),
                    textoErrorAbajo = stringResource(R.string.solicitar_puntuacion),
                    esContraseña = false
                )


                Spacer(modifier = Modifier.height(80.dp))
            }
        }
    }
}