package test.unitTest.vector

import vector.Vector

import org.scalatest._

/**
  * Created by zhenghe on 3/18/2016.
  */
class VectorTest extends FlatSpec with Matchers {
    "Vector addition" should "add two Vectors together" in {
        (new Vector(8.218, -9.341) + new Vector(-1.129, 2.111)) ~= (new Vector(7.089, -7.230))
    }
}
