package com.example.a19.di

import com.example.a19.ui.startFragment.StartFragment
import com.example.a19.ui.workManagerFragment.WorkManagerFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class UIModule {

    @ContributesAndroidInjector
    abstract fun bindStartFragment() : StartFragment

    @ContributesAndroidInjector
    abstract fun bindWorkManagerFragment() : WorkManagerFragment
}