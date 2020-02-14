import classes.Repo
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SQLContext
import org.scalatest.{FlatSpec, Matchers}

class RepoTest extends FlatSpec with Matchers {

  "A Stack" should "pop values in last-in-first-out order" in {
    val conf = new SparkConf().setMaster("local[2]")
      .setAppName("RepoTest")

    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    import sqlContext.implicits._

    val JsonDfRepo = sqlContext.read.json("src/test/resources/repo.json");
    val rdd = JsonDfRepo.as[Repo].rdd
    rdd.foreach(println)

    assert(true)
  }
}
