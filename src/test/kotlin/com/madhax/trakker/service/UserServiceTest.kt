package com.madhax.trakker.service

import com.madhax.trakker.model.User
import com.madhax.trakker.repository.UserRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers
import org.mockito.ArgumentMatchers.any
import org.mockito.BDDMockito.anyLong
import org.mockito.BDDMockito.given
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.util.*

@ExtendWith(SpringExtension::class)
internal class UserServiceTest {

    val KNOWN_ID: Long = 1L
    val KNOWN_USERNAME = "MADHAX"

    @Mock
    lateinit var userRepository: UserRepository

    @InjectMocks
    lateinit var userService: UserService

    lateinit var user: User
    lateinit var userList: List<User>

    @BeforeEach
    fun setUp() {

        user = User(
                id = KNOWN_ID,
                firstName = "Taylor",
                lastName = "Swift",
                userName = KNOWN_USERNAME,
                password = "taylorPassword",
                email = "t.swift@gmail.com",
                enabled = true)

        userList = Arrays.asList(
                user,
                User(
                        id = 2L,
                        firstName = "Sasha",
                        lastName = "Digiulian",
                        userName = "sasha.d",
                        password = "sashaPassword",
                        email = "s.diguilian@gmail.com",
                        enabled = true),
                User(
                        id = KNOWN_ID,
                        firstName = "Jessica",
                        lastName = "Alba",
                        userName = "jess",
                        password = "jessicaPassword",
                        email = "j.alba@gmail.com",
                        enabled = true) )
    }

    @Test
    fun getAll() {

        given(userRepository.findAll()).willReturn(userList)

        val returnedUsers: List<User> = userService.getAll()

        assertEquals(3, returnedUsers.size)

        verify(userRepository, times(1)).findAll()
    }

    @Test
    fun getById() {

        given(userRepository.findById(anyLong())).willReturn(Optional.of(user))

        val returnedUSer = userService.getById(KNOWN_ID)

        assertEquals(KNOWN_ID, returnedUSer.id)
        assertEquals(KNOWN_USERNAME, returnedUSer.userName)

        verify(userRepository, times(1)).findById(ArgumentMatchers.anyLong())
    }

    @Test
    fun save() {

        given(userRepository.save(any(User::class.java))).willReturn(user)

        val savedUser = userService.save(user)

        assertEquals(KNOWN_USERNAME, savedUser.userName)
        assertEquals(KNOWN_ID, savedUser.id)

        verify(userRepository, times(1)).save(any(User::class.java))
    }

    @Test
    fun deleteById() {
        userService.deleteById(KNOWN_ID)
        verify(userRepository, times(1)).deleteById(anyLong())
    }
}
