package vector

import java.text.DecimalFormat

/**
  * Created by zhenghe on 3/17/2016.
  */
class Vector(val coordinates: scala.collection.immutable.Vector[Double], val dimensions: Int) {

    /*****************************************************
      * PRIVATE MEMBER FIELDS/METHODS
      ****************************************************/

    private val threeDecForm = new DecimalFormat("#.###")
    private val round3D = threeDecForm.format(_: Double).toDouble

    /*****************************************************
      * AUXILIARY CONSTRUCTORS
      ****************************************************/

    def this(coordinates: Double*) = this(coordinates.toVector, coordinates.length)

    def this(coordinates: scala.collection.immutable.Vector[Double]) = this(coordinates, coordinates.length)

    /*****************************************************
      * FUNCTIONS
      ****************************************************/

    /**
      * Finds the magnitude of the Vector => sqrt of the sum of all squared values
      * @return Double magnitude
      */
    def magnitude(): Double = round3D(scala.math.sqrt(this.coordinates.map(scala.math.pow(_, 2)).sum))

    /**
      * Normalizes Vector to unit vector, with sum = 1
      * @return
      */
    def normalize(): Vector = {
        val magnitudeVal = magnitude()
        if(magnitudeVal == 0) this else this * (1/magnitude())
    }

    /*****************************************************
      * OPERATORS
      ****************************************************/

    def +(that: Vector): Vector = new Vector((this.coordinates, that.coordinates).zipped.map((a, b) => round3D(a + b)))

    def -(that: Vector): Vector = new Vector((this.coordinates, that.coordinates).zipped.map((a, b) => round3D(a - b)))

    def *(scalar: Double): Vector = new Vector(this.coordinates.map(a => round3D(a * scalar)))

    /*****************************************************
      * OVERRIDES
      ****************************************************/

    override def toString: String = coordinates.toString

    override def equals(o: Any) = o match {
        case that: Vector => that.coordinates.equals(this.coordinates)
        case _ => false
    }

}
