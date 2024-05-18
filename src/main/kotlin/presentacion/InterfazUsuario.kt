import logica.ControladorFamilia
import logica.ControladorTerapeuta

/**
 * Clase que proporciona la interfaz de usuario para la aplicación.
 * Contiene menús y opciones para los individuos y los terapeutas.
 */
class InterfazUsuario{

    companion object {
        /**
         * Muestra el menú de inicio con opciones para iniciar sesión, registrarse, registrar un terapeuta o salir del sistema.
         * En concreto la opción de iniciar sesión identifica al usuario como individuo o terapeuta y le lanza a su menú correspondiente
         * Mantiene el bucle hasta que el usuario decide salir.
         */
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
                    1 -> login()
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

        /**
         * Muestra el menú de individuo con opciones para modificar la contraseña, cambiar el rol del usuario,
         * borrar un usuario o volver al menú anterior.
         */
        fun menuUsuario() {

            println(
                "[1] Modicar pass del individuo\n" +
                        "[2] Modificar Rol del usuario\n" +
                        "[3] Borrar individuo\n" +
                        "[4] Volver a menu anterior"
            )
            val option = readlnOrNull()?.toIntOrNull()

            when (option) {
                1 -> modificarPassIndividuo()
                2 -> modificarRolIndividuo()
                3 -> borrarIndividuo()
                4 -> menuInicio()
                else -> menuUsuario()

            }
        }

        /**
         * Muestra el menú de terapeuta con opciones para añadir, modificar o borrar individuos,
         * mostrar usuarios, buscar usuarios por email, administrar familias,
         * acceder al menú de administrar terapeutas, o volver al menú anterior.
         */
        fun menuTerapeuta() {

            println(
                "[1] Añadir individuo\n" +
                        "[2] Modicar individuo\n" +
                        "[3] Borrar individuo\n" +
                        "[4] Mostrar usuarios\n" +
                        "[5] Buscar usuario por email\n" +
                        "[6] Añadir familia\n" +
                        "[7] Mostrar familias\n" +
                        "[8] Modificar descripción familiar\n" +
                        "[9] Borrar familia\n" +
                        "[10] Administrar terapeutas\n" +
                        "[11] Volver a menu anterior"
            )
            val option = readlnOrNull()?.toIntOrNull()

            when (option) {
                1 -> aniadirIndividuo()
                2 -> modificarPassIndividuo()
                3 -> borrarIndividuo()
                4 -> mostrarUsuarios()
                5 -> buscarUsuarioPorEmail()
                6 -> registrarFamilia()
                7 -> mostrarFamilias()
                8 -> modificarFamilia()
                9 -> borrarFamilia()
                10 -> menuAdministrarTerapeutas()
                11 -> menuInicio()
                else -> menuTerapeuta()

            }
        }
        /**
         * Muestra el menú para administrar terapeutas con opciones para añadir, modificar o eliminar terapeutas,
         * mostrar terapeutas, buscar terapeutas por email, volver al menú anterior o salir del sistema.
         * Mantiene el bucle hasta que el usuario decide salir.
         */
        fun menuAdministrarTerapeutas() {
            var seguir = true
            while (seguir) {
                println(
                    "[1] Añadir terapeuta\n" +
                            "[2] Modificar grupo del terapeuta\n" +
                            "[3] Modificar metodología del terapeuta\n" +
                            "[4] Eliminar terapeuta\n" +
                            "[5] Mostrar terapeutas\n" +
                            "[6] Buscar por email\n" +
                            "[7] Volver a menu anterior" +
                            "[8] Salir"
                )
                val option = readLine()?.toIntOrNull()

                when (option) {
                    1 -> aniadirTerapeuta()
                    2 -> modificarGrupoTerapeuta()
                    3 -> modificarMetodoTerapeuta()
                    4 -> eliminarTerapeuta()
                    5 -> mostrarTerapeutas()
                    6 -> buscarTerapeutaPorEmail()
                    7 -> menuTerapeuta()
                    8 -> {
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

}

// FUNCIONES DEL MENU INICIAL
/**
 * Registra un nuevo usuario en el sistema solicitando los datos necesarios.
 * Pide al usuario que ingrese su email, contraseña, nombre, apellidos, familia y rol.
 * Luego, llama al controlador correspondiente para registrar al usuario.
 */
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

    ControladorIndividuoRol.registrar(email, pass, nombre, apellidos, familia, rol)
    println("Usuario registrado exitosamente.")
}

/**
 * Registra un nuevo terapeuta en el sistema solicitando los datos necesarios.
 * Pide al usuario que ingrese su email, contraseña, nombre, grupo y metodología.
 * Luego, llama al controlador correspondiente para registrar al terapeuta.
 */
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

    ControladorTerapeuta.registrar(email, pass, nombre, grupo, metodologia)
    println("Terapeuta registrado exitosamente.")
}
/**
 * Inicia sesión en el sistema solicitando el email y la contraseña del usuario.
 * Dependiendo del tipo de usuario (normal o terapeuta), redirige al menú correspondiente.
 * Si las credenciales son incorrectas, muestra un mensaje de error.
 */
private fun login() {
    print("Email: ")
    val email = readLine().orEmpty()
    print("Contraseña: ")
    val password = readLine().orEmpty()

    if (ControladorUsuario.login(email, password)){
        if (Rol != null) InterfazUsuario.menuUsuario()
    }
    else if (ControladorTerapeuta.login(email,password)){
        InterfazUsuario.menuTerapeuta()
    }
    else println("Email o contraseña incorrectos.")
}

//FUNCIONES DE MENU TERAPEUTA -- INDIVIDUOS

/**
 * Añade un nuevo individuo al sistema solicitando los datos necesarios.
 * Pide al terapeuta que ingrese el email, contraseña, nombre, apellidos, familia y rol.
 * Luego, llama al controlador correspondiente para registrar al individuo.
 */
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

    ControladorIndividuoRol.registrar(email, pass, nombre, apellidos, familia, rol)
    println("Terapeuta registrado exitosamente.")
}
/**
 * Muestra la lista de todos los individuos en el sistema.
 * Obtiene la lista desde el controlador y la imprime en la consola.
 */
private fun mostrarUsuarios() {
    val usuarios = ControladorIndividuoRol.obtenerTodosUsuarios()
    println("Lista de usuarios:")
    usuarios.forEach { println(it) }
}
/**
 * Busca un usuario por su email en el sistema.
 * Pide al terapeuta que ingrese el email y muestra la información del usuario si se encuentra.
 * Si no se encuentra, muestra un mensaje de error.
 */
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
/**
 * Borra un individuo del sistema por su email.
 * Pide al terapeuta que ingrese el email, busca al individuo y lo elimina si se encuentra.
 * Si no se encuentra, muestra un mensaje de error.
 */
private fun borrarIndividuo() {
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
/**
 * Modifica la contraseña de un individuo en el sistema.
 * Pide al terapeuta que ingrese el email del usuario a modificar y la nueva contraseña.
 * Actualiza la contraseña del individuo si se encuentra.
 * Si no se encuentra, muestra un mensaje de error.
 */
private fun modificarPassIndividuo() {
    print("Ingrese el email del usuario a modificar: ")
    val email = readLine() ?: ""
    val usuario = ControladorIndividuoRol.obtenerUsuarioPorEmail(email)
    if (usuario != null) {
        print("Ingrese la nueva pass: ")
        val nuevaPass = readLine()?: ""
        usuario.pass = nuevaPass
        ControladorIndividuoRol.actualizarUsuario(usuario)
        println("Pass modificada correctamente.")
    } else {
        println("No se encontró ningún usuario con el email proporcionado.")
    }
}
/**
 * Modifica el rol de un individuo en el sistema.
 * Pide al terapeuta que ingrese el email del individuo a modificar y el nuevo rol.
 * Actualiza el rol del individuo si se encuentra.
 * Si no se encuentra, muestra un mensaje de error.
 */
private fun modificarRolIndividuo() {
    print("Ingrese el email del usuario a modificar: ")
    val email = readLine() ?: ""
    val usuario = ControladorIndividuoRol.obtenerUsuarioPorEmail(email)
    if (usuario != null) {
        print("Seleccione nuevo rol: ")
        val nuevoRol = readLine()?: ""
        usuario.Rol = nuevoRol
        ControladorIndividuoRol.cambiarRol(email, nuevoRol)
        println("Rol modificado correctamente.")
    } else {
        println("No se encontró ningún usuario con el email proporcionado.")
    }
}

//FUNCIONES DE MENU TERAPEUTA -- PARTE FAMILIAS
/**
 * Registra una nueva familia en el sistema solicitando los datos necesarios.
 * Pide al terapeuta que ingrese la ID y la descripción de la familia.
 * Luego, llama al controlador correspondiente para registrar la familia.
 */
private fun registrarFamilia(){
    println ("Inserte nueva ID")
    var id = readlnOrNull()?:0
    println ("Inserte descripción de la familia")
    var descripcion= readlnOrNull()?:""
    ControladorFamilia.registrar(id,descripcion)
}
/**
 * Muestra la lista de todas las familias en el sistema.
 * Obtiene la lista desde el controlador y la imprime en la consola.
 */
private fun mostrarFamilias(){
    val familias = ControladorFamilia.obtenerFamilias()
    println("Lista de familias:")
    familias.forEach { println(it) }
}
/**
 * Modifica una familia existente en el sistema solicitando los datos necesarios.
 * Pide al terapeuta que ingrese la ID y la nueva descripción de la familia.
 * Luego, llama al controlador correspondiente para actualizar la familia.
 */
private fun modificarFamilia(){
    println("Inserte id de familia a borrar: ")
    var id = readlnOrNull()?:0
    println("Inserte descripcion de familia a borrar: ")
    var descripcion = readlnOrNull()?:""
    familia.id = id
    familia.descripcion = descripcion
    ControladorFamilia.actualizarFamilia(familia)
}
/**
 * Borra una familia del sistema solicitando los datos necesarios.
 * Pide al terapeuta que ingrese la ID y la descripción de la familia.
 * Luego, llama al controlador correspondiente para eliminar la familia.
 */
private fun borrarFamilia(){
    println("Inserte id de familia a borrar: ")
    var id = readlnOrNull()?:0
    println("Inserte descripcion de familia a borrar: ")
    var descripcion = readlnOrNull()?:""
    var familia = Familia()
    familia.id = id
    familia.descripcion = descripcion
    ControladorFamilia.eliminarFamilia(familia)
}

//FUNCIONES DE MENU ADMINISTRACION TERAPEUTAS:
/**
 * Añade un nuevo terapeuta al sistema solicitando los datos necesarios.
 * Pide al terapeuta que ha accedido, que ingrese el email, contraseña, nombre, grupo y metodología.
 * Luego, llama al controlador correspondiente para registrar al terapeuta.
 */
private fun aniadirTerapeuta(){
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

    ControladorTerapeuta.registrar(email, pass, nombre, grupo, metodologia)
    println("Terapeuta registrado exitosamente.")
}
/**
 * Modifica el grupo de un terapeuta en el sistema.
 * Pide al terapeuta que ha accedido, que ingrese el email del terapeuta y el nuevo grupo.
 * Luego, llama al controlador correspondiente para actualizar el grupo del terapeuta.
 */
private fun modificarGrupoTerapeuta(){
    print("Ingrese el email del terapeuta a buscar: ")
    val email = readLine() ?: ""
    val terapeuta = ControladorTerapeuta.obtenerTerapeuraPorEmail(email)
    if (terapeuta != null) {
        print("Ingrese el nuevo grupo del terapeuta: ")
        var grupo = readlnOrNull()?.toIntOrNull()
        ControladorTerapeuta.cambiarGrupo(email, grupo)
    }
}
/**
 * Modifica la metodología de un terapeuta en el sistema.
 * Pide al terapeuta que ha accedido, que ingrese el email del terapeuta y la nueva metodología.
 * Luego, llama al controlador correspondiente para actualizar la metodología del terapeuta.
 */
private fun modificarMetodoTerapeuta(){
    print("Ingrese el email del terapeuta a buscar: ")
    val email = readLine() ?: ""
    val terapeuta = ControladorTerapeuta.obtenerTerapeuraPorEmail(email)
    if (terapeuta != null) {
        print("Ingrese el nueva metodología del terapeuta: ")
        var metodologia = readlnOrNull()?:""
        ControladorTerapeuta.cambiarGrupo(email, metodologia)
    }
}
/**
 * Elimina un terapeuta del sistema solicitando el email del terapeuta.
 * Pide al terapeuta que ha accedido, que ingrese el email del terapeuta, lo busca y lo elimina si se encuentra.
 * Si no se encuentra, muestra un mensaje de error.
 */
private fun eliminarTerapeuta(){
    print("Ingrese el email del usuario a borrar: ")
    print("Ingrese el email del terapeuta a buscar: ")
    val email = readLine() ?: ""
    val terapeuta = ControladorTerapeuta.obtenerTerapeuraPorEmail(email)
    if (terapeuta != null) {
        ControladorTerapeuta.eliminarTerapeura(terapeuta)
        println("Terapeuta eliminado correctamente.")
    } else {
        println("No se encontró ningún terpeuta con el email proporcionado.")
    }
}
/**
 * Muestra la lista de todos los terapeutas en el sistema.
 * Obtiene la lista desde el controlador y la imprime en la consola.
 */
private fun mostrarTerapeutas(){
    val terapeutas = ControladorTerapeuta.obtenerTodosTerapeuras()
    println("Lista de usuarios:")
    terapeutas.forEach { println(it) }
}
/**
 * Busca un terapeuta por su email en el sistema.
 * Pide al terapeuta que ha accedido, que ingrese el email y muestra la información del terapeuta si se encuentra.
 * Si no se encuentra, muestra un mensaje de error.
 */
private fun buscarTerapeutaPorEmail(){
    print("Ingrese el email del terapeuta a buscar: ")
    val email = readLine() ?: ""
    val terapeuta = ControladorTerapeuta.obtenerTerapeuraPorEmail(email)
    if (terapeuta != null) {
        println("Terapeuta encontrado: $terapeuta")
    } else {
        println("No se encontró ningún terapeuta con el email proporcionado.")
    }
}