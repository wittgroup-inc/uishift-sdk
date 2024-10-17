package com.gowittgroup.uishift.data

import com.gowittgroup.uishift.domain.ConfigRepository
import com.gowittgroup.uishift.models.ScreenConfiguration
import com.gowittgroup.uishift.parser.ConfigParser

class ConfigRepositoryImpl(private val jsonConfiguration: String) : ConfigRepository {
    override suspend fun fetchScreenConfiguration(): Result<ScreenConfiguration> {
        return try {
            val screenConfiguration: ScreenConfiguration? = ConfigParser().parse(jsonConfiguration)
            if (screenConfiguration != null)
                Result.Success(screenConfiguration)
            else
                Result.Error(RuntimeException("Parsing error"))
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

}

class ConfigRepositoryImpl2(private val screenConfiguration: ScreenConfiguration? = null) :
    ConfigRepository {
    override suspend fun fetchScreenConfiguration(): Result<ScreenConfiguration> {

        return if (screenConfiguration != null)
            Result.Success(screenConfiguration)
        else
            Result.Error(RuntimeException("Parsing error"))
    }

}
