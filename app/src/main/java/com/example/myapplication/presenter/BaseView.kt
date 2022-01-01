package com.example.myapplication.presenter

interface BaseView<PresenterT: BasePresenter> {
    val presenter:PresenterT
}