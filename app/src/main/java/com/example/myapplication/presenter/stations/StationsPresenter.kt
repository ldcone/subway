package com.example.myapplication.presenter.stations

import com.example.myapplication.data.repository.StationRepository
import com.example.myapplication.domain.Station
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class StationsPresenter(
    private val view:StationsContract.View,
    private val stationRepository: StationRepository
) : StationsContract.Presenter {

    override val scope: CoroutineScope = MainScope()

    //stateFlow 현재 상태와 새로운 상태 업데이트를 수집기에 내보내는 식별 가능 상태
    // 식별 가능한 변경 가능 상태
    private val queryString: MutableStateFlow<String> = MutableStateFlow("")
    private val stations: MutableStateFlow<List<Station>> = MutableStateFlow(emptyList())

    init {
        observeStations()
    }

    override fun onViewCreated(){
        scope.launch {
            view.showStations(stations.value)
            stationRepository.refreshStations()
        }
    }


    override fun onDestroyView(){}

    override fun filterStations(query: String){
        scope.launch {
            queryString.emit(query)
        }
    }

    private fun observeStations(){
        stationRepository
            .station
            .combine(queryString){stations,query ->
                if(query.isBlank()){
                    stations
                }else{
                    stations.filter{it.name.contains(query)}
                }
            }
            .onStart{view.showLoadingIndicator()}
            .onEach{
                if(it.isNotEmpty()){
                    view.hideLoadingIndicator()
                }
                stations.value = it
                view.showStations(it)
            }

            .catch{
                it.printStackTrace()
                view.hideLoadingIndicator()
            }
            .launchIn(scope) // collect observing
    }







}