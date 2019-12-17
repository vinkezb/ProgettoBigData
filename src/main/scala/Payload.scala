import scala.tools.cmd.Demo

class Payload (
                   action: String,
                   before: String,
                   comment: Comment,
                   author_association: String,
                   body: String,
                   commit_id: String,
                   created_at: String,
                   diff_hunk: String,
                   html_url: String,
                   id: Long,
                   in_reply_to_id: Long,
                   issue_url: String,
                   line: Long,
                   original_commit_id: String,
                   original_position: Long,
                   path: String,
                   position: Long,
                   pull_request_review_id: Long,
                   pull_request_url: String,
                   updated_at: String,
                   url: String,
                   user: User,
                   commit: Commit,
                   description: String,
                   distinct_size: Long,
                   forkee: Forkee,
                   head: String,
                   issue: Issue
              )

extends Product
with Serializable {
  def canEqual(that: Any) = that.isInstanceOf[Demo]

  def productArity = 26

  def productElement(idx: Int) = idx match {
    case 0 => action
    case 1 => before
    case 2 => comment
    case 3 => author_association
    case 4 => body
    case 5 => commit_id
    case 6 => created_at
    case 7 => diff_hunk
    case 8 => html_url
    case 9 => id
    case 10 => in_reply_to_id
    case 11 => issue_url
    case 12 => line
    case 13 => original_commit_id
    case 14 => original_position
    case 15 => path
    case 16 => position
    case 17 => pull_request_review_id
    case 18 => pull_request_url
    case 18 => updated_at
    case 19 => url
    case 19 => user
    case 20 => commit
    case 21 => description
    case 22 => distinct_size
    case 23 => forkee
    case 24 => head
    case 25 => issue

  }
}