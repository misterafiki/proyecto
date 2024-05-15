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
    fun getIndividuoByEmail(email: String): Individuo?

    /**
     * Obtiene el ID de un [Individuo] por su dirección de correo electrónico.
     *
     * @param email Dirección de correo electrónico del individuo.
     * @return ID del individuo si se encuentra en la base de datos, o `null` si no existe.
     */
    fun getIdByEmail(email: String): Int?

    /**
     * Obtiene todos los individuos desde la base de datos.
     *
     * @return Lista de objetos [Individuo].
     */
    fun getAllIndividuos(): List<Individuo>

    /**
     * Inserta un nuevo [Individuo] en la base de datos.
     *
     * @param individuo Objeto [Individuo] a insertar.
     * @return `true` si la inserción fue exitosa, `false` en caso contrario.
     */
    fun insertIndividuo(individuo: Individuo): Boolean

    /**
     * Actualiza la contraseña de un [Individuo] en la base de datos.
     *
     * @param individuo Objeto [Individuo] con la nueva contraseña.
     * @return `true` si la actualización fue exitosa, `false` en caso contrario.
     */
    fun updatePassIndividuo(individuo: Individuo): Boolean

    /**
     * Actualiza el rol de un [Individuo] en la base de datos.
     *
     * @param individuo Objeto [Individuo] con el nuevo rol.
     * @return `true` si la actualización fue exitosa, `false` en caso contrario.
     */
    fun updateRole(individuo: Individuo): Boolean

    /**
     * Elimina un [Individuo] de la base de datos.
     *
     * @param individuo Objeto [Individuo] a eliminar.
     * @return `true` si la eliminación fue exitosa, `false` en caso contrario.
     */
    fun deleteIndividuo(individuo: Individuo): Boolean

    /**
     * Elimina todos los individuos asociados a una familia de la base de datos.
     *
     * @param id ID de la familia cuyos individuos se eliminarán.
     * @return `true` si la eliminación fue exitosa, `false` en caso contrario.
     */
    fun deleteAllIndividuos(id: Int): Boolean
}