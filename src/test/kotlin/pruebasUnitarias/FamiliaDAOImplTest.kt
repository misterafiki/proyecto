package pruebasUnitarias

import BBDD.FamiliaDAOImpl
import Familia
import org.junit.jupiter.api.*
import java.sql.SQLException

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
    fun getAllFamiliasTestUno() {
        val result = familiaRepository.getAllFamilias()
        Assertions.assertTrue(result.isEmpty())
    }

    /**
     * Test que verifica que el método [FamiliaDAOImpl.insertFamilia] inserta una nueva familia
     * correctamente en la base de datos.
     */
    @Test
    fun insertFamiliaTestUno() {
        val familia = Familia(1, "Nueva Familia")
        val result = familiaRepository.insertFamilia(familia)
        Assertions.assertTrue(result)
    }

    /**
     * Test que verifica que el método [FamiliaDAOImpl.updateFamilia] actualiza la descripción
     * de una familia existente en la base de datos.
     */
    @Test
    fun updateFamiliaTestUno() {
        val familia = Familia(1, "Familia Actualizada")
        val result = familiaRepository.updateFamilia(familia)
        Assertions.assertTrue(result)
    }

    /**
     * Test que verifica que el método [FamiliaDAOImpl.deleteFamilia] elimina una familia existente
     * en la base de datos.
     */
    @Test
    fun deleteFamiliaTestUno() {
        val familia = Familia(1, "Familia a Eliminar")
        familiaRepository.insertFamilia(familia)
        val result = familiaRepository.deleteFamilia(familia)
        Assertions.assertTrue(result)
    }

    /**
     * Test que verifica que el método [FamiliaDAOImpl.getAllFamilias] retorna una lista con las familias
     * existentes en la base de datos.
     */
    @Test
    fun getAllFamiliasTestDos() {
        val familia1 = Familia(1, "Familia 1")
        val familia2 = Familia(2, "Familia 2")
        familiaRepository.insertFamilia(familia1)
        familiaRepository.insertFamilia(familia2)
        val result = familiaRepository.getAllFamilias()
        Assertions.assertEquals(2, result.size)
        Assertions.assertTrue(result.contains(familia1))
        Assertions.assertTrue(result.contains(familia2))
    }

    /**
     * Test que verifica que el método [FamiliaDAOImpl.insertFamilia] falla cuando se intenta
     * insertar una familia con un ID duplicado.
     */
    @Test
    fun insertFamiliaTestDos() {
        val familia = Familia(1, "Familia Duplicada")
        familiaRepository.insertFamilia(familia)
        val result = assertThrows<SQLException> { familiaRepository.insertFamilia(familia) }
        Assertions.assertNotNull(result)
    }

    /**
     * Test que verifica que el método [FamiliaDAOImpl.updateFamilia] falla cuando se intenta
     * actualizar una familia inexistente en la base de datos.
     */
    @Test
    fun updateFamiliaTestDos() {
        val familia = Familia(999, "Familia Inexistente")
        val result = assertThrows<SQLException> { familiaRepository.updateFamilia(familia) }
        Assertions.assertNotNull(result)
    }

    /**
     * Test que verifica que el método [FamiliaDAOImpl.deleteFamilia] falla cuando se intenta
     * eliminar una familia inexistente en la base de datos.
     */
    @Test
    fun deleteFamiliaTestDos() {
        val familia = Familia(999, "Familia Inexistente")
        val result = assertThrows<SQLException> { familiaRepository.deleteFamilia(familia) }
        Assertions.assertNotNull(result)
    }
}