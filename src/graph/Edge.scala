package graph

class Edge[T <: Double](val start: Point[T], val end: Point[T]) {
  val weight: Double = start.distance(end, "euclidean")
}