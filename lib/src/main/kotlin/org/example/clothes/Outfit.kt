package org.example.clothes

class Outfit(shirt: Shirt = PlainWhiteShirt, boots: Boots)

class OutfitBuilder {
    private lateinit var shirt: Shirt
    private lateinit var boots: Boots
    private val clothes = ArrayList<Clothing>()

    // or inner class
    //data class Outfit(val shirt: Shirt, var boots: Boots)

    fun with(item: Clothing): OutfitBuilder {
        clothes.add(item)
        return this
    }

    fun build() : Outfit {
        clothes.forEach {
            when(it) {
                is Shirt -> this.shirt = it
                is Boots -> this.boots = it
            }
        }

        return Outfit(shirt = shirt, boots = boots )
    }
}