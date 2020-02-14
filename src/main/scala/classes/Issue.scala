package classes

import java.io.Serializable

class Issue(    assignee: Assignee,
                assignees: Array[Assignee],
                author_association: String,
                body: String,
                closed_at: String,
                comments: Long,
                comments_url: String,
                created_at: String,
                events_url: String,
                html_url: String,
                id: Long,
                labels: Array[Labels],
                labels_url: String,
                locked: Boolean,
                milestone: Milestone,
                number: Long,
                pull_request: PullRequest,
                repository_url: String,
                state: String,
                title: String,
                updated_at: String,
                url: String,
                user: User
                )

  extends Product
    //For Spark it has to be Serializable
  with Serializable{
  def canEqual(that: Any) = that.isInstanceOf[Issue]

  def productArity = 22 // number of columns

  def productElement(idx: Int) = idx match {
    case 0 => assignee
    case 1 => assignees
    case 2 => author_association
    case 3 => body
    case 4 => closed_at
    case 5 => comments
    case 6 => comments_url
    case 7 => created_at
    case 8 => events_url
    case 9 => html_url
    case 10 => id
    case 11 => labels
    case 12 => labels_url
    case 13 => locked
    case 14 => milestone
    case 15 => number
    case 16 => pull_request
    case 17 => repository_url
    case 18 => state
    case 19 => title
    case 20 => updated_at
    case 21 => url
    case 22 => user
  }
}
