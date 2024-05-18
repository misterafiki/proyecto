/**
 * Interfaz que define las operaciones relacionadas con la tabla "individuo" en la base de datos.
 */
interface IndividuoDAO {

    /**
     * Obtiene un [Individuo] por su dirección de correo electrónico.
     *
     * @param email Dirección de correo electrónico del individuo.
     * @return Objeto [Individuo] si se encuentra en la base de datos, o `null` si no existe.
     */
    fun obtenerIndividuoPorEmail(email: String): Individuo?

    /**
     * Obtiene el ID de un [Individuo] por su dirección de correo electrónico.
     *
     * @param email Dirección de correo electrónico del individuo.
     * @return ID del individuo si se encuentra en la base de datos, o `null` si no existe.
     */
    fun obternerIdPorEmail(email: String): Int?

    /**
     * Obtiene todos los individuos desde la base de datos.
     *
     * @return Lista de objetos [Individuo].
     */
    fun obtenerTodosIndividuos(): List<Individuo>

    /**
     * Inserta un nuevo [Individuo] en la base de datos.
     *
     * @param individuo Objeto [Individuo] a insertar.
     * @return `true` si la inserción fue exitosa, `false` en caso contrario.
     */
    fun insertarIndividuo(individuo: Individuo): Boolean

    /**
     * Actualiza la contraseña de un [Individuo] en la base de datos.
     *
     * @param individuo Objeto [Individuo] con la nueva contraseña.
     * @return `true` si la actualización fue exitosa, `false` en caso contrario.
     */
    fun actualizarPassIndividuo(individuo: Individuo): Boolean

    /**
     * Actualiza el rol de un [Individuo] en la base de datos.
     *
     * @param individuo Objeto [Individuo] con el nuevo rol.
     * @return `true` si la actualización fue exitosa, `false` en caso contrario.
     */
    fun actualizarRol(individuo: Individuo): Boolean

    /**
     * Elimina un [Individuo] de la base de datos.
     *
     * @param individuo Objeto [Individuo] a eliminar.
     * @return `true` si la eliminación fue exitosa, `false` en caso contrario.
     */
    fun borrarIndividuo(individuo: Individuo): Boolean

    /**
     * Elimina todos los individuos asociados a una familia de la base de datos.
     *
     * @param id ID de la familia cuyos individuos se eliminarán.
     * @return `true` si la eliminación fue exitosa, `false` en caso contrario.
     */
    fun borrarTodosIndividuos(id: Int): Boolean
}