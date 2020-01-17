import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SQLContext
import org.scalatest.{FlatSpec, Matchers}

class PullRequestTest extends FlatSpec with Matchers {

  "A Stack" should "pop values in last-in-first-out order" in {
    val conf = new SparkConf().setMaster("local[2]")
      .setAppName("PullRequestTest")

    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    import sqlContext.implicits._

    val JsonDfPullRequest = sqlContext.read.json("C:\\Users\\kevin\\Desktop\\json\\pull_request.json");
    val rdd = JsonDfPullRequest.as[Pull_request].rdd
    rdd.foreach(println)

    assert(true)
  }
}
