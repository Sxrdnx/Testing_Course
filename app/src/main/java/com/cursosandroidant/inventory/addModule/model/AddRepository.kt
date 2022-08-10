package com.cursosandroidant.inventory.addModule.model

import com.cursosandroidant.inventory.common.MyDataBase
import com.cursosandroidant.inventory.entities.Product

/****
 * Project: Inventory
 * From: com.cursosandroidant.inventory.addModule
 * Created by Alain Nicolás Tello on 15/12/21 at 19:29
 * All rights reserved 2021.
 *
 * All my Udemy Courses:
 * https://www.udemy.com/user/alain-nicolas-tello/
 * Web: www.alainnicolastello.com
 ***/
class AddRepository {
    private val myDataBase by lazy { MyDataBase.getInstance() }

    fun addProduct(product: Product, callback: (isSuccess: Boolean) -> Unit){
        callback(myDataBase.add(product))
    }
}