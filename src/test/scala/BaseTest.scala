import classes.Base
import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}
import org.scalatest.{FlatSpec, Matchers}

class BaseTest extends  FlatSpec  with Matchers {

  "A Stack" should "pop values in last-in-first-out order" in {
    val conf = new SparkConf().setMaster("local[2]")
      .setAppName("BaseTest")

    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    import sqlContext.implicits._

    val JsonDfBase = sqlContext.read.json("src/test/resources/base.json");
    val rdd = JsonDfBase.as[Base].rdd
    rdd.foreach(println)

    assert(true)
  }
}

