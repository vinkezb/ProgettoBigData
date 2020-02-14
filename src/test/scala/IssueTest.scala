import classes.Issue
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SQLContext
import org.scalatest.{FlatSpec, Matchers}

class IssueTest extends FlatSpec with Matchers{

  "A Stack" should "pop values in last-in-first-out order" in {
    val conf = new SparkConf().setMaster("local[2]")
      .setAppName("IssueTest")

    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    import sqlContext.implicits._

    val JsonDfIssue = sqlContext.read.json("src/test/resources/classes.Issue.json");
    val rdd = JsonDfIssue.as[Issue].rdd
    rdd.foreach(println)

    assert(true)
  }
}
