import logica.ControladorFamilia
import logica.ControladorTerapeuta

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
            1 -> modificarPassIndividuo()
            2 -> modificarRolIndividuo()
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
                    "[6] Añadir familia\n" +
                    "[7] Añadir individuo a familia\n" +
                    "[8] Modificar descripción familiar\n" +
                    "[9] Administrar terapeutas\n" +
                    "[0] Volver a menu anterior"
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
                2 -> modificarGrupoTerapeuta()
                3 -> eliminarTerapeuta()
                4 -> mostrarTerapeutas()
                5 -> buscarTerapeutaPorEmail()
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

    ControladorIndividuoRol.registrar(email, pass, nombre, apellidos, familia, rol)
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

    ControladorTerapeuta.registrar(email, pass, nombre, grupo, metodologia)
    println("Terapeuta registrado exitosamente.")
}

private fun login() {
    var menu = InterfazUsuario()
    print("Email: ")
    val email = readLine().orEmpty()
    print("Contraseña: ")
    val password = readLine().orEmpty()

    if (ControladorIndividuoRol.login(email, password)){
        menu.menuUsuario()
    }
    else if (ControladorTerapeuta.login(email,password)){
        menu.menuTerapeuta()
    }
    else println("Email o contraseña incorrectos.")
}

//FUNCIONES DE MENU TERAPEUTA -- INDIVIDUOS

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

//FUNCIONES DE MENU TERAPEUTA -- FAMILIAS
private fun registrarFamilia(){
    println ("Inserte nueva ID")
    var id = readlnOrNull()?:0
    println ("Inserte descripción de la familia")
    var descripcion= readlnOrNull()?:""
    ControladorFamilia.registrar(id,descripcion)
}
private fun mostrarFamilias(){
    val familias = ControladorFamilia.obtenerFamilias()
    println("Lista de familias:")
    familias.forEach { println(it) }
}
private fun modificarFamilia(){
    println("Inserte id de familia a borrar: ")
    var id = readlnOrNull()?:0
    println("Inserte descripcion de familia a borrar: ")
    var descripcion = readlnOrNull()?:""
    familia.id = id
    familia.descripcion = descripcion
    ControladorFamilia.actualizarFamilia(familia)
}
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
private fun mostrarTerapeutas(){
    val terapeutas = ControladorTerapeuta.obtenerTodosTerapeuras()
    println("Lista de usuarios:")
    terapeutas.forEach { println(it) }
}
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
