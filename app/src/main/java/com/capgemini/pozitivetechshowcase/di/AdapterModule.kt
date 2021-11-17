package com.capgemini.pozitivetechshowcase.di

import android.content.Context
import android.widget.ArrayAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.qualifiers.ActivityContext

@Module
@InstallIn(FragmentComponent::class)
object AdapterModule {

    @Provides
    fun provideStringArrayAdapter(@ActivityContext context: Context): ArrayAdapter<String> {
        return ArrayAdapter<String>(context, android.R.layout.simple_spinner_item).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }
    }
}