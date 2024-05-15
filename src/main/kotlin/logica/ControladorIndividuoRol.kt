import java.util.*

/**
 * Clase que actúa como controlador para las operaciones relacionadas con los individuos y sus roles.
 */
class ControladorIndividuoRol() {
    companion object {

        private val usuarioDAO = IndividuoDAOImpl()

        /**
         * Registra un nuevo individuo en la base de datos.
         *
         * @param email Dirección de correo electrónico del individuo.
         * @param pass Contraseña del individuo.
         * @param nombre Nombre del individuo.
         * @param apellidos Apellidos del individuo.
         * @param familia ID de la familia a la que pertenece el individuo.
         * @param rol Rol del individuo (PADRE, HIJO, OTRO).
         */
        fun registrar(email: String, pass: String, nombre: String, apellidos: String, familia: Int, rol: Rol) {
            val usuarioNuevo = Individuo(email, pass, nombre, apellidos, familia, rol)
            usuarioDAO.insertIndividuo(usuarioNuevo)
        }

        /**
         * Realiza el inicio de sesión para un individuo.
         *
         * @param email Dirección de correo electrónico del individuo.
         * @param password Contraseña proporcionada por el individuo.
         * @return Rol del individuo si el inicio de sesión es exitoso, o `null` si no se encuentra o la contraseña es incorrecta.
         */
        fun login(email: String, password: String): Rol? {
            val usuario = usuarioDAO.getIndividuoByEmail(email)
            var rol: Rol? = null

            if (usuario != null && usuario.pass == password) {
                rol = usuario.rol
            }

            return rol
        }

        /**
         * Obtiene todos los individuos desde la base de datos.
         *
         * @return Lista de objetos [Individuo].
         */
        fun obtenerTodosUsuarios(): List<Individuo> {
            return usuarioDAO.getAllIndividuos()
        }

        /**
         * Obtiene un individuo por su dirección de correo electrónico.
         *
         * @param email Dirección de correo electrónico del individuo.
         * @return Objeto [Individuo] si se encuentra en la base de datos, o `null` si no existe.
         */
        fun obtenerUsuarioPorEmail(email: String): Individuo? {
            return usuarioDAO.getIndividuoByEmail(email)
        }

        /**
         * Elimina un individuo de la base de datos.
         *
         * @param usuario Objeto [Individuo] a eliminar.
         * @return `true` si la eliminación fue exitosa, `false` en caso contrario.
         */
        fun eliminarUsuario(usuario: Individuo): Boolean {
            return usuarioDAO.deleteIndividuo(usuario)
        }

        /**
         * Actualiza la contraseña de un individuo en la base de datos.
         *
         * @param usuario Objeto [Individuo] con la nueva contraseña.
         * @return `true` si la actualización fue exitosa, `false` en caso contrario.
         */
        fun actualizarUsuario(usuario: Individuo): Boolean {
            return usuarioDAO.updatePassIndividuo(usuario)
        }

        /**
         * Cambia el rol de un individuo en la base de datos.
         *
         * @param email Dirección de correo electrónico del individuo.
         * @param nuevoRol Nuevo rol del individuo (PADRE, HIJO, OTRO).
         */
        fun cambiarRol(email: String, nuevoRol: String) {
            val usuario = usuarioDAO.getIndividuoByEmail(email)

            if (usuario != null) {
                val rolEnum = when (nuevoRol.uppercase(Locale.getDefault())) {
                    "PADRE" -> Rol.PADRE
                    "HIJO" -> Rol.HIJO
                    "OTRO" -> Rol.OTRO
                    else -> throw IllegalArgumentException("Rol desconocido: $nuevoRol")
                }
                usuario.rol = rolEnum
                usuarioDAO.updateRole(usuario)
            }
        }
    }
}