package com.example.data

import com.example.domain.Portfolio
import com.example.domain.UserRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*

class DefaultUserRepository : UserRepository {

    // Imitation place for keep and take Portfolio
    private val dataStateFlow = MutableStateFlow(PortfolioDto.empty)

    override fun savePortfolio(data: Portfolio) {
        dataStateFlow.tryEmit(data.toDto())
    }

    override fun getPortfolio(): Flow<Portfolio> {
/*
        return flow {
            delay(1000)
            emit(dataStateFlow.value.toDomain())
        }
*/
        delay(1000)
        return dataStateFlow.map(PortfolioDto::toDomain)
}