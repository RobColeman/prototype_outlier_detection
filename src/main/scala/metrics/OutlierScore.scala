package metrics

import breeze.linalg._
import breeze.numerics.abs

/**
 * Smallest ball metric
 *
 *
 *
 *
 */
object outlierScore {

  def apply(x: Vector[Double],
            neighbors: DenseMatrix[Double],
            metric: String = "delta",
            distanceMetric: String = "euclidean"): Double = {
    val distances: DenseVector[Double] = this.computeDistances(x, neighbors, distanceMetric)
    metric match {
      case "kappa" => kappa(distances)
      case "gamma" => gamma(distances)
      case "delta" => delta(distances)
      case _ => delta(distances)
    }
  }

  private def computeDistances(x: Vector[Double],
                               neighbors: DenseMatrix[Double],
                               distanceMetric: String = "euclidean"): DenseVector[Double] = {
    require(x.length == neighbors.cols, "vector sizes must match")
    neighbors(*, ::).map(distance(x, _, distanceMetric))
  }

  /**
   * max distance to kth neighbor
   * or
   * radius of smallest ball
   * @param distances
   * @return
   */
  private def kappa(distances: DenseVector[Double]): Double = max(abs(distances))

  /**
   * average, absolute distance to neighbors
   *
   * @param distances
   * @return
   */
  private def gamma(distances: DenseVector[Double]): Double = sum(abs(distances)) / distances.length.toDouble


  /**
   * average distance to neighbors
   *
   * @param distances
   * @return
   */
  private def delta(distances: DenseVector[Double]): Double = abs(sum(distances)) / distances.length.toDouble


}
