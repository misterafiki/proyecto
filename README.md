# Proyecto de Terapia Emocional

Este proyecto es una aplicación web desarrollada en Kotlin que permite la gestión de sesiones de terapia emocional. La aplicación está diseñada para ser utilizada por terapeutas y clientes, proporcionando herramientas para registrar y analizar las emociones experimentadas durante las sesiones de terapia.

## Características Principales

- **Gestión de Terapeutas y Clientes:** La aplicación permite registrar terapeutas y clientes, organizados en grupos de terapeutas y familias de clientes respectivamente.
- **Registro de Sesiones:** Los terapeutas pueden registrar sesiones de terapia, donde se capturan las emociones experimentadas durante la sesión.
- **Análisis de Emociones:** La aplicación ofrece herramientas para analizar y visualizar las emociones registradas durante las sesiones, facilitando el seguimiento del progreso emocional de los clientes.
- **Metodologías y Técnicas:** Los terapeutas pueden aplicar diferentes metodologías de terapia emocional, cada una con sus propias técnicas personalizadas.

## Estructura del Proyecto

El proyecto sigue una estructura modular para facilitar su mantenimiento y escalabilidad:

- **`backend/`:** Contiene el código del backend de la aplicación, incluyendo la lógica de negocio y la interacción con la base de datos.
- **`frontend/`:** Aquí se encuentra el código del frontend de la aplicación web, desarrollado con tecnologías como HTML, CSS y JavaScript.
- **`database/`:** Contiene los scripts SQL para la creación y configuración de la base de datos en XAMPP.

## Tecnologías Utilizadas

- **Kotlin:** Utilizado para el desarrollo del backend de la aplicación, proporcionando un entorno de ejecución seguro y eficiente.
- **HTML, CSS, JavaScript:** Empleados en el desarrollo del frontend de la aplicación web, garantizando una experiencia de usuario atractiva e interactiva.
- **XAMPP:** Utilizado como entorno de desarrollo local para la base de datos MySQL.
- **Git y GitHub:** Utilizados para el control de versiones y la colaboración en el desarrollo del proyecto.

## Instalación y Configuración

1. Clona este repositorio en tu máquina local.
2. Configura y ejecuta XAMPP para iniciar el servidor MySQL local.
3. Importa los scripts SQL proporcionados en `database/` para crear la base de datos y sus tablas. (Consulta el archivo `database.sql` bajo la sección de [Enlaces Útiles](#enlaces-%C3%BAtiles)).
4. Configura las credenciales de conexión a la base de datos en el backend de la aplicación.
5. Ejecuta la aplicación backend y frontend para empezar a utilizarla.


## Contribución

¡Las contribuciones son bienvenidas! Si deseas contribuir al desarrollo de esta aplicación, por favor sigue estos pasos:

1. Haz un fork de este repositorio.
2. Crea una nueva rama (`git checkout -b feature/nueva-caracteristica`).
3. Realiza tus cambios y haz commit (`git commit -am 'Agrega nueva característica'`).
4. Haz push a la rama (`git push origin feature/nueva-caracteristica`).
5. Crea un nuevo Pull Request.

## Enlaces Útiles

- **[Trello](https://trello.com/invite/b/9xwPp46F/ATTI9007ebdc8fc9700c3a734afb638495afDD246AAD/proyecto-1daw):** Tablero de Trello para la gestión de tareas y seguimiento del proyecto.
- **[Telegram](https://t.me/+zNppDPkdu3M5OWY8):** Grupo de Telegram para la comunicación y colaboración del equipo de desarrollo.
-  **[Google Drive](https://drive.google.com/drive/folders/1aqLXmsTsA3HWaBY8KBeBgtDV6fcM6dnE?usp=sharing):** Carpeta en Google Drive con documentación adicional y archivos SQL.

## Notas Adicionales

> [!NOTE]
> La base de datos debe configurarse correctamente para garantizar el funcionamiento adecuado de la aplicación.

> [!WARNING]
> Se recomienda realizar copias de seguridad periódicas de la base de datos para evitar la pérdida de datos importantes.

> [!CAUTION]
> Al manipular datos sensibles de clientes, asegúrate de seguir las mejores prácticas de seguridad y privacidad de la información.

> [!TIP]
> Utiliza comentarios descriptivos en el código para facilitar su comprensión y mantenimiento futuro.

> [!IMPORTANT]
> Para el uso del test es necesario instalación de una dependencias:
> ```
> testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
> testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
> testImplementation("com.h2database:h2:1.4.200") // Para una base de datos en memoria si es necesario
> ```

## Autores Principales

- Juan Morales Sánchez
- Rafael Becerra Guerra
- Miguel León Fernández
- Manuel Santos Navarro

## Licencia

Este proyecto está bajo la [Licencia MIT](LICENSE), lo que significa que puedes utilizarlo libremente, modificarlo y distribuirlo según tus necesidades.

---

Si necesitas más información o tienes alguna pregunta, no dudes en contactar con nosotros. ¡Gracias por tu interés en nuestro proyecto!
