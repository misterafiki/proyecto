package BBDD
import ConexionBD
import Terapeuta

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*


private val conexion = ConexionBD()
class TerapeutaDAOImplTest {

    private val terapeutaRepository = TerapeutaDAOImpl()


    @BeforeEach
    fun init() {
        // Limpieza y preparación de la base de datos antes de cada prueba
        conexion.conectar()
        val statement = conexion.getStatement()
        statement?.execute("DELETE FROM terapeuta") // Limpiar la tabla
        statement?.execute("INSERT INTO terapeuta (email, pass, nombre, grupo, metodologia) VALUES ('terapeuta1@example.com', 'password1', 'Terapeuta Uno', 1, 'METODO1')")
        statement?.execute("INSERT INTO terapeuta (email, pass, nombre, grupo, metodologia) VALUES ('terapeuta2@example.com', 'password2', 'Terapeuta Dos', 2, 'METODO2')")
        statement?.execute("INSERT INTO terapeuta (email, pass, nombre, grupo, metodologia) VALUES ('terapeuta3@example.com', 'password3', 'Terapeuta Tres', 3, 'METODO3')")
        statement?.close()
        conexion.desconectar()
    }

    @Test
    fun getTerapeutaByEmail() {
        // Act
        val terapeuta = terapeutaRepository.getTerapeutaByEmail("terapeuta1@example.com")

        // Assert
        assertNotNull(terapeuta)
        assertEquals("terapeuta1@example.com", terapeuta?.email)
        assertEquals("password1", terapeuta?.pass)
        assertEquals("Terapeuta Uno", terapeuta?.nombre)
    }

    @Test
    fun getAllTerapeutas() {
        // Act
        val terapeutas = terapeutaRepository.getAllTerapeuta()

        // Assert
        assertEquals(3, terapeutas.size) // Suponiendo que esperamos 3 terapeutas en la base de datos
        assertEquals("terapeuta1@example.com", terapeutas[0].email)
        assertEquals("terapeuta2@example.com", terapeutas[1].email)
        assertEquals("terapeuta3@example.com", terapeutas[2].email)
    }

    @Test
    fun insertTerapeuta() {
        // Arrange
        val nuevoTerapeuta = Terapeuta("new@example.com", "newpass", "Nuevo Terapeuta", 4, Metodologia.METODO1)

        // Act
        val resultado = terapeutaRepository.insertTerapeuta(nuevoTerapeuta)
        val terapeutaInsertado = terapeutaRepository.getTerapeutaByEmail("new@example.com")

        // Assert
        assertTrue(resultado)
        assertNotNull(terapeutaInsertado)
        assertEquals("new@example.com", terapeutaInsertado?.email)
        assertEquals("newpass", terapeutaInsertado?.pass)
        assertEquals("Nuevo Terapeuta", terapeutaInsertado?.nombre)
    }

    @Test
    fun updateGrupo() {
        // Arrange
        val terapeutaExistente = terapeutaRepository.getTerapeutaByEmail("terapeuta1@example.com")!!
        terapeutaExistente.grupo = 2

        // Act
        val resultado = terapeutaRepository.updateGrupo(terapeutaExistente)
        val terapeutaActualizado = terapeutaRepository.getTerapeutaByEmail("terapeuta1@example.com")

        // Assert
        assertTrue(resultado)
        assertEquals(10, terapeutaActualizado?.grupo)
    }

    @Test
    fun updateMetodo() {
        // Arrange
        val terapeutaExistente = terapeutaRepository.getTerapeutaByEmail("terapeuta1@example.com")!!
        terapeutaExistente.metodologia = Metodologia.METODO2

        // Act
        val resultado = terapeutaRepository.updateMetodo(terapeutaExistente)
        val terapeutaActualizado = terapeutaRepository.getTerapeutaByEmail("terapeuta1@example.com")

        // Assert
        assertTrue(resultado)
        assertEquals(Metodologia.METODO2, terapeutaActualizado?.metodologia)
    }

    @Test
    fun deleteTerapeuta() {
        // Arrange
        val terapeutaExistente = terapeutaRepository.getTerapeutaByEmail("terapeuta1@example.com")!!

        // Act
        val resultado = terapeutaRepository.deleteTerapeuta(terapeutaExistente)
        val terapeutaBorrado = terapeutaRepository.getTerapeutaByEmail("terapeuta1@example.com")

        // Assert
        assertTrue(resultado)
        assertNull(terapeutaBorrado)
    }
}