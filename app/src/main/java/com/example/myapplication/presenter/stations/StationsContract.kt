package com.example.myapplication.presenter.stations

import com.example.myapplication.domain.Station
import com.example.myapplication.presenter.BasePresenter
import com.example.myapplication.presenter.BaseView

interface StationsContract {

    interface View:BaseView<Presenter>{

        fun showLoadingIndicator()

        fun hideLoadingIndicator()

        fun showStations(stations:List<Station>)

    }

    interface Presenter:BasePresenter{

        fun filterStations(query:String)

    }
}