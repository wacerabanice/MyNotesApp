package net.pata.ui.theme.auth


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import net.pata.data.AuthRepository
import net.pata.data.Resource
import net.pata.data.utils.decimalFormat
import javax.inject.Inject
import kotlin.math.pow


@HiltViewModel
class AuthViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    private val _homeFlow = MutableStateFlow<Resource<FirebaseUser>?>(null)
    val homeFlow: StateFlow<Resource<FirebaseUser>?> = _homeFlow

    private val _loginFlow = MutableStateFlow<Resource<FirebaseUser>?>(null)
    val loginFlow: StateFlow<Resource<FirebaseUser>?> = _loginFlow

    private val _registerFlow = MutableStateFlow<Resource<FirebaseUser>?>(null)
    val registerFlow: StateFlow<Resource<FirebaseUser>?> = _registerFlow

    private val _aboutFlow = MutableStateFlow<Resource<FirebaseUser>?>(null)
    val aboutFlow: StateFlow<Resource<FirebaseUser>?> = _aboutFlow

    val currentUser: FirebaseUser?
        get() = repository.currentUser

    init {
        if (repository.currentUser != null) {
            _loginFlow.value = Resource.Success(repository.currentUser!!)
        }
    }

    fun login(email: String, password: String) = viewModelScope.launch {
        _loginFlow.value = Resource.Loading
        val result = repository.login(email, password)
        _loginFlow.value = result
    }

    fun register(name: String, email: String, password: String, phoneNumber: String) = viewModelScope.launch {
        _registerFlow.value = Resource.Loading
        val result = repository.register(name, email, password, phoneNumber)
        _registerFlow.value = result
    }

    fun logout() {
        repository.logout()
        _loginFlow.value = null
        _registerFlow.value = null
        _aboutFlow.value = null
    }


}



data class EmiCalculatorState(
    val isFirstEmiCalculator: Boolean = true,
    val isSecondEmiCalculator: Boolean = false,
)

data class Emi(
    val emiAmount: String,
    val interest: String,
    val interestRate: String,
    val totalAmount: String,
    val principal: String,
    val numberInstallments: String,
)

class EMIViewModel : ViewModel() {

    private val _emiCalculatorState = MutableStateFlow(EmiCalculatorState())
    val emiCalculatorState: StateFlow<EmiCalculatorState> = _emiCalculatorState.asStateFlow()

    private val _firstEmiCalculation: MutableStateFlow<Emi?> = MutableStateFlow(null)
    val firstEmiCalculation = _firstEmiCalculation.asStateFlow()

    private val _secondEmiCalculation: MutableStateFlow<Emi?> = MutableStateFlow(null)
    val secondEmiCalculation = _secondEmiCalculation.asStateFlow()

    fun updateEmiCalculatorState(emiCalculatorState: EmiCalculatorState) {
        _emiCalculatorState.value = emiCalculatorState
    }

    fun calculateEmi(loanAmount: Double, interestRate: Double, numberInstallments: Double) {
        viewModelScope.launch {
            val interestValue = interestRate / 12 / 100
            val commonPart = (1 + interestValue).pow(numberInstallments)
            val divUp = (loanAmount * interestValue * commonPart)
            val divDown = commonPart - 1
            val emiCalculationPerMonth: Float = ((divUp / divDown)).toFloat()
            emiCalculationPerMonth * 12
            val totalInterest = (emiCalculationPerMonth * numberInstallments) - loanAmount
            val totalPayment = totalInterest + loanAmount

            val emi = Emi(
                emiAmount = emiCalculationPerMonth.decimalFormat(),
                interest = totalInterest.decimalFormat(),
                interestRate = interestRate.decimalFormat(),
                totalAmount = totalPayment.decimalFormat(),
                principal = loanAmount.decimalFormat(),
                numberInstallments = numberInstallments.decimalFormat(),
            )

            if (_emiCalculatorState.value.isSecondEmiCalculator) {
                _secondEmiCalculation.value = emi
            } else {
                _firstEmiCalculation.value = emi
            }
        }
    }
}

@Entity(tableName = "previous_operation")
data class PreviousOperation(

    val input: String,

    val result: String,

    @PrimaryKey(autoGenerate = true) var id: Int = 0,
)