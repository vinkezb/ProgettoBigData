package classes

case class Head(
               label: String,
               ref: String,
               repo: RepoHead,
               sha: String,
               user: User
               )
