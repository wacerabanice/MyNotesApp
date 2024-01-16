package com.banice.keeptrack.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@HiltViewModel
class MoreViewModel @Inject constructor(
    private val expenseRepository: ExpenseRepository
) : ViewModel() {
    fun addExpenseCategory(categoryName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            expenseRepository.addExpenseCategory(
                ExpenseCategoryDto(
                    categoryName = categoryName
                )
            )
        }
    }
}