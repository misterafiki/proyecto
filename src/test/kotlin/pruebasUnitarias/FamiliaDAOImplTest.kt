package pruebasUnitarias

import BBDD.FamiliaDAOImpl
import Familia
import org.junit.jupiter.api.*

/**
 * Pruebas unitarias para la clase [FamiliaDAOImpl].
 */
class FamiliaDAOImplTest {

    // Repositorio de Familia para realizar pruebas
    private val familiaRepository = FamiliaDAOImpl()

    /**
     * Test que verifica que el método [FamiliaDAOImpl.getAllFamilias] retorna una lista vacía
     * cuando no hay familias en la base de datos.
     */
    @Test
    fun getAllFamiliasTestEmpty() {
        val result = familiaRepository.getAllFamilias()
        Assertions.assertTrue(result.isEmpty())
    }

    /**
     * Test que verifica que el método [FamiliaDAOImpl.getAllFamilias] retorna una lista con elementos
     * cuando hay familias en la base de datos.
     */
    @Test
    fun getAllFamiliasTestNotEmpty() {
        val result = familiaRepository.getAllFamilias()
        Assertions.assertTrue(result.isNotEmpty())
    }

    /**
     * Test que verifica que el método [FamiliaDAOImpl.insertFamilia] inserta una nueva familia
     * correctamente en la base de datos.
     */
    @Test
    fun insertFamiliaTest() {
        val familia = Familia(1, "Nueva Familia")
        val result = familiaRepository.insertFamilia(familia)
        Assertions.assertTrue(result)
    }

    /**
     * Test que verifica que el método [FamiliaDAOImpl.updateFamilia] actualiza la descripción
     * de una familia existente en la base de datos.
     */
    @Test
    fun updateFamiliaTest() {
        val familia = Familia(1, "Familia Actualizada")
        val result = familiaRepository.updateFamilia(familia)
        Assertions.assertTrue(result)
    }

    /**
     * Test que verifica que el método [FamiliaDAOImpl.deleteFamilia] elimina una familia existente
     * en la base de datos.
     */
    @Test
    fun deleteFamiliaTest() {
        val familia = Familia(1, "Familia a Eliminar")
        familiaRepository.insertFamilia(familia)
        val result = familiaRepository.deleteFamilia(familia)
        Assertions.assertTrue(result)
    }
}