# Lumière 

Lumière es una aplicación móvil diseñada para cinéfilos que desean gestionar su catálogo personal de películas. Con una interfaz minimalista y elegante en tonos oscuros, la aplicación permite llevar un control detallado de tus obras favoritas del séptimo arte.

##  Características principales

**-Autenticación de Usuarios:** Pantallas de Login y Registro con validación de formularios (correo, contraseñas coincidentes y campos obligatorios).

**-Catálogo Personalizado:** Visualización de películas con metadatos como género, director y puntuación (Rating).

**-Gestión CRUD:** Operaciones completas para agregar, editar y eliminar registros de la colección.

**-UI Cinema Noir:** Estética basada en alto contraste (rojo sobre negro) para una experiencia inmersiva.

## Arquitectura de Navegación

El proyecto utiliza Navegación 3 para gestionar el flujo de pantallas de forma declarativa y segura, estructurándose de la siguiente manera:

**-Gráfico de navegación:** Definición centralizada de rutas para evitar acoplamiento entre pantallas.

**-Deep Linking & Argumentos:** Paso de datos seguro (type-safe) entre la lista principal y la pantalla de edición de películas.

**-Gestión de Backstack:** Control preciso del historial para asegurar que el usuario no regrese a las pantallas de inicio de sesión una vez autenticado.

**-Transiciones:** Fluidez en el cambio entre el registro de usuarios y el tablero principal.

##  Stack Tecnológico

**-Lenguaje/Framework:** Kotlin

**-Navegación:** Navegación 3 (Jetpack / Compose)

**-Diseño:** Material Design 3 (con personalización Dark Theme).



## Vista Previa


  <img src="./capturas/Login.png" width="23%" alt="Pantalla de Login" />
  <img src="./capturas/Registro.png" width="23%" alt="Pantalla de Registro" />

  <img src="./capturas/Lista.png" width="23%" alt="Lista de Películas" />
  <img src="./capturas/Actualizar.png" width="23%" alt="Pantalla de Edición" />

## Justificación del uso de Material Design 3 (M3)
La elección del Material 3 para el desarrollo de Lumière no es solo estética, sino que responde a criterios técnicos de usabilidad y adaptabilidad modernos:

1. Personalización Avanzada (Roles de Color)
A diferencia del Material 2, M3 introduce un sistema de "roles de color" mucho más granular. En Lumière , esto ha permitido definir un esquema Cinema Noir (alto contraste rojo/negro) de manera coherente. El uso de MaterialTheme.colorScheme facilita que componentes como los LumTextField adaptan sus colores de error, foco y contenedores se obtienen automáticamente en una paleta lógica, asegurando que la interfaz sea inmersiva pero legible.

2. Componentes con Ergonomía Mejorada
M3 rediseña componentes clásicos para hacerlos más accesibles:

Campos de texto: Los OutlinedTextField tienen ahora una geometría más clara y estados de error mejor definidos (como el uso de supportingText), lo que reduce la carga cognitiva del usuario al rellenar datos técnicos como el "Director" o la "Puntuación".

Formas: El uso de CircleShape y esquinas redondeadas en botones y tarjetas permite una elevación visual más orgánica, alejándose de la rigidez de versiones anteriores.

3. Soporte Nativo para Tema Oscuro
Dado que Lumière es una aplicación de temática cinematográfica, el soporte nativo de M3 para temas oscuros es fundamental. El sistema de elevación (Tonal Elevation) de Material 3 maneja mejor las sombras y los niveles de profundidad sobre superficies negras puras, evitando el uso de sombras planas y mejorando la percepción de capas en la interfaz.

4. Tipografía y Escala Lineal
M3 utiliza una escala tipográfica actualizada que mejora la lectura de metadatos (Género, Director, Puntuación). Esto permite que la información secundaria se visualice correctamente sin competir visualmente con el título de la película, manteniendo el orden jerárquico que requiere un catálogo personal.

5. Futuro y Mantenibilidad
Al ser el estándar actual de Google para Android, usar Material 3 garantiza que la aplicación sea compatible con las últimas API de Jetpack Compose . Esto facilita la implementación de características futuras como Dynamic Color (Material You), permitiendo que la aplicación se adapte a los colores del sistema operativo del usuario si se desea en las próximas versiones.

