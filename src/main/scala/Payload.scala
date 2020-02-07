import scala.tools.cmd.Demo

class Payload (
                   action: String,
                   before: String,
                   comment: Comment,
                   commit: Commit,
                   description: String,
                   distinct_size: Long,
                   forkee: Forkee,
                   head: String,
                   issue: Issue,
                   master_branch: String,
                   member: Member,
                   number: Long,
                   pages: Pages,
                    //pull_request,
                   push_id: Long,
                   pusher_type: String,
                   ref: String,
                   ref_type: String,
                   release: Release,
                   size: Long

              )

extends Product
with Serializable {
  def canEqual(that: Any) = that.isInstanceOf[Demo]

  def productArity = 26

  def productElement(idx: Int) = idx match {
    case 0 => action
    case 1 => before
    case 2 => comment
    case 3 => commit
    case 4 => description
    case 5 => distinct_size
    case 6 => forkee
    case 7 => head
    case 8 => issue
    case 9 => master_branch
    case 10 => member
    case 11 => pages
     // case 12 => pull_request
    case 13 =>push_id
    case 14 => pusher_type
    case 15 => ref
    case 16 => ref_type
    case 17 => release
    case 18 => size

  }
}