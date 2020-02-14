import classes.Pages
import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}
import org.scalatest.{FlatSpec, Matchers}

class PagesTest extends  FlatSpec  with Matchers {

  "A Stack" should "pop values in last-in-first-out order" in {
    val conf = new SparkConf().setMaster("local[2]")
      .setAppName("PagesTest")

    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    import sqlContext.implicits._

    val JsonDfPages = sqlContext.read.json("src/test/resources/pages.json");
    val rdd = JsonDfPages.as[Pages].rdd
    rdd.foreach(println)

    assert(true)
  }
}

