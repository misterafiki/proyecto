class InterfazUsuario{

    fun menuInicio() {
        var seguir = true
        while (seguir) {
            println(
                "[1] Login\n" +
                        "[2] Registrarse\n" +
                        "[3] Registrar Terapeuta" +
                        "[4] Salir"
            )

            val option = readLine()?.toIntOrNull()

            when (option) {
                1 -> login() //si login de usuario, menu usuario, si terapeuta o equivocado
                2 -> registrar()
                3 -> registrarTerapeuta()
                4 -> {
                    println("Saliendo del sistema")
                    seguir = false
                }

                else -> println("Inserte una opción válida")
            }
        }
    }

    fun menuUsuario() {

        println(
            "[1] Modicar pass del individuo\n" +
                    "[2] Modificar Rol del usuario\n" +
                    "[3] Borrar individuo\n" +
                    "[4] Volver a menu anterior"
        )
        val option = readlnOrNull()?.toIntOrNull()

        when (option) {
            1 -> modificarUsuarioPass()
            2 -> modificarUsuarioRol()
            3 -> borrarIndividuo()
            4 -> menuInicio()
            else -> menuUsuario()

        }
    }

    fun menuTerapeuta() {

        println(
            "[1] Añadir individuo\n" +
                    "[2] Modicar individuo\n" +
                    "[3] Borrar individuo\n" +
                    "[4] Mostrar usuarios\n" +
                    "[5] Buscar usuario por email\n" +
                    "[4] Añadir individuo a familia\n" +
                    "[5] Modificar descripción familiar\n" +
                    "[6] Administrar terapeutas\n" +
                    "[7] Volver a menu anterior"
        )
        val option = readlnOrNull()?.toIntOrNull()

        when (option) {
            1 -> aniadirIndividuo()
            2 -> modificarIndividuo()
            3 -> borrarIndividuo()
            4 -> mostrarUsuarios()
            5 -> buscarUsuarioPorEmail()
            6 -> aniadirIndividuoAFamilia()
            7 -> modificarDescripcion()
            8 -> menuAdministrarTerapeutas()
            9 -> menuInicio()
            else -> menuTerapeuta()

        }
    }

    fun menuAdministrarTerapeutas() {
        var seguir = true
        while (seguir) {
            println(
                "[1] Añadir terapeuta\n" +
                        "[2] Modificar terapeuta\n" +
                        "[3] Eliminar terapeuta\n" +
                        "[4] Mostrar terapeutas\n" +
                        "[5] Buscar por email\n" +
                        "[6] Volver a menu anterior" +
                        "[7] Salir"
            )
            val option = readLine()?.toIntOrNull()

            when (option) {
                1 -> aniadirTerapeuta()
                2 -> modificarTerapeuta()
                3 -> eliminarTerapeuta()
                4 -> mostrarTerapeutas()
                5 -> buscarTerapeuta()
                6 -> menuTerapeuta()
                7 -> {
                    println("Saliendo del sistema")
                    seguir = false
                }

                else -> {
                    println("Elige bien")
                    menuAdministrarTerapeutas()
                }
            }
        }
    }


}

// FUNCIONES DEL MENU INICIAL
private fun registrar(){
    println("Ingrese los datos del usuario:")
    print("Email: ")
    val email = readLine() ?: ""
    print("Contraseña: ")
    val pass = readLine() ?: ""
    print("Nombre: ")
    val nombre = readLine() ?: ""
    print("Apellidos: ")
    val apellidos = readLine() ?: ""
    print("Familia: ")
    val familia = readLine() ?: ""
    print("Rol: ")
    val rol = readLine() ?: ""

    ControladorUsuario.registrar(email, pass, nombre, apellidos, familia, rol)
    println("Usuario registrado exitosamente.")

}

private fun registrarTerapeuta(){
    println("Ingrese los datos del terapeuta:")
    print("Email: ")
    val email = readLine() ?: ""
    print("Contraseña: ")
    val pass = readLine() ?: ""
    print("Nombre: ")
    val nombre = readLine() ?: ""
    print("Grupo del 1-4: ")
    val grupo = readLine() ?: "" // antes así: readlnOrNull()?.toIntOrNull()?: 0
    print("Metodología: ")
    val metodologia = readLine() ?: ""

    ControladorUsuario.registrar(email, pass, nombre, grupo, metodologia)
    println("Terapeuta registrado exitosamente.")

}

private fun login():ArrayList<String> {
    var retorno = ArrayList<String>()
    print("Email: ")
    val email = readLine().orEmpty()
    print("Contraseña: ")
    val pass = readLine().orEmpty()
    retorno.add(email)
    retorno.add(pass)

    return retorno
}

private fun aniadirIndividuo() {
    println("Ingrese los datos del usuario, terapeutilla de los cojones:")
    print("Email: ")
    val email = readLine() ?: ""
    print("Contraseña: ")
    val pass = readLine() ?: ""
    print("Nombre: ")
    val nombre = readLine() ?: ""
    print("Apellidos: ")
    val apellidos = readLine() ?: ""
    print("Familia: ")
    val familia = readLine() ?: ""
    print("Rol: ")
    val rol = readLine() ?: ""

    ControladorUsuario.registrar(email, pass, nombre, apellidos, familia, rol)
    println("Terapeuta registrado exitosamente.")

}

class InterfazUsuario {
    fun menuInicio() {
        var seguir = true
        while (seguir) {
            println(
                "[1] Login\n" +
                        "[2] Registrarse\n" +
                        "[3] Registrar Terapeuta" +
                        "[4] Salir"
            )

            val option = readLine()?.toIntOrNull()

            when (option) {
                1 -> login() //si login de usuario, pedir cita, comprobar cita y modificar cita
                2 -> registrar()
                3 -> registrarTerapeuta()
                4 -> {
                    println("Saliendo del sistema")
                    seguir = false
                }

                else -> println("Inserte una opción válida")
            }
        }
    }
}

private fun registrar(){
    println("Ingrese los datos del usuario:")
    print("Email: ")
    val email = readLine() ?: ""
    print("Contraseña: ")
    val pass = readLine() ?: ""
    print("Nombre: ")
    val nombre = readLine() ?: ""
    print("Apellidos: ")
    val apellidos = readLine() ?: ""
    print("Familia: ")
    val familia = readLine() ?: ""
    print("Rol: ")
    val rol = readLine() ?: ""

    ControladorUsuario.registrar(email, pass, nombre, apellidos, familia, rol)
    println("Usuario registrado exitosamente.")
}

private fun registrarTerapeuta(){
    println("Ingrese los datos del terapeuta:")
    print("Email: ")
    val email = readLine() ?: ""
    print("Contraseña: ")
    val pass = readLine() ?: ""
    print("Nombre: ")
    val nombre = readLine() ?: ""
    print("Grupo: ")
    val grupo = readLine() ?: ""  // antes así: readlnOrNull()?.toIntOrNull()?: 0
    print("Metodología: ")
    val metodologia = readLine() ?: ""

    ControladorUsuario.registrar(email, pass, nombre, grupo, metodologia)
    println("Terapeuta registrado exitosamente.")
}

private fun login() {
    print("Email: ")
    val email = readLine().orEmpty()
    print("Contraseña: ")
    val password = readLine().orEmpty()

    when (ControladorUsuario.login(email, password)){
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
            1 -> aniadirIndividuo()
            2 -> mostrarUsuarios()
            3 -> buscarUsuarioPorEmail()
            4 -> borrarIndividuo()
            5 -> modificarIndividuo()
            6 -> cambiarPermisosUsuario()
            7 -> seguir = false
            else -> println("Opción inválida. Por favor, seleccione nuevamente.")
        }
    }
}

private fun aniadirIndividuo() {
    println("Ingrese los datos del usuario, terapeutilla de los cojones:")
    print("Email: ")
    val email = readLine() ?: ""
    print("Contraseña: ")
    val pass = readLine() ?: ""
    print("Nombre: ")
    val nombre = readLine() ?: ""
    print("Apellidos: ")
    val apellidos = readLine() ?: ""
    print("Familia: ")
    val familia = readLine() ?: ""
    print("Rol: ")
    val rol = readLine() ?: ""

    ControladorUsuario.registrar(email, pass, nombre, apellidos, familia, rol)
    println("Usuario añadido correctamente.")
}

private fun mostrarUsuarios() {
    val usuarios = ControladorUsuario.obtenerTodosUsuarios()
    println("Lista de usuarios:")
    usuarios.forEach { println(it) }
}

private fun buscarUsuarioPorEmail() {
    print("Ingrese el email del usuario a buscar: ")
    val email = readLine() ?: ""
    val usuario = ControladorUsuario.obtenerUsuarioPorEmail(email)
    if (usuario != null) {
        println("Usuario encontrado: $usuario")
    } else {
        println("No se encontró ningún usuario con el email proporcionado.")
    }
}

private fun borrarIndividuo() {
    print("Ingrese el email del usuario a borrar: ")
    val email = readLine() ?: ""
    val usuario = ControladorUsuario.obtenerUsuarioPorEmail(email)
    if (usuario != null) {
        ControladorUsuario.eliminarUsuario(usuario)
        println("Usuario eliminado correctamente.")
    } else {
        println("No se encontró ningún usuario con el email proporcionado.")
    }
}

private fun cambiarPermisosUsuario() {
    print("Ingrese el email del usuario cuyos permisos desea cambiar: ")
    val email = readLine() ?: ""
    val usuario = ControladorUsuario.obtenerUsuarioPorEmail(email)
    if (usuario != null) {
        print("Ingrese el nuevo rol (ESTANDAR, ADMINISTRADOR o AMBOS): ")
        val nuevoRol = readLine() ?: ""
        ControladorUsuario.cambiarRol(email, nuevoRol)
        println("Rol cambiado correctamente.")
    } else {
        println("No se encontró ningún usuario con el email proporcionado.")
    }
}

private fun modificarIndividuo() {
    print("Ingrese el email del usuario a modificar: ")
    val email = readLine() ?: ""
    val usuario = ControladorUsuario.obtenerUsuarioPorEmail(email)
    if (usuario != null) {
        print("Ingrese la nueva edad: ")
        val nuevaEdad = readLine()?.toIntOrNull() ?: 0
        usuario.edad = nuevaEdad
        ControladorUsuario.actualizarUsuario(usuario)
        println("Edad modificada correctamente.")
    } else {
        println("No se encontró ningún usuario con el email proporcionado.")
    }
}



/*
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

        ControladorUsuario.registrar(email, name, lastName, age, password)
        println("Usuario registrado exitosamente.")
    }

    private fun login() {
        print("Email: ")
        val email = readLine().orEmpty()
        print("Contraseña: ")
        val password = readLine().orEmpty()

        when (ControladorUsuario.login(email, password)){
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

        ControladorUsuario.registrar(email, nombre, apellidos, edad, claveAcceso)
        println("Usuario añadido correctamente.")
    }

    private fun mostrarUsuarios() {
        val usuarios = ControladorUsuario.obtenerTodosUsuarios()
        println("Lista de usuarios:")
        usuarios.forEach { println(it) }
    }

    private fun buscarUsuarioPorEmail() {
        print("Ingrese el email del usuario a buscar: ")
        val email = readLine() ?: ""
        val usuario = ControladorUsuario.obtenerUsuarioPorEmail(email)
        if (usuario != null) {
            println("Usuario encontrado: $usuario")
        } else {
            println("No se encontró ningún usuario con el email proporcionado.")
        }
    }

    private fun borrarUsuario() {
        print("Ingrese el email del usuario a borrar: ")
        val email = readLine() ?: ""
        val usuario = ControladorUsuario.obtenerUsuarioPorEmail(email)
        if (usuario != null) {
            ControladorUsuario.eliminarUsuario(usuario)
            println("Usuario eliminado correctamente.")
        } else {
            println("No se encontró ningún usuario con el email proporcionado.")
        }
    }

    private fun modificarUsuario() {
        print("Ingrese el email del usuario a modificar: ")
        val email = readLine() ?: ""
        val usuario = ControladorUsuario.obtenerUsuarioPorEmail(email)
        if (usuario != null) {
            print("Ingrese la nueva edad: ")
            val nuevaEdad = readLine()?.toIntOrNull() ?: 0
            usuario.edad = nuevaEdad
            ControladorUsuario.actualizarUsuario(usuario)
            println("Edad modificada correctamente.")
        } else {
            println("No se encontró ningún usuario con el email proporcionado.")
        }
    }

    private fun cambiarPermisosUsuario() {
        print("Ingrese el email del usuario cuyos permisos desea cambiar: ")
        val email = readLine() ?: ""
        val usuario = ControladorUsuario.obtenerUsuarioPorEmail(email)
        if (usuario != null) {
            print("Ingrese el nuevo rol (ESTANDAR, ADMINISTRADOR o AMBOS): ")
            val nuevoRol = readLine() ?: ""
            ControladorUsuario.cambiarRol(email, nuevoRol)
            println("Rol cambiado correctamente.")
        } else {
            println("No se encontró ningún usuario con el email proporcionado.")
        }
    }
}*/