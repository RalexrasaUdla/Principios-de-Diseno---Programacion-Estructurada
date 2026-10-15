Comparativa de Rendimiento: Base de Datos vs Caché en Spring Boot

En esta actividad se buscó realizar una comparación del rendimiento y los tiempos de respuesta entre realizar consultas masivas directas a una base de datos relacional y utilizar una capa de caché en memoria RAM.

Descripción del Proyecto

Por medio del método run se hace que al ejecutar el aplicativo agregue 1.000,000 registros a una base de datos temporal (H2) que se instancia al momento de arrancar. Se procede a exponer la API REST por medio de CORS que permite mostrar y ejecutar metodos como el de medir la diferencia en milisegundos que hay entre:

Extraer los 1.000,000 registros procesando consultas SQL e instanciando objetos a través de JPA (Sin Caché).

Extraer los mismos registros leyendo directamente desde la memoria RAM mediante la abstracción de caché de Spring Boot (Con Caché) utilizando un precalentamiendo de memoria para simular que el fichero ya esta creado con anterioridad.

Además, incluye una interfaz web (Frontend) construida en HTML, CSS y Vanilla JavaScript para visualizar la comparativa de forma gráfica y amigable.

Estructura del Proyecto Backend

El código principal de Spring Boot se encuentra centralizado bajo el paquete com.example.Taller2:

Taller2Application.java: Clase principal que arranca la aplicación. Incluye la anotación @EnableCaching para activar el soporte de caché.

application.properties: Archivo de configuración que levanta la base de datos H2 en RAM.

Registro.java (Entidad): Modelo de datos con id, nombre y descripcion.

RegistroRepository.java (Repositorio): Interfaz JPA para interactuar con la base de datos sin escribir SQL.

DataLoader.java (Componente): Clase que implementa CommandLineRunner para inyectar 1.000,000 registros de prueba al encender el servidor.

RegistroService.java (Servicio): Contiene la lógica de negocio. Tiene un método de lectura tradicional y un método anotado con @Cacheable("registros"). Incluye la función para limpiar la memoria con @CacheEvict.

TestController.java (Controlador REST): Expone el endpoint /test-cache. Controla el flujo de pruebas forzando limpiezas de memoria (System.gc())  para asegurar métricas justas.

Instrucciones de Ejecución

1. Ejecutar el Backend (Spring Boot)

Abre el proyecto en tu IDE de preferencia (IntelliJ IDEA, Eclipse, VS Code).

Asegúrate de que las dependencias de Maven se hayan descargado correctamente.

Ejecuta la clase Taller2Application.java.

Observa la consola: verás un mensaje indicando que se están insertando los 400,000 registros.

El servidor estará disponible en el puerto 8080.

2. Ejecutar el Frontend

Ve a la carpeta donde guardaste tu archivo index.html.

Haz doble clic sobre el archivo para abrirlo en cualquier navegador web moderno (Chrome, Firefox, Edge).

Haz clic en el botón "Ejecutar Prueba".

(Nota: La primera prueba tomará un par de segundos debido a las pausas forzadas para estabilizar el recolector de basura de Java).
