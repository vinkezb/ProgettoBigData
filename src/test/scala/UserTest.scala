import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SQLContext
import org.scalatest.{FlatSpec, Matchers}

class UserTest extends FlatSpec with Matchers {

  "A Stack" should "pop values in last-in-first-out order" in {
    val conf = new SparkConf().setMaster("local[2]")
      .setAppName("UserTest")

    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    import sqlContext.implicits._

    val JsonDfUser = sqlContext.read.json("C:\\Users\\kevin\\Desktop\\json\\user.json");
    val rdd = JsonDfUser.as[User].rdd
    rdd.foreach(println)

    assert(true)
  }
}
