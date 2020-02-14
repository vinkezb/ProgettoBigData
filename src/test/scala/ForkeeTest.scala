import classes.Forkee
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.catalyst.ScalaReflection
import org.apache.spark.sql.types.StructType
import org.scalatest.{FlatSpec, Matchers}

class ForkeeTest extends FlatSpec with Matchers{

  "A Stack" should "pop values in last-in-first-out order" in {
    val conf = new SparkConf().setMaster("local[2]")
      .setAppName("ForkeeTest")

    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    import sqlContext.implicits._

    val schema = ScalaReflection.schemaFor[Forkee].dataType.asInstanceOf[StructType]
    val JsonDfForkee= sqlContext.read.json("src/test/resources/forkee.json");
    val rdd = JsonDfForkee.as[Forkee].rdd
    rdd.foreach(println)

    assert(true)
  }
}
