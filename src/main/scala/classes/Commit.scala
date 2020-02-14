package classes

case class Commit(
                 author: Author,
                 distinct: Boolean,
                 message: String,
                 sha: String,
                 url: String
                 )
