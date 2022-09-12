package com.cursosandroidant.inventory.addModule.viewModel


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.cursosandroidant.inventory.entities.Product
import com.google.common.truth.Truth.assertThat
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class AddViewModelTest{
 @get:Rule
 var instantExecutorRule = InstantTaskExecutorRule()

 @Test
 fun addProductTest(){
   val viewModel = AddViewModel()
   val product = Product(name = "renezz", quantity = 5,
   photoUrl = "https://pbs.twimg.com/media/ExMHE0QUcAgCI0D.jpg",
   score = 5.6, totalVotes = 50)
   val observer =Observer<Boolean>{}
   try {
    viewModel.getResult().observeForever(observer)
    viewModel.addProduct(product)
    val result = viewModel.getResult().value
    assertThat(result).isTrue()
   }finally {
    viewModel.getResult().removeObserver(observer)
   }
  }
}