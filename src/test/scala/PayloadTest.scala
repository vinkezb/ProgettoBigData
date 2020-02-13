import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.catalyst.ScalaReflection
import org.apache.spark.sql.types.StructType
import org.apache.spark.{SparkConf, SparkContext}
import org.scalatest.{FlatSpec, Matchers}

class FinaleTest extends  FlatSpec  with Matchers {

  "A Stack" should "pop values in last-in-first-out order" in {
    val conf = new SparkConf().setMaster("local[2]")
      .setAppName("PayloadTest")

    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    import sqlContext.implicits._

    val schema = ScalaReflection.schemaFor[Payload].dataType.asInstanceOf[StructType]
    val JsonDfPayload = sqlContext.read.schema(schema).json("src/test/resources/payload.json");
    val rdd = JsonDfPayload.as[Payload].rdd
    rdd.foreach(println)



    assert(true)
  }
}

