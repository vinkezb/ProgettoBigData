import classes.Uploader
import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}
import org.scalatest.{FlatSpec, Matchers}

class UploaderTest extends  FlatSpec  with Matchers {

  "A Stack" should "pop values in last-in-first-out order" in {
    val conf = new SparkConf().setMaster("local[2]")
      .setAppName("UploaderTest")

    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    import sqlContext.implicits._

    val JsonDfUploader = sqlContext.read.json("src/test/resources/uploader.json");
    val rdd = JsonDfUploader.as[Uploader].rdd
    rdd.foreach(println)

    assert(true)
  }
}

