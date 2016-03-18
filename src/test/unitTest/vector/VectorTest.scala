package test.unitTest.vector

import vector.Vector

import org.scalatest._

/**
  * Created by zhenghe on 3/18/2016.
  */
class VectorTest extends FlatSpec with Matchers {
    "Vector addition" should "add two Vectors together" in {
        (new Vector(8.218, -9.341) + new Vector(-1.129, 2.111)) should be (new Vector(7.089, -7.230))
    }

    "Vector subtraction" should "subtract two Vectors" in {
        (new Vector(7.119, 8.215) - new Vector(-8.223, 0.878)) should be (new Vector(15.342, 7.337))
    }

    "Vector scalar multiplication" should "scale a Vector" in {
        (new Vector(1.671, -1.012, -0.318) * 7.41) should be (new Vector(12.382, -7.499, -2.356))
    }

    "Magnitude" should "find the length of a Vector" in {
        new Vector(-0.221, 7.437).magnitude() should be (7.440)
        new Vector(8.813, -1.331, -6.247).magnitude() should be (10.884)
    }

    "Normalize" should "normalize a Vector to the Unit Vector" in {
        new Vector(5.581, -2.136).normalize() should be (new Vector(0.934, -0.357))
        new Vector(1.996, 3.108, -4.554).normalize() should be (new Vector(0.34, 0.53, -0.777))
    }
}
