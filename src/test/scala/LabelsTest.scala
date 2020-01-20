import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SQLContext
import org.scalatest.{FlatSpec, Matchers}

class LabelsTest extends FlatSpec with Matchers {

  "A Stack" should "pop values in last-in-first-out order" in {
    val conf = new SparkConf().setMaster("local[2]")
      .setAppName("LabelsTest")

    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    import sqlContext.implicits._

    val JsonDfLabels = sqlContext.read.json("src/test/resources/labels.json");
    val rdd = JsonDfLabels.as[Labels].rdd
    rdd.foreach(println)

    assert(true)
  }
}
