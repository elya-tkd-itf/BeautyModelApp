package com.dasonick.beautymodelapp.data

import com.dasonick.beautymodelapp.base.Category

object CategoriesData {
    fun getCategories() = listOf(
        Category("Manicure", "https://clck.ru/epj5C", 1),
        Category("Pedicure", "https://clck.ru/epj5c", 2),
        Category("Hair", "https://clck.ru/epj67", 3),
        Category("Visages", "https://clck.ru/epj6s", 4),
        Category("Barber", "https://clck.ru/epja2", 5),
        Category("Epilation", "https://clck.ru/epjda", 6),
        Category("MakeUp", "https://clck.ru/epjiv", 7),
        Category("Massage", "https://clck.ru/epjmE", 8)
    )
}