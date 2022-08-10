package com.cursosandroidant.inventory.addModule.model

import com.cursosandroidant.inventory.common.MyDataBase
import com.cursosandroidant.inventory.entities.Product


class AddRepository {
    private val myDataBase by lazy { MyDataBase.getInstance() }

    fun addProduct(product: Product, callback: (isSuccess: Boolean) -> Unit){
        callback(myDataBase.add(product))
    }
}