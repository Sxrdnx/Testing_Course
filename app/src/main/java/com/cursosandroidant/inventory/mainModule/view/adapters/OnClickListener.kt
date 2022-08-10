package com.cursosandroidant.inventory.mainModule.view.adapters

import com.cursosandroidant.inventory.entities.Product


interface OnClickListener {
    fun onClick(product: Product)
    fun onLongClick(product: Product)
}