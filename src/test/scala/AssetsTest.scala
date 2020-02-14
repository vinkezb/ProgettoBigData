import classes.Assets
import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}
import org.scalatest.{FlatSpec, Matchers}

class AssetsTest extends  FlatSpec  with Matchers {

  "A Stack" should "pop values in last-in-first-out order" in {
    val conf = new SparkConf().setMaster("local[2]")
      .setAppName("AssetsTest")

    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    import sqlContext.implicits._

    val JsonDfAssets = sqlContext.read.json("src/test/resources/assets.json");
    val rdd = JsonDfAssets.as[Assets].rdd
    rdd.foreach(println)

    assert(true)
  }
}

