import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SQLContext
import org.scalatest.{FlatSpec, Matchers}

class MilestoneTest extends FlatSpec with Matchers {

  "A Stack" should "pop values in last-in-first-out order" in {
    val conf = new SparkConf().setMaster("local[2]")
      .setAppName("MilestoneTest")

    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    import sqlContext.implicits._

    val JsonDfMilestone = sqlContext.read.json("src/test/resources/milestone.json");
    val rdd = JsonDfMilestone.as[Milestone].rdd
    rdd.foreach(println)

    assert(true)
  }
}
