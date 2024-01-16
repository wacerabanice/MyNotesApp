package net.pata.data

import com.google.firebase.auth.FirebaseUser
import net.pata.data.local.PreviousOperationDao
import net.pata.ui.theme.auth.PreviousOperation
import kotlinx.coroutines.flow.distinctUntilChanged
import javax.inject.Inject

interface AuthRepository {
    val currentUser: FirebaseUser?
    suspend fun login(email: String, password: String): Resource<FirebaseUser>
    suspend fun register(name: String, email: String, password: String, phoneNumber: String): Resource<FirebaseUser>
    fun logout()
}



class PreviousOperationRepository @Inject constructor(
    private val previousOperationDao: PreviousOperationDao,
) {

    val listPreviousOperationsFlow =
        previousOperationDao.getListPreviousOperations().distinctUntilChanged()

    suspend fun insert(previousOperation: PreviousOperation) {
        previousOperationDao.insert(previousOperation)
    }

    suspend fun clear() {
        previousOperationDao.clear()
    }
}
