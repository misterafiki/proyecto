package BBDD

import Familia

/**
 * Interfaz que define las operaciones relacionadas con la tabla "familia" en la base de datos.
 */
interface FamiliaDAO {

    /**
     * Obtiene todas las familias desde la base de datos.
     *
     * @return Lista de objetos [Familia].
     */
    fun getAllFamilias(): List<Familia>

    /**
     * Inserta una nueva familia en la base de datos.
     *
     * @param familia Objeto [Familia] a insertar.
     * @return `true` si la inserción fue exitosa, `false` en caso contrario.
     */
    fun insertFamilia(familia: Familia): Boolean

    /**
     * Actualiza una familia existente en la base de datos.
     *
     * @param familia Objeto [Familia] con los datos actualizados.
     * @return `true` si la actualización fue exitosa, `false` en caso contrario.
     */
    fun updateFamilia(familia: Familia): Boolean

    /**
     * Elimina una familia de la base de datos.
     *
     * @param familia Objeto [Familia] a eliminar.
     * @return `true` si la eliminación fue exitosa, `false` en caso contrario.
     */
    fun deleteFamilia(familia: Familia): Boolean
}