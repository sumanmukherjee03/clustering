package graph

abstract class NumberLike {
	type T <: NumberLike
    def <(y: T): Boolean
    def >(y: T): Boolean
    def ==(y: T): Boolean
}

case class NumberLikeInt(x: Int) extends NumberLike {
	type T = NumberLikeInt
	val property_1: Int = x
	def <(y: T): Boolean = { property_1 < y.property_1 }
    def >(y: T): Boolean = { property_1 > y.property_1 }
    def ==(y: T): Boolean = { property_1 == y.property_1 }
    override def toString: String = property_1.toString
}