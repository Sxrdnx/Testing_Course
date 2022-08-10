package com.cursosandroidant.inventory.mainModule.view.adapters

import com.cursosandroidant.inventory.entities.Product

/****
 * Project: Inventory
 * From: com.cursosandroidant.inventory.mainModule.view.adapters
 * Created by Alain Nicolás Tello on 15/12/21 at 19:40
 * All rights reserved 2021.
 *
 * All my Udemy Courses:
 * https://www.udemy.com/user/alain-nicolas-tello/
 * Web: www.alainnicolastello.com
 ***/
interface OnClickListener {
    fun onClick(product: Product)
    fun onLongClick(product: Product)
}