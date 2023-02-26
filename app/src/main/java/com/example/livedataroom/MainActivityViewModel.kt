package com.example.livedataroom

import androidx.lifecycle.ViewModel
import java.util.concurrent.Executors

class MainActivityViewModel : ViewModel() {
    val stringEntityDAO = App.instanse.stringEntityDAO

    val stringLiveData = stringEntityDAO.getLastData()

    fun putDataToDB(stringEntity: StringEntity){
        //Работа с ДБ не должна происходить в главном потоке
        Executors.newSingleThreadExecutor().execute{
            stringEntityDAO.putData(stringEntity)
        }
    }
}