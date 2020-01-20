import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SQLContext
import org.scalatest.{FlatSpec, Matchers}

class AssigneeTest extends FlatSpec with Matchers {

  "A Stack" should "pop values in last-in-first-out order" in {
    val conf = new SparkConf().setMaster("local[2]")
      .setAppName("AssigneeTest")

    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    import sqlContext.implicits._

    val JsonDfAssignee = sqlContext.read.json("src/test/resources/assignee.json");
    val rdd = JsonDfAssignee.as[Assignee].rdd
    rdd.foreach(println)

    assert(true)
  }
}