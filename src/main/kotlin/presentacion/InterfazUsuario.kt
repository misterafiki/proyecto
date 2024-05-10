class InterfazUsuario {
    fun menuPrincipal() {
        var seguir=true
        while (seguir) {
            println("Bienvenido al sistema:")
            println("1.- Login")
            println("2.- Registrar")
            println("3.- Salir")
            print("Por favor, seleccione una opción: ")
            val option = readLine()?.toIntOrNull()

            when (option) {
                1 -> login()
                2 -> registro()
                3 -> {
                    println("Saliendo del sistema...")
                    seguir = false
                }
                else -> println("Opción inválida. Por favor, seleccione nuevamente.")
            }
        }
    }

    private fun registro() {
        println("Por favor, ingrese los siguientes datos:")
        print("Email: ")
        val email = readLine().orEmpty()
        print("Nombre: ")
        val name = readLine().orEmpty()
        print("Apellidos: ")
        val lastName = readLine().orEmpty()
        print("Edad: ")
        val age = readLine()?.toIntOrNull() ?: 0
        print("Contraseña: ")
        val password = readLine().orEmpty()

        ControladorIndividuoRol.registrar(email, name, lastName, age, password)
        println("Usuario registrado exitosamente.")
    }

    private fun login() {
        print("Email: ")
        val email = readLine().orEmpty()
        print("Contraseña: ")
        val password = readLine().orEmpty()

        when (ControladorIndividuoRol.login(email, password)){
            Rol.ESTANDAR -> playGame(email)
            Rol.ADMINISTRADOR -> menuAdministrador()
            Rol.AMBOS -> {
            print("Por favor, como entrar ESTANDAR (1) ADMINISTRADOR (2): ")
            val option = readLine()?.toIntOrNull()
            when (option) {
                1 -> playGame(email)
                2 -> menuAdministrador()
                else -> println("Opción inválida. Por favor, seleccione nuevamente.")
            }
        }
            else -> println("Email o contraseña incorrectos.")
        }
    }

    private fun playGame(email: String) {
            println("¡Bienvenido al juego de adivinar!")
            val juego = ControladorJuego(email)

            while (juego.estado == EstadoJuego.EN_PROGRESO) {
                println("Ingrese un número entre 1 y 10: ")
                val input = readLine()
                val intento = input?.toIntOrNull()
                if (intento != null) {
                    juego.jugar(intento)
                    when (juego.estado) {
                        EstadoJuego.GANADO -> println("¡Felicidades! ¡Has adivinado el número correctamente!")
                        EstadoJuego.PERDIDO -> println("¡Lo siento! Te has quedado sin intentos. ¡Inténtalo de nuevo!")
                        else -> println("Número incorrecto. Sigue intentándolo.")
                    }
                } else {
                    println("Por favor, ingrese un número válido.")
                }
            }
            println("El juego ha terminado.")
    }

    fun menuAdministrador() {
        var seguir=true
        while (seguir) {
            println("Menú de administrador:")
            println("1.- Añadir usuario")
            println("2.- Mostrar usuarios")
            println("3.- Buscar usuario por email")
            println("4.- Borrar usuario")
            println("5.- Modificar usuario")
            println("6.- gestion de terapeutas")
            println("7.- Salir")
            print("Por favor, seleccione una opción: ")
            val opcion = readLine()?.toIntOrNull()

            when (opcion) {
                1 -> aniadirUsuario()
                2 -> mostrarUsuarios()
                3 -> buscarUsuarioPorEmail()
                4 -> borrarUsuario()
                5 -> modificarUsuario()
                6 -> cambiarPermisosUsuario()
                7 -> seguir = false
                else -> println("Opción inválida. Por favor, seleccione nuevamente.")
            }
        }
    }

    private fun aniadirUsuario() {
        println("Ingrese los datos del usuario:")
        print("Email: ")
        val email = readLine() ?: ""
        print("Nombre: ")
        val nombre = readLine() ?: ""
        print("Apellidos: ")
        val apellidos = readLine() ?: ""
        print("Edad: ")
        val edad = readLine()?.toIntOrNull() ?: 0
        print("Clave de acceso: ")
        val claveAcceso = readLine() ?: ""

        ControladorIndividuoRol.registrar(email, nombre, apellidos, edad, claveAcceso)
        println("Usuario añadido correctamente.")
    }

    private fun mostrarUsuarios() {
        val usuarios = ControladorIndividuoRol.obtenerTodosUsuarios()
        println("Lista de usuarios:")
        usuarios.forEach { println(it) }
    }

    private fun buscarUsuarioPorEmail() {
        print("Ingrese el email del usuario a buscar: ")
        val email = readLine() ?: ""
        val usuario = ControladorIndividuoRol.obtenerUsuarioPorEmail(email)
        if (usuario != null) {
            println("Usuario encontrado: $usuario")
        } else {
            println("No se encontró ningún usuario con el email proporcionado.")
        }
    }

    private fun borrarUsuario() {
        print("Ingrese el email del usuario a borrar: ")
        val email = readLine() ?: ""
        val usuario = ControladorIndividuoRol.obtenerUsuarioPorEmail(email)
        if (usuario != null) {
            ControladorIndividuoRol.eliminarUsuario(usuario)
            println("Usuario eliminado correctamente.")
        } else {
            println("No se encontró ningún usuario con el email proporcionado.")
        }
    }

    private fun modificarUsuario() {
        print("Ingrese el email del usuario a modificar: ")
        val email = readLine() ?: ""
        val usuario = ControladorIndividuoRol.obtenerUsuarioPorEmail(email)
        if (usuario != null) {
            print("Ingrese la nueva edad: ")
            val nuevaEdad = readLine()?.toIntOrNull() ?: 0
            usuario.edad = nuevaEdad
            ControladorIndividuoRol.actualizarUsuario(usuario)
            println("Edad modificada correctamente.")
        } else {
            println("No se encontró ningún usuario con el email proporcionado.")
        }
    }

    private fun cambiarPermisosUsuario() {
        print("Ingrese el email del usuario cuyos permisos desea cambiar: ")
        val email = readLine() ?: ""
        val usuario = ControladorIndividuoRol.obtenerUsuarioPorEmail(email)
        if (usuario != null) {
            print("Ingrese el nuevo rol (ESTANDAR, ADMINISTRADOR o AMBOS): ")
            val nuevoRol = readLine() ?: ""
            ControladorIndividuoRol.cambiarRol(email, nuevoRol)
            println("Rol cambiado correctamente.")
        } else {
            println("No se encontró ningún usuario con el email proporcionado.")
        }
    }
}