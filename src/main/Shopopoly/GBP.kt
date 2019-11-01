package main.Shopopoly

class GBP(gbp: Int) {
    val money = if (gbp < 1) 0 else gbp

    override fun toString() = "£$money"
}